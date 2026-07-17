package modelo;

public class JogadorGoleiro extends Jogador {
    private int rapidez;
    private int passe;
    private int reflexos;
    private int pulo;
    private int posicionamento;

    public JogadorGoleiro() {
        super();
    }

    public JogadorGoleiro(int id, String nome, long valorMercado,
                   int reputacao,
                   int rapidez, int passe, int reflexos,
                   int pulo, int posicionamento) {

        super(id, nome, valorMercado, reputacao);
        this.rapidez = rapidez;
        this.passe = passe;
        this.reflexos = reflexos;
        this.pulo = pulo;
        this.posicionamento = posicionamento;
    }

    public void treinarReflexos() {
        reflexos++;
    }
}
