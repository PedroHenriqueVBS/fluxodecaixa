import Caixa.Gerenciamento;
import Texto.Entradas;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nomeProduto;
        int codigoProduto;
        float valorProduto;
        int produtos;

        Entradas.listarOpcoes();
        produtos = sc.nextInt();
        sc.nextLine();
        System.out.println();

        while (produtos != 8) {

            if (produtos == 1) {
                System.out.print("Nome do produto: ");
                nomeProduto = sc.nextLine();
                System.out.print("Valor do produto: ");
                valorProduto = sc.nextFloat();

                Gerenciamento.cadastrar(nomeProduto, valorProduto);

            } else if (produtos == 2) {
                System.out.print("Codigo do produto: ");
                codigoProduto = sc.nextInt();
                Gerenciamento.editar(codigoProduto);

            } else if (produtos == 3) {
                Gerenciamento.listar();

            } else if (produtos == 4) {
                System.out.print("Codigo do produto: ");
                codigoProduto = sc.nextInt();
                Gerenciamento.remover(codigoProduto);

            } else if (produtos == 5) {
                System.out.print("Codigo do produto: ");
                codigoProduto = sc.nextInt();
                Gerenciamento.adicionarCompra(codigoProduto);
            } else if (produtos == 6) {
                Gerenciamento.listarCompra();
            } else if (produtos == 7) {
                Gerenciamento.finalizarCompra();
            } else if (produtos == 8) {
            }

            Entradas.listarOpcoes();
            produtos = sc.nextInt();
            sc.nextLine();
            System.out.println();
        }

    }
}