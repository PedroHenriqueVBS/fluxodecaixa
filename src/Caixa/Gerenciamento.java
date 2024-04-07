package Caixa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Gerenciamento {
    private static List<Compra> compras = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();

    public static void cadastrar(String nome, float valor) {
        boolean nomeExistente = false;

        for (Produto produto : produtos) {
            if (produto.getName().equals(nome)) {
                nomeExistente = true;
            }
        }

        if (nomeExistente) {
            JOptionPane.showMessageDialog(null, "O produto que será adicionado já foi cadastrado. Por favor, insira um novo produto!");
        } else {
            Produto p1 = new Produto(nome, valor);
            produtos.add(p1);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
        }
    }

    public static void editar(int codigo) {
        boolean produtoEncontrado = false;

        for (Produto produto : produtos) {
            if (produto.getCode() == codigo) {
                String novoNome = JOptionPane.showInputDialog("Digite o novo nome do produto:");
                float novoValor = Float.parseFloat(JOptionPane.showInputDialog("Digite o novo valor do produto:"));
                produto.setName(novoNome);
                produto.setValue(novoValor);
                produtoEncontrado = true;
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
            }
        }

        if (!produtoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado. Não foi possível editar.");
        }
    }

    public static void listar() {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há produtos na lista!!");
        } else {
            StringBuilder mensagem = new StringBuilder();
            for (Produto produto : produtos) {
                mensagem.append("Codigo: ").append(produto.getCode()).append("\nNome: ").append(produto.getName()).append("\nValor: ").append(produto.getValue()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, mensagem.toString());
        }
    }

    public static void remover(int codigo) {
        Produto produtoRemovido = null;

        for (Produto produto : produtos) {
            if (produto.getCode() == codigo) {
                produtoRemovido = produto;
            }
        }

        if (produtoRemovido != null) {
            produtos.remove(produtoRemovido);
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado. Não foi possível remover.");
        }
    }

    public static void adicionarCompra(int codigo) {
        boolean produtoEncontrado = false;

        for (Compra compra : compras) {
            if (compra.getProduto().getCode() == codigo) {
                JOptionPane.showMessageDialog(null, "Este produto já foi adicionado à lista de compras.");
                return;
            }
        }

        for (Produto produto : produtos) {
            if (produto.getCode() == codigo) {
                Compra c1 = new Compra(produto);
                compras.add(c1);
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!!");
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado. Não foi possível adicionar à lista de compras.");
        }
    }

    public static void listarCompra() {
        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há compras realizadas!");
        } else {
            float total = 0;
            StringBuilder mensagem = new StringBuilder();
            for (Compra compra : compras) {
                total += compra.getProduto().getValue();
                mensagem.append(compra.toString()).append("\n");
            }
            mensagem.append("Total da compra: ").append(total).append("\n");
            JOptionPane.showMessageDialog(null, mensagem.toString());
        }
    }

    public static void finalizarCompra() {
        int finalCompra = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Finalizar Compra",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Finalizar a compra", "Continuar comprando"},
                "Finalizar a compra"
        );

        if (finalCompra == 0) {
            compras.clear();
            JOptionPane.showMessageDialog(null, "Agradecemos pela preferência!!!");
        }
    }
}
