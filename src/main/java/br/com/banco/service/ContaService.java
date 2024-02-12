package br.com.banco.service;

import br.com.banco.config.ModelMapperConfig;
import br.com.banco.model.Conta;
import br.com.banco.model.dto.ContaDTO;
import br.com.banco.model.dto.ContaInputDTO;
import br.com.banco.repository.ContaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Conta salvarConta(ContaInputDTO contaInputDTO) {
        Conta contaInput = modelMapper.map(contaInputDTO, Conta.class);
        contaRepository.save(contaInput);
        return contaInput;
    }

    public List<ContaDTO> buscarTodos() {
        List<Conta> contas = contaRepository.findAll();
        List<ContaDTO> contasDTO = contas.stream().map(c -> modelMapper.map(c, ContaDTO.class)).toList();
        return contasDTO;
    }

    public ContaDTO buscarContaPorId(Long id) {
        Conta conta = contaRepository.findById(id).get();
        return modelMapper.map(conta, ContaDTO.class);
    }
}
