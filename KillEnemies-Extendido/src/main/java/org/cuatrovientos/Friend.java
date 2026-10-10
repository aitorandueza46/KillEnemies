package org.cuatrovientos;

import java.io.Serializable;

public abstract class Friend implements Character, Serializable {

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return "amigo";
    }

    @Override
    public int getVida() {
        return 0;
    }

    @Override
    public int getVidaMax() {
        return 0;
    }

    @Override
    public void recibirDano(int dano) {
    }

    public abstract void efecto(Hero heroe);

    public boolean seConsume() {
        return false;
    }

}
