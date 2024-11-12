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
public  class Transferencia extends Pago
{
	private final String cuit;
	private final String cbu;
	
	public Transferencia(String cbu, String cuit) {
            super(0, TipoPago.TRANSFERENCIA);
            this.cbu = cbu;
            this.cuit = cuit;
    	}
	
        @Override
	public  void realizarPago(ArrayList < ItemsPedido > l){
		double suma = 0.0;
                for(int i=0 ; i<l.size(); ++i)
                {
                    suma += l.get(i).getPrecio();
                }
                this.monto = 1.02 * suma;
	}
        
        public String getCuit()
        {
            return this.cuit;
        }
        public String getCbu()
        {
            return this.cbu;
        }
}
