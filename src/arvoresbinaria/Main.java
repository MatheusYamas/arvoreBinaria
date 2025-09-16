package arvoresbinaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        System.out.println("Insira os valores na arvore (Digite 0 para interromper): ");
        int item, valor;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) {
                break;
            }
            arvore.inserir(item);
        }
//        int[] numerosParaTeste = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};
//        for (int numero : numerosParaTeste) {
//            System.out.println("Inserindo o valor: " + numero);
//            arvore.inserir(numero);
//        }
        System.out.println("\nPercurso Pré-Ordem:");
        arvore.preOrdem();
        System.out.println("\n\nPercurso Em-Ordem:");
        arvore.inOrdem();
        System.out.println("\n\nPercurso Pós-Ordem:");
        arvore.posOrdem();
        arvore.removerMenor();
        arvore.inOrdem();
        arvore.removerMaior();
        arvore.inOrdem();
        System.out.println("\n\nDigite o valor que quer retirar da arvore: ");
        valor = scanner.nextInt();
        arvore.removerValor(valor);
        arvore.inOrdem();
        System.out.println("\n\nAlunos: Mateus Roese Tocunduva, Matheus Yamamoto Dias, Victor Ryuki Tamezava.");
    }
}
