package Ejercicio1;

import java.util.Random;

public class DownloadTask implements Runnable{
    private String fileName;

    public DownloadTask(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Random random = new Random();
        long waitTime = random.nextLong(5000, 30000);

        try {
            System.out.println("Iniciando descarga de " + fileName);
            Thread.sleep(waitTime);
            System.out.println("Descarga completa de: " + fileName + " Tiempo de espera de: " + waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
