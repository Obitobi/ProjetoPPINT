/**
 * 
 */
package br.com.projetoppint.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetoppint.enums.TiposItens;
import br.com.projetoppint.models.Item;
import br.com.projetoppint.models.Pedido;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public class Context {

	/**
	 * Método utilizado para pesquisar
	 * @param campos a serem utilizados
	 * @return resultset
	 */
	public ResultSet pesquisar(String[] campos) {
		Conexao con = new Conexao();
		String sql = "SELECT " + campos[0] + " FROM " + campos[1] + ";";
		return con.retornarResultset(sql);
	}

	/**
	 * Retorna os items pelo id
	 * @param id do item
	 * @return item preenchido
	 * @throws SQLException possível exceção
	 */
	public Item getItem(int id) throws SQLException {
		ResultSet resultSet = null;
		Item item = new Item();
		String[] queryItem = new String[2];
		queryItem[0] = "id, nome, precounitario, tipo, idpedido";
		queryItem[1] = "itens WHERE id = " + id;
		resultSet = pesquisar(queryItem);
		do {
			item.setId(resultSet.getInt(0));
			item.setNome(resultSet.getString(1));
			item.setPrecoUnitario(resultSet.getDouble(2));
			item.setTipo(TiposItens.valueOf(resultSet.getString(3)));
			item.setPedido(getPedido(resultSet.getInt(4)));
		} while (resultSet.next());
		return item;
	}

	/**
	 * Retorna todos os itens
	 * @return Lista de itens 
	 * @throws SQLException possível exceção
	 */
	public ArrayList<Item> getItens() throws SQLException
	{
		ArrayList<Item> itens = new ArrayList<>();
		ResultSet resultSet = null;
		String[] queryItem = new String[2];
		queryItem[0] = "id, nome, precounitario, tipo, idpedido";
		queryItem[1] = "itens";
		resultSet = pesquisar(queryItem);
		do {
			Item item = new Item();
			item.setId(resultSet.getInt(0));
			item.setNome(resultSet.getString(1));
			item.setPrecoUnitario(resultSet.getDouble(2));
			item.setTipo(TiposItens.valueOf(resultSet.getString(3)));
			item.setPedido(getPedido(resultSet.getInt(4)));
		} while (resultSet.next());
		return itens;
	}
	
	/**
	 * Retorna todos os itens
	 * @params id pedido
	 * @return Lista de itens 
	 * @throws SQLException possível exceção
	 */
	public ArrayList<Item> getItens(int idPedido) throws SQLException
	{
		ArrayList<Item> itens = new ArrayList<>();
		ResultSet resultSet = null;
		String[] queryItem = new String[2];
		queryItem[0] = "id, nome, precounitario, tipo, idpedido";
		queryItem[1] = "itens WHERE idpedido = "+idPedido;
		resultSet = pesquisar(queryItem);
		do {
			Item item = new Item();
			item.setId(resultSet.getInt(0));
			item.setNome(resultSet.getString(1));
			item.setPrecoUnitario(resultSet.getDouble(2));
			item.setTipo(TiposItens.valueOf(resultSet.getString(3)));
			item.setPedido(getPedido(resultSet.getInt(4)));
		} while (resultSet.next());
		return itens;
	}
	
	/**
	 * Método utilizado para consultar pedidos baseado no id
	 * @param id do pedido
	 * @return retorna pedido preenchido
	 * @throws SQLException possível exceção
	 */
	public Pedido getPedido(int id) throws SQLException
	{
		ResultSet resultSet = null;
		Pedido pedido = new Pedido();
		String[] queryItem = new String[2];
		queryItem[0] = "id";
		queryItem[1] = "itens WHERE id = " + id;
		resultSet = pesquisar(queryItem);
		do {
			pedido.setId(resultSet.getInt(0));
			pedido.setListaItens(getItens(id));
		} while (resultSet.next());
		return pedido;
	}
	
	/**
	 * Método utilizado para consultar pedidos
	 * @param id do pedido
	 * @return retorna pedido preenchido
	 * @throws SQLException possível exceção
	 */
	public Pedido getPedido() throws SQLException
	{
		ResultSet resultSet = null;
		Pedido pedido = new Pedido();
		String[] queryItem = new String[2];
		queryItem[0] = "id";
		queryItem[1] = "itens WHERE";
		resultSet = pesquisar(queryItem);
		do {
			pedido.setId(resultSet.getInt(0));
			pedido.setListaItens(getItens(pedido.getId()));
		} while (resultSet.next());
		return pedido;
	}
}
