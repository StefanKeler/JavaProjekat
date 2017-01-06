package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Oblik;
import geometrija.Pomerljiv;
import geometrija.PovrsinskiOblik;
import geometrija.Pravougaonik;
import geometrija.Tacka;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.Stack;
import java.beans.PropertyChangeEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.FlowLayout;
import java.awt.Canvas;
import javax.swing.JTextField;



public class Crtanje extends JFrame {

	private JPanel pnlGlavni;
	private JPanel pnlModifikuj;

	private String odabran;
	private JButton btnOdabranDugmic;
	private Oblik odabranOblik = null;
	private int iteracija = 0;

	private JLabel lblKoordinate;
	private JLabel lblPlatno;
	private JPanel pnlCtrez;

	private JButton btnSelektuj, btnObrisi;

	private Oblik selektovan =  null;

	private Stack<Oblik> stakOblika = new Stack<Oblik>();

	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfAtr1;
	private JTextField tfAtr2;
	private JLabel lblAtrNaslov;
	private JLabel lblAtr1;
	private JLabel lblAtr2;
	private JLabel lblUnutrasnjosti;
	private JButton btnUnutrasnjosti;
	private JButton btnKonture;
	private JLabel lblPoruka;
	private JLabel lblTacka;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje frame = new Crtanje();
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





	public Crtanje() {
		setTitle("Crtanje, Keler Stefan IT 27-2015");



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);

		JPanel pnlPalete = new JPanel();
		pnlGlavni.add(pnlPalete, BorderLayout.NORTH);

		JPanel pnlOblici = new JPanel();
		pnlPalete.add(pnlOblici);
		pnlOblici.setLayout(new MigLayout("", "[][71px]", "[][23px][23px][23px]"));

		JLabel label = new JLabel("Oblici");
		pnlOblici.add(label, "cell 0 0 2 1,alignx center");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		//Dugmici za oblike

		JButton btnTacka = new JButton("Tacka");

		btnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odaberiDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnTacka, "cell 0 1,grow");

		JButton btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				odaberiDugme((JButton)arg0.getSource());
			}
		});
		pnlOblici.add(btnPravougaonik, "cell 1 1");

		JButton btnLinija = new JButton("Linija");

		btnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odaberiDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnLinija, "cell 0 2,grow");

		JButton btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odaberiDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnKvadrat, "cell 1 2,grow");

		JButton btnKrug = new JButton("Krug");
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odaberiDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnKrug, "cell 0 3 2 1,growx");

		JPanel panel = new JPanel();
		pnlPalete.add(panel);
		panel.setLayout(new MigLayout("", "[71.00][70.00]", "[][66.00][]"));

		JLabel lblBoje = new JLabel("Boje");
		lblBoje.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBoje, "cell 0 0 2 1,alignx center");

		JButton btnBojaKonture = new JButton("");
		btnBojaKonture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabirBoje((JButton)e.getSource());
			}
		});
		btnBojaKonture.setBackground(Color.BLACK);
		panel.add(btnBojaKonture, "cell 0 1,grow");

		JButton btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabirBoje((JButton)e.getSource());
			}
		});
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		panel.add(btnBojaUnutrasnjosti, "cell 1 1,grow");

		JLabel lblKontura = new JLabel("    Kontura    ");
		panel.add(lblKontura, "cell 0 2,alignx center,growy");

		JLabel lblUnutra = new JLabel("Unutra\u0161njost");
		panel.add(lblUnutra, "cell 1 2,alignx center,aligny center");

		JPanel pnlKomande = new JPanel();
		pnlPalete.add(pnlKomande);
		pnlKomande.setLayout(new MigLayout("", "[]", "[][40.00][40.00]"));

		JLabel lblKomande = new JLabel("Komande");
		pnlKomande.add(lblKomande, "cell 0 0,alignx center,aligny center");

		btnSelektuj = new JButton("Selektuj");
		btnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odaberiDugme((JButton)e.getSource());
			}
		});
		pnlKomande.add(btnSelektuj, "cell 0 1,grow");

		btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//System.out.println(selektovan.equals(stakOblika.get(0)));

				System.out.println("brisem: " + selektovan);
				stakOblika.removeElement(selektovan);
				selektovan = null;
				osveziCrtez();


				osveziUIKomande(false);

				System.out.println(stakOblika);


			}
		});
		pnlKomande.add(btnObrisi, "cell 0 2,grow");

		pnlModifikuj = new JPanel();
		pnlPalete.add(pnlModifikuj);
		pnlModifikuj.setLayout(new MigLayout("", "[][35.00][][35.00,grow][][35.00,grow]", "[][][][][]"));

		JLabel lblModifikuj = new JLabel("Modifikuj");
		pnlModifikuj.add(lblModifikuj, "cell 0 0 6 1,alignx center");

		JLabel lblBoja = new JLabel("Boja");
		pnlModifikuj.add(lblBoja, "cell 0 1 2 1,alignx center");

		lblTacka = new JLabel("Tacka");
		pnlModifikuj.add(lblTacka, "cell 2 1 2 1,alignx center");

		lblAtrNaslov = new JLabel("atr");
		pnlModifikuj.add(lblAtrNaslov, "cell 4 1 2 1,alignx center");

		JLabel lblKonture = new JLabel("konture:");
		pnlModifikuj.add(lblKonture, "cell 0 2,alignx right");

		btnKonture = new JButton("");
		btnKonture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabirBoje((JButton)e.getSource());
				selektovan.setBoja(btnKonture.getBackground());
				osveziCrtez();

			}
		});
		pnlModifikuj.add(btnKonture, "cell 1 2,grow");

		JLabel lblX = new JLabel(" x:");
		pnlModifikuj.add(lblX, "cell 2 2,alignx right");

		tfX = new JTextField();
		tfX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				try {
					
					//int br = Integer.parseInt(tfX.getText());
					//proveriBroj(br);
					
					if(selektovan instanceof Tacka){

						x = ((Tacka) selektovan).getX();
						((Tacka) selektovan).setX(Integer.parseInt(tfX.getText()));
			
					}else if(selektovan instanceof Linija){
						
						x = ((Linija) selektovan).gettPocetna().getX();
						((Linija) selektovan).gettPocetna().setX(Integer.parseInt(tfX.getText()));
						
					}else if(selektovan instanceof Kvadrat){
						
						x = ((Kvadrat) selektovan).getGoreLevo().getX();
						((Kvadrat) selektovan).getGoreLevo().setX(Integer.parseInt(tfX.getText()));
						
					}else if(selektovan instanceof Pravougaonik){
						
						x = ((Kvadrat) selektovan).getGoreLevo().getX();
						((Kvadrat) selektovan).getGoreLevo().setX(Integer.parseInt(tfX.getText()));
						
					}else if(selektovan instanceof Krug){
						
						x = ((Krug) selektovan).getCentar().getX();
						((Krug) selektovan).getCentar().setX(Integer.parseInt(tfX.getText()));
						
					}
				}catch(NumberFormatException nfe){
					tfX.setText("" + x);
					JOptionPane.showMessageDialog(null, "Unos mora biti ceo broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}catch ( Exception e1) {
					tfX.setText("" + x);
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}

				osveziCrtez();
				
			}
		});
		pnlModifikuj.add(tfX, "cell 3 2,growx");
		tfX.setColumns(10);

		lblAtr1 = new JLabel(" atr1:");
		pnlModifikuj.add(lblAtr1, "cell 4 2,alignx right");

		tfAtr1 = new JTextField();
		tfAtr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x = 0;
				try {
					if(selektovan instanceof Linija){
						
						x = ((Linija) selektovan).gettKrajnja().getX();
						((Linija) selektovan).gettKrajnja().setX(Integer.parseInt(tfAtr1.getText()));
						
					}else if(selektovan instanceof Pravougaonik){
						
						x = ((Pravougaonik) selektovan).getSirina();
						((Pravougaonik) selektovan).setSirina(Integer.parseInt(tfAtr1.getText()));
						
					}
					else if(selektovan instanceof Kvadrat){
						
						x = ((Kvadrat) selektovan).getDuzinaStranice();
						((Kvadrat) selektovan).setDuzinaStranice(Integer.parseInt(tfAtr1.getText()));
						
					}else if(selektovan instanceof Krug){
						
						x = ((Krug) selektovan).getR();
						((Krug) selektovan).setR(Integer.parseInt(tfAtr1.getText()));
						
					}
				}catch(NumberFormatException nfe){
					tfAtr1.setText("" + x);
					JOptionPane.showMessageDialog(null, "Unos mora biti ceo broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}catch ( Exception e1) {
					tfAtr1.setText("" + x);
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}

				osveziCrtez();
				
			}
		});
		pnlModifikuj.add(tfAtr1, "cell 5 2,growx");
		tfAtr1.setColumns(10);

		lblUnutrasnjosti = new JLabel("unutrasnjosti:");
		pnlModifikuj.add(lblUnutrasnjosti, "cell 0 3,alignx right");

		btnUnutrasnjosti = new JButton("");
		btnUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabirBoje((JButton)e.getSource());
				((PovrsinskiOblik) selektovan).setBojaUnutrasnjosti(btnUnutrasnjosti.getBackground());
				osveziCrtez();
			}
		});
		pnlModifikuj.add(btnUnutrasnjosti, "cell 1 3,grow");

		JLabel lblY = new JLabel("  y:");
		pnlModifikuj.add(lblY, "cell 2 3,alignx right");

		tfY = new JTextField();
		tfY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = 0;
				try {
					if(selektovan instanceof Tacka){

						x = ((Tacka) selektovan).getY();
						((Tacka) selektovan).setY(Integer.parseInt(tfY.getText()));
			
					}else if(selektovan instanceof Linija){
						
						x = ((Linija) selektovan).gettPocetna().getY();
						((Linija) selektovan).gettPocetna().setY(Integer.parseInt(tfY.getText()));
						
					}else if(selektovan instanceof Kvadrat){
						
						x = ((Kvadrat) selektovan).getGoreLevo().getY();
						((Kvadrat) selektovan).getGoreLevo().setY(Integer.parseInt(tfY.getText()));
						
					}else if(selektovan instanceof Pravougaonik){
						
						x = ((Kvadrat) selektovan).getGoreLevo().getY();
						((Kvadrat) selektovan).getGoreLevo().setY(Integer.parseInt(tfY.getText()));
						
					}else if(selektovan instanceof Krug){
						
						x = ((Krug) selektovan).getCentar().getY();
						((Krug) selektovan).getCentar().setY(Integer.parseInt(tfY.getText()));
						
					}
				}catch(NumberFormatException nfe){
					tfY.setText("" + x);
					JOptionPane.showMessageDialog(null, "Unos mora biti ceo broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}catch ( Exception e1) {
					tfY.setText("" + x);
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}

				osveziCrtez();
			}
		});
		pnlModifikuj.add(tfY, "cell 3 3,growx");
		tfY.setColumns(10);

		lblAtr2 = new JLabel(" atr2:");
		pnlModifikuj.add(lblAtr2, "cell 4 3,alignx right");

		tfAtr2 = new JTextField();
		tfAtr2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int x = 0;
				try {
					if(selektovan instanceof Linija){
						
						x = ((Linija) selektovan).gettKrajnja().getY();
						((Linija) selektovan).gettKrajnja().setY(Integer.parseInt(tfAtr2.getText()));
						
					}else if(selektovan instanceof Pravougaonik){
						
						x = ((Pravougaonik) selektovan).getVisina();
						((Pravougaonik) selektovan).setVisina(Integer.parseInt(tfAtr2.getText()));
						
					}
					
				}catch(NumberFormatException nfe){
					tfAtr2.setText("" + x);
					JOptionPane.showMessageDialog(null, "Unos mora biti ceo broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}catch ( Exception e1) {
					tfAtr2.setText("" + x);
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Pogresan unos", JOptionPane.ERROR_MESSAGE);
				}

				osveziCrtez();
				
				
			}
		});
		pnlModifikuj.add(tfAtr2, "cell 5 3,growx");
		tfAtr2.setColumns(10);

		lblPoruka = new JLabel("posle unosa pritisnite enter za prikaz izmena");
		pnlModifikuj.add(lblPoruka, "cell 0 4 6 1,alignx center");

		pnlModifikuj.setVisible(false);

		pnlCtrez = new JPanel();
		pnlCtrez.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				lblPlatno.setText("platno: " + pnlCtrez.getWidth() + ":" + pnlCtrez.getHeight());
				osveziCrtez();

			}
		});



		pnlCtrez.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblKoordinate.setText("koor: " + e.getX() + ":" + e.getY());
			}
		});
		pnlCtrez.setBackground(Color.WHITE);




		pnlCtrez.addMouseListener(new MouseAdapter() {




			public void mouseClicked(MouseEvent e) {




				if(btnOdabranDugmic == btnTacka){
					odabranOblik = new Tacka(e.getX(),e.getY(),btnBojaKonture.getBackground());					
					odabranOblik.crtajSe(pnlCtrez.getGraphics());

				}else if (btnOdabranDugmic == btnLinija){

					if(iteracija == 0){
						odabranOblik = new Linija(new Tacka(e.getX(),e.getY()),new Tacka(0,0),btnBojaKonture.getBackground());
						iteracija++;
						return;
					}else{
						Linija l = (Linija) odabranOblik;
						l.settKrajnja(new Tacka(e.getX(),e.getY()));
						l.crtajSe(pnlCtrez.getGraphics());
						iteracija = 0;
					}
				}else if (btnOdabranDugmic == btnKvadrat) {
					//JOptionPane.showMessageDialog(null, "Kliknuto je na dugme!", "Poruka", JOptionPane.ERROR_MESSAGE);
					String inp = JOptionPane.showInputDialog("Unesi stranicu");
					boolean p = true;
					while(p){
						try {
							int stranica = Integer.parseInt(inp);
							odabranOblik = new Kvadrat(new Tacka(e.getX(),e.getY()), stranica,btnBojaKonture.getBackground(),btnBojaUnutrasnjosti.getBackground());
							Kvadrat kv = (Kvadrat) odabranOblik;
							kv.crtajSe(pnlCtrez.getGraphics());
							p = false;
						} catch (Exception ex) {
							//System.out.println(ex.getMessage());
							if(ex.getMessage() == "null")
								return;
							inp = JOptionPane.showInputDialog("Unos mora biti ceo broj, unesi stranicu:");
						}
					}


				}else if (btnOdabranDugmic == btnPravougaonik) {
					//JOptionPane.showMessageDialog(null, "Kliknuto je na dugme!", "Poruka", JOptionPane.ERROR_MESSAGE);
					String inpSirina = JOptionPane.showInputDialog("Unesi sirinu");
					int sirina = 0;
					boolean p = true;
					while(p){
						try {
							sirina = Integer.parseInt(inpSirina);
							p = false;
						} catch (Exception ex) {
							if(ex.getMessage() == "null")
								return;
							inpSirina = JOptionPane.showInputDialog("Unos mora biti ceo broj, unesi sirinu:");
						}
					}


					String inpVisina = JOptionPane.showInputDialog("Unesi visinu");
					int visina;
					p = true;
					while(p){
						try {
							visina = Integer.parseInt(inpVisina);
							odabranOblik = new Pravougaonik(new Tacka(e.getX(),e.getY()), sirina, visina,btnBojaKonture.getBackground(),btnBojaUnutrasnjosti.getBackground());
							Pravougaonik pr = (Pravougaonik) odabranOblik;
							pr.crtajSe(pnlCtrez.getGraphics());
							p = false;
						} catch (Exception ex) {
							if(ex.getMessage() == "null")
								return;
							inpSirina = JOptionPane.showInputDialog("Unos mora biti ceo broj, unesi stranicu:");
						}
					}


				}else if (btnOdabranDugmic == btnKrug) {
					//JOptionPane.showMessageDialog(null, "Kliknuto je na dugme!", "Poruka", JOptionPane.ERROR_MESSAGE);
					String inp = JOptionPane.showInputDialog("Unesi poluprecnik");
					boolean p = true;
					while(p){
						try {
							int r = Integer.parseInt(inp);
							odabranOblik = new Krug(new Tacka(e.getX(),e.getY()), r,btnBojaKonture.getBackground(), btnBojaUnutrasnjosti.getBackground());
							Krug k = (Krug) odabranOblik;
							k.crtajSe(pnlCtrez.getGraphics());
							p = false;
						} catch (Exception ex) {
							//System.out.println(ex.getMessage());
							if(ex.getMessage() == "null")
								return;
							inp = JOptionPane.showInputDialog("Unos mora biti ceo broj, unesi poluprecnik:");
						}
					}


				}else if (btnOdabranDugmic == btnSelektuj){

					if(selektovan != null){
						selektovan = null;
						osveziCrtez();

						osveziUIKomande(false);
					}



					for(int i = stakOblika.size()-1; i>= 0; i--){
						if(stakOblika.get(i).sadrzi(e.getX(), e.getY())){


							osveziCrtez();

							selektovan = stakOblika.get(i);		
							selektovan.selektovan(pnlCtrez.getGraphics());

							osveziUIKomande(true);		

							return;
						}
					}
				}else{
					selektovan = null;

					osveziCrtez();
				}

				if(odabranOblik != null)
					stakOblika.add(odabranOblik);

				//System.out.println(stakOblika);
				System.out.println("\n Oblici u staku:");
				for(int i = stakOblika.size()-1; i>= 0; i--)
					System.out.println(stakOblika.get(i));


			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("presovano");




			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblKoordinate.setText("koor: ");
			}
		});
		pnlGlavni.add(pnlCtrez, BorderLayout.CENTER);

		JPanel pnlStanje = new JPanel();
		pnlGlavni.add(pnlStanje, BorderLayout.SOUTH);
		pnlStanje.setLayout(new GridLayout(0, 2, 0, 0));

		lblKoordinate = new JLabel("koor:");
		pnlStanje.add(lblKoordinate);

		lblPlatno = new JLabel("platno: ");
		pnlStanje.add(lblPlatno);




	}

	public void osveziCrtez(){
		Pravougaonik p = new Pravougaonik(new Tacka(0,0), pnlCtrez.getWidth(), pnlCtrez.getHeight(), Color.WHITE,Color.WHITE);
		p.crtajSe(pnlCtrez.getGraphics());

		for(Oblik o : stakOblika){
			o.crtajSe(pnlCtrez.getGraphics());
		}
		if(selektovan!= null)
			selektovan.selektovan(pnlCtrez.getGraphics());
	}

	private void odaberiDugme(JButton dugme){

		if(selektovan != null){
			selektovan = null;
			osveziCrtez();
		}


		osveziUIKomande(false);

		iteracija = 0;
		odabranOblik = null;
		if(btnOdabranDugmic == dugme){
			btnOdabranDugmic.setForeground(Color.BLACK);
			btnOdabranDugmic = null;	

		}else{
			if(btnOdabranDugmic != null){
				btnOdabranDugmic.setForeground(Color.BLACK);
			}

			btnOdabranDugmic = dugme;
			btnOdabranDugmic.setForeground(Color.RED);

		}
	}


	private void osveziUIKomande(Boolean b){
		
		btnObrisi.setEnabled(b);
		pnlModifikuj.setVisible(b);



		lblUnutrasnjosti.setVisible(true);
		btnUnutrasnjosti.setVisible(true);
		lblAtr1.setVisible(true);
		lblAtr2.setVisible(true);
		lblAtrNaslov.setVisible(true);
		tfAtr1.setVisible(true);
		tfAtr2.setVisible(true);


		if(b){

			btnKonture.setBackground(selektovan.getBoja());
			if(selektovan instanceof PovrsinskiOblik){
				btnUnutrasnjosti.setBackground(((PovrsinskiOblik) selektovan).getBojaUnutrasnjosti());
			}

			if(selektovan instanceof Tacka){

				lblUnutrasnjosti.setVisible(false);
				btnUnutrasnjosti.setVisible(false);
				lblAtr1.setVisible(false);
				lblAtr2.setVisible(false);
				lblAtrNaslov.setVisible(false);
				tfAtr1.setVisible(false);
				tfAtr2.setVisible(false);

				lblTacka.setText("Tacka");
				tfX.setText("" + ((Tacka) selektovan).getX());
				tfY.setText("" + ((Tacka) selektovan).getY());



			}else if(selektovan instanceof Linija){

				lblUnutrasnjosti.setVisible(false);
				btnUnutrasnjosti.setVisible(false);
				lblTacka.setText("tPocetna");
				lblAtrNaslov.setText("tKrajnja");
				lblAtr1.setText(" x:");
				lblAtr2.setText(" y:");
				tfX.setText("" + ((Linija) selektovan).gettPocetna().getX());
				tfY.setText("" + ((Linija) selektovan).gettPocetna().getY());

				tfAtr1.setText("" + ((Linija) selektovan).gettKrajnja().getX());
				tfAtr2.setText("" + ((Linija) selektovan).gettKrajnja().getY());

			}else if(selektovan instanceof Pravougaonik){

				lblTacka.setText("tGoreLevo");
				tfX.setText("" + ((Pravougaonik) selektovan).getGoreLevo().getX());
				tfY.setText("" + ((Pravougaonik) selektovan).getGoreLevo().getY());

				lblAtrNaslov.setText("Duzina");
				lblAtr1.setText(" Sirina:");
				tfAtr1.setText("" + ((Pravougaonik) selektovan).getSirina());

				lblAtr2.setText(" Visina:");
				tfAtr2.setText("" + ((Pravougaonik) selektovan).getDuzinaStranice());

			}else if(selektovan instanceof Kvadrat){

				lblAtr2.setVisible(false);
				tfAtr2.setVisible(false);

				lblTacka.setText("tGoreLevo");
				tfX.setText("" + ((Kvadrat) selektovan).getGoreLevo().getX());
				tfY.setText("" + ((Kvadrat) selektovan).getGoreLevo().getY());

				lblAtrNaslov.setText("Duzina");
				lblAtr1.setText(" Stranica:");
				tfAtr1.setText("" + ((Kvadrat) selektovan).getDuzinaStranice());

			}else if(selektovan instanceof Krug){

				lblAtr2.setVisible(false);
				tfAtr2.setVisible(false);

				lblTacka.setText("Centar");
				tfX.setText("" + ((Krug) selektovan).getCentar().getX());
				tfY.setText("" + ((Krug) selektovan).getCentar().getY());

				lblAtrNaslov.setText("Duzina");
				lblAtr1.setText(" R:");
				tfAtr1.setText("" + ((Krug) selektovan).getR());
			}
		}
	}

	private void odabirBoje(JButton btn){
		JColorChooser jcc = new JColorChooser();
		Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
		//System.out.println(c);
		if(c!=null)
			btn.setBackground(c);
	}
	
	




}
