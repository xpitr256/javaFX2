package modelo;

public class Direccion {
    private static Direccion norte;
    private static Direccion sur;
    private static Direccion este;
    private static Direccion oeste;

    static {
        norte = new Direccion(0, 1);
        sur = new Direccion(0, -1);
        este = new Direccion(1, 0);
        oeste = new Direccion(-1, 0);

        norte.setInversa(sur);
        sur.setInversa(norte);
        este.setInversa(oeste);
        oeste.setInversa(este);
    }

    private Direccion inversa;
    private int valueX;
    private int valueY;

    private Direccion(int valX, int valY) {
        this.valueX = valX;
        this.valueY = valY;
    }

    private void setInversa(Direccion inversa) {
        this.inversa = inversa;
    }

    public static Direccion norte() {
        return norte;
    }

    public Direccion inversa() {
        return this.inversa;
    }

    public Posicion proximaPosicion(Posicion posicion) {
        int nextX = posicion.getX() + this.valueX * 10;
        int nextY = posicion.getY() + this.valueY * 10;

        return new Posicion(nextX, nextY);
    }

    public static Direccion sur() {
        return sur;
    }

    public static Direccion este() {
        return este;
    }

    public static Direccion oeste() {
        return oeste;
    }
}
