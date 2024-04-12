package Caixa;

public class Compra {
    private Produto produto;
    private int stockQuantity;


    public Compra(Produto produto, int stockQuantity) {
        this.produto = produto;
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return "Codigo:" + produto.getCode() +
                "\nProduto comprado: " + produto.getName() +
                "\nValor: " + produto.getValue() +
                "\nQuantidade: "+ getStockQuantity() +"\n";
    }
}