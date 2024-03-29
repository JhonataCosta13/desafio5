package br.com.banco.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TransferenciaDTO {

    private Long id;
    private LocalDate dataTransferencia;
    private Double valorTransferencia;
    private String tipoTransferencia;
    private String nomeOperadorTransacao;
}
