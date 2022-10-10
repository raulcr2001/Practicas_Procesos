package CreacionHebras;

public class CreacionHebrasRunnable {

    public static void main(String args[]){
        int numHebras = 2;

        Tarea2[] v = new Tarea2[10];

        for(int i = 0;i < numHebras;i++){
            v[i] = new Tarea2(i);
        }

        for(int i = 0;i < numHebras;i++){
            Thread t1 = new Thread(v[i]);
            t1.start();
        }

        for(int i = 0;i < numHebras;i++){
            try{
                Thread t1 = new Thread(v[i]);
                t1.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            };
        }
    }
}

class Tarea2 implements Runnable {
    int idHebra;

    public Tarea2(int idHebra) {
        this.idHebra = idHebra;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(idHebra);
        }
    }
}
