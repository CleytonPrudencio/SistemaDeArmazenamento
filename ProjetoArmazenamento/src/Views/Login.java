package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classesnaoutilizadas.Telainicial;
import banco.conexao;
import codigo.Beans;
import codigo.Dao;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;
//Criado por Cleyton Sales - 2020

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldusuario;
	private JPasswordField textFieldsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		conexao conex = new conexao();
		conex.Conexao();
		Beans beans = new Beans();
		Dao dao= new Dao();
		Inicial_gerencia inicial = new Inicial_gerencia();
		Inicial_funcionario inicial_funcionario = new Inicial_funcionario();
		setTitle("Sistema de Armazenamento - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setBounds(196, 81, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(197, 108, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldusuario = new JTextField();
		textFieldusuario.setColumns(10);
		textFieldusuario.setBounds(249, 77, 142, 20);
		contentPane.add(textFieldusuario);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\Configura\u00E7\u00F5es.png"));
		lblNewLabel_3.setBounds(22, 51, 142, 131);
		contentPane.add(lblNewLabel_3);
		
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
				conex.executaSql("select usuario, senha, Cargo from usuarios where usuario like '" + beans.getUsuario() + "' and senha like " + beans.getSenha());
				
				try {
					while (conex.rs.next()) {
						//JOptionPane.showMessageDialog(null,conex.rs.getString("usuario") + conex.rs.getInt("senha"));
						beans.setUserbanc(conex.rs.getString("usuario"));//Faz a contagem dos chamados
						beans.setSenhabanc(conex.rs.getInt("senha"));
						beans.setCargo(conex.rs.getString("Cargo"));
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao pegar usuario\n\n" + e + "\n\nResultado: " + beans.getUsuario());
				}
				//dao.pegarusuario(beans);
				String usuariobanco = beans.getUserbanc();
				String senhabanco = Integer.toString(beans.getSenhabanc());
				String cargos = beans.getCargo();
				
			
				
				//JOptionPane.showMessageDialog(null, "Resultado" + usuario + usuariobanco + senha + senhabanco);

				if (usuario.equals(usuariobanco) && senha.equals(senhabanco)) {
					//JOptionPane.showMessageDialog(null, "Entrou com sucesso." + usuario + usuariobanco);
					//"Presidente", "Diretor", "Gerente", "Encarregado", "Supervisor"
					if (cargos.equals("Presidente") || cargos.equals("Diretor") || cargos.equals("Gerente") || cargos.equals("Encarregado") || cargos.equals("Supervisor")) {
						
						inicial.setVisible(true);
						dispose();
					} else {
						inicial_funcionario.setVisible(true);
						dispose();
					
					}
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
		btnentrar.setBounds(213, 142, 89, 23);
		contentPane.add(btnentrar);
		
		JButton btnsair = new JButton("Sair");
		btnsair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Volte sempre.");
				System.exit(1);
			}
		});
		btnsair.setBounds(323, 142, 89, 23);
		contentPane.add(btnsair);
		
		textFieldsenha = new JPasswordField();
		textFieldsenha.setBounds(249, 105, 142, 20);
		contentPane.add(textFieldsenha);
		
		JLabel lblNewLabel_1_1 = new JLabel("N\u00E3o possui cadastro? Cadastre-se j\u00E1.");
		lblNewLabel_1_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
		});
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CadastroNovoUser cadastroNovoUser = new CadastroNovoUser();
				cadastroNovoUser.setVisible(true);
			}
		});
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(lblNewLabel_1_1.getFont().deriveFont(lblNewLabel_1_1.getFont().getStyle() | Font.ITALIC));
		lblNewLabel_1_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1_1.setBounds(196, 176, 228, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}
}
