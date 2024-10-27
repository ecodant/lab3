package Ejercicio3;

import java.util.Random;

public class HiloMain extends Thread {
    private ConditionMonitor monitor;

    public HiloMain(ConditionMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                int numero = numeroAleatorio();
                System.out.println("iteración: " + (i+1) + " número aleatorio: " + numero);
                monitor.setCondition(numero);
                Thread.sleep(100); // Simula algún trabajo
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int numeroAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Genera un número entre 1 y 100
    }
}
