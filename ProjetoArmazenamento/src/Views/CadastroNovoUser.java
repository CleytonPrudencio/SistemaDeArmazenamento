package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.conexao;
import codigo.Beans;
import codigo.Dao;

import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class CadastroNovoUser extends JFrame {

	private JPanel contentPane;
	private JTextField novouser;
	private JTextField novasenha;
	private JTextField nomecomp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroNovoUser frame = new CadastroNovoUser();
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
	public CadastroNovoUser() {
		Beans beans = new Beans();
		Dao dao = new Dao();
		conexao conex = new conexao();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		setTitle("Sistema de Armazenamento - Cadastro de Usu\u00E1rio");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(31, 26, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(31, 47, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		novouser = new JTextField();
		novouser.setColumns(10);
		novouser.setBounds(80, 23, 86, 20);
		contentPane.add(novouser);
		
		novasenha = new JTextField();
		novasenha.setColumns(10);
		novasenha.setBounds(80, 45, 86, 20);
		contentPane.add(novasenha);
		
		
		
		JButton btnfechar = new JButton("Fechar");
		btnfechar.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fechar_preview_rev_1.png"));
		btnfechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnfechar.setBounds(154, 160, 112, 23);
		contentPane.add(btnfechar);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E1ximo de 10 caracteres.");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(176, 26, 154, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Utilize apenas numeros (M\u00E1ximo de 10 numeros).");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(176, 48, 344, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel nomecompleto = new JLabel("Nome Completo:");
		nomecompleto.setForeground(Color.WHITE);
		nomecompleto.setBounds(31, 72, 94, 14);
		contentPane.add(nomecompleto);
		
		nomecomp = new JTextField();
		nomecomp.setBounds(135, 69, 401, 20);
		contentPane.add(nomecomp);
		nomecomp.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(31, 99, 94, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JComboBox comobocargo = new JComboBox();
		comobocargo.setModel(new DefaultComboBoxModel(new String[] {"Presidente", "Diretor", "Gerente", "Encarregado", "Supervisor", "Manuten\u00E7\u00E3o de Ferramentas", "Caixa", "Lojista", "Vendendor", "Faxineira", "Outros"}));
		comobocargo.setBounds(80, 96, 229, 20);
		contentPane.add(comobocargo);
		
		JButton btngravar = new JButton("Gravar");
		btngravar.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\confirma_preview_rev_1.png"));
		btngravar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int senha = 0;
				String newuser = novouser.getText().toString();
				String senhaantiga = novasenha.getText().toString();
				String cargo = String.valueOf(comobocargo.getSelectedItem().toString());
				String nome = nomecomp.getText().toString();
				
				senha = Integer.parseInt(senhaantiga);
				
				if (newuser.equals(null) || newuser.equals("") || senhaantiga.equals(null) || senhaantiga.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente.");
				}else { 
				
				conex.Conexao();
				conex.executaSqlInsert("INSERT INTO `armazenamento_sistema`.`usuarios` (`usuario`, `senha`, `nome_completo`, `Cargo`) VALUES ('" + newuser + "', " + senha + " , '" + nome + "' , '" + cargo + "' );");
				
				try {
					JOptionPane.showMessageDialog(null,"Cadastrado com sucesso.");
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Erro desconhecido: " + e1);
				}
				
			}
			}
		});
		btngravar.setBounds(19, 160, 106, 23);
		contentPane.add(btngravar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		lblNewLabel_2.setBounds(0, 0, 567, 357);
		contentPane.add(lblNewLabel_2);
	}
}
