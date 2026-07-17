package modelo;


public class Jogador {
    private int id;
    private String nome;
    private long valorMercado;
    private int reputacao; // 0 a 100

    protected Jogador() {
    }

    protected Jogador(int id, String nome, long valorMercado, int reputacao) {
        this.id = id;
        this.nome = nome;
        this.valorMercado = valorMercado;
        setReputacao(reputacao);
    }

    public void ganharReputacao(int pontos) {
        setReputacao(this.reputacao + pontos);
    }

    protected void setReputacao(int reputacao) {
        if (reputacao < 0) {
            this.reputacao = 0;
        } else if (reputacao > 100) {
            this.reputacao = 100;
        } else {
            this.reputacao = reputacao;
        }
    }

    public int getReputacao() {
        return reputacao;
    }

    public long getValorMercado() {
        return valorMercado;
    }

    protected void setValorMercado(long valorMercado) {
        this.valorMercado = valorMercado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
