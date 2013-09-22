/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmatriz;

/**
 *
 * @author salaf513
 */
public class Producto {
    
    private double cantidad;
    private String descripcion;
    private int id;
    private double precio;

    public Producto(double cantidad, String descripcion, int id, double precio) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.id = id;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double getValor() {
        return this.precio * this.cantidad;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
         System.out.print(this.id + "\t" 
                 + this.descripcion + "\t\t"
                 + String.format("%,10.2f", this.precio) + "\t"
                 + String.format("%,10.2f", this.cantidad) + "\t"
                 + String.format("%,15.2f", this.getValor()));
        return "\n";
    }
}
