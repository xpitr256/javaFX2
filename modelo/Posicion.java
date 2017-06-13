package modelo;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int posX, int posY) {
        this.x = posX;
        this.y = posY;
    }

    public Posicion siguiente(Direccion direccion) {
        return direccion.proximaPosicion(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Posicion other = (Posicion) obj;

        return (this.getX() == other.getX() && this.getY() == other.getY());
    }

}
