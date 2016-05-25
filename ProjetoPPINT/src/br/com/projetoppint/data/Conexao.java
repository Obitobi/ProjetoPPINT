/**
 * 
 */
package br.com.projetoppint.data;

import java.sql.*;
import javax.swing.*;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public class Conexao 
{
    //Objetos utilizados para a conexão com o banco de dados
    public Connection conexao;
    public Statement statement;
    
    //variavl do tipo string que armazena o nome do driver a ser carregado(no caso o drivar para o JDBC mysql)
    final private String servidor = "com.mysql.jdbc.Driver";
    //variavel que armazena o nome da fonte de dados
    private String urlBanco = "jdbc:mysql://localhost:3306/nomebancodedados";    
    // variavel q armazena o nome do usuario
    private String usuarioBanco = "root";
    //variavel que armazena a senha do usuario
    private String senhaBanco = "";
    
    public boolean conectar() 
    {
        boolean result = true;
        try 
        {
         Class.forName(servidor);//vai tentar carregar o driver que foi indicado acima
         conexao = DriverManager.getConnection(urlBanco, usuarioBanco, senhaBanco); //vai executar a conexao utilizando dados indicados
         //JOptionPane.showMessageDialog(null,"Conectou com o Banco de dados!");
        } 
        catch (ClassNotFoundException Driver) 
        { //Se ele não conseguir achar o driver indicado ele executa esse erro
            JOptionPane.showMessageDialog(null, "Driver nao localizado: " + Driver); //Mensagem explicando qual é o erro
            result = false; // como não conseguiu conectar retorna a opção false
        } 
        catch(SQLException Fonte) 
        {//Se não conseguir achar a fonte de dados porque não foi criada ele executa esse catch
            JOptionPane.showMessageDialog(null, "Deu erro na conexão com a fonte de dados: " + Fonte);
            result = false;// como não conseguiu achar a fonte de dados retorna false
        }
        return result; //resultado final
    }
    
    public void desconectar() 
    { //método do tipo void porque não precisa de nenhum retorno só para que o banco seja fechado
        try 
        {
            conexao.close();
        } 
        catch(SQLException fecha) 
        {//Se não conseguir fechar o banco entra nessa linha
            JOptionPane.showMessageDialog(null,"Não foi possivel fechar o banco de dados" + fecha);
        }
    }
    
    public void executeSQL(String sql) 
    {
        try 
        {
            conectar();
            statement = conexao.createStatement();//cria a ligação da conexão com o banco de dados
            statement.execute(sql);//executa sql solicitada
        } 
        catch(SQLException sqle) 
        {//se houver erros de sql entra nessa linha
            JOptionPane.showMessageDialog(null, "Erro de SQL" + sqle.getMessage());//mensagem mostrando o erro
        }
    }
    public ResultSet retornarResultset(String sql) 
    { //método que opera a sql (ex: operações de soma, contar,etc)
        ResultSet resultSet = null; //variavel resulSet do tipo ResulSet
        conectar(); //chama o método conectar
        try 
        {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// é necessário para que seja possível caminhar entre os registros
            resultSet = statement.executeQuery(sql);
            resultSet.next(); //vai para o proximo registro
        } 
        catch (Exception e) 
        { //se não conseguir
            //JOptionPane.showMessageDialog(null, e.getMessage()); //mostra mensagem com o erro
        }
        return resultSet;
    }
}