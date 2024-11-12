/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;
import java.util.ArrayList;
import jakarta.persistence.*;
/**
 *
 * @author tobir
 */

@Entity
public abstract class Pago
{
        @Transient
        private static int contadorID = 0;
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pago", nullable = false)
	protected int id_pago;
        
        @Column
   	protected double monto;
        
        @Column(name= "metodo_pago")
        @Enumerated(EnumType.STRING)
    	protected TipoPago tipoPago;

	public Pago(double monto, TipoPago tipo) {
            this.id_pago = contadorID++;
            this.monto = monto;
            this.tipoPago = tipo;
   	}
	
	public abstract void realizarPago( ArrayList < ItemsPedido > l);
	
}

