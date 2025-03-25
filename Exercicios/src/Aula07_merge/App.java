package Aula07_merge;

public class App {
    public static int[] mergear(int[] a, int b[]) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        return c;
    }

    public static int[] mergearOrdenado(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        // Se ainda houver elementos em a ou b
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        
        return c;
    }

    public static void main(String[] args) {
        int[] a = {10, 14, 20};
        int[] b = {12, 15, 32};
        int[] c = mergearOrdenado(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
