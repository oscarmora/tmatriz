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
        
        Productos productos = null;
        int opc = 0;
        boolean haCreadoProductos = false;
        
        do {            
            opc = menu();
            
            switch(opc){
                case 1:
                    System.out.println("productos");
            }
            
        } while (opc != 0);
    }
    
    public static int menu()
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
        System.out.println("Digite su opción: ");
        
        return sc.nextInt(); 
    }
}
