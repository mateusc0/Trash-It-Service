package br.com.fiap.trashitservice.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_coleta")
@SequenceGenerator(name = "coleta", sequenceName = "SQ_COLETA", allocationSize = 200)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coleta")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco_dono", nullable = false)
    @JsonBackReference
    private Endereco endereco;
    @Column(name = "dt_coleta")
    private String dtColeta;
    @Embedded
    private Lixeira lixeira;

    public Coleta() {
    }

    public Coleta(Long id, Endereco endereco, String dtColeta, Lixeira lixeira) {
        this.id = id;
        this.endereco = endereco;
        this.dtColeta = dtColeta;
        this.lixeira = lixeira;
    }

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

    public String getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(String dtColeta) {
        this.dtColeta = dtColeta;
    }

    public Lixeira getLixeira() {
        return lixeira;
    }

    public void setLixeira(Lixeira lixeira) {
        this.lixeira = lixeira;
    }

    @Override
    public String toString() {
        return "Coleta{" +
                "id=" + id +
                ", endereco=" + endereco +
                ", dtColeta=" + dtColeta +
                ", lixeira=" + lixeira +
                '}';
    }
}
