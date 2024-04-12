import Caixa.Gerenciamento;
import Texto.Entradas;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        int produtos;

        Entradas.listarOpcoes();
        produtos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do que você deseja seguir: "));


        while (produtos != 8) {

            if (produtos == 1) {
                Entradas.condicaoUm();
            } else if (produtos == 2) {
                Entradas.condicaoDois();
            } else if (produtos == 3) {
                Gerenciamento.listar();
            } else if (produtos == 4) {
                Entradas.condicaoTres();
            } else if (produtos == 5) {
                Entradas.condicaoQuatro();
            } else if (produtos == 6) {
                Gerenciamento.listarCompra();
            } else if (produtos == 7) {
                Gerenciamento.finalizarCompra();
            }

            Entradas.listarOpcoes();
            produtos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do que você deseja seguir: "));

        }

    }
}
