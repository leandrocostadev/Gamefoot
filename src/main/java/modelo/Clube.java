package modelo;

public class Clube {
    private long id;
    private String nome;
    private String escudo;
    private String corPrimariaHex;
    private String corSecundariaHex;
    private int reputacao;

    public Clube() {
    }

    public Clube(String nome,
                 String escudo,
                 String corPrimariaHex,
                 String corSecundariaHex,
                 int reputacao) {

        this.nome = nome;
        this.escudo = escudo;
        this.corPrimariaHex = corPrimariaHex;
        this.corSecundariaHex = corSecundariaHex;
        this.reputacao = reputacao;
    }

    public Clube(String nome, String corPrimariaHex, String corSecundariaHex) {
        this.nome = nome;
        this.corPrimariaHex = corPrimariaHex;
        this.corSecundariaHex = corSecundariaHex;
    }

    public Clube(long id, String nome, String escudo,
                 String corPrimariaHex, String corSecundariaHex, int reputacao) {
        this.id = id;
        this.nome = nome;
        this.escudo = escudo;
        this.corPrimariaHex = corPrimariaHex;
        this.corSecundariaHex = corSecundariaHex;
        this.reputacao = reputacao;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEscudo() {
        return escudo;
    }

    public String getCorPrimariaHex() {
        return corPrimariaHex;
    }

    public String getCorSecundariaHex() {
        return corSecundariaHex;
    }

    public int getReputacao() {
        return reputacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public void setCorPrimariaHex(String corPrimariaHex) {
        this.corPrimariaHex = corPrimariaHex;
    }

    public void setCorSecundariaHex(String corSecundariaHex) {
        this.corSecundariaHex = corSecundariaHex;
    }

    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }

    public void setId(long id) {
        this.id = id;
    }
}
