package PabellonSemaforos;

import java.util.concurrent.Semaphore;

// El pabellón tiene capacidad para 10 partidos, por lo que el semáforo tiene una capacidad de 10.
public class MainPabellon {

    public static void main(String[] args) {
        // Creación de un semáforo con una capacidad de 8, lo que significa que solo
        // 8 partidos pueden jugar al mismo tiempo.
        Semaphore pabellon = new Semaphore(8);

        // Creación de 10 hilos para representar cada uno de los partidos que se juegan
        // en el pabellón.
        SemaforoPabellon partido1 = new SemaforoPabellon("1", pabellon);
        SemaforoPabellon partido2 = new SemaforoPabellon("2", pabellon);
        SemaforoPabellon partido3 = new SemaforoPabellon("3", pabellon);
        SemaforoPabellon partido4 = new SemaforoPabellon("4", pabellon);
        SemaforoPabellon partido5 = new SemaforoPabellon("5", pabellon);
        SemaforoPabellon partido6 = new SemaforoPabellon("6", pabellon);
        SemaforoPabellon partido7 = new SemaforoPabellon("7", pabellon);
        SemaforoPabellon partido8 = new SemaforoPabellon("8", pabellon);
        SemaforoPabellon partido9 = new SemaforoPabellon("9", pabellon);
        SemaforoPabellon partido10 = new SemaforoPabellon("10", pabellon);

        // Inicio de los hilos.
        partido1.start();
        partido2.start();
        partido3.start();
        partido4.start();
        partido5.start();
        partido6.start();
        partido7.start();
        partido8.start();
        partido9.start();
        partido10.start();
    }
}
