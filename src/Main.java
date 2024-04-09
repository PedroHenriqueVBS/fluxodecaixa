import Caixa.Gerenciamento;
import Texto.Entradas;
import javax.swing.JOptionPane;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Lista de controle de produtos.");
        String[] opcoes = Entradas.listarOpcoes();
        JOptionPane.showMessageDialog(null, opcoes);

        int produtos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da opção desejada:"));

        while(produtos != 8) {
            if (produtos == 1) {
                String nomeProduto = JOptionPane.showInputDialog("Nome do produto:");
                float valorProduto = Float.parseFloat(JOptionPane.showInputDialog("Valor do produto:"));
                Gerenciamento.cadastrar(nomeProduto, valorProduto);
            } else {
                int codigoProduto;
                if (produtos == 2) {
                    codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
                    Gerenciamento.editar(codigoProduto);
                } else if (produtos == 3) {
                    Gerenciamento.listar();
                } else if (produtos == 4) {
                    codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
                    Gerenciamento.remover(codigoProduto);
                } else if (produtos == 5) {
                    codigoProduto = Integer.parseInt(JOptionPane.showInputDialog("Código do produto:"));
                    Gerenciamento.adicionarCompra(codigoProduto);
                } else if (produtos == 6) {
                    Gerenciamento.listarCompra();
                } else if (produtos == 7) {
                    Gerenciamento.finalizarCompra();
                }
            }

            opcoes = Entradas.listarOpcoes();
            JOptionPane.showMessageDialog(null, opcoes);
            produtos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da opção desejada:"));
        }
    }
}
