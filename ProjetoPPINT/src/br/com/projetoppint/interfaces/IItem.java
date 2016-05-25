/**
 * 
 */
package br.com.projetoppint.interfaces;

import br.com.projetoppint.enums.TiposItens;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public interface IItem {
	int getId();
	String getNome();
	double getPrecoUnitario();
	TiposItens getTipo();
}