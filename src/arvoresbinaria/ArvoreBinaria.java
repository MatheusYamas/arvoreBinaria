package arvoresbinaria;

import java.util.Scanner;

public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }
    // As 2 funções abaixo são para inserir
    public void inserir(int informacao){
        if (this.raiz == null){
            this.raiz = new Node(informacao);
        }
        else {
            this.raiz = recursaoInserir(this.raiz, informacao);
        }
    }
    public Node recursaoInserir(Node no, int informacao){
        if(vazia(no)){
            return new Node(informacao);
        }

        if(informacao < no.getInformacao()){
            no.setEsquerda(recursaoInserir(no.getEsquerda(), informacao));
        }
        else{
            no.setDireita(recursaoInserir(no.getDireita(), informacao));
        }
        return no;
    }

    //As 2 funções abaixo são para Percorrer o Pré-ordem
    public void recursaoPre(Node no){
        if(vazia(no)){
            return;
        }
        System.out.print(no.getInformacao() + " ");
        recursaoPre(no.getEsquerda());
        recursaoPre(no.getDireita());
    }
    public void preOrdem(){
        System.out.println("Percorrendo de forma Pré-Ordem:");
        recursaoPre(this.raiz);
    }

    // As 2 funções abaixos são para Percorrer o In-ordem
    public void recursaoIn(Node no){
        if (vazia(no)){
            return;
        }
        recursaoIn(no.getEsquerda());
        System.out.print(no.getInformacao() + " ");
        recursaoIn(no.getDireita());
    }
    public void inOrdem(){
        System.out.println("Percorrendo de forma In-ordem:");
        recursaoIn(this.raiz);
    }

    // As 2 funções abaixos são para Percorrer o Pos-ordem
    public void recursaoPos(Node no){
        if (vazia(no)){
            return;
        }
        recursaoPos(no.getEsquerda());
        recursaoPos(no.getDireita());
        System.out.print(no.getInformacao() + " ");
    }
    public void posOrdem(){
        System.out.println("Percorrendo de forma Pos-ordem:");
        recursaoPos(this.raiz);
    }

    // As 2 funções abaixo são para a remocão do menor nó
    public Node recursaoRemoverMenor(Node no){
        if (no.getEsquerda() == null){
            return no.getDireita();
        }
        no.setEsquerda(recursaoRemoverMenor(no.getEsquerda()));
        return no;
    }
    public void removerMenor(){
        System.out.println("Removendo o menor nó");
        recursaoRemoverMenor(this.raiz);
    }

    public boolean vazia(Node no){
        return no == null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        System.out.println("Insira valores na arvore: ");
//        int item;
//        while (true) {
//            item = scanner.nextInt();
//            if (item == 0) {
//                break;
//            }
//            arvore.inserir(item);
//        }
        int[] numerosParaTeste = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};
        for (int numero : numerosParaTeste) {
            System.out.println("Inserindo o valor: " + numero);
            arvore.inserir(numero);
        }
        System.out.println("Percurso Pré-Ordem (Esperado: 14 4 3 9 7 5 15 18 16 17 20)");
        System.out.println("Percurso Em-Ordem (Esperado: 3 4 5 7 9 14 15 16 17 18 20)");
        System.out.println("Percurso Pós-Ordem (Esperado: 3 5 7 9 4 17 16 20 18 15 14)");
        arvore.preOrdem();
        arvore.inOrdem();
        arvore.posOrdem();
        arvore.removerMenor();
    }
}
