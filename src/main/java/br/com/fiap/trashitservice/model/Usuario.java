package br.com.fiap.trashitservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usr_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;
    private String cpf;
    private String email;
    private String celular;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", endereco=" + endereco +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
