public enum TipoDeCafe {
    CAFE_CON_LECHE(1.20),
    SOLO(1.00),
    SOLO_AMERICANO(1.10),
    CORTADO(1.10),
    LECHE_MANCHADA(1.30),
    CHOCOLATE(1.25),
    TE_CON_LIMON(1.10),
    CAPUCHINO(2.0);

    private final double precio;

    TipoDeCafe(double precio) {
        this.precio = precio;
    }
    public double getPrecio() {
        return precio;
    }
}
