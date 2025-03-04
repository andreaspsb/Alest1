package Aula01;

public class Exercicio01 {
    public String retornarInteirosDe0aN(int n) {
        StringBuilder retorno = new StringBuilder();
            for (int index = 0; index <= n; index++) {
                retorno = retorno.append(String.valueOf(index));
            }
        return retorno.toString();
    }
}
