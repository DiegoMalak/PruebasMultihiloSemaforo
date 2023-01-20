package PabellonSemaforos;

import java.util.concurrent.Semaphore;

public class SemaforoPabellon extends Thread {

    private static Semaphore pabellon;

    SemaforoPabellon(String nombre, Semaphore pabellon) {
        super(nombre);
        this.pabellon = pabellon;
    }

    public void run() {
        // Bloquea
        try {
            pabellon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Partido " + getName() + " comienza.");

        // Simula el partido
        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Partido " + getName() + " termina y deja el balón.");

        // Libera.
        pabellon.release();
    }

}
