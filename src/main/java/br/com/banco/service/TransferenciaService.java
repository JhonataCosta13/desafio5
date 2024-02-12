package br.com.banco.service;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.model.dto.TransferenciaDTO;
import br.com.banco.repository.TransferenciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ModelMapper modelMaper;

    public Transferencia salvarTransferencia(TransferenciaDTO transferenciaInputDTO) {
        Transferencia transferenciaInput = modelMaper.map(transferenciaInputDTO, Transferencia.class);
        transferenciaRepository.save(transferenciaInput);
        return transferenciaInput;
    }

    public List<TransferenciaDTO> buscarTodos() {
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        List<TransferenciaDTO> transferenciasDTO = transferencias.stream()
                .map(t -> modelMaper.map(t, TransferenciaDTO.class)).toList();
        return transferenciasDTO;
    }

    public List<Transferencia> buscarTransferenciaPorId(List<Long> transferenciaIds) {
        return transferenciaRepository.findAllById(transferenciaIds);
    }

    public void vinculaConta(List<Transferencia> transferencias, Conta conta) {
        transferencias.stream().forEach(t -> t.setConta(conta));
        transferenciaRepository.saveAll(transferencias);
    }
}
