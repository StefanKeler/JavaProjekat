package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.List;
import net.miginfocom.swing.MigLayout;

public class Sortiranje extends JFrame {

	private JPanel pnlGlavni;

	/**
	 * Launch the application.
	 */

	ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();
	ArrayList<Kvadrat> listaSortirana = new ArrayList<Kvadrat>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortiranje frame = new Sortiranje();
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
	public Sortiranje() {
		setTitle("Crtanje, Keler Stefan IT 27-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 643);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlGlavni);
		pnlGlavni.setLayout(new BorderLayout(0, 0));

		JLabel lblAplikacijaZaManipulaciju = new JLabel("Aplikacija za manipulaciju liste sa kvadratima");
		lblAplikacijaZaManipulaciju.setVerticalAlignment(SwingConstants.TOP);
		lblAplikacijaZaManipulaciju.setHorizontalAlignment(SwingConstants.CENTER);
		pnlGlavni.add(lblAplikacijaZaManipulaciju, BorderLayout.NORTH);

		JPanel pnlSredina = new JPanel();
		pnlGlavni.add(pnlSredina, BorderLayout.CENTER);
		pnlSredina.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnlElementi = new JPanel();
		pnlSredina.add(pnlElementi);
		pnlElementi.setLayout(new MigLayout("", "[500.00px][500.00px]", "[][450.00px][]"));

		List listLista = new List();
		pnlElementi.add(listLista, "cell 0 1,grow");

		List listSortiranaLista = new List();
		pnlElementi.add(listSortiranaLista, "cell 1 1,grow");

		JLabel lblLista = new JLabel("Lista");
		pnlElementi.add(lblLista, "cell 0 2,alignx center");

		JLabel lblSortiranaLista = new JLabel("Sortirana lista");
		pnlElementi.add(lblSortiranaLista, "cell 1 2,alignx center");

		JButton btnDodajElementU = new JButton("Dodaj element u listu");
		pnlElementi.add(btnDodajElementU, "cell 0 0 2 1,growx");
		btnDodajElementU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogZaUnos d = new DijalogZaUnos();
				d.setVisible(true);
				String inp = d.getText();
			
				
				if(d.pritisnutoOk == false){
					System.out.println("retun");
					return;
				}else{

					String nizReci[] = inp.split(", ");
					Kvadrat kv = new Kvadrat(new Tacka(Integer.parseInt(nizReci[0]), Integer.parseInt(nizReci[1])), Integer.parseInt(nizReci[2]), nizReci[3],nizReci[4]);
					lista.add(kv);
					listaSortirana.add(kv);


					listLista.removeAll();
					listSortiranaLista.removeAll();
					listaSortirana.sort(null);
				}

				for (Kvadrat k : lista) {
					listLista.add(k.opis());
				}

				for (Kvadrat k : listaSortirana) {
					listSortiranaLista.add(k.opis());
				}

			}
		});


	}

}
