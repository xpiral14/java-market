package models;

/**
 * Produto
 */
public class Produto {

    private int id;
    private String nome;
    private int quantidade;
    private double preco;
    private double desconto;
    private String codigoBarras;
    private Categoria categoria;

    public Produto(int id, String nome, int quantidade, double preco, double desconto, String codigoBarras,
            Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.desconto = desconto;
        this.codigoBarras = codigoBarras;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        }

    @Override
    public String toString() {
        return "Produto [categoria=" + categoria + ", codigoBarras=" + codigoBarras + ", desconto=" + desconto + ", id="
                + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }

}