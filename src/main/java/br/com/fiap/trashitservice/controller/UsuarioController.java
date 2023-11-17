package br.com.fiap.trashitservice.controller;

import br.com.fiap.trashitservice.model.Endereco;
import br.com.fiap.trashitservice.model.Lixeira;
import br.com.fiap.trashitservice.model.Usuario;
import br.com.fiap.trashitservice.model.repository.EnderecoRepository;
import br.com.fiap.trashitservice.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("cadastro")
    public ResponseEntity<Usuario> create(){
        Lixeira lixeira = new Lixeira(false,false,false,false,false,false,null);
        Endereco endereco = new Endereco(1L,"09211111","111","Rua Exemplo","","Bairro Exemplo","São Paulo","SP", lixeira, Set.of(), Set.of());
        enderecoRepository.save(endereco);
        Usuario usuario = new Usuario(1L,"Seu Nome",null,"00000000000","seuEmail@email.com","11900000000","senha");
        usuarioRepository.save(usuario);
        endereco.setUsuarios(Set.of(usuario));
        enderecoRepository.save(endereco);
        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioRepository.findById(1L).orElse(null));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") long id){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
        if (usuarioBanco != null){
            return ResponseEntity.ok(usuarioBanco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping()
    public ResponseEntity<Usuario> findByNomeAndSenha(@RequestParam(name = "email", required = true) String email,
                                                      @RequestParam(name = "senha", required = true) String senha){
        Usuario usuarioBanco = usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
        if (usuarioBanco != null){
            return ResponseEntity.ok(usuarioBanco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") long id, @RequestBody Usuario usuario) {
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
        if (usuario != null && usuarioBanco != null){
            if (!usuarioBanco.getCelular().equals(usuario.getCelular())){
                usuarioBanco.setCelular(usuario.getCelular());
            }
            if (!usuarioBanco.getEmail().equals(usuario.getEmail())){
                usuarioBanco.setEmail(usuario.getEmail());
            }
            if (!usuarioBanco.getSenha().equals(usuario.getSenha())){
                usuarioBanco.setSenha(usuario.getSenha());
            }
            usuarioRepository.save(usuarioBanco);
            return ResponseEntity.ok(usuarioBanco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable("id") long id){
        Usuario usuarioBanco = usuarioRepository.findById(id).orElse(null);
        if (usuarioBanco != null){
            Endereco endereco = usuarioBanco.getEndereco();
            Set<Usuario> usuarios = endereco.getUsuarios();
            usuarios.remove(usuarioBanco);
            endereco.setUsuarios(usuarios);
            enderecoRepository.save(endereco);
            usuarioRepository.delete(usuarioBanco);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();

    }
}
