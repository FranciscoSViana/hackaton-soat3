package com.soat3.hackaton.atendmed.commons.filters;

import com.soat3.hackaton.atendmed.application.medico.service.MedicoService;
import com.soat3.hackaton.atendmed.application.paciente.service.PacienteService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HeaderValidationFilter implements Filter {

    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        // Bypass validation for POST requests to /api/pacientes and /api/medicos (registration endpoints)
        if (method.equalsIgnoreCase("POST") && (path.equals("/api/pacientes") || path.equals("/api/medicos"))) {
            chain.doFilter(request, response);
            return;
        }

        // Validate credentials for other endpoints
        if (path.startsWith("/api/pacientes") && !method.equalsIgnoreCase("POST")) {
            String cpf = httpRequest.getHeader("cpf");
            String senha = httpRequest.getHeader("senha");
            if (cpf == null || cpf.isEmpty() || senha == null || senha.isEmpty() || !pacienteService.validarCredenciais(cpf, senha)) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais de paciente inválidas");
                return;
            }
        }

        if (path.startsWith("/api/medicos") && !method.equalsIgnoreCase("POST")) {
            String crm = httpRequest.getHeader("crm");
            String senha = httpRequest.getHeader("senha");
            if (crm == null || crm.isEmpty() || senha == null || senha.isEmpty() || !medicoService.validarCredenciais(crm, senha)) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais de médico inválidas");
                return;
            }
        }

        if (path.startsWith("/v1/consulta")) {
            String cpf = httpRequest.getHeader("cpf");
            String senha = httpRequest.getHeader("senha");
            if (cpf == null || cpf.isEmpty() || senha == null || senha.isEmpty() || !pacienteService.validarCredenciais(cpf, senha)) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciais de paciente inválidas");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
