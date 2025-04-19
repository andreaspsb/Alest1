package T1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContadorDeTexto {
    public static void main(String[] args) throws FileNotFoundException {

        // Verifica se o arquivo foi passado como argumento
        if (args.length == 0) {
            System.out.println("Nenhum arquivo foi passado como argumento.");
            System.exit(1);
        }
        
        String nomeArquivo = args[0];
        
        // Verifica se o arquivo existe
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
            System.exit(1);
        }
        // Verifica se o arquivo é um arquivo de texto
        if (!arquivo.isFile()) {
            System.out.println("O caminho fornecido não é um arquivo: " + nomeArquivo);
            System.exit(1);
        }
        // Verifica se o arquivo é legível
        if (!arquivo.canRead()) {
            System.out.println("Não é possível ler o arquivo: " + nomeArquivo);
            System.exit(1);
        }
        // Verifica se o arquivo é um arquivo de texto
        if (!nomeArquivo.endsWith(".txt")) {
            System.out.println("O arquivo não é um arquivo de texto: " + nomeArquivo);
            System.exit(1);
        }

        ListaEncadeada lPalavras = new ListaEncadeada();
        ListaEstatica lPalindromos = new ListaEstatica();

        Scanner ler = new Scanner(arquivo);
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            // Remove caracteres especiais e transforma em minúsculas
            linha = linha.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
            // Divide a linha em palavras
            String[] palavras = linha.split("[\\s]+");

            for (String palavra : palavras) {
                if (lPalavras.existe(palavra)) {
                    // Se a palavra já existe, incrementa a quantidade
                    lPalavras.incrementarQuantidade(palavra);

                } else {
                    // Adiciona a palavra na lista encadeada
                    lPalavras.adicionar(palavra);
                }

                // Verifica se a palavra é um palíndromo
                if (palavra.equals(new StringBuilder(palavra).reverse().toString()) && palavra.length() > 1) {
                    if (!lPalindromos.contem(palavra)) {
                        // Adiciona a palavra na lista estática
                        lPalindromos.adicionar(palavra);
                    }
                }
            }
        }

        // imprime o total de palavras
        System.out.println("Total de palavras: " + lPalavras.retornarTamanho());
        System.out.println();

        // imprime as 20 palavras mais frequentes
        System.out.println("20 palavras mais frequentes:");
        lPalavras.ordenarPorQuantidade();
        for (int i = 0; i < 20 && i < lPalavras.retornarTamanho(); i++) {
            System.out.println(lPalavras.buscar(i).toString());
        }

        System.out.println();

        // imprime os palíndromos
        System.out.println("Palíndromos:");
        System.out.println(lPalindromos.toString());
        System.out.println();

        ler.close();

        //encerra o programa
        System.out.println("Pressione qualquer tecla para encerrar o programa.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
        System.exit(0);

    }
}
