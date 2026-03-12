package ExamenGoku.model;

import ExamenGoku.exception.GokuException;

public class Ataque {
    private String nombre;
    private int kiNecesario;
    private int nivelPerfeccionAtaque;
    private int dañoAtaque;

    public Ataque(String nombre, int kiNecesario, int nivelPerfeccionAtaque, int dañoAtaque) {
        this.nombre = nombre;
        setKiNecesario(kiNecesario);
        setNivelPerfeccionAtaque(nivelPerfeccionAtaque);
        setDañoAtaque(dañoAtaque);
    }

    public String getNombre() {
        return nombre;
    }

    public int getKiNecesario() {
        return kiNecesario;
    }

    public void setKiNecesario(int kiNecesario) throws GokuException{
        if (kiNecesario <= 0) {
            throw new GokuException("El ki debe ser mayor a 0");
        }
        this.kiNecesario = kiNecesario;
    }

    public int getNivelPerfeccionAtaque() {
        return nivelPerfeccionAtaque;
    }

    public void setNivelPerfeccionAtaque(int nivelPerfeccionAtaque) {
        if (nivelPerfeccionAtaque < 1 || nivelPerfeccionAtaque > 3) {
            throw new GokuException("El nivel de perfeccion debe ser entre 1 y 3");
        }
        this.nivelPerfeccionAtaque = nivelPerfeccionAtaque;
    }

    public int getDañoAtaque() {
        return dañoAtaque;
    }

    public void setDañoAtaque(int dañoAtaque) {
        if (dañoAtaque <= 0) {
            throw new GokuException("El daño de ataque debe ser mayor a 0");
        }
        this.dañoAtaque = dañoAtaque;
    }
}
