package com.wpsnetwork.entidades;

public class Figura {
	public static class Coordenada2D{
		//Clase interna estática
		//Se comporta como una clase normal
		//Puede acceder a las propiedades estáticas de la clase contenedor
		//Puede tener los modificadores final, public, protected o private
		
		private class Punto{
			//Clase interna miembro
			//Esta tiene acceso a las propiedades de la clase contenedor aunque sean
			//  privadas
			//Puede tener los modificadores public, protected o private
			//NO PUEDEN TENER PROPIEDADES ESTATICAS
			private int valor;

			
			public Punto() {
				this(0);
			}

			public Punto(int valor) {
				super();
				this.valor = valor;
			}

			public int getValor() {
				return valor;
			}
			
			//No ponemos setter (solo lectura)
			
			
		}
		
		private Punto x;
		private Punto y;
		
		public Coordenada2D(int x, int y) {
			super();
			this.x = new Punto(x);
			this.y = new Punto(y);
			numCoodenadas++;
		}

		public int getX() {
			return x.getValor();
		}

		public void setX(int x) {
			this.x = new Punto(x);
		}

		public int getY() {
			return y.getValor();
		}

		public void setY(int y) {
			this.y = new Punto(y);
		}
		
		
	}
	
	static{
		//Constructor estático
		//Solo tenemos acceso a las propiedades y métodos estáticos
		//Solo se llama una vez. La primera vez que se usa la clase
		numCoodenadas = 0;
	}
	
	private Coordenada2D posicion;
	private static int numCoodenadas;
	
	
	public Figura(Coordenada2D posicion) {
		super();
		this.posicion = posicion;
	}


	public Coordenada2D getPosicion() {
		return posicion;
	}


	public void setPosicion(Coordenada2D posicion) {
		this.posicion = posicion;
	}


	public static int getNumCoodenadas() {
		return numCoodenadas;
	}


	public static void setNumCoodenadas(int numCoodenadas) {
		Figura.numCoodenadas = numCoodenadas;
	}
	
	
}


















