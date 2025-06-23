package Aula21_arvore_generica_com_array;

public class ArvoreGenerica {

    class Nodo {
        private int CAPACIDADE = 5;
        private Nodo[] filhos;
        private Nodo pai;
        private int numFilhos;
        private String valor;

        public Nodo(String valor) {
            this.valor = valor;
            filhos = new Nodo[CAPACIDADE];
        }

        public void adicionarFilho(Nodo filho) {
            if (numFilhos == filhos.length) {
                duplicar();
            }

            filho.pai = this;
            filhos[numFilhos] = filho;
            numFilhos++;
        }

        private void duplicar() {
            Nodo[] aux = new Nodo[CAPACIDADE * 2];
            CAPACIDADE = CAPACIDADE * 2;

            for (int i = 0; i < filhos.length; i++) {
                aux[i] = filhos[i];
            }

            filhos = aux;
        }

        public void imprimirFilhos() {
            System.out.println();
            for (int i = 0; i < numFilhos; i++) {
                System.out.print(filhos[i].valor + " ");
            }
            System.out.println();
        }
    }

    private Nodo raiz;

    private int tamanho;

    public ArvoreGenerica(String valor) {
        adicionarRaiz(valor);
    }

    public void adicionarRaiz(String valor) {
        if (raiz != null) {
            return;
        }
        raiz = new Nodo(valor);
        tamanho = 1;
    }

    public void adicionarFilho(String pai, String valor) {
        Nodo nodoPai = obterNodo(pai);
        if (nodoPai == null) {
            return;
        }
        Nodo filho = new Nodo(valor);
        nodoPai.adicionarFilho(filho);
        tamanho++;
    }

    public void imprimirFilhos(String pai) {
        Nodo nodoPai = obterNodo(pai);
        if (nodoPai == null) {
            System.out.println("Nodo não encontrado");
            return;
        }
        nodoPai.imprimirFilhos();
    }

    private Nodo obterNodo(String pai) {
        return buscarNodoRecursivo(raiz, pai);
    }

    private Nodo buscarNodoRecursivo(Nodo n, String chave) {
        if (n == null) {
            return null;
        }
        if (n.valor.equals(chave)) {
            return n;
        }

        for (int i = 0; i < n.numFilhos; i++) {
            Nodo encontrado = buscarNodoRecursivo(n.filhos[i], chave);
            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    public int obterTamanho() {
        return this.tamanho;
    }

    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    public String obterPai(String chave) {
        Nodo nodo = obterNodo(chave);
        if (nodo == null) {
            System.out.println("Nodo não encontrado");
            return null;
        }
        return nodo.pai.valor;
    }

    public void imprimirArvoreCompleta() {
        this.imprimirArvoreCompleta(raiz);
    }

    private void imprimirArvoreCompleta(Nodo n) {
        if (n == null) {
            return;
        }
        System.out.println(n.valor);

        for (int i = 0; i < n.numFilhos; i++) {
            imprimirArvoreCompleta(n.filhos[i]);            
        }
    }

}
