package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Oblik;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Stek extends JFrame {

	private JPanel pnlGlavni;
	private Stack<Kvadrat> stek = new Stack<Kvadrat>();
	List listKvadrata;
	Object uzeoFokus = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stek frame = new Stek();
					frame.setVisible(true);
					System.out.println("p");
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
		setBounds(100, 100, 593, 391);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);

		JPanel pnlKomande = new JPanel();
		pnlGlavni.add(pnlKomande, BorderLayout.CENTER);
		GridBagLayout gbl_pnlKomande = new GridBagLayout();
		gbl_pnlKomande.columnWidths = new int[]{108, 103, 103, 0};
		gbl_pnlKomande.rowHeights = new int[]{23, 0, 0, 0, 0};
		gbl_pnlKomande.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlKomande.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlKomande.setLayout(gbl_pnlKomande);

		JButton btnIzbaciSaSteka = new JButton("Izbaci sa steka");
		btnIzbaciSaSteka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Kvadrat kv = stek.pop();
					listKvadrata.remove(kv.opis());
					JOptionPane.showMessageDialog(null, kv.opis(), "Sa steka se izbacuje", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Stek je prazan!", "Greska!", JOptionPane.ERROR_MESSAGE);
				}

			}
		});



		JButton btnDodajNaStek = new JButton("Dodaj na stek");
		btnDodajNaStek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				DijalogZaUnos d = new DijalogZaUnos();
				d.setVisible(true);
				String inp = d.getText();
			
				if(d.pritisnutoOk == false){
					System.out.println("retun");
					return;
				}else{
					System.out.println(inp);
					String nizReci[] = inp.split(", ");
					Kvadrat kv = new Kvadrat(new Tacka(Integer.parseInt(nizReci[0]), Integer.parseInt(nizReci[1])), Integer.parseInt(nizReci[2]), nizReci[3],nizReci[4]);
					stek.push(kv);
					listKvadrata.add(kv.opis());


					
				}

				
				
			
			}
		});
		GridBagConstraints gbc_btnDodajNaStek = new GridBagConstraints();
		gbc_btnDodajNaStek.fill = GridBagConstraints.BOTH;
		gbc_btnDodajNaStek.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajNaStek.gridx = 0;
		gbc_btnDodajNaStek.gridy = 0;
		pnlKomande.add(btnDodajNaStek, gbc_btnDodajNaStek);
		GridBagConstraints gbc_btnIzbaciSaSteka = new GridBagConstraints();
		gbc_btnIzbaciSaSteka.fill = GridBagConstraints.BOTH;
		gbc_btnIzbaciSaSteka.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzbaciSaSteka.gridx = 2;
		gbc_btnIzbaciSaSteka.gridy = 0;
		pnlKomande.add(btnIzbaciSaSteka, gbc_btnIzbaciSaSteka);

		listKvadrata = new List();




		GridBagConstraints gbc_listKvadrata = new GridBagConstraints();
		gbc_listKvadrata.gridwidth = 3;
		gbc_listKvadrata.gridheight = 3;
		gbc_listKvadrata.fill = GridBagConstraints.BOTH;
		gbc_listKvadrata.insets = new Insets(0, 0, 0, 5);
		gbc_listKvadrata.gridx = 0;
		gbc_listKvadrata.gridy = 1;
		pnlKomande.add(listKvadrata, gbc_listKvadrata);

		JLabel lblOpis = new JLabel("Aplikacija za manipulaciju seta sa kvadratima");
		lblOpis.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpis.setVerticalAlignment(SwingConstants.TOP);
		pnlGlavni.add(lblOpis, BorderLayout.NORTH);
	}

}
