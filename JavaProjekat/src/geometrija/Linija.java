package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik implements Pomerljiv{
	private Tacka tPocetna;
	private Tacka tKrajnja;

	public Linija(){

	}
	public Linija(Tacka tPocetna, Tacka tKrajnja){
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
	}

	public Linija(Tacka tPocetna, Tacka tKrajnja, Color boja){
		this(tPocetna, tKrajnja);
		setBoja(boja);
	}

	public Tacka sredinaLinije(){
		int sredinaX = (tPocetna.getX() + tKrajnja.getX()) / 2;
		int sredinaY = (tPocetna.getY() + tKrajnja.getY()) / 2;
		return new Tacka(sredinaX, sredinaY);
	}

	public String toString(){
		return "("+tPocetna.getX()+"," +tPocetna.getY()+") --> (" + tKrajnja.getX()+","+ tKrajnja.getY() + ")";
	}

	public boolean equals(Object obj){
		if(obj instanceof Linija){
			Linija pomocna=(Linija) obj;
			if(this.tPocetna.equals(pomocna.tPocetna) && this.equals(pomocna.tKrajnja))
				return true;
			else
				return false;
		}
		else 
			return false;
	}


	public double duzina(){
		return tPocetna.udaljenost(tKrajnja);
	}

	public void pomeriZa(int x, int y){
		tPocetna.setX(tPocetna.getX()+x);
		tPocetna.setY(tPocetna.getY()+y);
		tKrajnja.setX(tKrajnja.getX()+x);
		tKrajnja.setY(tKrajnja.getY()+y);

	}
	
	public void pomeriNa(int x, int y) {
		int rx = tPocetna.getX() - tKrajnja.getX();
		int ry = tPocetna.getY() - tKrajnja.getY();
		tPocetna.setX(x);
		tPocetna.setY(y);
		tKrajnja.setX(x+rx);
		tKrajnja.setY(y+ry);
		
		
	}
	
	public boolean sadrzi(int x, int y){
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(tPocetna)+mestoKlika.udaljenost(tKrajnja)-this.duzina()<=0.5)
			return true;
		 else 
			return false;		
	}
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);
	}
	public void crtajSe(Graphics g){
		g.setColor(getBoja());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());
		if(isSelektovan())
			selektovan(g);
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Linija){
			Linija pomocna  = (Linija) o;
			//Linija drugaPomocna = new Linija(tPocetna, tKrajnja);
			return (int) (this.duzina()-pomocna.duzina());

		}
		else
			return 0;
	}
	public Tacka gettPocetna(){
		return tPocetna;
	}
	public Tacka gettKrajnja(){
		return tKrajnja;
	}
	public void settPocetna(Tacka tPocetna){
		this.tPocetna = tPocetna;
	}
	public void settKrajnja(Tacka tKrajnja){
		this.tKrajnja = tKrajnja;
	}

	

}
