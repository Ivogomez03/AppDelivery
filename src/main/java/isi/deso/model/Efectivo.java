/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;

import java.util.ArrayList;

/**
 *
 * @author tobir
 */

public  class Efectivo extends Pago 
{
	
	public Efectivo() {
            super(0, TipoPago.EFECTIVO);
    	}
	
        @Override
	public  void realizarPago(ArrayList < ItemsPedido > l)
	{
		double suma = 0.0;
                for(int i=0 ; i<l.size(); ++i)
                {
                    suma += l.get(i).getPrecio();
                }
                this.monto = suma;
	}
        
}
