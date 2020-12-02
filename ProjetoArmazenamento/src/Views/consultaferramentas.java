package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.conexao;
import codigo.Beans;
import codigo.Dao;
import codigo.ManipularImagem;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class consultaferramentas extends JFrame {

	private JPanel contentPane;
	private JTextField nomeferamenta;
	JLabel lblImg = new JLabel();
	ImageIcon im = new ImageIcon();
	private JTextField nomeferra;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaferramentas frame = new consultaferramentas();
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
	public consultaferramentas() {
		Beans beans = new Beans();
		conexao conex = new conexao();
		Dao dao = new Dao();
		
		setTitle("Sistema de Armazenamento - Ajustes");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Ferramenta:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(29, 29, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		nomeferamenta = new JTextField();
		nomeferamenta.setBounds(161, 26, 103, 20);
		contentPane.add(nomeferamenta);
		nomeferamenta.setColumns(10);
		
		nomeferra = new JTextField();
		nomeferra.setColumns(10);
		nomeferra.setBounds(29, 368, 568, 20);
		contentPane.add(nomeferra);
		
		JButton btngravar = new JButton("Consultar");
		btngravar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Image image = null;
				String nomeferramenta = nomeferamenta.getText().toString();
				conex.Conexao();
				conex.executaSql("SELECT * FROM armazenamento_sistema.ferramentas where caminhoimagem like '" + nomeferramenta + "'");
				
				try {
					while (conex.rs.next()) {
				    beans.setCaminhodaimagem(conex.rs.getString("caminhoimagem"));
				    beans.setNomeferramenta(conex.rs.getString("nomeferramenta"));
					File sourcefile = new File ("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\CadastroFerramentas\\" + beans.getCaminhodaimagem() + ".jpg");
					image = ImageIO.read(sourcefile);
					lblImg.setIcon(new ImageIcon(image));
					nomeferra.setText(beans.getNomeferramenta());
					}
					}catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2);
					}
			}
		});
		//btngravar.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\confirma_preview_rev_1.png"));
		btngravar.setBounds(322, 25, 122, 23);
		contentPane.add(btngravar);
		
		JButton btnsair = new JButton("Fechar");
		btnsair.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fechar_preview_rev_1.png"));
		btnsair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnsair.setBounds(635, 502, 99, 23);
		contentPane.add(btnsair);
		
		
		lblImg.setBounds(40, 83, 224, 211);
		contentPane.add(lblImg);
		lblImg.setSize(450, 300); 
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome da Ferramenta");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(29, 343, 132, 14);
		contentPane.add(lblNewLabel_1_1);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		lblNewLabel.setBounds(0, 0, 744, 536);
		contentPane.add(lblNewLabel);
	}
	
	
}
