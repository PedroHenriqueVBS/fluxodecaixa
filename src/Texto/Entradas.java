package Texto;

import Caixa.Gerenciamento;

import java.util.Scanner;

public class Entradas {

    public static String[] listarOpcoes() {
        return new String[] {
                "1) Cadastrar produto",
                "2) Editar produtos",
                "3) Listar produtos",
                "4) Remover um produto",
                "5) Adicionar produto a lista de compras",
                "6) Listar items",
                "7) Finalizar a compra",
                "8) Sair do programa"
        };
    }

}
