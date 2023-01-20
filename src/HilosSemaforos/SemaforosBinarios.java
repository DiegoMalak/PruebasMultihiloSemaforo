package HilosSemaforos;

import java.util.concurrent.Semaphore;

// Se crea una clase que extiende de la clase Thread. Esto significa que la clase
// SemaforosBinarios es un hilo.
public class SemaforosBinarios extends Thread {
    // Vamos a crear un semáforo binario, es decir, que solo puede tener dos valores
    // posibles: 0 o 1. El valor 0 significa que el recurso está ocupado y el valor 1
    // significa que el recurso está libre.
    private static int contador = 1;
    private static Semaphore semaforo = new Semaphore(1);

    // Constructor que se utiliza para inicializar las variables de instancia.
    SemaforosBinarios(String hilo) {
        super(hilo);
    }

    // Método que se ejecuta cuando se inicia el hilo.
    public void run() {
        // Bucle para simular el proceso de comprobar el DNI de cada persona y dejarla
        // pasar a través del torno (el hilo).
        for(int i = 1; i <= 10; i++) {
            // El hilo adquiere un permiso del semáforo, lo que significa que una persona
            // puede pasar a través del torno (el hilo).
            try {
                semaforo.acquire(); // Bloquea el codigo que hay después.
            } catch (InterruptedException e) {
                // Se lanza una excepción en caso de que haya un problema con la espera.
                e.printStackTrace();
            }
            // Simulo el comprobar dni.
            System.out.println("Hilo " + getName() + " contador = " + contador++);
            // Se libera un permiso del semáforo, lo que significa que otra persona puede
            // pasar a través del torno (el hilo).
            semaforo.release();
            // Se simula un tiempo de espera para la comprobación de los datos.
            try {
                sleep(10);
            } catch (InterruptedException e) {
                // Se lanza una excepción en caso de que haya un problema con la espera.
                e.printStackTrace();
            }
        }
    }

    // Método principal, que se ejecuta al iniciar el programa.
    // Se crean tres hilos y se inician.
    public static void main(String[] args) {
        new SemaforosBinarios("Hilo 1").start();
        new SemaforosBinarios("Hilo 2").start();
        new SemaforosBinarios("Hilo 3").start();
    }
}