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
        
        
        /*ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);*/
        
        
        // Agregar vendedores al ArrayList
        /*vendedores.add(new Vendedor(1, "Juan Pérez", "Calle Falsa 123", 40.7128, -74.0060,null));
        vendedores.add(new Vendedor(2, "Ana Gómez", "Avenida Siempre Viva 456", 34.0522, -118.2437,null));
        vendedores.add(new Vendedor(3, "Luis Martínez", "Boulevard de los Sueños Rotos 789", 51.5074, -0.1278,null));*/
        
        
        
        /* Agregar clientes al ArrayList
        clientes.add(new Cliente(1, "cliente1@example.com", "20-12345678-9", "Calle del Cliente 1", 40.7128, -74.0060,null));
        clientes.add(new Cliente(2, "cliente2@example.com", "20-23456789-0", "Calle del Cliente 2", 34.0522, -118.2437,null));
        clientes.add(new Cliente(3, "cliente3@example.com", "20-34567890-1", "Calle del Cliente 3", 51.5074, -0.1278,null));*/
        /*
        List<String> nombres = vendedores.stream()  // Crear el Stream a partir de la lista de personas
            .filter(p -> p.getNombre() != "Ana Gómez")    // Filtrar personas cuyo nombre no es nulo
            .map(p -> p.getNombre())                // Mapear las personas a sus nombres
            .collect(Collectors.toList());
        Iterator i = nombres.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        
        }
      */
       /*
        //buscar vendedor por id
        Vendedor vid = buscarVendedorPorId(vendedores);
        vid.println();
        // buscar vendedor por nombre
        Vendedor vNm = buscarVendedorPorNombre(vendedores);
        vNm.println();
        
        // eliminar un vendedor del arreglo por id
        deleteVendedor(vendedores);
        
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor vendedor = vendedores.get(i);
            System.out.println("Id vendedor " + (i + 1) + ": " + vendedor.getId());
            System.out.println("Nombre vendedor " + (i + 1) + ": " + vendedor.getNombre());
            System.out.println("Dirección vendedor " + (i + 1) + ": " + vendedor.getDireccion());
            System.out.println("Latitud vendedor " + (i + 1) + ": " + vendedor.getCoordenada().getLat());
            System.out.println("Longitud vendedor " + (i + 1) + ": " + vendedor.getCoordenada().getLng());
        }
        
        
        
         //buscar cliente por id
        Cliente cId = buscarClientePorId(clientes);
        cId.println();
        
        // eliminar un cliente del arreglo por id
        deleteCliente(clientes);
      
    
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println("Id cliente " + (i + 1) + ": " + cliente.getId());
            System.out.println("Email cliente " + (i + 1) + ": " + cliente.getEmail());
            System.out.println("Cuit cliente " + (i + 1) + ": " + cliente.getCuit());
            System.out.println("Direccion cliente " + (i + 1) + ": " + cliente.getDireccion());
            System.out.println("Latitud cliente " + (i + 1) + ": " + cliente.getCoordenada().getLat());
            System.out.println("Longitud cliente " + (i + 1) + ": " + cliente.getCoordenada().getLng());
        }
        
        
        
        //distancia entre vendedor y cliente
        System.out.println("Vendedor que quieras para calcular la distancia");
        Vendedor vd = buscarVendedorPorId(vendedores);
        
        System.out.println("Cliente que quieras para calcular la distancia");
        Cliente cd = buscarClientePorId(clientes);
        
        vd.distance(cd);          
        */
       // Creación de ItemsMenu para la prueba
       Categoria c1 = new Categoria(1, "Pastas", TipoDeItem.COMIDA);
       Categoria c2 = new Categoria(2, "Gaseosas", TipoDeItem.BEBIDA);
       //int id, String nombre, String descripcion, Categoria categoria, double precio, int calorias, boolean aptoCeliaco, boolean aptoVegetariano
        ItemMenu plato1 = new Plato(1, "Ravioles", "Pasta con salsa sin carne", c1, 12.5, 100, false, true, false); // Supone una clase Plato heredando de ItemMenu
        //(int id, String nombre, String descripcion, Categoria categoria, double precio, int tamanio, double graduacionAlcohol)
        ItemMenu bebida1 = new Bebida(2, "Coca Cola", "Bebida gaseosa", c2, 3.0, 500, 0, true); // Supone una clase Bebida heredando de ItemMenu
        
        // Creación de ItemsPedido
        ItemsPedido itemPedido1 = new ItemsPedido(2, plato1, 1);
        ItemsPedido itemPedido2 = new ItemsPedido(1, bebida1, 2);
        
        // Creación de Pedido para el Cliente
        ArrayList<ItemsPedido> detallesPedido1 = new ArrayList<>();
        detallesPedido1.add(itemPedido1);
        Pedido pedido1 = new Pedido(); 

        ArrayList<ItemsPedido> detallesPedido2 = new ArrayList<>();
        detallesPedido2.add(itemPedido2);
        Pedido pedido2 = new Pedido();
        
        // Creación del Cliente con pedidos
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();
        pedidosCliente.add(pedido1);
        pedidosCliente.add(pedido2);
        Cliente cliente = new Cliente(1, "email@ejemplo.com", "123456789", "Direccion Ejemplo", 40.7128, -74.0060);
        
        // Creación del Vendedor con Items
        ArrayList<ItemMenu> itemsVendedor = new ArrayList<>();
        itemsVendedor.add(plato1);
        itemsVendedor.add(bebida1);
        Vendedor vendedor = new Vendedor(1, "Nombre Vendedor", "Direccion Vendedor", 40.7128, -74.0060, itemsVendedor);
        
        // Creación de ItemsPedidoMemory
        List<ItemsPedido> itemsPedidos = new ArrayList<>();
        itemsPedidos.add(itemPedido1);
        itemsPedidos.add(itemPedido2);
        ItemsPedidoMemory itemsPedidoMemory = new ItemsPedidoMemory(itemsPedidos);

        // Test buscarPorVendedor
        /*
        try {
            List<ItemsPedido> resultPorVendedor = itemsPedidoMemory.buscarPorVendedor(vendedor);
            System.out.println("Buscar por Vendedor: ");
            for(int i=0; i < resultPorVendedor.size(); i++){
                ItemsPedido aux = (ItemsPedido) resultPorVendedor.get(i);
                System.out.println(aux.toString());
            }
            //resultPorVendedor.forEach(System.out::println);
        } catch (ItemNoEncontradoException e) {
            System.out.println("No se encontraron ItemsPedido para el vendedor.");
        }

        // Test buscarPorCliente
        try {
            List<ItemsPedido> resultPorCliente = itemsPedidoMemory.buscarPorCliente(cliente);
            System.out.println("Buscar por Cliente: ");
            for(int i=0; i < resultPorCliente.size(); i++){
                ItemsPedido aux = (ItemsPedido) resultPorCliente.get(i);
                System.out.println(aux.toString());
            }
        } catch (ItemNoEncontradoException e) {
            System.out.println("No se encontraron ItemsPedido para el cliente.");
        }

        // Test buscarPorRangodePrecio
        try {
            List<String> resultRangoPrecio = itemsPedidoMemory.buscarPorRangodePrecio(2, 15);
            System.out.println("Buscar por Rango de Precio: ");
            resultRangoPrecio.forEach(System.out::println);
        } catch (ItemNoEncontradoException e) {
            System.out.println("No se encontraron ItemsPedido en el rango de precio.");
        }
       
        // Test ordenarPorPrecio
        System.out.println("Ordenar por Precio Ascendente:");
        List<ItemsPedido> ordenAsc = itemsPedidoMemory.ordenarPorPrecio(true);
        ordenAsc.forEach(item -> System.out.println(item.getItemMenu().getNombre() + " - Precio Total: " + item.getPrecio()));

        System.out.println("Ordenar por Precio Descendente:");
        List<ItemsPedido> ordenDesc = itemsPedidoMemory.ordenarPorPrecio(false);
        ordenDesc.forEach(item -> System.out.println(item.getItemMenu().getNombre() + " - Precio Total: " + item.getPrecio()));
         
        vendedor.mostrarMenu();
        */
        
        //Etapa 5
        Cliente clienteApedir1 = new Cliente(2, "email@ejemplo.com", "123456789", "Direccion Ejemplo", 40.7128, -74.0060);
        Cliente clienteApedir2 = new Cliente(3, "email@ejemplo2.com", "987654321", "Direccion Ejemplo2",40.5012, -74.2);
        Pedido pedidoNuevo1 = new Pedido();
        pedidoNuevo1.crearPedido(vendedor,clienteApedir1);
        Pedido pedidoNuevo2 = new Pedido();
        pedidoNuevo2.crearPedido(vendedor,clienteApedir2);
        Estado e = Estado.PENDIENTE;
        
        ArrayList<Pedido> pedidosVendedor = vendedor.buscarPorEstado(e);
        if(pedidosVendedor.isEmpty()){
            System.out.println("No se a encontrado pedidos con el estado "+ e);
        }
        else{ 
            System.out.println("Cual pedido desea actualizar su estado? ");
            for(int i = 0; i<pedidosVendedor.size(); i++){
                Pedido aux = pedidosVendedor.get(i);
                System.out.println("Pedido: "+ (i+1) +" Identificacion: "+ aux.getID());
            }
            Scanner entrada = new Scanner(System.in);
            System.out.print("Seleccione el numero de pedido: ");
            
            int numPedido;
            do{
                numPedido = entrada.nextInt();
                entrada.nextLine();
                if((numPedido-1)>pedidosVendedor.size() && 0<(numPedido-1))
                    System.out.println("Seleccione un numero valido desde 1 a "+ pedidosVendedor.size());
            }while((numPedido-1)>pedidosVendedor.size() && 0<(numPedido-1));
            
            pedidosVendedor.get(numPedido-1).siguienteEstado();   
            System.out.println("Pedido actualizado correctamente");
        }        
        
        e = Estado.RECIBIDO;
        
        pedidosVendedor = vendedor.buscarPorEstado(e);
        if(pedidosVendedor.isEmpty()){
            System.out.println("No se a encontrado pedidos con el estado "+ e);
        }
        else{ 
            System.out.println("Cual pedido desea actualizar su estado? ");
            for(int i = 0; i<pedidosVendedor.size(); i++){
                Pedido aux = pedidosVendedor.get(i);
                System.out.println("Pedido: "+ (i+1) +" Identificacion: "+ aux.getID());
            }
            Scanner entrada = new Scanner(System.in);
            System.out.print("Seleccione el numero de pedido: ");
            
            int numPedido;
            do{
                numPedido = entrada.nextInt();
                entrada.nextLine();
                if((numPedido-1)>pedidosVendedor.size() && 0<(numPedido-1))
                    System.out.println("Seleccione un numero valido desde 1 a "+ pedidosVendedor.size());
            }while((numPedido-1)>pedidosVendedor.size() && 0<(numPedido-1));
            
            pedidosVendedor.get(numPedido-1).siguienteEstado();   
            System.out.println("Pedido actualizado correctamente");
        }        
        
        e = Estado.PREPARACION;
        
        pedidosVendedor = vendedor.buscarPorEstado(e);
        
        if(pedidosVendedor.isEmpty()){
            System.out.println("No se a encontrado pedidos con el estado "+ e);
        }
        else{ 
            System.out.println("Cual pedido desea actualizar su estado? ");
            for(int i = 0; i<pedidosVendedor.size(); i++){
                Pedido aux = pedidosVendedor.get(i);
                System.out.println("Pedido: "+ (i+1) +" Identificacion: "+ aux.getID());
            }
            Scanner entrada = new Scanner(System.in);
            System.out.print("Seleccione el numero de pedido: ");
            
            int numPedido;
            do{
                numPedido = entrada.nextInt();
                entrada.nextLine();
                if((numPedido-1)>pedidosVendedor.size() && 0<(numPedido-1))
                    System.out.println("Seleccione un numero valido desde 1 a "+ pedidosVendedor.size());
            }while((numPedido-1)>pedidosVendedor.size() && 0<(numPedido-1));
            
            pedidosVendedor.get(numPedido-1).siguienteEstado();   
            System.out.println("Pedido actualizado correctamente");
        }        
        
        
        
        
    }
       
}
    
