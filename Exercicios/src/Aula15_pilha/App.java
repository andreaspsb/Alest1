package Aula15_pilha;

public class App {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        pilha.empilhar("Junior");
        pilha.empilhar("Samantha");
        pilha.empilhar("Andreas");
        pilha.imprimir();

        System.out.println("tirei o -> " + pilha.desempilhar());
        pilha.imprimir();

        pilha.empilhar("Samantha");
        pilha.empilhar("Andreas");
        pilha.empilhar("Eduarda");
        pilha.imprimir();

    }

}
