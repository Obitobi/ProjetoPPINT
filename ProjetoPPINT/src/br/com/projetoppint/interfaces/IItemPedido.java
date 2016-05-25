package br.com.projetoppint.interfaces;

import java.util.ArrayList;

import br.com.projetoppint.models.Item;
import br.com.projetoppint.models.Pedido;

public interface IItemPedido {
	int getId();
	Pedido getPedido();

	ArrayList<Item> getItens();
}
