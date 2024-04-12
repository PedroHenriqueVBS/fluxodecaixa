package Caixa;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciamento {
    private static final List<Compra> compras = new ArrayList<>();
    private static final List<Produto> produtos = new ArrayList<>();

    public static void cadastrar(String nome, float valor, int estoque) {
        boolean nomeExistente = produtos.stream().anyMatch(produto -> produto.getName().equals(nome));

        if (nomeExistente) {
            JOptionPane.showMessageDialog(null, "O produto que será adicionado já foi cadastrado. Por favor, insira um novo produto!");
        } else {
            Produto p1 = new Produto(nome, valor, estoque);
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
                int novoEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite uma nova quantidade do produto:"));

                produto.setName(novoNome);
                produto.setValue(novoValor);
                produto.setStock(novoEstoque);
                produtoEncontrado = true;
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
            }
        }
        if (!produtoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado. Não foi possível editar.");
        }
    }

    public static void listar() {
        StringBuilder message = new StringBuilder();

        if (produtos.isEmpty()) {
            message.append("Não há produtos na lista!!");
        } else {
            for (Produto produto : produtos) {
                message.append("Codigo: ").append(produto.getCode())
                        .append("\nNome: ").append(produto.getName())
                        .append("\nValor: ").append(produto.getValue())
                        .append("\nQuantidade: ").append(produto.getStock()).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    public static void remover(int codigo) {
        Produto produtoRemovido = produtos.stream()
                .filter(produto -> produto.getCode() == codigo)
                .findFirst().orElse(null);

        if (produtoRemovido != null) {
            produtos.remove(produtoRemovido);
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado. Não foi possível remover.");
        }
    }

    public static void adicionarCompra(int codigo, int quantidadeEstoque) {
        Scanner scanner = new Scanner(System.in);
        boolean produtoEncontrado = false;

        //validação da quantidade(se existe a quantidade do produto)
        for (Compra compra : compras) {

            Produto produto = compra.getProduto();

            //verifica  se o produto existe pelo codigo para entrar na condição
            if (produto.getCode() == codigo) {

                int quantidadeDisponivel = produto.getStock();

                if (produto.getStock() >= quantidadeEstoque) {
                    compra.setStockQuantity(compra.getStockQuantity() + quantidadeEstoque);
                    produto.setStock(quantidadeDisponivel - quantidadeEstoque); // Reduz o estoque
                    JOptionPane.showMessageDialog(null, "Quantidade do produto na lista de compras atualizada.");

                } else if (produto.getStock() == 0) {
                    JOptionPane.showMessageDialog(null,"Desculpe, não há quantidade suficiente em estoque.");
                    JOptionPane.showMessageDialog(null,"Quantidade disponível em estoque: " + quantidadeDisponivel);
                } else {
                    JOptionPane.showMessageDialog(null,"Desculpe, não há quantidade suficiente em estoque.");
                    JOptionPane.showMessageDialog(null, "Quantidade disponível em estoque: " + quantidadeDisponivel);
                    int option = JOptionPane.showConfirmDialog(null, "Deseja comprar a quantidade disponível?");
                    if ( option == JOptionPane.YES_OPTION){
                        compra.setStockQuantity(compra.getStockQuantity() + quantidadeDisponivel);
                        produto.setStock(0); // Reduz o estoque para zero
                        System.out.println("Quantidade do produto na lista de compras atualizada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Compra do produto cancelada.");
                    }
                }
                produtoEncontrado = true; //torna o false em true e não entra na condição seguinte
            }
        }
        //validação do produto (se existe o produto pelo codigo), caso a condição permaneça false
        if (!produtoEncontrado) {
            for (Produto produto : produtos) {
                //verifica  se o produto existe pelo codigo para entrar na condição
                if (produto.getCode() == codigo) {
                    int estoqueDisponivel = produto.getStock();
                    if (estoqueDisponivel > 0) {
                        if (estoqueDisponivel >= quantidadeEstoque) {
                            Compra compra = new Compra(produto, quantidadeEstoque);
                            compras.add(compra);
                            produto.setStock(estoqueDisponivel - quantidadeEstoque);
                            JOptionPane.showMessageDialog(null, "Produto adicionado à lista de compras com a quantidade desejada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Desculpe, não há quantidade suficiente em estoque.");
                            JOptionPane.showMessageDialog(null, "Quantidade disponível em estoque: " + estoqueDisponivel);
                            int opcao = JOptionPane.showConfirmDialog(null, "Deseja comprar a quantidade disponível?");

                            if (opcao == JOptionPane.YES_OPTION) {
                                Compra compra = new Compra(produto, estoqueDisponivel);
                                compras.add(compra);
                                produto.setStock(0);
                                JOptionPane.showMessageDialog(null,"Produto adicionado à lista de compras com a quantidade disponível.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Compra do produto cancelada.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Desculpe, o produto está fora de estoque.");
                    }
                    produtoEncontrado = true; //torna o false em true e não entra na condição seguinte
                }
            }
            if (!produtoEncontrado) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado. Não foi possível adicionar à lista de compras.");
            }
        }

    }


    public static void listarCompra() {
        StringBuilder message = new StringBuilder();

        if (compras.isEmpty()) {
            message.append("Não há compras realizadas!");
        } else {
            int totalProduto = 0;
            float total = 0;
            for (Compra compra : compras) {
                Produto produto = compra.getProduto();
                total += produto.getValue() * compra.getStockQuantity();
                totalProduto += compra.getStockQuantity();
                message.append(compra.toString()).append("\n");
            }
            message.append("Total da compra: ").append(total).append(" Total de Produtos: ").append(totalProduto);
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    public static void finalizarCompra() {
        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há compras para finalizar.");
            return;
        }

        StringBuilder notaFiscal = new StringBuilder();
        float total = 0;

        notaFiscal.append("========== NOTA FISCAL ==========\n");

        for (Compra compra : compras) {
            Produto produto = compra.getProduto();
            float subtotal = produto.getValue() * compra.getStockQuantity();

            notaFiscal.append("Produto: ").append(produto.getName())
                    .append("\nQuantidade: ").append(compra.getStockQuantity())
                    .append("\nValor Unitário: ").append(produto.getValue())
                    .append("\nSubtotal: ").append(subtotal)
                    .append("\n-------------------------------\n");

            total += subtotal;
        }

        notaFiscal.append("Total da compra: ").append(total)
                .append("\n================================");

        JOptionPane.showMessageDialog(null, notaFiscal.toString());
        compras.clear();
        JOptionPane.showMessageDialog(null, "Agradecemos pela preferência!");
    }

}
