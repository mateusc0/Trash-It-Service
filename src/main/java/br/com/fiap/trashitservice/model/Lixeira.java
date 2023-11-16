package br.com.fiap.trashitservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class Lixeira {
    @Column(name = "status_coleta")
    private boolean precisaColeta;
    @Column(name = "coleta_plastico")
    private boolean temPlastico;
    @Column(name = "coleta_papel")
    private boolean temPapel;
    @Column(name = "coleta_vidro")
    private boolean temVidro;
    @Column(name = "coleta_metal")
    private boolean temMetal;
    @Column(name = "coleta_organico")
    private boolean temOrganico;
    @Column(name = "dt_notificacao")
    private LocalDateTime dtNotificacao;

    public Lixeira() {
    }

    public Lixeira(boolean precisaColeta, boolean temPlastico, boolean temPapel, boolean temVidro, boolean temMetal, boolean temOrganico, LocalDateTime dtNotificacao) {
        this.precisaColeta = precisaColeta;
        this.temPlastico = temPlastico;
        this.temPapel = temPapel;
        this.temVidro = temVidro;
        this.temMetal = temMetal;
        this.temOrganico = temOrganico;
        this.dtNotificacao = dtNotificacao;
    }

    public boolean isPrecisaColeta() {
        return precisaColeta;
    }

    public void setPrecisaColeta(boolean precisaColeta) {
        this.precisaColeta = precisaColeta;
    }

    public boolean isTemPlastico() {
        return temPlastico;
    }

    public void setTemPlastico(boolean temPlastico) {
        this.temPlastico = temPlastico;
    }

    public boolean isTemPapel() {
        return temPapel;
    }

    public void setTemPapel(boolean temPapel) {
        this.temPapel = temPapel;
    }

    public boolean isTemVidro() {
        return temVidro;
    }

    public void setTemVidro(boolean temVidro) {
        this.temVidro = temVidro;
    }

    public boolean isTemMetal() {
        return temMetal;
    }

    public void setTemMetal(boolean temMetal) {
        this.temMetal = temMetal;
    }

    public boolean isTemOrganico() {
        return temOrganico;
    }

    public void setTemOrganico(boolean temOrganico) {
        this.temOrganico = temOrganico;
    }

    public LocalDateTime getDtNotificacao() {
        return dtNotificacao;
    }

    public void setDtNotificacao(LocalDateTime dtNotificacao) {
        this.dtNotificacao = dtNotificacao;
    }

    @Override
    public String toString() {
        return "Lixeira{" +
                "precisaColeta=" + precisaColeta +
                ", temPlastico=" + temPlastico +
                ", temPapel=" + temPapel +
                ", temVidro=" + temVidro +
                ", temMetal=" + temMetal +
                ", temOrganico=" + temOrganico +
                ", dtNotificacao=" + dtNotificacao +
                '}';
    }
}
