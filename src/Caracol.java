import java.util.concurrent.CountDownLatch;

class Caracol extends Thread {
    final private int dorsal;
    final private CountDownLatch barreraSalida;

    public Caracol(int dorsal, CountDownLatch barreraSalida) {
        this.dorsal = dorsal;
        this.barreraSalida = barreraSalida;
    }

    @Override
    public void run() {
        try {
            // Esperar la señal de salida
            barreraSalida.await();

            // Simular la carrera
            int tiempoCarrera = (int) (Math.random() * 6) + 5; // Entre 5 y 10 segundos
            System.out.println("Caracol con dorsal " + dorsal + " ha terminado la carrera en " + tiempoCarrera + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}