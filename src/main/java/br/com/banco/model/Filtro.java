package br.com.banco.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Filtro {

    private LocalDate inicioPeriodo = LocalDate.of(2018, 07, 22);
    private LocalDate fimPeriodo = LocalDate.of(2024, 02, 12);
    private String nomeOperador = "Jailson";
}
