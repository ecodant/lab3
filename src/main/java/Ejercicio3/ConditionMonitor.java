package Ejercicio3;

public class ConditionMonitor {
    private int condition = 0;

    public synchronized void waitForCondition() {
        while (condition % 5 != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " notificado. Condición: " + condition);
    }

    public synchronized void setCondition(int condition) {
        this.condition = condition;
        if (condition % 5 == 0) {
            notifyAll();
        }
    }

    public static void main(String[] args) {
        ConditionMonitor monitor = new ConditionMonitor();

        HiloSecundario t1 = new HiloSecundario(monitor);
        HiloSecundario t2 = new HiloSecundario(monitor);
        HiloSecundario t3 = new HiloSecundario(monitor);

        t1.start();
        t2.start();
        t3.start();

        for (int i = 1; i <= 100; i++) {
            monitor.setCondition(i);
            try {
                Thread.sleep(100); // Simula algún trabajo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


