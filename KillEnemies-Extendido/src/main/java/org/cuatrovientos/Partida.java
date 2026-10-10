package org.cuatrovientos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Partida implements Serializable {

    private final ArrayList<Character> personajes;
    private final Hero heroe;

    public Partida(ArrayList<Character> personajes, Hero heroe) {
        this.personajes = personajes;
        this.heroe = heroe;
    }

    public ArrayList<Character> getPersonajes() {
        return personajes;
    }

    public Hero getHeroe() {
        return heroe;
    }

    public boolean guardar(File fichero) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero))) {
            salida.writeObject(this);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Partida cargar(File fichero) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
            return (Partida) entrada.readObject();
        } catch (Exception e) {
            return null;
        }
    }

}
