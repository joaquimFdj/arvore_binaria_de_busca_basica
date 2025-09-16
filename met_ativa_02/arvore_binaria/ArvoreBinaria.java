package arvore_binaria;
// JOAQUIM DOS ANJOS FARACO

public class ArvoreBinaria {

    private Node raiz;

    public ArvoreBinaria(int dado) {
        this.raiz = new Node(dado);
    }

    private boolean estaVazia() {
        return this.raiz == null;
    }

    private void recursaoInserirNode(Node pai, Node novoNode) {

        if (novoNode.lerDado() >= pai.lerDado()) {
            if (pai.lerDireito() == null) {
                pai.setDireito(novoNode);
            } else {
                recursaoInserirNode(pai.lerDireito(), novoNode);
            }
        } else {
            if (pai.lerEsquerdo() == null) {
                pai.setEsquerdo(novoNode);
            } else {
                recursaoInserirNode(pai.lerEsquerdo(), novoNode);
            }
        }

    }

    public void inserirDado(int dado) {
        if (this.estaVazia()) {this.raiz = new Node(dado);}
        else {
            recursaoInserirNode(this.raiz, new Node(dado));
        }
    }

    private int recursaoTamanhoAtual(Node atual) {
        int contador = 1;
        if (atual.lerEsquerdo() != null) {
            contador += recursaoTamanhoAtual(atual.lerEsquerdo());
        }
        if (atual.lerDireito() != null) {
            contador += recursaoTamanhoAtual(atual.lerDireito());
        }
        return contador;
    }

    private int tamanhoAtual() {
        if (this.estaVazia()) {throw new IllegalStateException();}
        else {return this.recursaoTamanhoAtual(this.raiz);}
    }

    private int recursaoPreOrdem(Node atual, int[] lista, int indice) {
        lista[indice] = atual.lerDado();
        indice++;
        if (atual.lerEsquerdo() != null) {
            indice = recursaoPreOrdem(atual.lerEsquerdo(), lista, indice);
        }
        if (atual.lerDireito() != null) {
            indice = recursaoPreOrdem(atual.lerDireito(), lista, indice);
        }
        return indice;
    }

    public int[] preOrdem() {
        if (this.estaVazia()) {throw new IllegalStateException();}
        else {
            int[] elementos = new int[tamanhoAtual()];
            this.recursaoPreOrdem(this.raiz, elementos, 0);
            return elementos;
        }
    }

    private int recursaoInOrdem(Node atual, int[] lista, int indice) {
        if (atual.lerEsquerdo() != null) {
            indice = recursaoInOrdem(atual.lerEsquerdo(), lista, indice);
        }

        lista[indice] = atual.lerDado();
        indice ++;

        if (atual.lerDireito() != null) {
            indice = recursaoInOrdem(atual.lerDireito(), lista, indice);
        }
        return indice;
    }

    public int[] inOrdem() {
        if (this.estaVazia()) {throw new IllegalStateException();}
        else {
            int[] elementos = new int[tamanhoAtual()];
            this.recursaoInOrdem(this.raiz, elementos, 0);
            return elementos;
        }
    }

    private int recursaoPosOrdem(Node atual, int[] lista, int indice) {
        if (atual.lerEsquerdo() != null) {
            indice = recursaoPosOrdem(atual.lerEsquerdo(), lista, indice);
        }
        if (atual.lerDireito() != null) {
            indice = recursaoPosOrdem(atual.lerDireito(), lista, indice);
        }

        lista[indice] = atual.lerDado();
        indice++;

        return indice;
    }

    public int[] posOrdem() {
        if (this.estaVazia()) {throw new IllegalStateException();}
        else {
            int[] elementos = new int[tamanhoAtual()];
            this.recursaoPosOrdem(this.raiz, elementos, 0);
            return elementos;
        }
    }

    private Node recursaoRemoverMaior(Node pai, Node filho) {

        if (filho.lerDireito() == null) {
            pai.setDireito(filho.lerEsquerdo());
            filho.setEsquerdo(null);
            return filho;
        }

        return recursaoRemoverMaior(filho, filho.lerDireito());
    }

    public void removerMaiorElemento() {
        if (this.estaVazia()) {System.out.println("\narvore vazia!");}
        else if (this.raiz.lerDireito() == null) {
            Node aux = this.raiz;
            this.raiz = this.raiz.lerEsquerdo();
            aux.setEsquerdo(null);
            System.out.println("\nraiz era o maior elemento e foi removida");
        }
        else {
            Node removido = this.recursaoRemoverMaior(this.raiz, this.raiz.lerDireito());
            System.out.println("\nElemento com valor " + removido.lerDado() + " removido");
        }
    }

    private Node recursaoRemoverMenor(Node pai, Node filho) {
        if (filho.lerEsquerdo() == null) {
            pai.setEsquerdo(filho.lerDireito());
            filho.setDireito(null);
            return filho;
        }

        return recursaoRemoverMenor(filho, filho.lerEsquerdo());
    }

    public void removerMenorElemento() {
        if (this.estaVazia()) {System.out.println("\narvore vazia!");}
        else if (this.raiz.lerEsquerdo() == null) {
            Node aux = this.raiz;
            this.raiz = this.raiz.lerDireito();
            aux.setDireito(null);
            System.out.println("\nraiz era o menor elemento e foi removida");
        }
        else {
            Node removido = recursaoRemoverMenor(this.raiz, this.raiz.lerEsquerdo());
            System.out.println("\nElemento com valor " + removido.lerDado() + " removido");
        }
    }

}