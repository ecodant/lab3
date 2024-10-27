package Ejercicio1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        //Programa usando ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        System.out.println("Hilos dentro de un ThreadPoolExecutor -> URL: /https/eureka ");
        System.out.println("Hilos dentro de un FixedThreadPool -> URL: /https/warmane ");
        System.out.println("Hilos dentro de un CachedThreadPool -> URL: /https/hots ");
        System.out.println();

        for (int i = 0; i < 50; i++){
            DownloadTask hilo = new DownloadTask("Hilo:" + (i+1) + " -> URL: /https/eureka ");
            threadPoolExecutor.execute(hilo);
        }
        threadPoolExecutor.shutdown();
        System.out.println();

        //Programa usando FixedThreadPool
        ExecutorService executorsFixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 50; i < 100; i++){
            DownloadTask hilo = new DownloadTask("Hilo:" + (i+1) + " -> URL: /https/warmane ");
            executorsFixedThreadPool.execute(hilo);
        }
        executorsFixedThreadPool.shutdown();
        System.out.println();

        //Programa usando CachedThreadPool
        ExecutorService executorsCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 100; i < 150; i++){
            DownloadTask hilo = new DownloadTask("Hilo:" + (i+1) + " -> URL: /https/hots ");
            executorsCachedThreadPool.execute(hilo);
        }
        executorsCachedThreadPool.shutdown();
    }


}
