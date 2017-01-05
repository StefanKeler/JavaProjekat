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



public class Crtanje extends JFrame {

	private JPanel pnlGlavni;
	
	private String odabran;
	private JButton btnOdabranDugmic;
	private Oblik odabranOblik = null;
	private int iteracija = 0;
	
	private JLabel lblKoordinate;
	private JLabel lblPlatno;
	private JPanel pnlCtrez;
	
	private JButton btnModifikuj, btnSelektuj, btnObrisi;
	
	private Oblik selektovan =  null;
	
	private Stack<Oblik> stakOblika = new Stack<Oblik>();
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
				odabiriDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnTacka, "cell 0 1,grow");
		
		JButton btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				odabiriDugme((JButton)arg0.getSource());
			}
		});
		pnlOblici.add(btnPravougaonik, "cell 1 1");
		
		JButton btnLinija = new JButton("Linija");
	
		btnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabiriDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnLinija, "cell 0 2,grow");
		
		JButton btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabiriDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnKvadrat, "cell 1 2,grow");
		
		JButton btnKrug = new JButton("Krug");
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabiriDugme((JButton)e.getSource());
			}
		});
		pnlOblici.add(btnKrug, "cell 0 3 2 1,growx");
		
		JPanel panel = new JPanel();
		pnlPalete.add(panel);
		panel.setLayout(new MigLayout("", "[][]", "[][66.00][]"));
		
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
		panel.add(lblUnutra, "cell 1 2,growx,aligny center");
		
		JPanel pnlKomande = new JPanel();
		pnlPalete.add(pnlKomande);
		pnlKomande.setLayout(new MigLayout("", "[][][]", "[][]"));
		
		JLabel lblKomande = new JLabel("Komande");
		pnlKomande.add(lblKomande, "cell 0 0 3 1,alignx center,aligny center");
		
		btnSelektuj = new JButton("Selektuj");
		btnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabiriDugme((JButton)e.getSource());
			}
		});
		pnlKomande.add(btnSelektuj, "cell 0 1");
		
		btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.setEnabled(false);
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/* Pomeri za
				String inp = JOptionPane.showInputDialog("x:y");
				
				Pomerljiv sel = (Pomerljiv)selektovan;
				
				
				boolean p = true;
				while(p){
					try {
						String niz[] = inp.split(":");
						int x = Integer.parseInt(niz[0]);
						int y = Integer.parseInt(niz[1]);
						sel.pomeriZa(x, y);
						osveziCrtez();
						p = false;
					} catch (Exception ex) {
						//System.out.println(ex.getMessage());
						if(ex.getMessage() == null){
							System.out.println("tuj sam");
							return;
						}
						
						inp = JOptionPane.showInputDialog("pogresan unos! unesi u obliku x:y");
					}
				}*/
				
				
				
							
			}
		});
		pnlKomande.add(btnModifikuj, "cell 1 1");
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(selektovan.equals(stakOblika.get(0)));
				
				System.out.println("brisem: " + selektovan);
				stakOblika.removeElement(selektovan);
				selektovan = null;
				osveziCrtez();
				
				
				btnModifikuj.setEnabled(false);
				btnObrisi.setEnabled(false);
				
				System.out.println(stakOblika);
				/* pomeri na 
				String inp = JOptionPane.showInputDialog("x:y");
				
				Pomerljiv sel = (Pomerljiv)selektovan;
				boolean p = true;
				while(p){
					try {
						String niz[] = inp.split(":");
						int x = Integer.parseInt(niz[0]);
						int y = Integer.parseInt(niz[1]);
						sel.pomeriNa(x, y);
						osveziCrtez();
						p = false;
					} catch (Exception ex) {
						//System.out.println(ex.getMessage());
						if(ex.getMessage() == null){
							System.out.println("tuj sam");
							return;
						}
						
						inp = JOptionPane.showInputDialog("pogresan unos! unesi u obliku x:y");
					}
				}
				*/
				
				
			}
		});
		pnlKomande.add(btnObrisi, "cell 2 1");
		
		JPanel panel_1 = new JPanel();
		pnlPalete.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][]", "[][][]"));
		
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
					
					//pnlCtrez.revalidate();
					//pnlCtrez.repaint();
					
					
					/*Tacka t = new Tacka(20,20);
					t.crtajSe(pnlCtrez.getGraphics());
					t.pomeriNa(30, 30);
					t.crtajSe(pnlCtrez.getGraphics());*/
					
					if(selektovan != null){
						selektovan = null;
						osveziCrtez();
						btnModifikuj.setEnabled(false);
						btnObrisi.setEnabled(false);
					}
					
				
					
					for(int i = stakOblika.size()-1; i>= 0; i--){
						if(stakOblika.get(i).sadrzi(e.getX(), e.getY())){
						
							
							osveziCrtez();
							
							selektovan = stakOblika.get(i);		
							selektovan.selektovan(pnlCtrez.getGraphics());
							btnModifikuj.setEnabled(true);
							btnObrisi.setEnabled(true);
							
							
							
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
	
	private void odabiriDugme(JButton dugme){
		
		selektovan = null;
		osveziCrtez();
		btnModifikuj.setEnabled(false);
		btnObrisi.setEnabled(false);
		
		
		
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
	
	
	
	private void odabirBoje(JButton btn){
		JColorChooser jcc = new JColorChooser();
		Color c = jcc.showDialog(null, "Izaberite boju", Color.BLACK);
		//System.out.println(c);
		if(c!=null)
		btn.setBackground(c);
	}
	
	
	

	
}
