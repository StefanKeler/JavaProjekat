package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv{
	private int x;
	private int y;


	public Tacka(){

	}
	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, Color boja){
		this(x, y);
		setBoja(boja);
	}	

	public String toString(){
		return "(" + x+ ","+ getY()+ ")";
	}

	public boolean equals(Object obj){
		if(obj instanceof Tacka){
			Tacka pomocna=(Tacka) obj;
			if(x==pomocna.getX() && y==pomocna.getY())
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public void pomeriNa(int novoX, int novoY){
		x = novoX;
		y = novoY;
	}

	public void pomeriZa(int novoX, int novoY){
		x = x + novoX;
		y = y + novoY;
	}

	public double udaljenost(Tacka t2){
		double dx = x - t2.x;
		double dy = y - t2.getY();
		double rezultat = Math.sqrt(dx*dx + dy*dy);

		return rezultat;
	}
	public boolean sadrzi(int x, int y){
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(this)<=2)
			return true;
		else
			return false;

	}
	public void selektovan(Graphics g){
		g.setColor(pronadjiBoju("plava"));
		g.drawRect(this.getX()-3, this.getY()-3, 6, 6);
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelektovan())
			selektovan(g);

	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Tacka){
			Tacka pomocna  = (Tacka) o;
			Tacka nula = new Tacka(0, 0);
			Tacka drugaPomocna = new Tacka(x, y);
			int pom1 = (int) nula.udaljenost(drugaPomocna);
			int pom2 = (int) nula.udaljenost(pomocna);

			return pom1 - pom2;

		}
		else
			return 0;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

	public void setX(int novoX)throws Exception{
		if(novoX<0)
			throw new Exception("X mora biti minimum 0!");
		else
			x = novoX;
	}
	public void setY(int novoY)throws Exception{
		if(novoY<0)
			throw new Exception("Y mora biti minimum 0!");
		else
			y = novoY;
	}

}
