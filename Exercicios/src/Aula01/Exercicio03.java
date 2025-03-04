package Aula01;

public class Exercicio03 {

    public boolean verificarNumeroPrimo(int i) {

        for (int index = 2; index < i; index++) {
            if (i % index == 0) {
                return false;
            }
        }

        return true;
    }

}
