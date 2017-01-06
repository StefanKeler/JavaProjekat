package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Tacka;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class Stek extends JFrame {

	private JPanel pnlGlavni;
	
	private Stack<Kvadrat> stek = new Stack<Kvadrat>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stek frame = new Stek();
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
	public Stek() {
		setTitle("Stek, Keler Stefan IT 27-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		
		JPanel pnlKomande = new JPanel();
		pnlGlavni.add(pnlKomande, BorderLayout.CENTER);
		pnlKomande.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnDodajNaStek = new JButton("Dodaj na stek");
		btnDodajNaStek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inp = JOptionPane.showInputDialog("Unesi kvadrat u formatu: X, Y koordinate tacke gore levo, duzina stranice, boja ivice, boja unutrasnjosti");
				boolean p = true;
				while(p){
					try {
						String nizReci[] = inp.split(",");
						Kvadrat kv = new Kvadrat(new Tacka(Integer.parseInt(nizReci[0]), Integer.parseInt(nizReci[1])), Integer.parseInt(nizReci[2]), nizReci[3],nizReci[4]);
						stek.push(kv);
						p = false;
					} catch (Exception ex) {
						//System.out.println(ex.getMessage());
						if(ex.getMessage() == null)
							return;
						inp = JOptionPane.showInputDialog("Greska, unos mora biti u formi: x, y, duzina stranice, boja ivice, boja unutrasnjosti");
					}
				}
			}
		});
		pnlKomande.add(btnDodajNaStek);
		
		JButton btnIzbaciSaSteka = new JButton("Izbaci sa steka");
		btnIzbaciSaSteka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Kvadrat kv = stek.pop();
					JOptionPane.showMessageDialog(null, kv.opis(), "Sa steka se izbacuje", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Stek je prazan!", "Greska!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		pnlKomande.add(btnIzbaciSaSteka);
		
		JLabel lblOpis = new JLabel("Aplikacija za manipulaciju seta sa kvadratima");
		lblOpis.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpis.setVerticalAlignment(SwingConstants.TOP);
		pnlGlavni.add(lblOpis, BorderLayout.NORTH);
	}

}
