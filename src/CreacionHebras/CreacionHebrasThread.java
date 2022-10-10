package CreacionHebras;

public class CreacionHebrasThread {

    public static void main(String args[]){
        int numHebras = 2;

        numHebra[] v = new numHebra[10];

        for(int i = 0;i < numHebras;i++){
            v[i] = new numHebra(i);
        }

        for(int i = 0;i < numHebras;i++){
            v[i].start();
        }

        for(int i = 0;i < numHebras;i++){
            try{
                v[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            };
        }
    }
}

class numHebra extends Thread{
    int idHebra;
    public numHebra (int idHebra){
        this.idHebra = idHebra;
    }

    public void run(){
        for(int i = 0;i < 1000;i++) {
            System.out.println(idHebra);
        }
    }
}