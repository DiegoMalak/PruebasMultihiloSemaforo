package PuertasAcceso;

import java.util.concurrent.Semaphore;

public class SemaforoTorno extends Thread {

    // Variables de instancia que representan el nombre del torno, el número de
    // personas que pasarán por él, el semáforo y el monitor de cuenta.
    private String nombre;
    private Semaphore semaforo;
    private Integer numPersonas;
    private MonitorCuenta monitorCuenta;

    // Constructor que se utiliza para inicializar las variables de instancia.
    public SemaforoTorno(String nombre, int numPersonas, Semaphore semaforo, MonitorCuenta monitorCuenta) {
        this.nombre = nombre;
        this.numPersonas = numPersonas;
        this.semaforo = semaforo;
        this.monitorCuenta = monitorCuenta;
    }

    @Override
    public void run() {
        // Bucle para simular el proceso de comprobar el DNI de cada
        // persona y dejarla pasar a través del torno
        for (int i = 0; i < numPersonas; i++) {
            // El hilo adquiere un permiso del semáforo, lo que
            // significa que una persona puede pasar a través
            // del torno.
            try {
                semaforo.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Simulo el comprobar dni.
            try {
                // Se imprime en consola que el torno está comprobando los datos de la persona.
                System.out.println(this.nombre + " -- comprobando datos de la persona");
                // Se incrementa el contador de personas en el monitor de cuenta.
                monitorCuenta.incrementarCuenta();
                // Se simula un tiempo de espera para la comprobación de los datos.
                Thread.sleep(10);
                // Se imprime en consola que el torno ha dejado pasar a la persona.
                System.out.println(this.nombre + " -- ha dejado pasar a la persona");
            } catch (InterruptedException e) {
                // Se lanza una excepción en caso de que haya un problema con la espera.
                throw new RuntimeException(e);
            }
            // Se libera un permiso del semáforo, lo que significa que otra persona puede pasar a través del torno.
            semaforo.release();
        }

    }

}
