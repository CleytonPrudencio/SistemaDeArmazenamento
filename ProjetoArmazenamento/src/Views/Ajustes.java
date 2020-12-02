package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ajustes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajustes frame = new Ajustes();
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
	public Ajustes() {
		setTitle("Sistema de Armazenamento - Ajustes");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Banco de Dados:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(29, 29, 163, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(122, 26, 555, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Utilize sempre o modelo abaixo:\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(266, 51, 242, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\"jdbc:mysql://localhost:3306/armazenamento_sistema?useSSL=false\";");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(173, 75, 478, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btngravar = new JButton("Gravar");
		btngravar.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\confirma_preview_rev_1.png"));
		btngravar.setBounds(522, 502, 103, 23);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		lblNewLabel.setBounds(0, 0, 744, 548);
		contentPane.add(lblNewLabel);
	}

}
