/**
 * 
 */
package br.com.projetoppint.interfaces;

import br.com.projetoppint.enums.TiposItens;
import br.com.projetoppint.models.Pedido;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public interface IItem {
	int getId();
	String getNome();
	double getPrecoUnitario();
	TiposItens getTipo();
	Pedido getPedido();
}