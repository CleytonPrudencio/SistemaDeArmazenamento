package codigo;

import javax.swing.JOptionPane;

import banco.conexao;

public class Dao {
	
	conexao conex = new conexao();
	Beans beans = new Beans();
	
	public Beans pegarusuario (Beans pegarusuario) {
	
		conex.Conexao();
		conex.executaSql("select * from usuarios where usuario like '" + beans.getUsuario() + "' and senha like " + beans.getSenha());
		
		try {
			while (conex.rs.next()) {
				pegarusuario.setUserbanc(conex.rs.getString("usuario"));//Faz a contagem dos chamados
				pegarusuario.setSenhabanc(conex.rs.getInt("senha"));
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao pegar usuario\n\n" + e + "\n\nResultado: " + pegarusuario.getUsuario());
		}
		return pegarusuario;
		
	}
	
	
	//novo usuario
	public Beans novousuario (Beans novousuario) {
		
		conex.Conexao();
		conex.executaSql("INSERT INTO `armazenamento_sistema`.`usuarios` (`usuario`, `senha`) VALUES ('" + novousuario.getNovouser() + "', " + novousuario.getNovasenha() + ");");
		
		try {
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso.");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
		
		return novousuario;
		
	}
	
	public Beans pegarid (Beans pegarid) {
		
		conex.Conexao();
		conex.executaSql("select id from usuarios where usuario like '" + beans.getUsuario()+ "'");
		
		try {
			while (conex.rs.next()) {
				pegarid.setID(conex.rs.getString("id"));//Faz a contagem dos chamados
				
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao pegar usuario\n\n" + e + "\n\nResultado: " + pegarid.getUsuario());
		}
		return pegarid;
		
	}
	
public Beans pegarferramenta (Beans pegarferramenta) {
		
		conex.Conexao();
		conex.executaSql("select * from ferramentas");
		
		try {
			while (conex.rs.next()) {
				//beans.setImagem(conex.rs.getBytes("imagem"));//Faz a contagem dos chamados
				beans.setIdferramenta_lista(conex.rs.getInt("idferramentas"));
				beans.setNomeferramenta_lista(conex.rs.getString("nomeferramenta"));
				beans.setQuantidadeferramentas_lista(conex.rs.getInt("quantidade"));
				beans.setDescricaoferramenta_lista(conex.rs.getString("descricao"));
				beans.setMarcaferramenta_lista(conex.rs.getString("marca"));
				beans.setGarantiaferramenta_lista(conex.rs.getString("garantia"));
				beans.setValorferramenta_lista(conex.rs.getInt("valor"));
				
				
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Erro ao pegar usuario\n\n" + e + "\n\nResultado: " + pegarferramenta.getCodgoferramenta());
		}
		return pegarferramenta;
	}
	

}
