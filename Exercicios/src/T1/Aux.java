package T1;

public class Aux {
    public String palavra;
    public int quantidade;

    public Aux(String palavra, int quantidade) {
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