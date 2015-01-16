package Outils;

public class Coordonnees<c1,c2>  {
	
		private  c1 x;
		private  c2 y;
		
		public Coordonnees(c1 x,c2 y){
			this.x=x;
			this.y=y;
		}
		
	public c1 getx(){ return x;}
	public c2 gety(){return y;}
	
	public void setx(c1 x){this.x=x;};
	public void sety(c2 y){this.y=y;};
	
	
		
	}



