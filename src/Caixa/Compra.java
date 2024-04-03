package Caixa;

public class Compra {
    private Produto produto;

    public Compra(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "Produto comprado: " + produto.getName() + "\nValor: " + produto.getValue() + "\n";
    }
}