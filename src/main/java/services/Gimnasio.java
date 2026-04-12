package services;

import models.Actividad;
import models.Reserva;
import models.Socio;

import java.time.LocalDate;
import java.util.*;

public class Gimnasio {

    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    private HashMap<String, Socio> socios;
    private HashMap<String, Actividad> actividades;
    private TreeMap<Socio, HashSet<Reserva>> reservas;


    public Gimnasio(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.socios = new HashMap<>();
        this.actividades = new HashMap<>();
        this.reservas = new TreeMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<String, Socio> getSocios() {
        return socios;
    }

    public HashMap<String, Actividad> getActividades() {
        return actividades;
    }

    public TreeMap<Socio, HashSet<Reserva>> getReservas() {
        return reservas;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("gimnasio{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", socios=").append(socios);
        sb.append(", actividades=").append(actividades);
        sb.append(", reservas=").append(reservas);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gimnasio gimnasio = (Gimnasio) o;
        return Objects.equals(nombre, gimnasio.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public void addSocio(Socio s) {
        socios.put(s.getDni(), s);
    }
    public void addActividad(Actividad a) {
        actividades.put(a.getCodigo(), a);
    }
    public void reservarActividad(String dni, String codigoActividad) {
        Socio socio = socios.get(dni);
        Actividad actividad = actividades.get(codigoActividad);

        if (socio == null || actividad == null) {
            System.out.println("Error: socio o actividad no existe");
            return;
        }

        if (!reservas.containsKey(socio)) {
            reservas.put(socio, new HashSet<>());
        }
        HashSet<Reserva> lista = reservas.get(socio);

        for (Reserva r : lista) {
            if (r.getActividad().equals(actividad)) {
                IO.println("Ya tiene reservada esta actividad");
                return;
            }
        }
        int total = 0;

        for (HashSet<Reserva> conjunto : reservas.values()) {
            for (Reserva r : conjunto) {
                if (r.getActividad().equals(actividad)) {
                    total++;
                }
            }
        }
        if (total >= actividad.getAforoMaximo()) {
            IO.println("Actividad llena");
            return;
        }
        Reserva nueva = new Reserva(socio, actividad, LocalDate.now());
        lista.add(nueva);

        IO.println("Reserva realizada correctamente");

    }



    public void cancelarReserva(String dni, String codigoActividad) {
        Socio socio = socios.get(dni);
        Actividad actividad = actividades.get(codigoActividad);
        if (socio == null || actividad == null)
            return;

        HashSet<Reserva> lista = reservas.get(socio);

        if (lista == null)
            return;

        Reserva borrar = null;

        for (Reserva r : lista) {
            if (r.getActividad().equals(actividad)) {
                borrar = r;
            }
        }
        if (borrar != null) {
            lista.remove(borrar);
            IO.println("Reserva cancelada");
        }
    }



    public TreeSet<Actividad> getActividadesSocio(String dni) {
        TreeSet<Actividad> resultado = new TreeSet<>();
        Socio socio = socios.get(dni);
        if (socio == null)
            return resultado;
        HashSet<Reserva> lista = reservas.get(socio);

        if (lista == null)
            return resultado;

        for (Reserva r : lista) {
            resultado.add(r.getActividad());
        }
        return resultado;
    }




    public List<Actividad> getActividadesLlenas() {
        List<Actividad> llenas = new ArrayList<>();
        for (Actividad a : actividades.values()) {
            int total = 0;
            for (HashSet<Reserva> conjunto : reservas.values()) {
                for (Reserva r : conjunto) {
                    if (r.getActividad().equals(a)) {
                        total++;
                    }
                }
            }
            if (total >= a.getAforoMaximo()) {
                llenas.add(a);
            }
        }
        return llenas;
    }



    public List<Socio> getRankingSocios() {
        List<Socio> lista = new ArrayList<>(reservas.keySet());

        lista.sort(new Comparator<Socio>() {
            public int compare(Socio s1, Socio s2) {

                int r1 = reservas.get(s1).size();
                int r2 = reservas.get(s2).size();

                return Integer.compare(r2, r1);
            }
        });

        return lista;
    }



    private List<Reserva> getTodasLasReservas() {
        List<Reserva> todasLasReservas = new ArrayList<>();

        for (HashSet<Reserva> conjuntoReservas : reservas.values()) {
            for (Reserva r : conjuntoReservas) {
                todasLasReservas.add(r);
            }
        }
        return todasLasReservas;
    }




    public List<Reserva> getReservasOrdenadasPorFecha() {
        List<Reserva> lista = getTodasLasReservas();
        lista.sort(Comparator.comparing(Reserva::getFechaReserva));
        return lista;
    }



    public List<Reserva> getReservasOrdenadasPorActividad() {
        List<Reserva> lista = getTodasLasReservas();
        lista.sort(Comparator.comparing(r -> r.getActividad()
                .getNombre()));
        return lista;
    }
    public List<Reserva> getReservasOrdenadasPorSocioYFecha() {
        List<Reserva> lista = getTodasLasReservas();
        lista.sort(Comparator.comparing((Reserva r) -> r.getSocio()
                        .getApellidos())
                        .thenComparing(Reserva::getFechaReserva, Comparator.reverseOrder()));
        return lista;
    }
    public List<Reserva> getReservasOrdenadasPorDuracion() {
        List<Reserva> lista = getTodasLasReservas();
        lista.sort(Comparator.comparing((Reserva r) -> r.getActividad()
                        .getDuracionMinutos())
                        .reversed());
        return lista;
    }
    public List<Reserva> getReservasPendientesOrdenadasPorFecha() {
        List<Reserva> reservasPendientes = new ArrayList<>();
        for (HashSet<Reserva> conjuntoReservas : reservas.values()) {
            for (Reserva r : conjuntoReservas) {
                if (r.estaActiva()) {
                    reservasPendientes.add(r);
                }
            }
        }
        reservasPendientes.sort(Comparator.comparing(Reserva::getFechaReserva));
        return reservasPendientes;
    }




}
