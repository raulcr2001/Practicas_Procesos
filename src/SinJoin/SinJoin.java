package SinJoin;

public class SinJoin {
    public static void main(String[] args) {
        Tarea1 t1 = new Tarea1 (0);
        Tarea1 t2 = new Tarea1 (1);
        Tarea1 t3 = new Tarea1(2);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
        } catch ( InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            t2.join();
        } catch ( InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            t3.join();
        } catch ( InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Final del programa");
    }
}

class Tarea1 extends Thread{
    private int idHebra;
    public Tarea1 (int idHebra){
        this.idHebra = idHebra;
    }
    public void run(){
        try{
            int x = (int) (Math.random() * 5000);
            Thread.sleep(x);
            System.out.println("Soy la hebra: "+ idHebra + "( " + x + ")" );
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
