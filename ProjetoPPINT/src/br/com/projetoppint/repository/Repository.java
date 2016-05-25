/**
 * 
 */
package br.com.projetoppint.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetoppint.data.Conexao;
import br.com.projetoppint.enums.TiposItens;
import br.com.projetoppint.models.Item;
import br.com.projetoppint.models.ItemPedido;
import br.com.projetoppint.models.Pedido;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public class Repository {

	/**
	 * Método utilizado para pesquisar
	 * 
	 * @param campos
	 *            a serem utilizados
	 * @return resultset
	 */
	public ResultSet pesquisar(String[] campos) {
		Conexao con = new Conexao();
		String sql = "SELECT " + campos[0] + " FROM " + campos[1] + ";";
		return con.retornarResultset(sql);
	}

	/**
	 * Método utilizado para inserção
	 * 
	 * @param campos
	 *            a serem utilizados
	 */
	public void inserir(String[] campos) {
		Conexao con = new Conexao();
		String sql = "INSERT INTO " + campos[0] + " VALUES " + campos[1] + ";";
		con.executeSQL(sql);
	}

	/**
	 * Método utilizado para alteração
	 * 
	 * @param campos
	 *            a serem utilizados
	 */
	public void alterar(String[] campos) {
		Conexao con = new Conexao();
		String sql = "UPDATE " + campos[0] + " SET " + campos[1] + ";";
		con.executeSQL(sql);
	}

	/**
	 * Método utilizado para exclusão
	 * 
	 * @param campos
	 *            a serem utilizados
	 */
	public void excluir(String campo) {
		Conexao con = new Conexao();
		String sql = "DELETE FROM " + campo + ";";
		con.executeSQL(sql);
	}

	/**
	 * Retorna os items pelo id
	 * 
	 * @param id
	 *            do item
	 * @return item preenchido
	 * @throws SQLException
	 *             possível exceção
	 */
	public Item getItem(int id) throws SQLException {
		ResultSet resultSet = null;
		Item item = new Item();
		String[] queryItem = new String[2];
		queryItem[0] = "id, nome, precounitario, tipo";
		queryItem[1] = "itens WHERE id = " + id;
		resultSet = pesquisar(queryItem);
		do {
			item.setId(resultSet.getInt(0));
			item.setNome(resultSet.getString(1));
			item.setPrecoUnitario(resultSet.getDouble(2));
			item.setTipo(TiposItens.valueOf(resultSet.getString(3)));
		} while (resultSet.next());
		return item;
	}

	/**
	 * Retorna todos os itens
	 * 
	 * @return Lista de itens
	 * @throws SQLException
	 *             possível exceção
	 */
	public ArrayList<Item> getItens() throws SQLException {
		ArrayList<Item> itens = new ArrayList<>();
		ResultSet resultSet = null;
		String[] queryItem = new String[2];
		queryItem[0] = "id, nome, precounitario, tipo";
		queryItem[1] = "itens";
		resultSet = pesquisar(queryItem);
		do {
			Item item = new Item();
			item.setId(resultSet.getInt(0));
			item.setNome(resultSet.getString(1));
			item.setPrecoUnitario(resultSet.getDouble(2));
			item.setTipo(TiposItens.valueOf(resultSet.getString(3)));
			itens.add(item);
		} while (resultSet.next());
		return itens;
	}

	/**
	 * Retorna todos os itens
	 * 
	 * @params id pedido
	 * @return Lista de itens
	 * @throws SQLException
	 *             possível exceção
	 */
	public ArrayList<Item> getItens(int idPedido) throws SQLException {
		ArrayList<Item> itens = new ArrayList<>();
		ResultSet resultSet = null;
		String[] queryItem = new String[2];
		queryItem[0] = "id, idpedido, iditem";
		queryItem[1] = "itens_pedidos WHERE idpedido = " + idPedido;
		resultSet = pesquisar(queryItem);
		do {
			itens.add(getItem(resultSet.getInt(2)));
		} while (resultSet.next());
		return itens;
	}

	/**
	 * Método utilizado para consultar pedidos baseado no id
	 * 
	 * @param id
	 *            do pedido
	 * @return retorna pedido preenchido
	 * @throws SQLException
	 *             possível exceção
	 */
	public Pedido getPedido(int id) throws SQLException {
		ResultSet resultSet = null;
		Pedido pedido = new Pedido();
		String[] queryItem = new String[2];
		queryItem[0] = "id, data";
		queryItem[1] = "pedidos WHERE id = " + id;
		resultSet = pesquisar(queryItem);
		do {
			pedido.setId(resultSet.getInt(0));
			pedido.setData(resultSet.getDate(1));
			pedido.setListaItens(getItens(id));
		} while (resultSet.next());
		return pedido;
	}

	/**
	 * Método utilizado para consultar pedidos
	 * 
	 * @param id
	 *            do pedido
	 * @return retorna pedido preenchido
	 * @throws SQLException
	 *             possível exceção
	 */
	public Pedido getPedidos() throws SQLException {
		ResultSet resultSet = null;
		Pedido pedido = new Pedido();
		String[] queryItem = new String[2];
		queryItem[0] = "id, data";
		queryItem[1] = "pedidos";
		resultSet = pesquisar(queryItem);
		do {
			pedido.setId(resultSet.getInt(0));
			pedido.setData(resultSet.getDate(1));
			pedido.setListaItens(getItens(pedido.getId()));
		} while (resultSet.next());
		return pedido;
	}

	/**
	 * Método utilizado para consultar itens + pedidos
	 * 
	 * @return lista de itens com relacionamento de pedidos
	 * @throws SQLException
	 *             possível exceção
	 */
	public ArrayList<ItemPedido> getItensPedidos() throws SQLException {
		ArrayList<ItemPedido> itensPedidos = new ArrayList<>();
		ResultSet resultSet = null;
		String[] queryItem = new String[2];
		queryItem[0] = "id, idpedido, idItem";
		queryItem[1] = "itens_pedidos";
		resultSet = pesquisar(queryItem);
		do {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setId(resultSet.getInt(0));
			itemPedido.setPedido(getPedido(resultSet.getInt(1)));
			itemPedido.setItens(getItens(resultSet.getInt(1)));
			itensPedidos.add(itemPedido);
		} while (resultSet.next());
		return itensPedidos;
	}

	public void inserirPedido(Pedido pedido) {
		String[] query = new String[2];
		query[0] = "pedido(data)";
		query[1] = "(" + pedido.getData() + ")";
		inserir(query);
	}

	public void inserirItemPedido(ItemPedido itemPedido) {
		String[] query = new String[2];
		query[0] = "item_pedido(idpedido, iditem)";
		for (Item item : itemPedido.getItens()) {
			query[1] = "(" + itemPedido.getPedido().getId() + ", " + item.getId() + ")";
			inserir(query);
		}
	}

}
