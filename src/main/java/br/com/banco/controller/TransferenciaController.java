package br.com.banco.controller;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.model.dto.ContaDTO;
import br.com.banco.model.dto.ContaInputDTO;
import br.com.banco.model.dto.TransferenciaDTO;
import br.com.banco.model.dto.TransferenciaInputDTO;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("transferencia")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<?> criarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO){

        Transferencia transferenciaOutput = transferenciaService.salvarTransferencia(transferenciaDTO);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/transferencia/{id}").
                buildAndExpand(transferenciaOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> buscarTransferencias(
            @RequestParam (name = "inicioPeriodo", required = false) LocalDate inicioPeriodo,
            @RequestParam (name = "fimPeriodo", required = false) LocalDate fimoPeriodo,
            @RequestParam (name = "nomeOperador", required = false) String nomeOperador
            ){
        List<TransferenciaDTO> transferenciasDTO = transferenciaService.buscarTodos(inicioPeriodo, fimoPeriodo, nomeOperador);
        return ResponseEntity.ok().body(transferenciasDTO);
    }
}
