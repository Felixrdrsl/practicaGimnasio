package models;

import java.time.LocalTime;
import java.util.Objects;

public class Actividad implements Comparable<Actividad> {

    private String codigo;
    private String nombre;
    private String descripcion;
    private diaSemana diaSemana;
    private LocalTime horaInicio;
    private Integer duracionMinutos;
    private Integer aforoMaximo;
    private String monitor;


    public Actividad(String codigo, String nombre, String descripcion, diaSemana diaSemana,
                     LocalTime horaInicio, Integer duracionMinutos, Integer aforoMaximo, String monitor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
        this.aforoMaximo = aforoMaximo;
        this.monitor = monitor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public diaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(diaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Integer getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(Integer aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Actividad{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", diaSemana=").append(diaSemana);
        sb.append(", horaInicio=").append(horaInicio);
        sb.append(", duracionMinutos=").append(duracionMinutos);
        sb.append(", aforoMaximo=").append(aforoMaximo);
        sb.append(", monitor='").append(monitor).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return Objects.equals(codigo, actividad.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }


    @Override
    public int compareTo(Actividad o) {
        int resultado = this.diaSemana.compareTo(o.diaSemana);

        if (resultado == 0)
            resultado = this.horaInicio.compareTo(o.horaInicio);
        return resultado;

    }
}



