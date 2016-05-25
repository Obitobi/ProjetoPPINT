/**
 * 
 */
package br.com.projetoppint.models;

import java.util.ArrayList;

import br.com.projetoppint.interfaces.IItemPedido;

/**
 * @author wotan
 *
 */
public class ItemPedido implements IItemPedido {
	private int id;
	private Pedido pedido;
	private ArrayList<Item> itens;

	public ItemPedido() {
		this.id = 0;
		this.pedido = new Pedido();
		this.itens = new ArrayList<>();
	}

	public ItemPedido(IItemPedido sourceObject) {
		super();
		this.id = sourceObject.getId();
		this.pedido = sourceObject.getPedido();
		this.itens = sourceObject.getItens();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the itens
	 */
	public ArrayList<Item> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
	

}
