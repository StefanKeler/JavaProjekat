package uvod;

public class KontrolaToka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prviBroj = 0;
		if(prviBroj > 0)
			System.out.println("Broj je pozitivan!");
		else if (prviBroj == 0)
			System.out.println("Broj je jednak nuli!");
		else
			System.out.println("Broj je negativan!");

		System.out.println("od 1 do 10 pomocu while");

		int i = 1;
		while(i<=10){
			System.out.println(i);
			i++;
		}

		System.out.println("od 8 do 3");

		i = 8;
		while(i>=3){
			System.out.println(i);
			i--;
		}

		System.out.println("faktorijel broja 5");

		int faktorijel = 1;
		i = 5;
		while(i>0){
			faktorijel = faktorijel * i;
			i--;
		}
		System.out.println("5! = "+faktorijel);

		System.out.println("pomocu for petlje brojeve od 8 do 3");

		for(i=8;i>=3;i--){
			System.out.println(i);
		}
		
		System.out.println("rezultat operacije je "+sabiranje(-5, 3));
		System.out.println("povrsina kruga je: "+povrsina(5));
		konobar();
		System.out.println(konobarDonesi("nes", "fanta"));
	}
	public static int sabiranje (int x, int y){
		int suma = x+y;
		return suma;

	}
	
	public static double povrsina(int r){
		double p = r * r * Math.PI;
		return p;
	}
	
	public static void konobar(){
		System.out.println("Dobar dan, izvolite!");
	}
	
	
	public static double konobarDonesi(String kafa, String sok){
		double racun = 0;
		double nes = 129.99;
		double fanta = 150.99;
		
		if(kafa.equalsIgnoreCase("nes") && sok.equalsIgnoreCase("fanta")){
			System.out.println("U redu Vas racun ce iznositi: ");
			racun  = nes + fanta;
		}
		return racun;
	}

}
