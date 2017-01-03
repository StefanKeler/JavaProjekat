package geometrija;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {/*
		Tacka t1 = new Tacka();
		System.out.println("X koordinata t1: " + t1.getX());
		t1.setX(10);
		t1.setY(20);
		System.out.println("X koordinata t1: " + t1.getX() + "\nY koordinata t1: " + t1.getY());
		Linija l1 = new Linija();
		Tacka t2 = new Tacka();
		t2.setX(30);
		t2.setY(40);
		l1.settPocetna(t1);
		l1.settKrajnja(t2);
		System.out.println("X koordinata pocetne tacke l1: "+l1.gettPocetna().getX());

		//postaviti vrednost y koordinate pocetne tacke l1 na vrednost
		// x koordinate krajnje tacke linije l1
		l1.gettPocetna().setY(l1.gettKrajnja().getX());
		System.out.println("Y koordinata pocetne tacke l1: "+l1.gettPocetna().getY());
		System.out.println("Udaljenost t1 od t2: "+t1.udaljenost(t2));
		System.out.println("Duzina l1: "+l1.duzina());

		//postaviti x koordinatu krajnje tacke l1 na vrednost duzine linije l1 umanjene za 
		//vrednost zbira x i y koordinate pocetne tacke linije.
		l1.gettKrajnja().setX((int) l1.duzina()-(l1.gettPocetna().getX()+l1.gettPocetna().getY()));
		Pravougaonik p1 = new Pravougaonik();
		p1.setGoreLevo(l1.gettKrajnja());
		System.out.println("X koordinata tacke gore levo p1: "+p1.getGoreLevo().getX());
		Krug kr1 = new Krug();
		kr1.setCentar(t1);
		Kvadrat kv1 = new Kvadrat();
		kv1.setGoreLevo(t2);
		//postaviti x koordinatu centra kruga
		//na vrednost zbira x koordinata pocetne i krajnje tacke l1
		kr1.getCentar().setX(l1.gettPocetna().getX()+l1.gettKrajnja().getX());
		Tacka t3 = new Tacka(2,3);
		System.out.println("Y t3: "+t3.getY());
		Linija l2 = new Linija(new Tacka(4, 4), new Tacka(10, 10));
		System.out.println("Duzina l2: "+l2.duzina());
		//t1 = t2;
		Tacka t4 = new Tacka(t2.getX(), t2.getY());
		System.out.println("X pocetne tacke l2: "+l2.gettPocetna().getX());
		l2.gettKrajnja().pomeriZa(5, 10);
		System.out.println("X krajnje tacke l2: "+l2.gettKrajnja().getX());
		Pravougaonik p2 = new Pravougaonik(l2.gettKrajnja(), 100, 50);
		System.out.println("Povrisina p2: "+p2.povrsina());
		System.out.println("Zbir udaljenosti pocetne tacke linije l1 od tacke gore levo p1 i duzine linije l2: "
				+ (l1.gettPocetna().udaljenost(p1.getGoreLevo())+ l2.duzina()));
		//kreirati kvadrat kv2
		//gore levo --> pocetna tacka linije l2, pomerena za po x 15 po y 20
		//stranica = duzina l2 uvecana za vrednost povrsine p1

		Tacka tp = new Tacka(l2.gettPocetna().getX(), l2.gettPocetna().getY());
		//Tacka tr = l2./(); //referenca!
		//System.out.println(tr);
		tp.pomeriZa(15, 20);
		Kvadrat kv2 = new Kvadrat(tp, (int)(l2.duzina() + p1.povrsina()));
		Krug kr2 = new Krug(new Tacka(50,60),100);
		System.out.println("Obim kr2: "+kr2.obim());
		System.out.println("Boja centra kruga kr2: "+kr2.getCentar().getBoja());
		kr2.setBoja("crna");
		System.out.println("Boja kr2 je: "+kr2.getBoja());
		//ispisati x koordinatu tacke t1
		System.out.println(t1.getX());
		System.out.println(t1);
		//(x,y)
		//(xPocetne, yPocetne)-->(xKrajnje, yKrajnje)
		System.out.println(l1);
		//"gornji levi ugao=(x,y), stranica=duzinaStranice"
		//"gornji levi ugao=(x,y), sirina=sirina, visina=visina"
		//"centar=(x,y)", poluprecnik=poluprecnik"
		System.out.println(kv1);
		Kvadrat kv5 = new Kvadrat(new Tacka(4,3), 16);
		System.out.println(kv5);
		Pravougaonik p3=new Pravougaonik(new Tacka(5,6),370,420);
		System.out.println(p3);
		Krug kr6 = new Krug(new Tacka(1,1), 5);
		System.out.println(kr6);
		//System.out.println(t1==t2);
		t2.setX(-8);
		t2.setY(30);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1==t2);
		System.out.println(t1.equals(t2));


		System.out.println("Sredina linije l1: "+l1.sredinaLinije());
		// postaviti y koordinatu centra pravougaonika p1 na vrednost
		// y koordinate sredine linije dijagonale pravougaonika p1
		p1.centarPravougaonika().setY(p1.dijagonala().sredinaLinije().getY());
		kv1.centarKvadrata().setY(kv1.dijagonala().sredinaLinije().getY());

		System.out.println("Centralna tacka p1: "+p1.centarPravougaonika());
		System.out.println("X gore levo p1: "+p1.getGoreLevo().getX());
		p1.getGoreLevo().setX(50);
		System.out.println("X gore levo p1: "+p1.getGoreLevo().getX());
	 */
		/*Tacka t1 = new Tacka(10, 10);
		Tacka t2 = new Tacka(20, 20);
		Tacka t3 = new Tacka(30, 30);
		Tacka t4 = new Tacka(40, 40);

		Tacka [] nizTacaka = new Tacka[4];
		nizTacaka[0] = t3;
		nizTacaka[1] = t2;
		nizTacaka[2] = t4;
		nizTacaka[3] = t1;

		for(int i=0;i<nizTacaka.length;i++)
			System.out.println(nizTacaka[i]);

		Arrays.sort(nizTacaka);

		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizTacaka.length;i++)
			System.out.println(nizTacaka[i]);

		Linija l2 = new Linija(t1, new Tacka(20, 20));
		Linija l3 = new Linija(t1, new Tacka(30, 30));
		Linija l4 = new Linija(t1, new Tacka(40, 40));
		Linija l5 = new Linija(t1, new Tacka(50, 50));

		Linija[] nizLinija = {l4,l2,l3,l5};

		for(int i=0;i<nizLinija.length;i++)
			System.out.println(nizLinija[i]);

		Arrays.sort(nizLinija);

		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizLinija.length;i++)
			System.out.println(nizLinija[i]);

		Krug k1 = new Krug(t1, 10);
		Krug k2 = new Krug(t1, 20);
		Krug k3 = new Krug(t1, 30);
		Krug k4 = new Krug(t1, 40);

		Krug[] nizKrugova = {k4,k2,k3,k1};

		for(int i=0;i<nizKrugova.length;i++)
			System.out.println(nizKrugova[i]);

		Arrays.sort(nizKrugova);

		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizKrugova.length;i++)
			System.out.println(nizKrugova[i]);
		
		Kvadrat kv1 = new Kvadrat(t1, 10);
		Kvadrat kv2 = new Kvadrat(t1, 20);
		Kvadrat kv3 = new Kvadrat(t1, 30);
		Kvadrat kv4 = new Kvadrat(t1, 40);
		
		Kvadrat[] nizKvadrata = {kv4,kv2,kv3,kv1};

		for(int i=0;i<nizKvadrata.length;i++)
			System.out.println(nizKvadrata[i]);

		Arrays.sort(nizKvadrata);

		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizKvadrata.length;i++)
			System.out.println(nizKvadrata[i]);
		
		Pravougaonik p1 = new Pravougaonik(t1, 10, 100);
		Pravougaonik p2 = new Pravougaonik(t1, 20, 100);
		Pravougaonik p3 = new Pravougaonik(t1, 30, 100);
		Pravougaonik p4 = new Pravougaonik(t1, 40, 100);
		
		Pravougaonik[] nizPravougaonika = {p4,p2,p3,p1};

		for(int i=0;i<nizPravougaonika.length;i++)
			System.out.println(nizPravougaonika[i]);

		Arrays.sort(nizPravougaonika);

		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizPravougaonika.length;i++)
			System.out.println(nizPravougaonika[i]);
		
		ArrayList<Oblik> lista = new ArrayList<Oblik>();
		lista.add(t1);
		lista.add(l2);
		lista.add(p1);
		lista.add(k1);
		
		lista.remove(1);
		lista.add(1, l2);
		System.out.println("lista:");
		Iterator it = lista.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println(lista.size());
		
		HashMap<String, Oblik> hm = new HashMap<String, Oblik>();
		hm.put("tacka", t1);
		hm.put("linija", l2);
		hm.put("krug", k1);
		hm.put("kvadrat", kv1);
		hm.put("krug", kv1);
		hm.remove("krug");
		System.out.println(hm.get("krug"));
		System.out.println(hm.values());*/
		Tacka t1 = new Tacka(10, 10);
		Tacka t2 = new Tacka(20, 20);
		Tacka t3 = new Tacka(30, 30);
		Tacka t4 = new Tacka(40, 40);

		Tacka [] nizTacaka = new Tacka[4];
		nizTacaka[0] = t3;
		nizTacaka[1] = t2;
		nizTacaka[2] = t4;
		nizTacaka[3] = t1;

		try {
			for(int i=0;i<100;i++)
				System.out.println(nizTacaka[i]);
			Integer.parseInt("pet");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Niz nema toliko elemenata!");
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Ne mogu da pretvorim u int!");
		}
		finally {
			System.out.println("finally");
		}
		
		System.out.println("ja sam sledeca naredba!");

	}

}
