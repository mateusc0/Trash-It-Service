package br.com.fiap.trashitservice.model.repository;

import br.com.fiap.trashitservice.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
