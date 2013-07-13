package fiuba.navalgo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;


import java.awt.Font;
import java.awt.Color;

public class FinJuego extends JFrame {
	private JLabel lblpuntajeFinal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinJuego frame = new FinJuego();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public FinJuego() {
		getContentPane().setBackground(Color.CYAN);
		
		getContentPane().setForeground(new Color(0, 0, 0));
		setBounds(300, 300, 355, 236);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIN DEL JUEGO! ");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 35));
		lblNewLabel.setBounds(41, 24, 254, 79);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTuPuntajeFinal = new JLabel("Tu puntaje final es:");
		lblTuPuntajeFinal.setForeground(Color.BLACK);
		lblTuPuntajeFinal.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
		lblTuPuntajeFinal.setBounds(27, 114, 182, 45);
		getContentPane().add(lblTuPuntajeFinal);
		
		lblpuntajeFinal = new JLabel("");
		lblpuntajeFinal.setForeground(Color.RED);
		lblpuntajeFinal.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
		lblpuntajeFinal.setBounds(205, 114, 117, 45);
		getContentPane().add(lblpuntajeFinal);
		
		
		
	}
	public void recibirPuntaje(String puntaje){
		lblpuntajeFinal.setText(puntaje);
	}
}
