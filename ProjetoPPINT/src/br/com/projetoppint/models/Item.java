/**
 * 
 */
package br.com.projetoppint.models;

import br.com.projetoppint.enums.TiposItens;
import br.com.projetoppint.interfaces.IItem;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public class Item implements IItem {
	private int id;
	private String nome;
	private double precoUnitario;
	private TiposItens tipo;

	public Item() {
		this.id = 0;
		this.nome = "";
		this.precoUnitario = 0.0;
		this.tipo = TiposItens.Entrada;
	}

	public Item(IItem sourceObject) {
		this.id = sourceObject.getId();
		this.nome = sourceObject.getNome();
		this.precoUnitario = sourceObject.getPrecoUnitario();
		this.tipo = sourceObject.getTipo();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the precoUnitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario
	 *            the precoUnitario to set
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * 
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(TiposItens tipo) {
		this.tipo = tipo;
	}

	/**
	 * 
	 * @return the tipo
	 */
	public TiposItens getTipo() {
		return this.tipo;
	}
}
