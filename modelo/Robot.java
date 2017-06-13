package modelo;

import java.util.concurrent.ConcurrentHashMap;

public class Robot {

    private Direccion direccion;
    private Posicion posicion;
    public final int RADIO = 10;

    private Terreno terreno;
    private ConcurrentHashMap<Direccion, Direccion> rotationMap;

    public Robot(Terreno terreno, Posicion posicion) {
        this.terreno = terreno;
        this.posicion = posicion;
        this.rotationMap = new ConcurrentHashMap<>();
        this.rotationMap.put(Direccion.oeste(), Direccion.norte());
        this.rotationMap.put(Direccion.norte(), Direccion.este());
        this.rotationMap.put(Direccion.este(), Direccion.sur());
        this.rotationMap.put(Direccion.sur(), Direccion.oeste());
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void mover() {
        if (this.terreno.estaEnContacto(this.posicion)) {
            this.direccion = this.direccion.inversa();
            this.posicion = this.posicion.siguiente(this.direccion);
        } else {
            this.posicion = this.posicion.siguiente(this.direccion);
        }

    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void rotar() {
        this.setDireccion(this.rotationMap.get(this.getDireccion()));
    }
}
