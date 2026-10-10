package org.cuatrovientos;

public interface Character {

    boolean isEnemy();

    String getName();

    int getVida();

    int getVidaMax();

    void recibirDano(int dano);

}