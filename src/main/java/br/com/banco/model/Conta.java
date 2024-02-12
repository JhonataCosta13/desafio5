package br.com.banco.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias;
}
