package Views;

import java.awt.BorderLayout;

import codigo.Beans;
import codigo.ManipularImagem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.conexao;

import javax.swing.JMenuBar;
import java.awt.Toolkit;
import java.awt.Frame;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.DropMode;
import java.awt.Cursor;
import javax.swing.JTextPane;
import javax.swing.RootPaneContainer;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.KeyEvent;
import java.awt.Canvas;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class consultaferramentas_lista extends JFrame {
	
	BufferedImage imagem;
	   JLabel jLabel1 = new javax.swing.JLabel();
       JButton blnEnviar = new javax.swing.JButton();
		String nome;
		String caminho;
		String caminhoimagem;
		conexao conex = new conexao();
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");
	private JTable table;
	private JTextField campodepesquisa;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaferramentas_lista frame = new consultaferramentas_lista();
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
	public consultaferramentas_lista() {
		Beans beans = new Beans();
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		CadastroNovoUser cadastro= new CadastroNovoUser();
		Ajustes ajustes = new Ajustes();
		setTitle("Sistema de Armazenamento - Tela Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 740);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 77, 1296, 584);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(Color.BLUE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Ferramenta", "Quantidade", "Descri\u00E7\u00E3o do Produto", "Marca / Fabricante", "Garantia", "Valor"
			}
		));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Escolha um Filtro");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setBounds(26, 26, 180, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JComboBox combofiltros = new JComboBox();
		combofiltros.setModel(new DefaultComboBoxModel(new String[] {"", "ID da Ferramenta", "Nome da Ferramenta", "Quantidade", "Marca", "Valor"}));
		combofiltros.setBounds(26, 39, 229, 20);
		contentPane.add(combofiltros);
		
		campodepesquisa = new JTextField();
		campodepesquisa.setBounds(303, 39, 269, 20);
		contentPane.add(campodepesquisa);
		campodepesquisa.setColumns(10);
		
		JButton btnpesquisar = new JButton("Pesquisar");
		btnpesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String filtro = String.valueOf(combofiltros.getSelectedItem().toString());
				String campopesquisa = campodepesquisa.getText().toString();
				
				if (filtro.equals("ID da Ferramenta")) {
				carregatabela("idferramentas", campopesquisa );
				} if (filtro.equals("Nome da Ferramenta")) {
				carregatabela("nomeferramenta", campopesquisa );
				} if (filtro.equals("Quantidade")) {
					carregatabela("quantidade", campopesquisa );
				} if (filtro.equals("Marca")) {
					carregatabela("marca", campopesquisa );
				} if (filtro.equals("Valor")) {
					carregatabela("valor", campopesquisa );
				} if (filtro == null || filtro.equals("") || campopesquisa.equals("") || campopesquisa == null)  {
					JOptionPane.showMessageDialog(null, "Filtro ou campo de pesquisa incorreto. Não foi possível carregar os produtos.");
				}
			}
		});
		btnpesquisar.setBounds(614, 38, 118, 23);
		contentPane.add(btnpesquisar);
		
		JButton listartodas = new JButton("Listar todas as ferramentas");
		listartodas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listacompleta();
			}
		});
		listartodas.setBounds(756, 38, 387, 23);
		contentPane.add(listartodas);
		
		JButton btnsair = new JButton("Fechar");
		btnsair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnsair.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fechar.jpg"));
		btnsair.setBounds(614, 670, 150, 31);
		contentPane.add(btnsair);
		lblNewLabel.setBounds(0, 0, 1366, 726);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setDisplayedMnemonic(KeyEvent.VK_COPY);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		contentPane.add(lblNewLabel);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	 
	  public void blnEnviarActionPerformed() {//GEN-FIRST:event_blnEnviarActionPerformed
		  		Beans beans = new Beans();
		         try {
	             // TODO add your handling code here:
	             caminho = "C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\CadastroFerramentas\\";
	             File outputfile = new File(caminho + nome + ".jpg");
	             ImageIO.write(imagem, "jpg", outputfile);
	             JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
	             caminhoimagem = caminho + nome + ".jpg";
	             beans.setCaminhodaimagem(caminhoimagem); 
	             
	             
	         } catch (IOException ex) {
	             Logger.getLogger(consultaferramentas_lista.class.getName()).log(Level.SEVERE, null, ex);
	         }
	    }
	  
	  	
	  public void carregatabela (String coluna, String filtro) {
		  DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(20);
			table.getColumnModel().getColumn(2).setPreferredWidth(20);
			table.getColumnModel().getColumn(3).setPreferredWidth(20);
			table.getColumnModel().getColumn(4).setPreferredWidth(20);
			table.getColumnModel().getColumn(5).setPreferredWidth(20);
			table.getColumnModel().getColumn(6).setPreferredWidth(20);
			
			try {
				
				
				conex.Conexao();
				conex.executaSql("select * from ferramentas where " + coluna + " like '%" + filtro + "%'");
				
while (conex.rs.next()) {
					
					modelo.addRow(new Object[] {
							conex.rs.getString("idferramentas"),
							conex.rs.getString("nomeferramenta"),
							conex.rs.getString("quantidade"),
							conex.rs.getString("descricao"),
							conex.rs.getString("marca"),
							conex.rs.getString("garantia"),
							conex.rs.getString("valor")
								
					});
					
				} 
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Erro no select\n\n" + e);
				// TODO: handle exception
			}
}
	  
	  public void listacompleta () {
		  DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(20);
			table.getColumnModel().getColumn(2).setPreferredWidth(20);
			table.getColumnModel().getColumn(3).setPreferredWidth(20);
			table.getColumnModel().getColumn(4).setPreferredWidth(20);
			table.getColumnModel().getColumn(5).setPreferredWidth(20);
			table.getColumnModel().getColumn(6).setPreferredWidth(20);
			
			try {
				
				
				conex.Conexao();
				conex.executaSql("select * from ferramentas");
				
while (conex.rs.next()) {
					String real = "R$";
					modelo.addRow(new Object[] {
							conex.rs.getString("idferramentas"),
							conex.rs.getString("nomeferramenta"),
							conex.rs.getString("quantidade"),
							conex.rs.getString("descricao"),
							conex.rs.getString("marca"),
							conex.rs.getString("garantia"),
							real + conex.rs.getString("valor")
								
					});
					
				} 
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Erro no select\n\n" + e);
				// TODO: handle exception
			}
}
}
