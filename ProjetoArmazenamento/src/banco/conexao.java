package banco;



import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexao {

	/*
	 * Conexão local host public Statement stm; public ResultSet rs; private String
	 * driver = "com.microsoft.sqlserver.jdbc.SQLServerD‌​river"; private String
	 * caminho = "jdbc:sqlserver://localhost:1433;/" + "databaseName=Trustsis;";
	 * private String usuario = "sa"; private String senha = "sa"; public Connection
	 * con;
	 */
	
	
	
	/* Conexão AZURE */
	public Statement stm;
	public ResultSet rs;
	public int rsupdate;
	public int rsinsert;
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://localhost:3306/armazenamento_sistema?useSSL=false&allowPublicKeyRetrieval=true";
	private String usuario = "root";
	private String senha = "admin";
	public Connection con;
	public void Conexao () {
	
		try {
			System.setProperty("jdbc.Drivers", driver);
			con=DriverManager.getConnection(caminho, usuario, senha);
			//JOptionPane.showMessageDialog(null, "Conectou");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar\n" + ex.getMessage());
			
		}
	}
	
	public void executaSql (String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao executa SQL \n" + ex.getMessage());
		}
	}
	
	public void executaSqlInsert (String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rsinsert = stm.executeUpdate(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao executa SQL \n" + ex.getMessage());
		}
	}
	
	public void executaSqlUpdate (String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rsupdate = stm.executeUpdate(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao executa SQL \n" + ex.getMessage());
		}
	}


	public void desconecta () {
		try {
			con.close();
			//JOptionPane.showMessageDialog(null, "BD Desconectado com sucesso! ");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com BD \n" + e.getMessage());
		}
	}
	
}