package org.cuatrovientos;

public class Juego {

    public boolean combatir(Hero heroe, Enemy enemigo) {

        while (heroe.getVida() > 0 && enemigo.getVida() > 0) {

            heroe.attack(enemigo);

            if (enemigo.getVida() <= 0) {
                break;
            }

            int danoRecibido = heroe.reducirDano(enemigo.atacar());
            heroe.recibirDano(danoRecibido);

        }

        heroe.resetDanoExtra();

        return heroe.getVida() > 0;
    }

}
