package Aula14_fila_estatica;

public class App {
    public static void main(String[] args) {
        FilaEstatica f = new FilaEstatica();
        f.enfileirar("Junior");
        f.enfileirar("Samantha");
        f.enfileirar("Andreas");
        f.enfileirar("Eduarda");
        f.imprimir();

        System.out.println("tirei o -> " + f.desenfileirar());
        f.imprimir();

        f.enfileirar("Samantha");
        f.enfileirar("Andreas");
        f.enfileirar("Eduarda");
        f.imprimir();

        f.enfileirar("Joao");
        f.imprimir();
    }
}
