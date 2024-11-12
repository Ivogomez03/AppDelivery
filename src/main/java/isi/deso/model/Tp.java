/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package isi.deso.model;
import isi.deso.service.ItemsPedidoMemory;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.InputMismatchException;
 /*
 * @author Francisco
 */
public class Tp {

    
    public static Vendedor buscarVendedorPorId(List lista){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Introduce el id del vendedor que desea buscar: ");
                int id = scanner.nextInt();
                int i = 0;
                while(i< lista.size()){
                    Vendedor aux = (Vendedor)lista.get(i);
                    if(aux.getId() == id){
                        return aux; 
                    }
                    i++;
                }
                scanner.nextLine();
                System.out.println("El vendedor no se encontro");
            }
            catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, ingrese los datos correctamente.");
                    scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
        
    }
    
    public static Cliente buscarClientePorId(List lista){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Introduce el id del cliente que desea buscar: ");
                int id = scanner.nextInt();
                int i = 0;
                while(i< lista.size()){
                    Cliente aux = (Cliente)lista.get(i);
                    if(aux.getId() == id){
                        return aux;
                    }
                    i++;
                }
                scanner.nextLine();
                System.out.println("El cliente no se encontro");
            }
            catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, ingrese los datos correctamente.");
                    scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
    
    public static Vendedor buscarVendedorPorNombre(List lista){
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.print("Introduce el nombre del vendedor que desea buscar: ");
                String nombre = scanner.nextLine();
                int i = 0;
                while(i< lista.size()){
                    Vendedor aux = (Vendedor)lista.get(i);
                    if(aux.getNombre().equals(nombre)){
                        return aux;
                    }
                    i++;
                }
                scanner.nextLine();
                System.out.println("El vendedor no se encontro");
            }
            catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, ingrese los datos correctamente.");
                    scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
    
    public static void deleteVendedor(List lista){
        Scanner scanner = new Scanner(System.in);
        boolean b1 = false;
        while(!b1){
            try{
                System.out.print("Introduce el id del vendedor que desea eliminar: ");
                int id = scanner.nextInt();
                int i = 0;
                boolean b = true;
                while(i< lista.size() && b){
                    Vendedor aux = (Vendedor)lista.get(i);
                    if(aux.getId() == id){
                        lista.remove(i);
                        System.out.println("El vendedor de id " + id + " ha sido eliminado correctamente.");
                        b=false;
                        b1 = true;
                    }
                    i++;
                }

            }
            catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese los datos correctamente.");
                    scanner.nextInt(); // Limpiar el buffer del scanner
            }
        }
    }
    
    public static void deleteCliente(List lista){
        Scanner scanner = new Scanner(System.in);
        boolean b1 = false;
        while(!b1){
            try{
                System.out.print("Introduce el id del cliente que desea eliminar: ");
                int id = scanner.nextInt();
                int i = 0;
                boolean b = true;
                while(i< lista.size() && b){
                    Cliente aux = (Cliente)lista.get(i);
                    if(aux.getId() == id){
                        lista.remove(i);
                        System.out.println("El cliente de id " + id + " ha sido eliminado correctamente.");
                        b=false;
                        b1 = true;
                    }
                    i++;
                }

            }
            catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, ingrese los datos correctamente.");
                    scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
    
    public static void main(String[] args){
        
        System.out.println("Integrantes: ");
        System.out.println("Quagliotti, Franco DNI: 45637539");
        System.out.println("Ruybal, Pablo Andres DNI: 44761756");
        System.out.println("Gomez Enrico, Ivo DNI: 44783043");
        System.out.println("Balsamo, Francisco DNI: 45952094");
        System.out.println("Rivero, Tobias DNI: 45.805.884");
        System.out.println("--------------------------------\n\n\n");
          
    }
       
}
    
