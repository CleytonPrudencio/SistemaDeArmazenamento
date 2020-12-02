package Classesnaoutilizadas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import banco.conexao;
import codigo.Beans;
import codigo.Dao;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class TelaLogin extends JFrame {

	private JFrame frmSistemaDeArmazenamento;
	private JTextField textFieldusuario;
	private JTextField textFieldsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public TelaLogin() {
		conexao conex = new conexao();
		conex.Conexao();
		Beans beans = new Beans();
		Dao dao= new Dao();
		Telainicial inicial = new Telainicial();

		frmSistemaDeArmazenamento = new JFrame();
		frmSistemaDeArmazenamento.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		frmSistemaDeArmazenamento.setTitle("Sistema de Armazenamento");
		frmSistemaDeArmazenamento.setBounds(100, 100, 450, 300);
		frmSistemaDeArmazenamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeArmazenamento.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(179, 83, 46, 14);
		frmSistemaDeArmazenamento.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(179, 114, 46, 14);
		frmSistemaDeArmazenamento.getContentPane().add(lblNewLabel_2);
		
		textFieldusuario = new JTextField();
		textFieldusuario.setBounds(235, 80, 142, 20);
		frmSistemaDeArmazenamento.getContentPane().add(textFieldusuario);
		textFieldusuario.setColumns(10);
		
		textFieldsenha = new JTextField();
		textFieldsenha.setBounds(235, 111, 142, 20);
		frmSistemaDeArmazenamento.getContentPane().add(textFieldsenha);
		textFieldsenha.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\Configura\u00E7\u00F5es.png"));
		lblNewLabel_3.setBounds(10, 54, 142, 131);
		frmSistemaDeArmazenamento.getContentPane().add(lblNewLabel_3);
		
		JButton btnentrar = new JButton("Entrar");
		btnentrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String usuario = textFieldusuario.getText().toString();
				String senha = textFieldsenha.getText().toString();
				int senhaconvertida = Integer.parseInt(senha);				
				beans.setUsuario(usuario);
				beans.setSenha(senhaconvertida);
			
				conex.Conexao();
				conex.executaSql("select usuario, senha from usuarios where usuario like '" + beans.getUsuario() + "' and senha like " + beans.getSenha());
				
				try {
					while (conex.rs.next()) {
						//JOptionPane.showMessageDialog(null,conex.rs.getString("usuario") + conex.rs.getInt("senha"));
						beans.setUserbanc(conex.rs.getString("usuario"));//Faz a contagem dos chamados
						beans.setSenhabanc(conex.rs.getInt("senha"));
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao pegar usuario\n\n" + e + "\n\nResultado: " + beans.getUsuario());
				}
				//dao.pegarusuario(beans);
				String usuariobanco = beans.getUserbanc();
				String senhabanco = Integer.toString(beans.getSenhabanc());
				
			
				
				//JOptionPane.showMessageDialog(null, "Resultado" + usuario + usuariobanco + senha + senhabanco);

				if (usuario.equals(usuariobanco) && senha.equals(senhabanco)) {
					//JOptionPane.showMessageDialog(null, "Entrou com sucesso." + usuario + usuariobanco);
					inicial.setVisible(true);
					dispose();
					
				}
				/*
				 * if (usuario.equals(null) || usuario.equals("") ||
				 * !usuario.equals(usuariobanco)) { JOptionPane.showMessageDialog(null,
				 * "Usuário em branco ou incorreto. Favor tente novamente."); } if
				 * (!senha.equals(senhabanco) || senha.equals(null) || senha.equals("")) {
				 * JOptionPane.showMessageDialog(null,
				 * "Senha em branco ou incorreta. Favor tente novamente."); }
				 */ if (!usuario.equals(usuariobanco) && !senha.equals(senhabanco)) {
					JOptionPane.showMessageDialog(null, "Usuário e senha incorretos. Favor tente novamente.");

				}
				 
			}
		});
		btnentrar.setBounds(190, 162, 89, 23);
		frmSistemaDeArmazenamento.getContentPane().add(btnentrar);
		
		JButton btnsair = new JButton("Sair");
		btnsair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Volte sempre.");
				System.exit(1);
			}
		});
		btnsair.setBounds(288, 162, 89, 23);
		frmSistemaDeArmazenamento.getContentPane().add(btnsair);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frmSistemaDeArmazenamento.getContentPane().add(lblNewLabel_1);
	}

	
}
