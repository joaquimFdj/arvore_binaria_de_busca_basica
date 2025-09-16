package arvore_binaria;
// JOAQUIM DOS ANJOS FARACO

public class Main {

    public static void main(String[] args) {
        // ####### TESTES #################################
        ArvoreBinaria arvore_teste = new ArvoreBinaria(5);

        arvore_teste.inserirDado(12);
        arvore_teste.inserirDado(1);
        arvore_teste.inserirDado(3);
        arvore_teste.inserirDado(4);
        arvore_teste.inserirDado(42);
        arvore_teste.inserirDado(14);
        arvore_teste.inserirDado(17);
        arvore_teste.inserirDado(100);

        int[] vetor_pre_ordem = arvore_teste.preOrdem();
        int[] vetor_in_ordem = arvore_teste.inOrdem();
        int[] vetor_pos_ordem = arvore_teste.posOrdem();

        System.out.println("\n\nvetor_pre_ordem:");
        for (int elemento: vetor_pre_ordem) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n");

        System.out.println("\n\nvetor_in_ordem:");
        for (int elemento: vetor_in_ordem) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n");

        System.out.println("\n\nvetor_pos_ordem:");
        for (int elemento: vetor_pos_ordem) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n");

        System.out.println("\nRemover maior elemento da arvore:");
        arvore_teste.removerMaiorElemento();
        vetor_in_ordem = arvore_teste.inOrdem();
        System.out.println("\n\nvetor_in_ordem apos remocao:");
        for (int elemento: vetor_in_ordem) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n");

        System.out.println("\nRemover menor elemento da arvore:");
        arvore_teste.removerMenorElemento();
        vetor_in_ordem = arvore_teste.inOrdem();
        System.out.println("\n\nvetor_in_ordem apos remocao:");
        for (int elemento: vetor_in_ordem) {
            System.out.print(elemento + " ");
        }
        System.out.println("\n");
        // ##############################################

    }

}