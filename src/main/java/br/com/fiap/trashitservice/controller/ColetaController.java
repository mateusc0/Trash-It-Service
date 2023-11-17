package br.com.fiap.trashitservice.controller;

import br.com.fiap.trashitservice.model.Coleta;
import br.com.fiap.trashitservice.model.Endereco;
import br.com.fiap.trashitservice.model.Lixeira;
import br.com.fiap.trashitservice.model.repository.ColetaRepository;
import br.com.fiap.trashitservice.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("coleta")
public class ColetaController {
    @Autowired
    private ColetaRepository coletaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @PostMapping("/{id_endereco}")
    public ResponseEntity<Coleta> create(@PathVariable("id_endereco") long idEndereco, @RequestBody Coleta coleta){
        Endereco endereco = enderecoRepository.findById(idEndereco).orElse(null);
        if (coleta != null && endereco != null){
            coleta.setEndereco(endereco);
            coletaRepository.save(coleta);
            Set<Coleta> coletas = endereco.getColetas();
            coletas.add(coleta);
            endereco.setColetas(coletas);
            enderecoRepository.save(endereco);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(path = "/{id_endereco}")
    public ResponseEntity<List<Coleta>> findById(@PathVariable("id_endereco") long idEndereco){
        Endereco endereco = enderecoRepository.findById(idEndereco).orElse(null);
        if (endereco != null){
            List<Coleta> coletas = coletaRepository.findAllByEndereco(endereco).orElse(null);
            if (coletas != null){
                return ResponseEntity.ok(coletas);
            }
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Coleta> update(@PathVariable("id") long id, @RequestBody Coleta coleta) {
        Coleta coletaBanco = coletaRepository.findById(id).orElse(null);
        if (coleta != null && coletaBanco != null){
            Lixeira lixeiraBanco = coletaBanco.getLixeira();
            Lixeira lixeira = coleta.getLixeira();

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
            coletaRepository.save(coletaBanco);
            return ResponseEntity.ok(coletaBanco);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Coleta> delete(@PathVariable("id") long id){
        Coleta coletaBanco  = coletaRepository.findById(id).orElse(null);
        if (coletaBanco != null){
            Endereco endereco = coletaBanco.getEndereco();
            Set<Coleta> coletas = endereco.getColetas();
            coletas.remove(coletaBanco);
            endereco.setColetas(coletas);
            enderecoRepository.save(endereco);
            coletaRepository.delete(coletaBanco);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();

    }
}
