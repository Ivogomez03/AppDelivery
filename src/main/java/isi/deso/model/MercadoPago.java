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
public  class MercadoPago extends Pago
{
	private final String alias;
	
	public MercadoPago(String alias) {
        super(0, TipoPago.MERCADOPAGO);
            this.alias = alias;
   	}
	
        @Override
	public  void realizarPago(ArrayList < ItemsPedido > l)
	{
		double suma = 0.0;
                for(int i=0 ; i<l.size(); ++i)
                {
                    suma += l.get(i).getPrecio();
                }
                this.monto = 1.04 * suma;
	}
        
        public String getAlias()
        {
            return this.alias;
        }
	
}