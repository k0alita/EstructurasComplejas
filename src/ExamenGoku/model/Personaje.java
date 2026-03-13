package ExamenGoku.model;

import ExamenGoku.exception.GokuException;
import ExamenGoku.utils.TRaza;

import java.util.*;

public class Personaje {
    private String nombre;
    private TRaza raza;
    private int vidaMaxima;
    private int vidaActual;
    private int kiMaximo;
    private int kiActual;
    private Set<Ataque> ataques;
    private boolean muerto;

    public Personaje(String nombre, TRaza raza, int vidaMaxima, int vidaActual, int kiMaximo, int kiActual) {
        this.nombre = nombre;
        this.raza = raza;
        setVidaMaxima(vidaMaxima);
        setVidaActual(vidaActual);
        setKiMaximo(kiMaximo);
        setKiActual(kiActual);
        ataques = new LinkedHashSet<>();
        muerto = false;
    }

    public String getNombre() {
        return nombre;
    }

    public TRaza getRaza() {
        return raza;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        if (vidaMaxima < 1 || vidaMaxima > 100) {
            throw new GokuException("La vida maxima tiene que estar entre 1 y 100");
        }
        this.vidaMaxima = vidaMaxima;
    }

    public int getNivelActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        if (vidaActual > vidaMaxima || vidaActual < 0) {
            if (vidaActual < 0) {
                vidaActual = 0;
            }
            throw new GokuException("La vida actual tiene que estar entre 0 y la vida maxima");
        }
        this.vidaActual = vidaActual;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getKiMaximo() {
        return kiMaximo;
    }

    public void setKiMaximo(int kiMaximo) {
        if (kiMaximo < 1 || kiMaximo > 100) {
            throw new GokuException("El ki maximo tiene que estar entre 1 y 100");
        }
        this.kiMaximo = kiMaximo;
    }

    public int getKiActual() {
        return kiActual;
    }

    public void setKiActual(int kiActual) {
        if (kiActual > kiMaximo || kiActual < 1) {
            throw new GokuException("El ki actual tiene que estar entre 1 y 100");
        }
        this.kiActual = kiActual;
    }

    public void addAtaque(Ataque ataque) {
        if (!ataques.add(ataque)) {
            throw new GokuException("No se ha podido añadir el ataque");
        }
    }

    public Set<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(Set<Ataque> ataques) {
        this.ataques = ataques;
    }

    public boolean estaMuerto() {
        if (vidaActual == 0) {
            return true;
        }
        return false;
    }

    public void recibirDaño(int daño) {
        if (!estaMuerto()) {
            if (daño > vidaActual) {
                vidaActual = 0;
            } else vidaActual = vidaActual - daño;
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Personaje personaje)) return false;

        return Objects.equals(nombre, personaje.nombre) && raza == personaje.raza;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + Objects.hashCode(raza);
        return result;
    }
}

