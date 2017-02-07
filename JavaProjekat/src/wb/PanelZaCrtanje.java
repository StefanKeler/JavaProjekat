package wb;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import geometrija.Oblik;

public class PanelZaCrtanje extends JPanel {
	
	private List<Oblik> oblici;
	
	public PanelZaCrtanje(){
		oblici = new ArrayList<Oblik>();
	}
	
	public void add(Oblik o){
		oblici.add(o);
		repaint();
	}
	
	public void remove(Oblik o){
		oblici.remove(o);
		repaint();
	}

	
	protected void paintComponent(Graphics g){
		System.out.println("osvezavam...");
		super.paintComponent(g);
		for(Oblik o : oblici){
			o.crtajSe(g);
		}
	}
}
