package br.com.banco.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TransferenciaInputDTO {

    private List<Long> transferenciaIds;
}
