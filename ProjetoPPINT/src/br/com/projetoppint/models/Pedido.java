/**
 * 
 */
package br.com.projetoppint.models;

import java.util.ArrayList;

import br.com.projetoppint.interfaces.IPedido;

/**
 * @author wotan
 *
 */
public class Pedido implements IPedido {
	private int id;
	private ArrayList<Item> listaItens;
	
	public Pedido()
	{
		this.id = 0;
		this.listaItens = new ArrayList<>();
	}
	
	public Pedido(IPedido sourceObject)
	{
		this.id = sourceObject.getId();
		this.listaItens = sourceObject.getListaItens();
	}
	
	
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param listaItens the listaItens to set
	 */
	public void setListaItens(ArrayList<Item> listaItens) {
		this.listaItens = listaItens;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return lista de itens
	 */
	public ArrayList<Item> getListaItens() {
		// TODO Auto-generated method stub
		return this.listaItens;
	}

}
