package br.com.fiap.trashitservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tbl_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
    @SequenceGenerator(name = "endereco_sequence", sequenceName = "end_seq")
    private Long id;
    private String cep;
    private String numero;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    @Embedded
    private Lixeira lixeira;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Coleta> coletas;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Usuario> usuarios;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String numero, String rua, String complemento, String bairro, String cidade, String uf, Lixeira lixeira, Set<Coleta> coletas, Set<Usuario> usuarios) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.lixeira = lixeira;
        this.coletas = coletas;
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Lixeira getLixeira() {
        return lixeira;
    }

    public void setLixeira(Lixeira lixeira) {
        this.lixeira = lixeira;
    }

    public Set<Coleta> getColetas() {
        return coletas;
    }

    public void setColetas(Set<Coleta> coletas) {
        this.coletas = coletas;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", lixeira=" + lixeira +
                ", coletas=" + coletas +
                ", usuarios=" + usuarios +
                '}';
    }
}
