package Texto;

import Caixa.Gerenciamento;

import javax.swing.JOptionPane;

public class Entradas {

    public static void listarOpcoes() {
        JOptionPane.showMessageDialog(null,
                "Menu:\n"+
                        "1) Cadastrar produto\n" +
                        "2) Editar produtos\n" +
                        "3) Listar produtos\n" +
                        "4) Remover um produto\n" +
                        "5) Adicionar produto a lista de compras\n" +
                        "6) Listar items\n" +
                        "7) Finalizar a compra\n" +
                        "8) Sair do programa");
    }

    public static void condicaoUm() {
        String nomeProduto = JOptionPane.showInputDialog("Nome do produto:");
        float valorProduto = Float.parseFloat(JOptionPane.showInputDialog("Valor do produto:"));
        int estoqueProduto = Integer.parseInt(JOptionPane.showInputDialog("Deseja adicionar quantos ao estoque?"));

        Gerenciamento.cadastrar(nomeProduto, valorProduto, estoqueProduto);
    }

    public static void condicaoDois() {
        int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto:"));
        Gerenciamento.editar(codigoProduto);
    }

    public static void condicaoTres() {
        int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto:"));
        Gerenciamento.remover(codigoProduto);
    }

    public static void condicaoQuatro() {
        int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto:"));
        int estoqueProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantidade que deseja adicionar:"));
        Gerenciamento.adicionarCompra(codigoProduto, estoqueProduto);
    }
}
