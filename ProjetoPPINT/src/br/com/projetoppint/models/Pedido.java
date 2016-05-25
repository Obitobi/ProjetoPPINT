/**
 * 
 */
package br.com.projetoppint.models;

import java.sql.Date;
import java.util.ArrayList;

import br.com.projetoppint.interfaces.IPedido;

/**
 * @author wotan
 *
 */
public class Pedido implements IPedido {
	private int id;
	private ArrayList<Item> listaItens;
	private Date data;
	
	public Pedido()
	{
		this.id = 0;
		this.listaItens = new ArrayList<>();
		this.data = new Date(0); 
	}
	
	public Pedido(IPedido sourceObject)
	{
		this.id = sourceObject.getId();
		this.listaItens = sourceObject.getListaItens();
		this.data = sourceObject.getData();
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

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	
}
