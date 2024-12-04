/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ivogo
 */

@Entity
public class Pedido extends pedidoObservable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", nullable = false)
    private int id;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
    private List<ItemsPedido> detalle;
    
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    public Cliente cliente;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_pago")
    public Pago pago;
    
    @ManyToOne
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    public Vendedor vendedor;
    
    
    public Pedido(){
        this.estado = Estado.PENDIENTE;
        this.detalle = new ArrayList();
    }
    public Pago getPago(){
        return this.pago;
    }    
    public Estado getEstado(){
        return this.estado;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public Vendedor getVendedor(){
        return this.vendedor;
    }
    public int getID(){
        return this.id;
    }
    public List<ItemsPedido> getDetalle(){
        return this.detalle;
    }
    
    public void setID(int id){
        this.id = id;
    }
    public void setCliente(Cliente cl){
        this.cliente = cl;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }
    public void setDetalle(List<ItemsPedido> detalle){
        this.detalle = detalle;
    }
 
    public void setPago(Pago p){
        this.pago= p;
    }
    
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }
    
    /*public void crearPedido(Vendedor vendedor,Cliente cliente){
        vendedor.mostrarMenu();
         
        ArrayList itemsPedidoCliente = new ArrayList<ItemsPedido>();
        Boolean bandera = true;
        
        while(bandera){
            Scanner scanner = new Scanner(System.in);
            int numeroPlato, cantidadPlato;
            
            System.out.println("Seleccione el plato que desea y luego su cantidad (ingrese 0 para finalizar): "); 
            System.out.print("Plato: ");
            numeroPlato = scanner.nextInt();
            
            if(numeroPlato > vendedor.getItems().size()){
                System.out.println("Seleccione un numero de plato entre 1 y " + vendedor.getItems().size());
            }
            else if(numeroPlato != 0){
                System.out.print("Cantidad: ");
                cantidadPlato = scanner.nextInt();
                
                if(cantidadPlato <= 0){
                
                System.out.println("Seleccione una cantidad valida (mayor o igual a 1)");
                
                }
                else if(numeroPlato <= vendedor.getItems().size() && cantidadPlato >= 1){

                    ItemsPedido itempedido = new ItemsPedido(cantidadPlato, (ItemMenu) vendedor.getItems().get(numeroPlato-1), 0);

                    itemsPedidoCliente.add(itempedido);

                }
            }
            else{
                System.out.println("Fin");
                scanner.nextLine();
                bandera = false;     
            }
        
            
        }
        
        this.setDetalle(itemsPedidoCliente);
        
        this.setCliente(cliente);
        
        bandera = true;
        
        while(bandera){
            Scanner scanner = new Scanner(System.in);
            int opcion;
            System.out.println("Elegir metodo de pago: ");
            System.out.println("1: Efectivo");
            System.out.println("2: Transferencia");
            System.out.println("3: Mercado Pago");
            System.out.print("Ingrese su eleccion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            if(opcion == 1){
                this.pago.tipoPago = TipoPago.EFECTIVO;
            }
            else if(opcion ==2){
                this.pago.tipoPago = TipoPago.TRANSFERENCIA;
            
            } 
            else if(opcion == 3){
                this.pago.tipoPago = TipoPago.MERCADOPAGO;
            }
            bandera = false;
            
        }
        
        cliente.addPedido(this);
        vendedor.addPedido(this);

    }*/
    @Override
    public void notificarCliente(Cliente c){}/*
        c.notificarPedido(this.estado);
    }
    public void generarPago(){
        Scanner scanner = new Scanner(System.in);
        if(this.pago.tipoPago == TipoPago.EFECTIVO){
                Efectivo e = new Efectivo();
                e.realizarPago(this.detalle);
                

                this.setPago(e);
        
            }
            else if(this.pago.tipoPago == TipoPago.TRANSFERENCIA){
                System.out.print("Ingrese su cbu: ");
                String cbu;
                cbu = scanner.nextLine();
               
                if(cbu.length() == 22){
                    Transferencia tranf = new Transferencia(cliente.getCuit(),cbu);
                    tranf.realizarPago(this.detalle);


                    this.setPago(tranf);
                 
                }
                else{
                    System.out.println("Cbu invalida");
                }
            
            } 
            else if(this.pago.tipoPago == TipoPago.MERCADOPAGO){
                System.out.println("Ingrese su alias: ");
                String alias = scanner.nextLine();
                
                MercadoPago mp = new MercadoPago(alias);
               
                mp.realizarPago(this.detalle);
                
                this.setPago(mp);

            }
    
    }
    */@Override
    public void siguienteEstado(){
        // cambiar estado
        switch(this.estado){
            case Estado.PENDIENTE ->  {
                this.estado = Estado.RECIBIDO;
            }
            case Estado.RECIBIDO ->  {
                this.estado = Estado.PREPARACION;
            }
            case Estado.PREPARACION ->  {
                this.estado = Estado.ENVIADO;
            }
            case Estado.ENVIADO ->  {
                this.estado = Estado.ENTREGADO;
            }
            default -> {
            }
        }
        // notificamos al cliente de que el estado de su pedido ha cambiado
        notificarCliente(this.cliente);
        if(this.estado == Estado.ENVIADO); //generarPago();
    }
}