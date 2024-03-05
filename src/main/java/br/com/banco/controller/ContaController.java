package br.com.banco.controller;

import br.com.banco.model.Conta;
import br.com.banco.model.Filtro;
import br.com.banco.model.dto.ContaDTO;
import br.com.banco.model.dto.ContaInputDTO;
import br.com.banco.model.dto.TransferenciaInputDTO;
import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<?> criarConta(@RequestBody ContaInputDTO contaInputDTO){

        Conta contaOutput = contaService.salvarConta(contaInputDTO);
        URI location = UriComponentsBuilder.
                fromUriString("http://localhost:8080/conta/{id}").
                buildAndExpand(contaOutput.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<ContaDTO>> buscarUsuarios(){
        List<ContaDTO> contasDTO = contaService.buscarTodos();
        return ResponseEntity.ok().body(contasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> buscarConta(@PathVariable("id") Long id){
        ContaDTO contaDTO = contaService.buscarContaPorId(id);
        return ResponseEntity.ok().body(contaDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ContaDTO> adicionarTransferencia(@PathVariable("id") Long id, @RequestBody TransferenciaInputDTO transferenciaInputDTO){
        ContaDTO contaDTO = contaService.vincularTransferencias(id, transferenciaInputDTO);
        return ResponseEntity.ok().body(contaDTO);
    }
}
