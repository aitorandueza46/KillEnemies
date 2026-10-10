package org.cuatrovientos;

public enum Orden {

    CORREDORES_DEL_VIENTO("Corredores del Viento", 30, 7,
            "+2 daño, +1 sanación y +1 daño por aliado"),
    ESQUIRLAS_DEL_CIELO("Esquirlas del Cielo", 34, 6,
            "+2 daño contra el jefe"),
    PORTADORES_DEL_POLVO("Portadores del Polvo", 28, 8,
            "ignora 1 de daño recibido"),
    BAILARINES_DEL_FILO("Bailarines del Filo", 30, 6,
            "+1 daño e ignora 1 de daño recibido"),
    OBSERVADORES_DE_LA_VERDAD("Observadores de la Verdad", 32, 6,
            "los sanadores curan +2"),
    TEJEDORES_DE_LUZ("Tejedores de Luz", 30, 6,
            "ignora 2 de daño recibido"),
    FORJADORES_DE_ALMAS("Forjadores de Almas", 30, 7,
            "+3 daño"),
    MOLDEADORES_DE_VOLUNTAD("Moldeadores de Voluntad", 33, 6,
            "+2 daño si la vida supera el 50%"),
    GUARDIANES_DE_LA_PIEDRA("Guardianes de la Piedra", 36, 5,
            "reduce 1 el daño recibido"),
    FORJADORES_DEL_VINCULO("Forjadores del Vínculo", 34, 5,
            "los aliados dan +2 extra");

    private final String nombre;
    private final int vida;
    private final int dano;
    private final String pasiva;

    Orden(String nombre, int vida, int dano, String pasiva) {
        this.nombre = nombre;
        this.vida = vida;
        this.dano = dano;
        this.pasiva = pasiva;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public String getPasiva() {
        return pasiva;
    }

    public int bonusCuracion() {
        switch (this) {
            case CORREDORES_DEL_VIENTO:
                return 1;
            case OBSERVADORES_DE_LA_VERDAD:
                return 2;
            default:
                return 0;
        }
    }

    public int bonusAliado() {
        switch (this) {
            case CORREDORES_DEL_VIENTO:
                return 1;
            case FORJADORES_DEL_VINCULO:
                return 2;
            default:
                return 0;
        }
    }

}
