package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Mapa mapa;
	private JButton btnBuscarRuta;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblIParqueLa;
	private JLabel lblHPlazaUniversitario;
	private JLabel lblG;
	private JLabel lblF;
	private JLabel lblE;
	private JLabel lblDPlazuelaCobija;
	private JLabel lblCPlazuelaCobija;
	private JLabel lblB;
	private JLabel label_8;
	private JLabel lblPlazas;
	private JLabel lblNewLabel_1;
	private JLabel lblPlazaMeta;
	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Busqueda de Rutas (Bidireccional)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 27, 1089, 33);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(10, 84, 1006, 601);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		mapa = new Mapa();
		panel.add(mapa, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1021, 318, 233, 367);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblIParqueLa = new JLabel("I: Parque La Torre");
		lblIParqueLa.setHorizontalAlignment(SwingConstants.LEFT);
		lblIParqueLa.setFont(new Font("Arial", Font.PLAIN, 15));
		lblIParqueLa.setBounds(20, 330, 203, 26);
		panel_2.add(lblIParqueLa);
		
		lblHPlazaUniversitario = new JLabel("H: Plaza Universitario");
		lblHPlazaUniversitario.setHorizontalAlignment(SwingConstants.LEFT);
		lblHPlazaUniversitario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHPlazaUniversitario.setBounds(20, 293, 203, 26);
		panel_2.add(lblHPlazaUniversitario);
		
		lblG = new JLabel("G: Plaza Sucre");
		lblG.setHorizontalAlignment(SwingConstants.LEFT);
		lblG.setFont(new Font("Arial", Font.PLAIN, 15));
		lblG.setBounds(20, 256, 203, 26);
		panel_2.add(lblG);
		
		lblF = new JLabel("F: Plaza de la Mujer");
		lblF.setHorizontalAlignment(SwingConstants.LEFT);
		lblF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblF.setBounds(20, 219, 203, 26);
		panel_2.add(lblF);
		
		lblE = new JLabel("E: Plaza 14 de Septiembre");
		lblE.setHorizontalAlignment(SwingConstants.LEFT);
		lblE.setFont(new Font("Arial", Font.PLAIN, 15));
		lblE.setBounds(20, 182, 203, 26);
		panel_2.add(lblE);
		
		lblDPlazuelaCobija = new JLabel("D: Plaza San Sebastian");
		lblDPlazuelaCobija.setHorizontalAlignment(SwingConstants.LEFT);
		lblDPlazuelaCobija.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDPlazuelaCobija.setBounds(20, 145, 203, 26);
		panel_2.add(lblDPlazuelaCobija);
		
		lblCPlazuelaCobija = new JLabel("C: Plazuela Corazonistas");
		lblCPlazuelaCobija.setHorizontalAlignment(SwingConstants.LEFT);
		lblCPlazuelaCobija.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCPlazuelaCobija.setBounds(20, 108, 203, 26);
		panel_2.add(lblCPlazuelaCobija);
		
		lblB = new JLabel("B: Plaza Colon");
		lblB.setHorizontalAlignment(SwingConstants.LEFT);
		lblB.setFont(new Font("Arial", Font.PLAIN, 15));
		lblB.setBounds(20, 71, 203, 26);
		panel_2.add(lblB);
		
		label_8 = new JLabel("A: Plazuela Cobija");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Arial", Font.PLAIN, 15));
		label_8.setBounds(20, 37, 203, 26);
		panel_2.add(label_8);
		
		lblPlazas = new JLabel("Plazas");
		lblPlazas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlazas.setFont(new Font("Arial", Font.BOLD, 15));
		lblPlazas.setBounds(10, 0, 213, 26);
		panel_2.add(lblPlazas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1021, 84, 233, 223);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnBuscarRuta = new JButton("Buscar Ruta");
		btnBuscarRuta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarRuta.setBounds(48, 153, 142, 30);
		panel_1.add(btnBuscarRuta);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(20, 100, 142, 20);
		panel_1.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setBounds(20, 38, 142, 20);
		panel_1.add(comboBox_1);
		
		lblNewLabel_1 = new JLabel("Plaza Inicio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 11, 113, 14);
		panel_1.add(lblNewLabel_1);
		
		lblPlazaMeta = new JLabel("Plaza Meta:");
		lblPlazaMeta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlazaMeta.setBounds(10, 75, 113, 14);
		panel_1.add(lblPlazaMeta);
	}
	public Mapa getMapa() {
		return mapa;
	}
}
