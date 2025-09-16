package arvoresbinaria;

public class Node {
    private Integer informacao;
    private Node esquerda;
    private Node direita;

    public Node(Integer informacao)
    {
        this.informacao = informacao;
        this.esquerda = null;
        this.direita = null;
    }

    public Integer getInformacao() {
        return informacao;
    }

    public void setInformacao(Integer informacao) {
        this.informacao = informacao;
    }

    public Node getDireita() {
        return direita;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(Node direita){
        this.direita = direita;
    }
}