/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmatriz;

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
    
    private void fill() {
        Random rd = new Random();
        Object ids[] = new Object[this.sucursales * this.categorias];
        
        for (int i = 0; i < this.sucursales; i++) {
            for (int j = 0; j < this.categorias; j++) {
                double cantidad = rd.nextDouble() * 100;
                int id;
                
                do {                    
                    id = rd.nextInt(this.sucursales * this.categorias);
                } while (ids[id] == id);
                
                ids[id] = id;
                
                String descripcion = "Producto " + id;
                double precio = rd.nextDouble() * 100000;
                
                this.productos[i][j] = new Producto(cantidad, descripcion, id, precio);
                //System.out.println(this.productos[i][j]);
            }
        }
    }
    
    public String mejoresProductosPorCategoria() {
        String result = "";
        result += String.format("%s\t%10s\t%10s\t%10s\t%10s\t%15s\n", "Categoria", "ID", "Descripcion", "Precio", "Cantidad", "Valor");
            
        for (int i = 0; i < this.categorias; i++) {
            double cantidad = 0;
            double valor = 0;
            int id = -1;
            double precio = -1;
            String descripcion = "";
            
            for (int j = 0; j < this.sucursales; j++) {
                if (this.productos[j][i].getValor() > valor) {
                    cantidad = this.productos[j][i].getCantidad();
                    valor = this.productos[j][i].getValor();
                    id = this.productos[j][i].getId();
                    precio = this.productos[j][i].getPrecio();
                    descripcion = this.productos[j][i].getDescripcion();
                }
            }
            
            result += String.format("Categoria " + i + "\t%10d\t%10s\t%,10.2f\t%,10.2f\t%,15.2f\n", id, descripcion, precio, cantidad, valor);
        }
        
        return result;
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
                    cantidad = this.productos[i][j].getCantidad();
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
        for (int i = 0; i < this.sucursales; i++) {
            for (int j = 0; j < this.categorias; j++) {
                for (int k = 0; k < this.categorias - 1; k++) {
                    //System.out.println(this.productos[i][j].getId() + " > " + this.productos[i][j + 1].getId());
                    if (this.productos[i][k].getId() > this.productos[i][k + 1].getId()) {
                        Producto proAux = this.productos[i][k];
                        this.productos[i][k] = this.productos[i][k + 1];
                        this.productos[i][k + 1] = proAux;
                    }
                    //System.out.println(this.productos[i][j].getId() + " == " + this.productos[i][j + 1].getId());
                }
            }
        }
    }
    
    public void ordenarxVentas() {
       for (int i = 0; i < this.sucursales; i++) {
            for (int j = 0; j < this.categorias; j++) {
                for (int k = 0; k < this.categorias - 1; k++) {
                    //System.out.println(this.productos[i][j].getId() + " > " + this.productos[i][j + 1].getId());
                    if (this.productos[i][k].getValor() < this.productos[i][k + 1].getValor()) {
                        Producto proAux = this.productos[i][k];
                        this.productos[i][k] = this.productos[i][k + 1];
                        this.productos[i][k + 1] = proAux;
                    }
                    //System.out.println(this.productos[i][j].getId() + " == " + this.productos[i][j + 1].getId());
                }
            }
        }
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
        
        result += String.format("TOTAL GENERAL\t%,10.2f\t%,15.2f\n", tcantidad, tvalor);
        
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
        
        result += String.format("TOTAL GENERAL\t%,10.2f\t%,15.2f\n", tcantidad, tvalor);
        
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
