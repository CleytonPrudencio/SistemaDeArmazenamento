package Classesnaoutilizadas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Telainicial extends JFrame{

	private JFrame frmSistemaDeArmazenamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telainicial frame = new Telainicial();
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
	public Telainicial() {
		frmSistemaDeArmazenamento = new JFrame();
		frmSistemaDeArmazenamento.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		frmSistemaDeArmazenamento.setTitle("SIstema de Armazenamento");
		frmSistemaDeArmazenamento.setBounds(100, 100, 761, 571);
		frmSistemaDeArmazenamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeArmazenamento.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeArmazenamento.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\CadMedicos.png"));
		menuBar.add(mnNewMenu);
		
		JButton btnnovouser = new JButton("Novo usu\u00E1rio");
		btnnovouser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastronovousuario cadastro = new cadastronovousuario();
				cadastro.setVisible(true);
			}
		});
		mnNewMenu.add(btnnovouser);
		
		JButton btnsair = new JButton("Sair");
		mnNewMenu.add(btnsair);
		
		JLabel lblsairsistema = new JLabel("Sair");
		lblsairsistema.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\exit.png"));
		menuBar.add(lblsairsistema);
	}
}
