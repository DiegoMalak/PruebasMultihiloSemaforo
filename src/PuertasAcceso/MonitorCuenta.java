package PuertasAcceso;

public class MonitorCuenta {

    // Variable de instancia que representa el contador de
    // personas que han pasado a través de los tornos.
    private Integer cuenta;

    // Constructor que inicializa la variable de instancia con un valor de 0.
    public MonitorCuenta() {
        this.cuenta = 0;
    }

    // Método sincronizado para incrementar el contador de personas.
    public synchronized void incrementarCuenta() {
        this.cuenta++;
    }

    // Método para obtener el valor actual del contador de personas.
    public Integer getCuenta() {
        return cuenta;
    }
}
