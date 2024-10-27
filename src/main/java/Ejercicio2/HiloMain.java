package Ejercicio2;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class HiloMain extends Thread {
    private ReentrantLock lock;
    private Condition condition;

    public HiloMain(ReentrantLock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        conteoHaciaAtras();
    }

    public void conteoHaciaAtras() {
        lock.lock(); // Adquiere el bloqueo
        try {
            for (int i = 10; i >= 0; i--) {
                System.out.println("Contador = " + i);
                if (i == 0) {
                    System.out.println("Soy el hilo main, mi condición ya se ha cumplido, Adiós");
                    condition.signal(); // Notifica a otros hilos
                }
            }
        } finally {
            lock.unlock(); // Libera el bloqueo
        }
    }
}


