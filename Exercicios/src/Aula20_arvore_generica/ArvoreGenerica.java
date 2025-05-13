package Aula20_arvore_generica;

public class ArvoreGenerica {

    class Nodo {
        private String valor;
        private Nodo primeiroFilho;
        private Nodo proximoIrmao;

        public Nodo(String valor) {
            this.valor = valor;
        }

        public void adicionarFilho(String valor) {
            tamanho++;
            Nodo novoFilho = new Nodo(valor);
            if (this.primeiroFilho == null) {
                this.primeiroFilho = novoFilho;
                return;
            }

            Nodo aux = this.primeiroFilho;
            while (aux != null) {
                if (aux.proximoIrmao == null) {
                    aux.proximoIrmao = novoFilho;
                    return;
                }
                aux = aux.proximoIrmao;
            }
        }

        public void adicionarIrmao(String valor) {
            tamanho++;
            Nodo novoIrmao = new Nodo(valor);
            if (this.proximoIrmao == null) {
                this.proximoIrmao = novoIrmao;
                return;
            }

            Nodo aux = this.proximoIrmao;
            while (aux != null) {
                if (aux.proximoIrmao == null) {
                    aux.proximoIrmao = novoIrmao;
                    return;
                }
                aux = aux.proximoIrmao;
            }
        }
    }

    private Nodo raiz;
    int tamanho;

    public ArvoreGenerica(String valor) {
        raiz = new Nodo(valor);
        tamanho = 1;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    public Nodo getNodo(String valor) {
        return buscarNodoRecursivo(raiz, valor);
    }

    private Nodo buscarNodoRecursivo(Nodo n, String chave) {
        if (n == null) {
            return null;
        }
        if (n.valor.equals(chave)) {
            return n;
        }

        Nodo filho = n.primeiroFilho;
        while (filho != null) {
            Nodo r = buscarNodoRecursivo(filho, chave);
            if (r == null) {
                return r;
            }
            filho = filho.proximoIrmao;
        }
        
        return filho;
    }

    public int getAltura() {
        if (raiz == null) {
            return 0;
        }

        int i = 0;
        Nodo aux = raiz;
        while (aux != null) {
            i++;
            aux = aux.primeiroFilho;
        }

        return i;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getGrau(String chave) {
        Nodo n = getNodo(chave);
        if (n == null) {
            return -1;
        }
        int qtdFilhos = 0;
        Nodo filho = n.primeiroFilho;
        while (filho != null) {
            qtdFilhos++;
            filho = filho.proximoIrmao;
        }
        return qtdFilhos;
    }

    public String getPai(String chave) {

    }    

    public void imprimir() {

    }

    public void imprimirFilhos(Nodo pai) {
        Nodo aux = pai.primeiroFilho;
        while (aux != null) {
            System.out.println(aux.valor + " ");
            aux = aux.proximoIrmao;
        }
    }
}
