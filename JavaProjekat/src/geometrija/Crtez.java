package geometrija;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Crtez extends JPanel{
	int x;
	int y;
	public Crtez() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}
	
	public static void main(String[] args){
		JFrame prozor = new JFrame("Crtanje");
		prozor.setSize(800, 600);
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		Tacka t1 = new Tacka(x,y);
		t1.crtajSe(g);
		repaint();
		/*t1.setSelektovan(true);
		t1.crtajSe(g);
		t1.setBoja("crvena");
		t1.crtajSe(g);
		Linija l1 = new Linija(new Tacka(20, 20), new Tacka(100,30));
		l1.setSelektovan(true);
		l1.crtajSe(g);
		l1.gettPocetna().setBoja("plava");
		l1.gettKrajnja().setBoja("zelena");
		l1.setBoja("crvena");
		//l1.gettPocetna().crtajSe(g);
		//l1.gettKrajnja().crtajSe(g);
		l1.crtajSe(g);
		l1.sredinaLinije().setBoja("zuta");
		Tacka sredinaLinija = l1.sredinaLinije();
		sredinaLinija.setBoja("zuta");
		//sredinaLinija.crtajSe(g);
		Kvadrat kv1 = new Kvadrat(new Tacka(150,30), 100, "CrVenA");
		Pravougaonik p1 = new Pravougaonik(new Tacka(300, 30), 100, 50, "Zelena");
		Krug k1 = new Krug(new Tacka(500, 150), 100, "zuta");
		kv1.setSelektovan(true);
		kv1.crtajSe(g);
		p1.setSelektovan(true);
		p1.crtajSe(g);
		k1.setSelektovan(true);
		k1.crtajSe(g);
		k1.setBojaUnutrasnjosti("zuta");
		//k1.popuni(g);
		//kv1.popuni(g);
		//p1.popuni(g);
*/		
	}
}
