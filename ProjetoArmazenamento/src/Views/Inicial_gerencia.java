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

public class Inicial_gerencia extends JFrame {
	
	BufferedImage imagem;
	   JLabel jLabel1 = new javax.swing.JLabel();
       JLabel lblImagem = new javax.swing.JLabel();
       JButton blnEnviar = new javax.swing.JButton();
		String nome;
		String caminho;
		String caminhoimagem;

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");
	private JTextField nomeferramenta;
	private JTextField marcainterface;
	private JTextField valor;
	private JTextField descricaodaimagem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial_gerencia frame = new Inicial_gerencia();
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
	public Inicial_gerencia() {
		Beans beans = new Beans();

		setExtendedState(Frame.MAXIMIZED_BOTH);
		CadastroNovoUser cadastro= new CadastroNovoUser();
		Ajustes ajustes = new Ajustes();
		setTitle("Sistema de Armazenamento - Tela Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\icone.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 740);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair do sistema?");
				if (i == 0 ) {
					JOptionPane.showMessageDialog(null, "Volte sempre.");
					System.exit(1);
				} else if (i == 1) {
					
				}
				
			}
		});
		
		JMenu mnNewMenu = new JMenu("Cadastros");
		menuBar.add(mnNewMenu);
		
		JButton btnnovocadastro = new JButton("Novo Cadastro");
		btnnovocadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CadastroNovoUser cadastro = new CadastroNovoUser();
				cadastro.setVisible(true);
			}
		});
		mnNewMenu.add(btnnovocadastro);
		
		JButton btnNewButton_2 = new JButton("Alterar Cadastro");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AlterarCadastro alterarCadastro = new AlterarCadastro();
				alterarCadastro.setVisible(true);
			}
		});
		mnNewMenu.add(btnNewButton_2);
		
		JMenu mnNewMenu_1 = new JMenu("Ferramentas");
		menuBar.add(mnNewMenu_1);
		
		JButton btnconsultar = new JButton("Consultar Ferramenta Individual");
		btnconsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consultaferramentas consultaferramentas = new consultaferramentas();
				consultaferramentas.setVisible(true);
			}
		});
		mnNewMenu_1.add(btnconsultar);
		
		JButton consultartodas = new JButton("Consultar Todas Ferramentas");
		consultartodas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consultaferramentas_lista consultaferramentas_lista = new consultaferramentas_lista();
				consultaferramentas_lista.setVisible(true);
			}
		});
		mnNewMenu_1.add(consultartodas);
		lblNewLabel_1.setAlignmentX(10.0f);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\exit.png"));
		menuBar.add(lblNewLabel_1);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar uma nova ferramenta:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 11, 317, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome da ferramenta:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(212, 26, 180, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 236, 92, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Descri\u00E7\u00E3o do Produto:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(10, 353, 317, 14);
		contentPane.add(lblNewLabel_3_1);
		
		nomeferramenta = new JTextField();
		nomeferramenta.setBounds(212, 41, 424, 20);
		contentPane.add(nomeferramenta);
		nomeferramenta.setColumns(10);
		
		JSpinner spinner1 = new JSpinner();
		spinner1.setBounds(10, 253, 83, 20);
		contentPane.add(spinner1);
		
		JButton btnImagem = new javax.swing.JButton();
		btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });
		btnImagem.setForeground(Color.BLACK);
		btnImagem.setBounds(323, 72, 180, 20);
		contentPane.add(btnImagem);
		 btnImagem.setText("Selecionar Imagem");
	     
		JEditorPane descricao = new JEditorPane();
		descricao.setBounds(10, 371, 659, 124);
		contentPane.add(descricao);
		
		JComboBox combogarantia = new JComboBox();
		combogarantia.setModel(new DefaultComboBoxModel(new String[] {"Escolha uma op\u00E7\u00E3o", "6 Meses", "1 Ano", "2 Anos", "3 Anos", "4 Anos", "5 Anos", "Sem Garantia"}));
		combogarantia.setBounds(212, 160, 229, 20);
		contentPane.add(combogarantia);
		
		JButton btnNewButton = new JButton("Gravar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 conexao conex = new conexao();
				 nome = nomeferramenta.getText().toString();
	             String marca = marcainterface.getText().toString();
				 String garantia = String.valueOf(combogarantia.getSelectedItem().toString());
				 String descricaoimagem = descricaodaimagem.getText().toString();
	             int quantidade = Integer.parseInt(spinner1.getValue().toString());
	             String valorferramenta = valor.getText().toString();   
	            
	             String descri = descricao.getText().toString();
				
				  try {
			             // TODO add your handling code here:
			             caminho = "C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\CadastroFerramentas\\";
			             File outputfile = new File(caminho + nome + ".jpg");
			             ImageIO.write(imagem, "jpg", outputfile);
			             JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
			             String testecaminhoimagem = nome;
			             
			              
			             //JOptionPane.showMessageDialog(null, );
			             
			            // JOptionPane.showMessageDialog(null, nome + marca + garantia + descricaoimagem + quantidade + valorferramenta + descri);
			             conex.Conexao();
			             conex.executaSqlInsert("INSERT INTO `armazenamento_sistema`.`ferramentas`(`nomeferramenta`,`quantidade`,`descricao`,`Descricaoimagem`,`marca`,`garantia`,`valor`,`caminhoimagem`) VALUES ('" + nome + "', " + quantidade + " , '" + descri + "', '" + descricaoimagem + "', '" + marca + "' , '"+ garantia +"', '"+ valorferramenta +"', '" + testecaminhoimagem + "');");
				         
				         
				         try {
				        	 JOptionPane.showMessageDialog(null, "Ferramenta Salva!");
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, e2);
						}
			             
			         } catch (IOException ex) {
			             Logger.getLogger(Inicial_gerencia.class.getName()).log(Level.SEVERE, null, ex);
			         }
	             

	           	
					
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\confirma_preview_rev_1.png"));
		btnNewButton.setBounds(61, 510, 108, 23);
		contentPane.add(btnNewButton);
		
	
		
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nomeferramenta.setText("");
				descricao.setText("");
				spinner1.setValue(0);
				
			}
		});
		btnNewButton_1.setBounds(201, 510, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		lblImagem.setBounds(10, 26, 180, 154);
		contentPane.add(lblImagem);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Marca:");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(212, 103, 180, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		marcainterface = new JTextField();
		marcainterface.setColumns(10);
		marcainterface.setBounds(212, 116, 424, 20);
		contentPane.add(marcainterface);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Garantia:");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setBounds(212, 147, 180, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Valor:");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setBounds(10, 291, 92, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("R$");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setBounds(10, 309, 33, 14);
		contentPane.add(lblNewLabel_3_3);
		
		valor = new JTextField();
		valor.setColumns(10);
		valor.setBounds(31, 306, 97, 20);
		contentPane.add(valor);
		
		JLabel lblNewLabel_3_4 = new JLabel("Descri\u00E7\u00E3o da Imagem");
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setBounds(10, 191, 190, 14);
		contentPane.add(lblNewLabel_3_4);
		
		descricaodaimagem = new JTextField();
		descricaodaimagem.setColumns(10);
		descricaodaimagem.setBounds(10, 205, 424, 20);
		contentPane.add(descricaodaimagem);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setDisplayedMnemonic(KeyEvent.VK_COPY);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\CJL\\ProjetoArmazenamento\\imagens\\fundo-isa.jpg"));
		lblNewLabel.setBounds(0, 0, 1368, 668);
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
	

	 
	 public void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
	        // TODO add your handling code here:
	        JFileChooser fc = new JFileChooser();
	        int res = fc.showOpenDialog(null);

	        if (res == JFileChooser.APPROVE_OPTION) {
	            File arquivo = fc.getSelectedFile();

	            try {
	                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 200, 200);

	                lblImagem.setIcon(new ImageIcon(imagem));

	            } catch (Exception ex) {
	               // System.out.println(ex.printStackTrace().toString());
	            }

	        } else {
	            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
	        }
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
	             Logger.getLogger(Inicial_gerencia.class.getName()).log(Level.SEVERE, null, ex);
	         }
	    }
}
