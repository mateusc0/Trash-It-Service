package br.com.fiap.trashitservice.controller;

import br.com.fiap.trashitservice.model.Endereco;
import br.com.fiap.trashitservice.model.Lixeira;
import br.com.fiap.trashitservice.model.Usuario;
import br.com.fiap.trashitservice.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @PostMapping()
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco){
        if (endereco != null){
            enderecoRepository.save(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable("id") long id){
        Endereco endereco = enderecoRepository.findById(id).orElse(null);
        if (endereco != null){
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(path = "")
    public ResponseEntity<Endereco> findByUsuario(@RequestBody Usuario usuario){
        Endereco endereco = enderecoRepository.findByUsuariosEquals(Set.of(usuario)).orElse(null);
        if (endereco != null){
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable("id") long id, @RequestBody Endereco endereco) {
        Endereco enderecoBanco = enderecoRepository.findById(id).orElse(null);
        if (endereco != null && enderecoBanco != null){
            Lixeira lixeiraBanco = enderecoBanco.getLixeira();
            Lixeira lixeira = endereco.getLixeira();

            if (lixeiraBanco.isPrecisaColeta() != lixeira.isPrecisaColeta()){
                lixeiraBanco.setPrecisaColeta(lixeira.isPrecisaColeta());
            }
            if (lixeiraBanco.isTemPlastico() != lixeira.isTemPlastico()){
                lixeiraBanco.setTemPlastico(lixeira.isTemPlastico());
            }
            if (lixeiraBanco.isTemPapel() != lixeira.isTemPapel()){
                lixeiraBanco.setTemPapel(lixeira.isTemPapel());
            }
            if (lixeiraBanco.isTemVidro() != lixeira.isTemVidro()){
                lixeiraBanco.setTemVidro(lixeira.isTemVidro());
            }
            if (lixeiraBanco.isTemMetal() != lixeira.isTemMetal()){
                lixeiraBanco.setTemMetal(lixeira.isTemMetal());
            }
            if (lixeiraBanco.isTemOrganico() != lixeira.isTemOrganico()){
                lixeiraBanco.setTemOrganico(lixeira.isTemOrganico());
            }
            if (lixeiraBanco.getDtNotificacao() != lixeira.getDtNotificacao()){
                lixeiraBanco.setDtNotificacao(lixeira.getDtNotificacao());
            }
            enderecoRepository.save(enderecoBanco);
            return ResponseEntity.ok(enderecoBanco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Endereco> delete(@PathVariable("id") long id){
        Endereco endereco  = enderecoRepository.findById(id).orElse(null);
        if (endereco != null){
            enderecoRepository.delete(endereco);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();
    }
}
