package Aula24_arvore_binaria_pesquisa;

public class ArvoreBinariaPesquisa {
    private class Nodo {
        private int chave;
        private Nodo filhoEsquerda;
        private Nodo filhoDireita;
        private Nodo pai;

        public Nodo(int chave) {
            this.chave = chave;
        }

        public void imprimirFilhos() {
            System.out.println();
            if (filhoEsquerda != null) {
                System.out.print(filhoEsquerda.chave + " ");
            }
            if (filhoDireita != null) {
                System.out.print(filhoDireita.chave);
            }
            System.out.println();
        }

        public int getGrau() {
            int qtdFilhos = 0;

            if (filhoEsquerda != null) {
                qtdFilhos++;
            }
            if (filhoDireita != null) {
                qtdFilhos++;
            }

            return qtdFilhos;
        }
    }

    private Nodo raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa(int valor) {
        raiz = new Nodo(valor);
        tamanho = 1;
    }

    public void inserir(int chave) {
        Nodo n = new Nodo(chave);
        if (raiz == null) {
            raiz = n;
            return;
        }
        this.inserir(chave, n, raiz);
    }

    private void inserir(int chave, Nodo n, Nodo pai) {
        if (chave < pai.chave) {
            if (pai.filhoEsquerda == null) {
                pai.filhoEsquerda = n;
                n.pai = pai;
                tamanho++;
            } else {
                inserir(chave, n, pai.filhoEsquerda);
            }
        } else {
            if (pai.filhoDireita == null) {
                pai.filhoDireita = n;
                n.pai = pai;
                tamanho++;
            } else {
                inserir(chave, n, pai.filhoDireita);
            }
        }
    }

    public void imprimirFilhos(int pai) {
        Nodo nodoPai = obterNodo(pai);
        if (nodoPai == null) {
            System.out.println("Nodo não encontrado");
            return;
        }
        nodoPai.imprimirFilhos();
    }

    private Nodo obterNodo(int pai) {
        return buscarNodoRecursivo(raiz, pai);
    }

    private Nodo buscarNodoRecursivo(Nodo n, int chave) {
        if (n == null) {
            return null;
        }
        if (n.chave == chave) {
            return n;
        }

        Nodo encontrado;
        if (chave < n.chave) {
            encontrado = buscarNodoRecursivo(n.filhoEsquerda, chave);
        } else {
            encontrado = buscarNodoRecursivo(n.filhoDireita, chave);
        }

        return encontrado;
    }

    public int obterPai(int chave) {
        Nodo nodo = obterNodo(chave);
        if (nodo == null) {
            System.out.println("Nodo não encontrado");
            return -1;
        }
        if (nodo.pai == null) {
            System.out.println("Nodo raiz");
            return -1;
        }
        return nodo.pai.chave;
    }

    public int obterTamanho() {
        return this.tamanho;
    }

    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    public int getGrau(int chave) {
        Nodo n = obterNodo(chave);
        if (n == null) {
            return -1;
        }

        return n.getGrau();
    }

    public void remover(int chave) {
        Nodo n = obterNodo(chave);
        if (n == null) {
            return;
        }

        Nodo pai = n.pai;

        int grau = n.getGrau();
        if (grau == 0) {
            if (obterTamanho() == 1) {
                limpar();
                return;
            }
            if (pai.filhoEsquerda != null && pai.filhoEsquerda.chave == chave) {
                pai.filhoEsquerda = null;
            } else {
                pai.filhoDireita = null;
            }
        } else if (grau == 1) {
            Nodo filho;
            if (n.filhoEsquerda != null) {
                filho = n.filhoEsquerda;
            } else {
                filho = n.filhoDireita;
            }
            filho.pai = pai;
            if (pai != null) {
                if (pai.filhoEsquerda != null && pai.filhoEsquerda.chave == chave) {
                    pai.filhoEsquerda = filho;
                } else {
                    pai.filhoDireita = filho;
                }
            } else {
                raiz = filho;
            }
        } else {
            Nodo[] elementosArvoreDireita = elementosCentralOrdem(n.filhoDireita);
            Nodo substituto = elementosArvoreDireita[0];

            substituto.pai.filhoEsquerda = null;

            substituto.filhoEsquerda = n.filhoEsquerda;

            if (substituto.chave != n.filhoDireita.chave) {
                substituto.filhoDireita = n.filhoDireita;
            }

            substituto.filhoEsquerda.pai = substituto;

            if (substituto.filhoDireita != null) {
                substituto.filhoDireita.pai = substituto;
            }

            substituto.pai = pai;
            if (pai != null) {
                if (pai.filhoEsquerda != null && pai.filhoEsquerda.chave == chave) {
                    pai.filhoEsquerda = substituto;
                } else {
                    pai.filhoDireita = substituto;
                }
            } else {
                raiz = substituto;
            }
        }

        tamanho--;
    }

    public int[] elementosPosOrdem() {
        if (tamanho == 0) {
            return null;
        }
        int[] elementos = new int[tamanho];
        Nodo n = raiz;
        Integer pos = 0;
        pos = elementosPosOrdem(elementos, n.filhoEsquerda, pos);
        pos = elementosPosOrdem(elementos, n.filhoDireita, pos);

        elementos[pos] = n.chave;

        return elementos;
    }

    private Integer elementosPosOrdem(int[] elementos, Nodo n, Integer pos) {
        if (n == null) {
            return pos;
        }

        pos = elementosPosOrdem(elementos, n.filhoEsquerda, pos);
        pos = elementosPosOrdem(elementos, n.filhoDireita, pos);

        elementos[pos] = n.chave;
        pos++;
        return pos;
    }

    private Nodo[] elementosCentralOrdem(Nodo raiz) {
        if (tamanho == 0) {
            return null;
        }
        Nodo[] elementos = new Nodo[tamanho];
        Nodo n = raiz;
        Integer pos = 0;
        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);        

        return elementos;
    }

    private Integer elementosCentralOrdem(Nodo[] elementos, Nodo n, Integer pos) {
        if (n == null) {
            return pos;
        }

        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);
        
        return pos;
    }

    public int[] elementosPreOrdem() {
        if (tamanho == 0) {
            return null;
        }

        int[] elementos = new int[tamanho];
        Nodo n = raiz;
        Integer pos = 0;

        elementos[pos] = n.chave;
        pos++;
        pos = elementosPreOrdem(elementos, n.filhoEsquerda, pos);
        pos = elementosPreOrdem(elementos, n.filhoDireita, pos);        

        return elementos;
    }

    private Integer elementosPreOrdem(int[] elementos, Nodo n, Integer pos) {
        if (n == null) {
            return pos;
        }

        elementos[pos] = n.chave;
        pos++;
        pos = elementosPreOrdem(elementos, n.filhoEsquerda, pos);        
        pos = elementosPreOrdem(elementos, n.filhoDireita, pos);
        
        return pos;
    }

    public int[] elementosCentralOrdem() {
        if (tamanho == 0) {
            return null;
        }

        int[] elementos = new int[tamanho];
        Nodo n = raiz;
        Integer pos = 0;

        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n.chave;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);        

        return elementos;
    }

    private Integer elementosCentralOrdem(int[] elementos, Nodo n, Integer pos) {
        if (n == null) {
            return pos;
        }

        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n.chave;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);
        
        return pos;
    }
}
