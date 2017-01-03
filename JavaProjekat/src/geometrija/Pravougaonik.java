package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{
	private int sirina;


	public Pravougaonik(){

	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina){
		super(goreLevo, visina);
		this.sirina = sirina;
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja){
		this(goreLevo, sirina, visina);
		setBoja(boja);
	}
	
	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color bojaKonture, Color bojaUnutrasnjosti){
		this(goreLevo, sirina, visina, bojaKonture);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + sirina,goreLevo.getY() + duzinaStranice));
	}

	public void pomeriNa(int x, int y){
		goreLevo.setX(x);
		goreLevo.setY(y);
	}
	public void pomeriZa(int x, int y){
		goreLevo.setX(goreLevo.getX()+x);
		goreLevo.setY(goreLevo.getY()+y);

	}

	public Tacka centarPravougaonika(){
		return dijagonala().sredinaLinije();
	}

	public String toString(){
		return "Gornji levi ugao="+goreLevo+",sirina="+sirina+",visina="+duzinaStranice;
	}

	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Pravougaonik pomocni=(Pravougaonik) obj;
			if(this.goreLevo.equals(pomocni.goreLevo) && this.duzinaStranice==pomocni.duzinaStranice && this.sirina==pomocni.sirina)
				return true;
			else
				return false;
		}
		else 
			return false;
	}


	public int povrsina(){
		return duzinaStranice * sirina;
	}
	public int obim(){
		return  2 * duzinaStranice + 2 * sirina;
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + sirina)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;

	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+sirina, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+sirina, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja()).selektovan(g);
	}
	public void crtajSe(Graphics g){
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), sirina, duzinaStranice);
		popuni(g);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g){
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, sirina-1, duzinaStranice-1);
	}

	public int getVisina() {
		return duzinaStranice;
	}
	public int getSirina() {
		return sirina;
	}

	public void setVisina(int visina) {
		this.duzinaStranice = visina;
	}
	public void setSirina(int sirina) {
		this.sirina = sirina;
	}


}
