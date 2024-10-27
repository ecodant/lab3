package Ejercicio4;

import java.util.concurrent.BlockingQueue;

public class HiloConsumidor extends Thread {
    private BlockingQueue<Integer> numeros;

    public HiloConsumidor(BlockingQueue<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer numero = numeros.take();
                System.out.println("Número extraído: " + numero);
                Thread.sleep(1000); // Simula el tiempo de procesamiento
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
