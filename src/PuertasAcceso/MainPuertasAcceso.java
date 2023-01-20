package PuertasAcceso;

import java.util.concurrent.Semaphore;

public class MainPuertasAcceso {

    public static void main(String[] args) {
        // Creación de un semáforo con una capacidad de 3, lo que significa que solo
        // 3 personas pueden pasar a través de los tornos al mismo tiempo.
        Semaphore semaforo = new Semaphore(3);
        // Creación de una instancia del monitor de cuenta.
        MonitorCuenta monitorCuenta = new MonitorCuenta();

        // Creación de 3 hilos para representar cada uno de los tornos de acceso
        SemaforoTorno torno1 = new SemaforoTorno("Torno de acceso puerta 1", 5, semaforo, monitorCuenta);
        SemaforoTorno torno2 = new SemaforoTorno("Torno de acceso puerta 2", 7, semaforo, monitorCuenta);
        SemaforoTorno torno3 = new SemaforoTorno("Torno de acceso puerta 3", 3, semaforo, monitorCuenta);

        // Inicio de los hilos.
        torno1.start();
        torno2.start();
        torno3.start();

        // El programa espera a que cada hilo termine su ejecución.
        try {
            torno1.join();
            torno2.join();
            torno3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Imprime el número total de personas que han pasado a través de los tornos
        System.out.println("Han pasado " + monitorCuenta.getCuenta() );
    }
}
