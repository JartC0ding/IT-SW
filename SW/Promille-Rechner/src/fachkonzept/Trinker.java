package fachkonzept;

public class Trinker 
{
		private char Zeichen;
		private Getraenk getrunkenesGetraenk;
		private int koerpergewichtKG;
		
		public Trinker (char pGeschlecht, int pKoerpergewichtKG, Getraenk pGetraenk) {
			this.Zeichen = pGeschlecht;
			this.koerpergewichtKG = pKoerpergewichtKG < 0 ? -pKoerpergewichtKG : pKoerpergewichtKG;
			this.getrunkenesGetraenk = pGetraenk; // can't be null
		}
		
		public double berechneBlutalkoholgehaltPromille() {
			return getrunkenesGetraenk.berechneAlkoholgewichtG() / ((this.Zeichen == 'm' ? 0.7 : 0.6) * this.koerpergewichtKG);
		}
}
