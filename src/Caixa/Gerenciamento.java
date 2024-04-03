package Caixa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("\n" + "O produto que será adicionado já foi cadastrado. Por favor, insira um novo\n" + "produto!" + "\n");
        } else {
            Produto p1 = new Produto(nome,valor);
            produtos.add(p1);
            System.out.println("\n" + "Cadastrado com sucesso!!" + "\n");
        }
    }

    public static void editar(int codigo) {

        Scanner sc = new Scanner(System.in);

        boolean produtoEncontrado = false; //variavel de verificação

        for (Produto produto : produtos) {

            if (produto.getCode() == codigo) {
                System.out.print("\n" + "Digite o novo nome do produto:");
                String novoNome = sc.nextLine();
                System.out.print("Digite o novo valor do produto:");
                float novoValor = sc.nextFloat();
                produto.setName(novoNome); // set para atribuir um novo valor
                produto.setValue(novoValor); // set para atribuir um novo valor
                produtoEncontrado = true;
                System.out.println("\n" + "Produto editado com sucesso!" + "\n");
            }
        }
        if (!produtoEncontrado) {
            System.out.println("\n" + "Produto não encontrado. Não foi possível editar.");
        }
    }

    public static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos na lista!!" + "\n");
        } else {
            for (Produto produto : produtos) {
                System.out.println("Codigo: " + produto.getCode() + "\nNome: " + produto.getName() + "\nValor: " + produto.getValue() + "\n");
            }
        }
    }

    public static void remover(int codigo) {
        Produto produtoRemovido = null;

        for (Produto produto : produtos) {
            if (produto.getCode() == codigo) {
                produtoRemovido = produto;
                //verifica se o codigo digitado é referente ao produto e deixa alocado na variavel produtoRemovido
            }
        }
        if (produtoRemovido != null) {
            produtos.remove(produtoRemovido);
            System.out.println("\n" + "Produto removido com sucesso!" + "\n");
        } else {
            System.out.println("\n" + "Produto não encontrado. Não foi possível remover.");
        }
    }

    public static void adicionarCompra(int codigo) {

        boolean produtoEncontrado = false;

        for (Compra compra : compras) {
            if (compra.getProduto().getCode() == codigo) {
                System.out.println("\n" + "Este produto já foi adicionado à lista de compras." + "\n");
                return; // Se o produto já foi adicionado, saia do método
            }
        }

        for (Produto produto : produtos) {
            if (produto.getCode() == codigo) {
                Compra c1 = new Compra(produto);
                compras.add(c1);
                System.out.println("\n"+"Produto adicionado com sucesso!!"+ "\n");
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("\n" + "Produto não encontrado. Não foi possível adicionar à lista de compras." + "\n");
        }
    }

    public static void listarCompra() {
        if (compras.isEmpty()) {
            System.out.println("\n" + "Não há compras realizadas!\n");
        } else {
            float total = 0;
            for (Compra compra : compras) {
                total += compra.getProduto().getValue();
                System.out.println(compra.toString());
            }
            System.out.println("Total da compra: " + total + "\n");
        }
    }

    public static void finalizarCompra() {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Digite: (1) para finalizar a compra
                Digite: (2) para continuar comprando
                """);
        int finalCompra = sc.nextInt();
        if (finalCompra == 1) {
            compras.clear();
            System.out.println("Agradecemos pela preferencia!!!");
        }
    }
}