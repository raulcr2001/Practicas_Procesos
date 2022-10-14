package PorBloques;

public class PorBloques {
    public static void main(String[] args){
        int n = 31;
        int numHebras = 5;
        int miId = 0;

        int tam = (n+numHebras-1)/numHebras;
        int ini = miId * tam;
        int fin = Math.min(n,(miId+1)*tam);

        for (int i = ini;i < fin;i++){
            System.out.println(i);
        }
    }
}
