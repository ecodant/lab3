package Ejercicio4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Integer> numeros = new LinkedBlockingQueue<>(10);
        HiloProductor hiloProductor1 = new HiloProductor(numeros);
        HiloProductor hiloProductor2 = new HiloProductor(numeros);
        HiloConsumidor hiloConsumidor1 = new HiloConsumidor(numeros);
        HiloConsumidor hiloConsumidor2 = new HiloConsumidor(numeros);

        hiloProductor1.start();
        hiloProductor2.start();
        hiloConsumidor1.start();
        hiloConsumidor2.start();

    }
}
