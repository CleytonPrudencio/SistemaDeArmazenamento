package Classesnaoutilizadas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import banco.conexao;
import codigo.Beans;
import codigo.Dao;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cadastronovousuario extends javax.swing.JFrame {

	private JFrame frmSistemaDeArmazenamento;
	private JTextField novouser;
	private JTextField novasenha;

	/**
	 * Launch the application.
	 */
	
	  public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { try { cadastronovousuario window = new
	  cadastronovousuario(); window.frmSistemaDeArmazenamento.setVisible(true); }
	  catch (Exception e) { e.printStackTrace(); } } }); }
	 

	/**
	 * Create the application.
	 */
	public cadastronovousuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Beans beans = new Beans();
		Dao dao = new Dao();
		conexao conex = new conexao();
		frmSistemaDeArmazenamento = new JFrame();
		frmSistemaDeArmazenamento.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		frmSistemaDeArmazenamento.setTitle("Sistema de Armazenamento");
		frmSistemaDeArmazenamento.setBounds(100, 100, 450, 300);
		frmSistemaDeArmazenamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeArmazenamento.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setBounds(25, 23, 69, 14);
		frmSistemaDeArmazenamento.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(25, 48, 69, 14);
		frmSistemaDeArmazenamento.getContentPane().add(lblNewLabel_1);
		
		novouser = new JTextField();
		novouser.setBounds(79, 20, 86, 20);
		frmSistemaDeArmazenamento.getContentPane().add(novouser);
		novouser.setColumns(10);
		
		novasenha = new JTextField();
		novasenha.setBounds(79, 45, 86, 20);
		frmSistemaDeArmazenamento.getContentPane().add(novasenha);
		novasenha.setColumns(10);
		
		JButton btngravar = new JButton("Gravar");
		btngravar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newuser = novouser.getText().toString();
				int senha = Integer.parseInt(novasenha.getText().toString());
				
				conex.Conexao();
				conex.executaSqlInsert("INSERT INTO `armazenamento_sistema`.`usuarios` (`usuario`, `senha`) VALUES ('" + newuser + "', " + senha + ");");
				
				try {
					JOptionPane.showMessageDialog(null,"Cadastrado com sucesso.");
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Erro desconhecido: " + e1);
				}
				
			}
		});
		btngravar.setBounds(47, 97, 89, 23);
		frmSistemaDeArmazenamento.getContentPane().add(btngravar);
	}

}
