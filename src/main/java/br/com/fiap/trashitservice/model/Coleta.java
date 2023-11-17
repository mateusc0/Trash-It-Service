package br.com.fiap.trashitservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_coleta")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Coleta {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coleta_sequence")
    //@SequenceGenerator(name = "coleta_sequence", sequenceName = "col_seq")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco_dono", nullable = false)
    @JsonBackReference
    private Endereco endereco;
    @Column(name = "dt_coleta")
    private LocalDateTime dtColeta;
    @Embedded
    private Lixeira lixeira;

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

    public LocalDateTime getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(LocalDateTime dtColeta) {
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
