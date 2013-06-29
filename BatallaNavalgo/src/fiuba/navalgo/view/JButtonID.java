package fiuba.navalgo.view;

import javax.swing.JButton;

public class JButtonID extends JButton{

		private int fila;
		private int columna;
		
		public JButtonID(int fil, int col){
			super();
			fila = fil;
			columna = col;
		}
		
		public int getFila(){
			return fila;
			
		}
		public int getColumna(){
			return columna;
			
		}
		
		public void setFila(int fil){
			fila = fil;
			
		}
		public void setColumna(int col){
			columna = col;
			
		}
}
