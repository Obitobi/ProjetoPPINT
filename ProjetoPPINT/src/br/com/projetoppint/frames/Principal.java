/**
 * 
 */
package br.com.projetoppint.frames;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public class Principal {

	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu[] menus;
	private JMenuItem[] idiomas, pedidos;

	public void init(ResourceBundle resourceBundle) {
		frame = new JFrame(resourceBundle.getString("tela1.titulo"));
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		menus = new JMenu[3];
		for (int i = 0; i < menus.length; i++) {
			menus[i] = new JMenu();
			menuBar.add(menus[i]);
		}
		menus[0].setText(resourceBundle.getString("tela1.idioma"));
		menus[1].setText(resourceBundle.getString("tela1.pedido"));
		menus[2].setText(resourceBundle.getString("tela1.sair"));
		idiomas = new JMenuItem[3];
		for (int i = 0; i < idiomas.length; i++) {
			idiomas[i] = new JMenuItem();
			menus[0].add(idiomas[i]);
		}
		idiomas[0].setText(resourceBundle.getString("tela1.idioma.portugues"));
		idiomas[1].setText(resourceBundle.getString("tela1.idioma.ingles"));
		idiomas[2].setText(resourceBundle.getString("tela1.idioma.espanhol"));
		pedidos = new JMenuItem[2];
		for (int i = 0; i < pedidos.length; i++) {
			pedidos[i] = new JMenuItem();
			menus[1].add(pedidos[i]);
		}
		pedidos[0].setText(resourceBundle.getString("tela1.pedido.novopedido"));
		pedidos[1].setText(resourceBundle.getString("tela1.pedido.consultarpedido"));
		
		menus[2].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		panel.add(menuBar, BorderLayout.NORTH);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.init(ResourceBundle.getBundle("ex1", new Locale("pt", "BR")));
	}

}
