package app;

import models.*;
import services.Gimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeSet;

public class app {

    static void main() {

        Gimnasio gym = new Gimnasio("gym gold", "Calle Mayor 10",
                "600123123", "nose@gmail.com");



        // 2. Crear socios
        Socio s1 = new Socio("111A", "Juan", "García", "juan@mail.com", "600111111", LocalDate.now(), Cuota.BASICA);
        Socio s2 = new Socio("222B", "Ana", "López", "ana@mail.com", "600222222",LocalDate.now(), Cuota.PREMIUM);
        Socio s3 = new Socio("333C", "Luis", "Martín", "luis@mail.com", "600333333",LocalDate.now(), Cuota.FAMILIAR);
        Socio s4 = new Socio("444D", "Marta", "Sánchez", "marta@mail.com", "600444444",LocalDate.now(), Cuota.BASICA);
        Socio s5 = new Socio("555E", "Pedro", "Ruiz", "pedro@mail.com", "600555555",LocalDate.now(), Cuota.PREMIUM);
        Socio s6 = new Socio("666F", "Laura", "Díaz", "laura@mail.com", "600666666",LocalDate.now(), Cuota.FAMILIAR);

        gym.addSocio(s1);
        gym.addSocio(s2);
        gym.addSocio(s3);
        gym.addSocio(s4);
        gym.addSocio(s5);
        gym.addSocio(s6);

        // 3. Crear actividades
        Actividad a1 = new Actividad("A1", "Yoga", "Relajación", diaSemana.LUNES, LocalTime.of(9, 0), 60, 3, "Carlos");
        Actividad a2 = new Actividad("A2", "Spinning", "Bici", diaSemana.MARTES, LocalTime.of(18, 0), 60, 10, "Laura");
        Actividad a3 = new Actividad("A3", "Pilates", "Core", diaSemana.MIERCOLES, LocalTime.of(10, 0), 60, 2, "Marta");
        Actividad a4 = new Actividad("A4", "CrossFit", "Intenso", diaSemana.JUEVES, LocalTime.of(19, 0), 60, 8, "Pedro");
        Actividad a5 = new Actividad("A5", "Zumba", "Baile", diaSemana.VIERNES, LocalTime.of(17, 30), 60, 15, "Sonia");
        Actividad a6 = new Actividad("A6", "Natación", "Piscina", diaSemana.SABADO, LocalTime.of(10, 0), 60, 6, "Diego");
        Actividad a7 = new Actividad("A7", "Boxeo", "Contacto", diaSemana.LUNES, LocalTime.of(20, 0), 60, 3, "Raúl");
        Actividad a8 = new Actividad("A8", "Meditación", "Relax", diaSemana.DOMINGO, LocalTime.of(11, 0), 60, 12, "Ana");

        gym.addActividad(a1);
        gym.addActividad(a2);
        gym.addActividad(a3);
        gym.addActividad(a4);
        gym.addActividad(a5);
        gym.addActividad(a6);
        gym.addActividad(a7);
        gym.addActividad(a8);

        // 4. Reservas
        gym.reservarActividad("111A", "A1");
        gym.reservarActividad("222B", "A1");
        gym.reservarActividad("333C", "A1");
        gym.reservarActividad("444D", "A1");

        gym.reservarActividad("111A", "A2");
        gym.reservarActividad("222B", "A3");
        gym.reservarActividad("333C", "A4");
        gym.reservarActividad("444D", "A5");
        gym.reservarActividad("555E", "A6");
        gym.reservarActividad("666F", "A7");

        // 5. Confirmar asistencia
        gym.getReservasOrdenadasPorFecha().get(0).confirmarAsistencia();
        gym.getReservasOrdenadasPorFecha().get(1).confirmarAsistencia();

        // 6. Cancelar reserva
        gym.cancelarReserva("222B", "A3");


        IO.println();

        // 7. Actividades de un socio
        IO.println("Actividades de Juan:");
        TreeSet<Actividad> act = gym.getActividadesSocio("111A");
        for (Actividad a : act) {
            IO.println(a);
        }

        IO.println();


        // 8. Actividades llenas
        IO.println("Actividades llenas:");
        for (Actividad a : gym.getActividadesLlenas()) {
            IO.println(a);
        }

        IO.println();


        // 9. Ranking socios
        IO.println("Ranking socios:");
        for (Socio s : gym.getRankingSocios()) {
            IO.println(s);
        }

        IO.println();


        // 10. Reservas por fecha
        IO.println("Reservas por fecha:");
        for (Reserva r : gym.getReservasOrdenadasPorFecha()) {
            IO.println(r);
        }

        IO.println();

        // 11. Reservas por actividad
        IO.println("Reservas por actividad:");
        for (Reserva r : gym.getReservasOrdenadasPorActividad()) {
            IO.println(r);
        }

        IO.println();

        // 12. Reservas por socio y fecha
        IO.println("Reservas por socio y fecha:");
        for (Reserva r : gym.getReservasOrdenadasPorSocioYFecha()) {
            IO.println(r);
        }

        IO.println();

        // 13. Reservas por duración
        IO.println("Reservas por duración:");
        for (Reserva r : gym.getReservasOrdenadasPorDuracion()) {
            IO.println(r);
        }

        IO.println();

        // 14. Reservas pendientes
        IO.println("Reservas pendientes:");
        for (Reserva r : gym.getReservasPendientesOrdenadasPorFecha()) {
            IO.println(r);
        }




    }

}
