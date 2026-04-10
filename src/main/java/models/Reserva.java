package models;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {

    private Socio socio;
    private Actividad actividad;
    private LocalDate fechaReserva;
    private Boolean asistio ;

    public Reserva(Socio socio, Actividad actividad, LocalDate fechaReserva) {
        this.socio = socio;
        this.actividad = actividad;
        this.fechaReserva = fechaReserva;
        this.asistio = false;
    }


    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Reserva{");
        sb.append("socio=").append(socio);
        sb.append(", actividad=").append(actividad);
        sb.append(", fechaReserva=").append(fechaReserva);
        sb.append(", asistio=").append(asistio);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(socio, reserva.socio) && Objects.equals(actividad, reserva.actividad) && Objects.equals(fechaReserva, reserva.fechaReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socio, actividad, fechaReserva);
    }


    public void confirmarAsistencia(){
        this.asistio = true;
    }
    public Boolean estaActiva(){
        return !fechaReserva.isBefore(LocalDate.now());
    }


}
