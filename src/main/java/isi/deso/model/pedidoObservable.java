/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.model;

/**
 *
 * @author ivogo
 */
public abstract class pedidoObservable {
    //public abstract void añadirCliente(Cliente c);
    //public abstract void eliminarCliente(Cliente c);
    public abstract void notificarCliente(Cliente c);
    public abstract void siguienteEstado();
}
