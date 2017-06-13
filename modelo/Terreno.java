package modelo;

public class Terreno {
    private final int ancho;
    private final int alto;

    public Terreno(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public boolean estaEnContacto(Posicion posicion) {
        boolean contactX = Math.abs(posicion.getX()) >= this.ancho / 2;
        boolean contactY = Math.abs(posicion.getY()) >= this.alto / 2;
        return contactX || contactY;
    }

}
