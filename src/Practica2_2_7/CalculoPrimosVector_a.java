package Practica2_2_7;

public class CalculoPrimosVector_a {
    public static void main(String args[]) {
        int numHebras;
        long vectorNumeros[] = {
                200000033L, 200000039L, 200000051L, 200000069L,
                200000081L, 200000083L, 200000089L, 200000093L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L,
                4L, 4L, 4L, 4L, 4L, 4L, 4L, 4L
        };


        numHebras = 4;

        //implementacionSecuencial(vectorNumeros);

        //implementacionCiclica(vectorNumeros, numHebras);

        implementacionBloques(vectorNumeros, numHebras);


    }

    /*static void implementacionSecuencial(long[] vectorNumeros) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación secuencial.");

        t1 = System.nanoTime();

        //Escribe aquí la implementación secuencial
        for(int i = 0;i < vectorNumeros.length;i++){
            if(esPrimo(vectorNumeros[i]))
                System.out.println(vectorNumeros[i]);
        }

        //Fin de la implementación secuencial
        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo secuencial (seg.):\t\t\t" + tt);
    }*/

    /*static class MiHebraCiclica extends Thread{

        private int idHebra;
        private int numHebras;
        private long vector[];

        public MiHebraCiclica(int i, int numHebras, long vector[]){
            this.idHebra = i;
            this.numHebras = numHebras;
            this.vector = vector;
        }

        public void run(){
            try {
                for (int j = idHebra; j < vector.length; j += numHebras) {
                    if (esPrimo(vector[j])) {
                        System.out.println(vector[j]);
                    }
                }
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    static void implementacionCiclica(long[] vectorNumeros, int numHebras) {
        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación cíclica.");

        MiHebraCiclica v[] = new MiHebraCiclica[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraCiclica(i, numHebras, vectorNumeros);
            v[i].start();
        }

        for (int i = 0; i < numHebras; i++) {
            try {
                v[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo cíclico (seg.):\t\t\t" + tt);
    }*/


//------------------------------------------------------------------------------------------------------------

    static class MiHebraBloques extends Thread{
        private int idHebra;
        private int numHebras;
        private long vector[];

        public MiHebraBloques(int i, int numHebras, long vector[]){
            this.idHebra = i;
            this.numHebras = numHebras;
            this.vector = vector;
        }

        public void run(){
            try {
                int tam = (vector.length + numHebras-1)/numHebras;
                int ini = idHebra * tam;
                int fin = Math.min(vector.length,(idHebra + 1)*tam);

                for(int i = ini;i < fin;i++){
                    if(esPrimo(vector[i])) {
                        System.out.println(vector[i]);
                    }
                }
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    static void implementacionBloques(long[] vectorNumeros, int numHebras) {

        long t1;
        long t2;
        double tt;

        System.out.println("");
        System.out.println("Implementación por bloques.");

        MiHebraBloques v[] = new MiHebraBloques[numHebras];

        t1 = System.nanoTime();

        for (int i = 0; i < numHebras; i++) {
            v[i] = new MiHebraBloques(i, numHebras, vectorNumeros);
            v[i].start();
        }

        for (int i = 0; i < numHebras; i++) {
            try {
                v[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        t2 = System.nanoTime();
        tt = ((double) (t2 - t1)) / 1.0e9;

        System.out.println("Tiempo Bloques (seg.):\t\t\t" + tt);
    }

    static boolean esPrimo( long num ) {
        boolean primo;
        if( num < 2 ) {
            primo = false;
        } else {
            primo = true;
            long i = 2;
            while( ( i < num )&&( primo ) ) {
                primo = ( num % i != 0 );
                i++;
            }
        }
        return( primo );
    }
}