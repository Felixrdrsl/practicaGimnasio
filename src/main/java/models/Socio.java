package models;

import java.time.LocalDate;
import java.util.Objects;

public class Socio implements Comparable<Socio> {

    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private LocalDate fechaAlta;
    private Cuota cuota;

    public Socio(String dni, String nombre, String apellidos,
                 String email, String telefono, LocalDate fechaAlta, Cuota cuota) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
        this.cuota = cuota;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Socio{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellidos='").append(apellidos).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", fechaAlta=").append(fechaAlta);
        sb.append(", cuota=").append(cuota);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(dni, socio.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }


    @Override
    public int compareTo(Socio o) {
        int resultado = this.apellidos.compareToIgnoreCase(o.apellidos);
        if (resultado==0)
            resultado=this.nombre.compareToIgnoreCase(o.nombre);

        return resultado;
    }
}
