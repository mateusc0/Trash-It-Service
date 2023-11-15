package br.com.fiap.trashitservice.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_coleta")
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coleta_sequence")
    @SequenceGenerator(name = "coleta_sequence", sequenceName = "col_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_endereco_dono", nullable = false)
    private Endereco endereco;
    @Column(name = "dt_coleta")
    private Date dtColeta;
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

    public Date getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(Date dtColeta) {
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
