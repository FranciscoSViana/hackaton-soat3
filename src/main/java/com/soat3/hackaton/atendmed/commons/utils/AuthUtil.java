package com.soat3.hackaton.atendmed.commons.utils;

public interface AuthUtil {
    String encriptarSenha(String senha);
    boolean validarSenha(String senha, String senhaCriptografada);

}
