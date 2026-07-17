package modelo;

import java.util.Date;

public class Contrato {
    private long id;
    private Jogador jogador;
    private Clube clube;
    private Date dataInicio;
    private Date dataFim;
    private long salario;

    public Contrato(Jogador jogador, Clube clube, Date dataInicio, Date dataFim, long salario) {
        this.jogador = jogador;
        this.clube = clube;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.salario = salario;
    }

    public Contrato(long id, Jogador jogador, Clube clube, Date dataInicio, Date dataFim, long salario) {
        this.id = id;
        this.jogador = jogador;
        this.clube = clube;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Clube getClube() {
        return clube;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public long getSalario() {
        return salario;
    }
}
