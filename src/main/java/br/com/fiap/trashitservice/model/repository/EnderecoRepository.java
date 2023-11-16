package br.com.fiap.trashitservice.model.repository;

import br.com.fiap.trashitservice.model.Endereco;
import br.com.fiap.trashitservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    //Optional<Endereco> findByUsuariosEquals(Set<Usuario> usuarios);
}
