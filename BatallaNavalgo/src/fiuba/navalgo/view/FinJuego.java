package fiuba.navalgo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import fiuba.navalgo.model.Puntaje;

import java.awt.Font;
import java.awt.Color;

public class FinJuego extends JInternalFrame {
	private JLabel lblpuntajeFinal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinJuego frame = new FinJuego();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinJuego() {
		
		getContentPane().setForeground(Color.YELLOW);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIN DEL JUEGO! ");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel.setBounds(102, 53, 239, 56);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTuPuntajeFinal = new JLabel("Tu puntaje final es:");
		lblTuPuntajeFinal.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblTuPuntajeFinal.setBounds(32, 143, 147, 31);
		getContentPane().add(lblTuPuntajeFinal);
		
		lblpuntajeFinal = new JLabel("");
		lblpuntajeFinal.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblpuntajeFinal.setBounds(219, 143, 103, 31);
		getContentPane().add(lblpuntajeFinal);
		
		
		
	}
	public void recibirPuntaje(String puntaje){
		lblpuntajeFinal.setText(puntaje);
	}
}
