package Ejercicio4;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class HiloProductor extends Thread {
    private BlockingQueue<Integer> numeros;

    public HiloProductor(BlockingQueue<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            int numero = generarNumero();
            try {
                numeros.put(numero);
                System.out.println("Número producido: " + numero);
                Thread.sleep(500); // Simula el proceso de producción
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }

    public static int generarNumero() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Genera un número entre 1 y 100
    }

}
