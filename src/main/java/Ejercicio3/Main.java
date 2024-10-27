package Ejercicio3;

public class Main {
    public static void main(String[] args) {

        ConditionMonitor conditionMonitor = new ConditionMonitor();
        HiloSecundario h1 = new HiloSecundario(conditionMonitor);
        HiloSecundario h2 = new HiloSecundario(conditionMonitor);
        HiloSecundario h3 = new HiloSecundario(conditionMonitor);
        HiloMain hMain = new HiloMain(conditionMonitor);

        h1.start();
        h2.start();
        h3.start();

        hMain.start();
    }
}
