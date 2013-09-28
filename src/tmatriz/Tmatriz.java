/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tmatriz;

import java.util.Scanner;

/**
 *
 * @author salaf405
 */
public class Tmatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc;
        sc = new Scanner(System.in); 
        
        Productos productos = new Productos(10, 10);
        int opc = 0;
        boolean haCreadoProductos = false;
        
        do {            
            opc = menu();
            System.out.println("\n");
            
            switch(opc){
                case 1:
                    productos.toString();
                    break;
                case 2:
                    System.out.println(productos.ventasPorSucursal());
                    break;
                case 3:
                    System.out.println(productos.ventasPorCategoria());
                    break;
                case 4:
                    System.out.println(productos.mejoresProductosPorSucursal());
                    break;
                case 5:
                    System.out.println(productos.mejoresProductosPorCategoria());
                    break;
                case 6:
                    productos.ordenarxId();
                    System.out.println(productos.toString());
                    break;
                case 7:
                    productos.ordenarxVentas();
                    System.out.println(productos.toString());
                    break;
            }
            
        } while (opc != 0);
    }
    
    private static int menu()
    {
        Scanner sc;
        sc = new Scanner(System.in);
        
        System.out.println("*** PRODUCTOS ***");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Ventas por sucursal");
        System.out.println("3. Ventas por categoria");
        System.out.println("4. Mejores productos por sucursal");
        System.out.println("5. Mejores productos por categoria");
        System.out.println("6. Ordenar por ID ascendente");
        System.out.println("7. Ordenar por ventas descencente");
        System.out.println("0. Salir");
        System.out.print("Digite su opción: ");
        
        return sc.nextInt(); 
    }
}
