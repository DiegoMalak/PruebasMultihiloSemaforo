package PabellonSemaforos;

import java.util.concurrent.Semaphore;

public class MainPabellon {

    public static void main(String[] args) {
        Semaphore pabellon = new Semaphore(8);

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
