package arvoresbinaria;

public class ArvoreBinaria {
    private Node raiz;
    public ArvoreBinaria(){
        this.raiz = null;
    }

    // As 2 funções abaixo são para inserir
    public void inserir(int informacao){
        if (vazia(this.raiz)){
            this.raiz = new Node(informacao);
        }
        else {
            this.raiz = recursaoInserir(this.raiz, informacao);
        }
    }
    private Node recursaoInserir(Node no, int informacao){
        if(vazia(no)){
            return new Node(informacao);
        }

        if(informacao < no.getInformacao()){
            no.setEsquerda(recursaoInserir(no.getEsquerda(), informacao));
        }
        else if (informacao > no.getInformacao()){
            no.setDireita(recursaoInserir(no.getDireita(), informacao));
        }
        else{
            System.out.println("Valor já inserido: " + informacao);
        }
        return no;
    }

    //As 2 funções abaixo são para Percorrer o Pré-ordem
    private void recursaoPre(Node no){
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
    private void recursaoIn(Node no){
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
    private void recursaoPos(Node no){
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

    //As 2 funções abaixo são para remover um nó pelo valor do nó
    public void removerValor(int informacao){
        System.out.println("\nRemovendo o valor escolhido da arvore: " + informacao);
        this.raiz = recursaoRemoverValor(this.raiz, informacao);
    }
    private Node recursaoRemoverValor(Node no, int informacao){
        if (vazia(no)){
            return null;
        }

        if(informacao < no.getInformacao()){
            no.setEsquerda(recursaoRemoverValor(no.getEsquerda(), informacao));
        }
        else if (informacao > no.getInformacao()){
            no.setDireita(recursaoRemoverValor(no.getDireita(), informacao));
        }
        else{
            if (vazia(no.getEsquerda())){
                return no.getDireita();
            }
            else if (vazia(no.getDireita())){
                return no.getEsquerda();
            }
            else{
                Node substituir = encontrarMenorValor(no.getDireita());
                no.setInformacao(substituir.getInformacao());
                no.setDireita(recursaoRemoverValor(no.getDireita(), substituir.getInformacao()));
            }
        }
        return no;
    }

    // As 2 funções abaixo são para a remocão do menor nó
    private Node recursaoRemoverMenor(Node no){
        if (vazia(no.getEsquerda())){
            return no.getDireita();
        }
        no.setEsquerda(recursaoRemoverMenor(no.getEsquerda()));
        return no;
    }
    public void removerMenor(){
        System.out.println("\n\nRemovendo o menor nó");
        this.raiz = recursaoRemoverMenor(this.raiz);
    }

    // As 2 funções abaixo são para a remocão do maior nó
    private Node recursaoRemoverMaior(Node no){
        if (vazia(no.getDireita())){
            return no.getEsquerda();
        }
        no.setDireita(recursaoRemoverMaior(no.getDireita()));
        return no;
    }
    public void removerMaior(){
        System.out.println("\n\nRemovendo o maior nó");
        this.raiz = recursaoRemoverMaior(this.raiz);
    }

    //Função para ver se o nó é nulo
    private boolean vazia(Node no){
        return no == null;
    }

    //Função para encontrar o menor valor
    private Node encontrarMenorValor(Node no){
        if (vazia(no)){
            return null;
        }
        if (vazia(no.getEsquerda())){
            return no;
        }
        return encontrarMenorValor(no.getEsquerda());
    }
}