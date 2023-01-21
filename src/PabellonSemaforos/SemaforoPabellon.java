package PabellonSemaforos;

import java.util.concurrent.Semaphore;

public class SemaforoPabellon extends Thread {

    // Declaramos el semáforo como atributo de la clase, para que todos los hilos
    // compartan el mismo semáforo.
    private static Semaphore pabellon;

    // Constructor de la clase que recibe el nombre del partido y el semáforo.
    SemaforoPabellon(String nombre, Semaphore pabellon) {
        super(nombre);
        this.pabellon = pabellon;
    }

    // Método run que simula el partido.
    public void run() {
        // Controlamos con un try-catch la excepción que se lanza en caso de que haya
        // un problema con la espera.
        try {
            // El método acquire() bloquea el semáforo, si no hay permisos disponibles.
            pabellon.acquire();
        } catch (InterruptedException e) {
            // Se lanza una excepción en caso de que haya un problema con la espera.
            e.printStackTrace();
        }
        // Se imprime en consola que el partido ha comenzado.
        System.out.println("Partido " + getName() + " comienza.");

        // Simula el partido con un sleep.
        try {
            // Le damos un tiempo de 10 milisegundos para que el partido dure.
            sleep(10);
        } catch (InterruptedException e) {
            // Se lanza una excepción en caso de que haya un problema con la espera.
            e.printStackTrace();
        }
        // Se imprime en consola que el partido ha terminado y deja el balón.
        System.out.println("Partido " + getName() + " termina y deja el balón.");

        // Libera un permiso del semáforo, lo que significa que otro partido puede
        // comenzar en el pabellón.
        pabellon.release();
    }
}
