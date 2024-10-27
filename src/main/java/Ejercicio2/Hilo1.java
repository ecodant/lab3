package Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Hilo1 extends Thread{

    private ReentrantLock lock;
    private Condition condition;

    public Hilo1(ReentrantLock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }

    public void run (){
        try {
            mostrarMensaje();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void mostrarMensaje() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
            System.out.println("Soy el hilo 1, Tengo el bloqueo, eso quiere decir que la condición se cumplió y el otro hilo terminó.");
        }finally {
            lock.unlock();
        }
    }
}
