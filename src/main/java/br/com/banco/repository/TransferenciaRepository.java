package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(value = "SELECT * FROM transferencia t * " +
    "WHERE ((:inicioPeriodo IS NULL OR :fimPeriodo IS NULL) " +
            "OR t.data_transferencia BETWEEN :inicioPeriodo AND :fimPeriodo) " +
            "AND ((:nomeOperador IS NULL) OR UPPER (t.nome_operador_transacao) LIKE concat('%',UPPER(:nomeOperador),'%')) ",
            nativeQuery = true)
    List<Transferencia> findAll(
            @Param("inicioPeriodo") LocalDate inicioPeriodo,
            @Param("fimPeriodo") LocalDate fimPeriodo,
            @Param("nomeOperador") String nomeOperador);
}
