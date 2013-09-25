/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmatriz;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author salaf513
 */
public class Productos {
    
    private int categorias;
    private int sucursales;
    private Producto[][] productos;

    public Productos(int categorias, int sucursales) {
        this.categorias = categorias;
        this.sucursales = sucursales;
        this.productos = new Producto[sucursales][categorias];
                
        this.fill();
    }
    
    public void fill() {
        Random rd = new Random();
        int ids[] = new int[this.sucursales * this.categorias];
        
        for (int i = 0; i < this.sucursales; i++) {
            for (int j = 0; j < this.categorias; j++) {
                double cantidad = rd.nextDouble() * 100;
                int id;
                do {                    
                    id = rd.nextInt(this.sucursales * this.categorias);
                } while (Arrays.asList(ids).contains(id));
                
                String descripcion = "Producto " + id;
                double precio = rd.nextDouble() * 100000;
                
                this.productos[i][j] = new Producto(cantidad, descripcion, id, precio);
                //System.out.println(this.productos[i][j]);
            }
        }
    }
    
    public String mejoresProductosPorCategoria() {
        
        return "";
    }
    
    public String mejoresProductosPorSucursal() {
        String result = "";
        result += String.format("%s\t%10s\t%10s\t%10s\t%10s\t%15s\n", "Sucursal", "ID", "Descripcion", "Precio", "Cantidad", "Valor");
            
        for (int i = 0; i < this.categorias; i++) {
            double cantidad = 0;
            double valor = 0;
            int id = -1;
            double precio = -1;
            String descripcion = "";
            
            for (int j = 0; j < this.sucursales; j++) {
                if (this.productos[i][j].getValor() > valor) {
                    cantidad = this.productos[j][j].getCantidad();
                    valor = this.productos[i][j].getValor();
                    id = this.productos[i][j].getId();
                    precio = this.productos[i][j].getPrecio();
                    descripcion = this.productos[i][j].getDescripcion();
                }
            }
            
            result += String.format("Sucursal " + i + "\t%10d\t%10s\t%,10.2f\t%,10.2f\t%,15.2f\n", id, descripcion, precio, cantidad, valor);
        }
        
        return result;
    }
    
    public void ordenarxId() {
       
    }
    
    public void ordenarxVentas() {
       
    }
    
    public String ventasPorCategoria() {
        String result = "";
        result += String.format("%s\t%10s\t%15s\n", "Categoria", "Cantidad", "Valor");
        double tcantidad = 0;
        double tvalor = 0;
            
        for (int i = 0; i < this.categorias; i++) {
            double cantidad = 0;
            double valor = 0;
            
            for (int j = 0; j < this.sucursales; j++) {
                cantidad += this.productos[j][i].getCantidad();
                valor += this.productos[j][i].getValor();
            }
            
            tcantidad += cantidad;
            tvalor += valor;
            
            result += String.format("Categoria " + i + "\t%,10.2f\t%,15.2f\n", cantidad, valor);
        }
        
        result += String.format("Total General\t%,10.2f\t%,15.2f\n", tcantidad, tvalor);
        
        return result;
    }
    
    public String ventasPorSucursal() {
        String result = "";
        result += String.format("%s\t%10s\t%15s\n", "Sucursal", "Cantidad", "Valor");
        double tcantidad = 0;
        double tvalor = 0;
            
        for (int i = 0; i < this.sucursales; i++) {
            double cantidad = 0;
            double valor = 0;
            
            for (int j = 0; j < this.categorias; j++) {
                cantidad += this.productos[i][j].getCantidad();
                valor += this.productos[i][j].getValor();
            }
            
            tcantidad += cantidad;
            tvalor += valor;
            
            result += String.format("Sucursal " + i + "\t%,10.2f\t%,15.2f\n", cantidad, valor);
        }
        
        result += String.format("Total General\t%,10.2f\t%,15.2f\n", tcantidad, tvalor);
        
        return result;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.sucursales; i++) {
            System.out.println("Sucursal: " + i);
            System.out.printf("%s\t%10s\t\t%10s\t%10s\t%15s\n", "ID", "Descripcion", "Precio", "Cantidad", "Valor");
            
            for (int j = 0; j < this.categorias; j++) {
                System.out.print(this.productos[i][j]);
            }
        }
        
        return "\n";
    }
}
