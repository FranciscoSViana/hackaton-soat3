package com.soat3.hackaton.atendmed.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DataProvider {
    LocalDate obterDataAtutal();

    LocalDateTime obterDataHoraAtual();
}
