package T1;

public class PalavraAux {
    public String palavra;
    public int quantidade;

    public PalavraAux(String palavra, int quantidade) {
        this.palavra = palavra;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Aux{" +
                "palavra = '" + palavra + '\'' +
                ", quantidade = " + quantidade +
                '}';
    }
}