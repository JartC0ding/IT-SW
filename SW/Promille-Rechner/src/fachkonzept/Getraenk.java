package fachkonzept;

public class Getraenk {
		private double alkoholgehaltPzt;
		private int mengeML;
		
		public Getraenk (double pAlkoholgehaltPzt, int pMengeML) {
			this.alkoholgehaltPzt = pAlkoholgehaltPzt < 0 ? -pAlkoholgehaltPzt : pAlkoholgehaltPzt;
			this.mengeML = pMengeML < 0 ? -pMengeML : pMengeML;
		}
		
		double berechneAlkoholgewichtG() {
			return this.mengeML * (this.alkoholgehaltPzt/100) * 0.8;
		}
}
