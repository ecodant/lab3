package Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        HiloMain hiloMain = new HiloMain(lock, condition);
        Hilo1 hilo1 = new Hilo1(lock,condition);

        hilo1.start();
        hiloMain.start();

    }

}


