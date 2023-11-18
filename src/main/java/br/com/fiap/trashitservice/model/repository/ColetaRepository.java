package br.com.fiap.trashitservice.model.repository;

import br.com.fiap.trashitservice.model.Coleta;
import br.com.fiap.trashitservice.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ColetaRepository extends JpaRepository <Coleta, Long> {

    Optional<List<Coleta>> findAllByEnderecoOrderByIdDesc(@Param("endereco") Endereco endereco);
}
