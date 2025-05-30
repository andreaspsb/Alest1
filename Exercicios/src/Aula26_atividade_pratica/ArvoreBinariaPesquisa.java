package Aula26_atividade_pratica;

public class ArvoreBinariaPesquisa<T extends Comparable<T>> {

    private class Nodo<T extends Comparable<T>> {
        private T chave;
        private Nodo<T> filhoEsquerda;
        private Nodo<T> filhoDireita;
        private Nodo<T> pai;

        public Nodo(T chave) {
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

    private Nodo<T> raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa(T valor) {
        raiz = new Nodo<T>(valor);
        tamanho = 1;
    }

    public void inserir(T chave) {
        Nodo<T> n = new Nodo<T>(chave);
        if (raiz == null) {
            raiz = n;
            return;
        }
        this.inserir(chave, n, raiz);
    }

    private void inserir(T chave, Nodo<T> n, Nodo<T> pai) {
        if (chave.compareTo(pai.chave) < 0) {
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

    public void imprimirFilhos(T pai) {
        Nodo<T> nodoPai = obterNodo(pai);
        if (nodoPai == null) {
            System.out.println("Nodo não encontrado");
            return;
        }
        nodoPai.imprimirFilhos();
    }

    private Nodo<T> obterNodo(T pai) {
        return buscarNodoRecursivo(raiz, pai);
    }

    private Nodo<T> buscarNodoRecursivo(Nodo<T> n, T chave) {
        if (n == null) {
            return null;
        }
        if (n.chave == chave) {
            return n;
        }

        Nodo<T> encontrado;
        if (chave.compareTo(n.chave) < 0) {
            encontrado = buscarNodoRecursivo(n.filhoEsquerda, chave);
        } else {
            encontrado = buscarNodoRecursivo(n.filhoDireita, chave);
        }

        return encontrado;
    }

    public T obterPai(T chave) {
        Nodo<T> nodo = obterNodo(chave);
        if (nodo == null) {
            System.out.println("Nodo não encontrado");
            return null;
        }
        if (nodo.pai == null) {
            System.out.println("Nodo raiz");
            return null;
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

    public int getGrau(T chave) {
        Nodo<T> n = obterNodo(chave);
        if (n == null) {
            return -1;
        }

        return n.getGrau();
    }

    public void remover(T chave) {
        Nodo<T> n = obterNodo(chave);
        if (n == null) {
            return;
        }

        Nodo<T> pai = n.pai;

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
            Nodo<T> filho;
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
            Nodo<T>[] elementosArvoreDireita = elementosCentralOrdem(n.filhoDireita);
            Nodo<T> substituto = elementosArvoreDireita[0];

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

    private Nodo<T>[] elementosCentralOrdem(Nodo<T> raiz) {
        if (tamanho == 0) {
            return null;
        }
        Nodo<T>[] elementos = (ArvoreBinariaPesquisa<T>.Nodo<T>[]) new Object[tamanho];
        Nodo<T> n = raiz;
        Integer pos = 0;
        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);        

        return elementos;
    }

    private Integer elementosCentralOrdem(Nodo<T>[] elementos, Nodo<T> n, Integer pos) {
        if (n == null) {
            return pos;
        }

        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);
        
        return pos;
    }

    public T[] elementosPosOrdem() {
        if (tamanho == 0) {
            return null;
        }
        T[] elementos = (T[]) new Object[tamanho];
        Nodo<T> n = raiz;
        Integer pos = 0;
        pos = elementosPosOrdem(elementos, n.filhoEsquerda, pos);
        pos = elementosPosOrdem(elementos, n.filhoDireita, pos);

        elementos[pos] = n.chave;

        return elementos;
    }

    private Integer elementosPosOrdem(T[] elementos, Nodo<T> n, Integer pos) {
        if (n == null) {
            return pos;
        }

        pos = elementosPosOrdem(elementos, n.filhoEsquerda, pos);
        pos = elementosPosOrdem(elementos, n.filhoDireita, pos);

        elementos[pos] = n.chave;
        pos++;
        return pos;
    }    

    public T[] elementosPreOrdem() {
        if (tamanho == 0) {
            return null;
        }

        T[] elementos = (T[]) new Object[tamanho];
        Nodo<T> n = raiz;
        Integer pos = 0;

        elementos[pos] = n.chave;
        pos++;
        pos = elementosPreOrdem(elementos, n.filhoEsquerda, pos);
        pos = elementosPreOrdem(elementos, n.filhoDireita, pos);        

        return elementos;
    }

    private Integer elementosPreOrdem(T[] elementos, Nodo<T> n, Integer pos) {
        if (n == null) {
            return pos;
        }

        elementos[pos] = n.chave;
        pos++;
        pos = elementosPreOrdem(elementos, n.filhoEsquerda, pos);        
        pos = elementosPreOrdem(elementos, n.filhoDireita, pos);
        
        return pos;
    }

    public T[] elementosCentralOrdem() {
        if (tamanho == 0) {
            return null;
        }

        T[] elementos = (T[]) new Object[tamanho];
        Nodo<T> n = raiz;
        Integer pos = 0;

        pos = elementosCentralOrdem(elementos, n.filhoEsquerda, pos);
        elementos[pos] = n.chave;
        pos++;
        pos = elementosCentralOrdem(elementos, n.filhoDireita, pos);        

        return elementos;
    }

    private Integer elementosCentralOrdem(T[] elementos, Nodo<T> n, Integer pos) {
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
