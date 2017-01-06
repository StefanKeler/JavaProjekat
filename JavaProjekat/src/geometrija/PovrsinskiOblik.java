package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private Color bojaUnutrasnjosti = Color.WHITE;
	private String bojaUnutrasnjostiStr = "bela";
	
	public abstract void popuni(Graphics g);

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public String getBojaUnutrasnjostiStr() {
		return bojaUnutrasnjostiStr;
	}

	public void setBojaUnutrasnjostiStr(String bojaUnutrasnjostiStr) {
		this.bojaUnutrasnjostiStr = bojaUnutrasnjostiStr;
	}
	

}
