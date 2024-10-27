package Ejercicio3;

public class HiloSecundario extends Thread {
    private ConditionMonitor monitor;

    public HiloSecundario(ConditionMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        monitor.waitForCondition();
    }
}

