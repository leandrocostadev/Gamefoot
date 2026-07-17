package modelo;

public class JogadorLinha extends Jogador {
    private int cruzamento;
    private int forca;
    private int pulo;
    private int passe;
    private int drible;
    private int finalizacao;
    private int marcacao;
    private int desarme;
    private int resistencia;
    private int posicionamento;

    public JogadorLinha() {
        super();
    }

    public JogadorLinha(int id, String nome, long valorMercado,
                        int reputacao,
                        int cruzamento, int forca, int pulo, int passe,
                        int drible, int finalizacao, int marcacao,
                        int desarme, int resistencia, int posicionamento) {

        super(id, nome, valorMercado, reputacao);
        this.cruzamento = cruzamento;
        this.forca = forca;
        this.pulo = pulo;
        this.passe = passe;
        this.drible = drible;
        this.finalizacao = finalizacao;
        this.marcacao = marcacao;
        this.desarme = desarme;
        this.resistencia = resistencia;
        this.posicionamento = posicionamento;
    }

    public void treinarPosicionamento() {
        posicionamento++;
    }

}
