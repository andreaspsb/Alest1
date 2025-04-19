package T1;

public class ListaEstatica {

    private final int CAPACIDADE_INICIAL = 10;
    private String[] itens;
    private int tamanho;

    public ListaEstatica() {
        itens = new String[CAPACIDADE_INICIAL];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void limpar() {
        itens = new String[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    public boolean contem(String chave) {
        for (int i = 0; i < tamanho; i++) {
            if (itens[i].equals(chave)) {
                return true;
            }
        }
        return false;
    }

    public void adicionar(String item) {
        if (tamanho == itens.length) {
            duplicar();
        }
        itens[tamanho] = item;
        tamanho++;
    }

    public void adicionar(int posicao, String item) {
        if (tamanho == itens.length) {
            duplicar();
        }

        for (int i = tamanho; i > posicao; i--) {
            itens[i] = itens[i - 1];
        }

        itens[posicao] = item;
        tamanho++;
    }

    private void duplicar() {
        String[] novo = new String[itens.length * 2];
        for (int i = 0; i < itens.length; i++) {
            novo[i] = itens[i];
        }
        itens = novo;
    }

    public boolean remover(String item) {
        int p = obterPosicao(item);
        if (p < 0) {
            return false;
        }

        for (int i = p; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }

        itens[tamanho - 1] = null;
        tamanho--;
        return true;
    }

    public boolean remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return false;
        }

        for (int i = posicao; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }

        itens[tamanho - 1] = null;
        tamanho--;
        return true;
    }

    public int obterPosicao(String item) {
        for (int i = 0; i < tamanho; i++) {
            if (itens[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s = s + itens[i] + " ";
        }
        return s;
    }

    public int retornarTamanho() {
        return tamanho;
    }

}
