import java.util.concurrent.CountDownLatch;

class Carrera {
    private static final int NUM_CARACOLES = 8;

    public void iniciarCarrera() {
        System.out.println("Bienvenidos a la carrera de caracoles motorizados");
        System.out.println("______________________________________________");

        // Crear la barrera para la salida de los caracoles
        CountDownLatch barreraSalida = new CountDownLatch(1);

        // Crear los caracoles
        for (int i = 0; i < NUM_CARACOLES; i++) {
            new Caracol(i + 1, barreraSalida).start();
        }

        // Dar la señal de salida después de esperar 1 segundo
        try {
            Thread.sleep(1000);
            System.out.println("Preparados...");
            Thread.sleep(1000);
            System.out.println("Listos...");
            Thread.sleep(1000);
            System.out.println("Ya!");
            barreraSalida.countDown(); // Notificar a los caracoles que pueden empezar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}