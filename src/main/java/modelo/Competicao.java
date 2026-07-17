package modelo;

public class Competicao {
    private long id;
    private String nome;
    private int quantidadeClubes;

    public Competicao(long id, String nome, int quantidadeClubes) {
        this.id = id;
        this.nome = nome;
        this.quantidadeClubes = quantidadeClubes;
    }

    public Competicao(String nome, int quantidadeClubes) {
        this.nome = nome;
        this.quantidadeClubes = quantidadeClubes;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeClubes() {
        return quantidadeClubes;
    }

    public void setQuantidadeClubes(int quantidadeClubes) {
        this.quantidadeClubes = quantidadeClubes;
    }
}
