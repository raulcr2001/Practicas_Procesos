package Control1;

public class Control1 {

    public static void main(String args[]){
        int numHebras = 100;

        numHebra[] v = new numHebra[100];

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
        for(int i = 0;i < 100;i++) {
            if(idHebra % 3 == 0 && idHebra % 5 == 0){
                System.out.println(idHebra);
            }
        }
    }
}