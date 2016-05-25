package br.com.projetoppint.interfaces;

import java.util.ArrayList;

import br.com.projetoppint.models.Item;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public interface IPedido {
	int getId();
	ArrayList<Item> getListaItens();
}
