package modelo;

public class ParticipacaoCampeonato {
    private long id;
    private Clube clube;
    private Competicao competicao;
    private int jogos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int pontos;
    private int golsPro;
    private int golsContra;
    private int golsDiferenca;

    public ParticipacaoCampeonato(long id, Clube clube, Competicao competicao, int jogos, int vitorias, int empates, int derrotas, int pontos, int golsPro, int golsContra, int golsDiferenca) {
        this.id = id;
        this.clube = clube;
        this.competicao = competicao;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.pontos = pontos;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.golsDiferenca = golsDiferenca;
    }

    public ParticipacaoCampeonato(Clube clube, Competicao competicao, int jogos, int vitorias, int empates, int derrotas, int pontos, int golsPro, int golsContra, int golsDiferenca) {
        this.clube = clube;
        this.competicao = competicao;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.pontos = pontos;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.golsDiferenca = golsDiferenca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    public int getGolsDiferenca() {
        return golsDiferenca;
    }

    public void setGolsDiferenca(int golsDiferenca) {
        this.golsDiferenca = golsDiferenca;
    }
}
