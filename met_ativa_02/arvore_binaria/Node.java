package arvore_binaria;
// JOAQUIM DOS ANJOS FARACO

public class Node {

    private int dado;
    private Node esquerdo;
    private Node direito;

    public Node(int dado) {
        this.dado = dado;
        this.esquerdo = null;
        this.direito = null;
    }

    public Node lerEsquerdo() {return this.esquerdo;}

    public Node lerDireito() {return this.direito;}

    public void setEsquerdo(Node esquerdo) {
        this.esquerdo = esquerdo;
    }

    public void setDireito(Node direito) {this.direito = direito; }

    public int lerDado() {
        return this.dado;
    }

    public void setDado(int dado) {this.dado = dado;}
    
}