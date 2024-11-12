/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package isi.deso.dao;
import isi.deso.exception.ItemNoEncontradoException;
import isi.deso.model.Cliente;
import isi.deso.model.Vendedor;
import java.util.List;
/**
 *
 * @author ivogo
 */
public interface ItemsPedidoDAO {
    public abstract List buscarPorVendedor(Vendedor v) throws ItemNoEncontradoException;
    public abstract List buscarPorCliente(Cliente c) throws ItemNoEncontradoException;
    public abstract List buscarPorRangodePrecio(int min, int max) throws ItemNoEncontradoException;
    public abstract List ordenarPorPrecio(boolean asc);

}
/*
Etapa 3: Modulo de gestión de Búsqueda
- Objetivo: Realizar búsquedas sobre los ítems de menu.
- Temas aplicados: Interfaces, streams y lambda, excepciones.
Descripción
- Crear la interface “ItemsPedidoDao” que tendrá diversos métodos para realizar búsquedas.
- Crear una clase ItemsPedidoMemory que implemente ItemsPedidoDao y que realizará la búsqueda
de pedidos por diversos criterios usando el API de Streams
o Filtrado
o Ordenar por criterios
o Búsqueda por rango de precios.
o Buscar por restaurante
- Cuando no se encuentre un dato lanzará un “ItemNoEncontradoException”.
*/
/*
* La clase ItemsPedido es el Pedido Detalle que se ve en el modelo de dato desactualizado
* Se crea una clase ItemsPedidoMemory, acá vas a cargar una lista de los elementos instancias de la clase ItemsPedido, cada elemento va a estar relacionado con ItemMenu (que relaciona con vendedor y categoria), Pedido (que relaciona con el cliente q lo pidió)
* En relación al filtrado, es según a sus criterios, pueden filtrar por nombre de cliente y retornar una lista de Items pedidos; pueden filtrar por vendedor; por cuit de vendedor, etc.
* Ordenar por criterio, puede ser ascendente, descendente el nombre de cliente, o vendeor, etc.
* Buscar por restaurante, recuerden restaurante = vendedor como se detalla en la descripción al inicio del tp integrador (Leanlo!)

Para que se den una idea de pruebas:
Cargo 1 pedido, realizado por X Cliente, que tiene 4 ItemsPedido que cada una de ella está relacionado con ItemMenu, donde ItemMenu es vendido por Y Vendedor. Quiero filtrar por rango de precio entre 1000 y 5000, por ejemplo:
1 Gaseosa = 2500
2 Bife = 10000
3 Vino = 7000
4 Postre = 2500
Con el filtrado por rango me va a tomar como resultado [Postre, Gaseosa] (obviamente es un ejemplo, retornar el toString completo!)
Con el buscar por restaurante, directamente desarrollen una búsqueda sólo por id o nombre del vendedor.
Recuerden, el ejemplo anterior con 4 ItemsPedido 1 Cliente 1 Vendedor es un ejemplo. Les pedimos que desarrollen más que eso con diferentes clientes y vendedores. Para que tengan una idea, pueden tener al menos 20 ItemsPedido y así utilizar los filtrados, búsqueda, etc.
Con el tema de la excepción tendrán que desarrollarla una clase que extienda de la Exception, lean las presentaciones!
*/