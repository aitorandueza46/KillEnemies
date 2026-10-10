package org.cuatrovientos;

import java.io.Serializable;

public class Friend implements Character, Serializable {

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return "amigo";
    }

    public void heal() {
        System.out.println("¡Te he curado!");
    }

}