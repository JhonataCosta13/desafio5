package br.com.banco.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContaDTO {

    private Long id;
    private String nomeResponsavel;
    private List<TransferenciaDTO> transferencias;
}
