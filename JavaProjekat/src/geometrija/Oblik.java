package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable{
	private Color boja = Color.BLACK;
	private String bojaStr = "crna";
	private boolean selektovan;
	
	public Oblik(){
		
	}
	public Oblik(Color boja){
		this.boja = boja;
	}

	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	
	public static Color pronadjiBoju(String boja){
		if(boja.equalsIgnoreCase("crna"))
			return Color.BLACK;
		else if(boja.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(boja.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else if(boja.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(boja.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else if(boja.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(boja.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
	}
	
	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	
	public String getBojaStr() {
		return bojaStr;
	}

	public void setBojaStr(String bojaStr) {
		this.bojaStr = bojaStr;
	}
	
}
