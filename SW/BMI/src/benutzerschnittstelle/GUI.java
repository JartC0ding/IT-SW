package benutzerschnittstelle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import fachkonzept.Person;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtGewicht;
	private JLabel lblNewLabel_1;
	private JLabel lblGroesse;
	private JTextField txtGroesse;
	private JLabel lblNewLabel_3;
	private JLabel lblBmi;
	private JTextField txtBmi;
	private JTextField txtGewichtsklasse;
	private JButton btnNewButton;
	private JButton btnLoeschen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setForeground(Color.DARK_GRAY);
		setResizable(false);
		setTitle("BMI-Rechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 229);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Gewicht");
		lblNewLabel.setBounds(6, 6, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtGewicht = new JTextField();
		txtGewicht.setToolTipText("");
		txtGewicht.setBounds(65, 1, 97, 26);
		contentPane.add(txtGewicht);
		txtGewicht.setColumns(10);
		
		lblNewLabel_1 = new JLabel("kg");
		lblNewLabel_1.setBounds(174, 6, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		lblGroesse = new JLabel("Groesse");
		lblGroesse.setBounds(6, 34, 61, 16);
		contentPane.add(lblGroesse);
		
		txtGroesse = new JTextField();
		txtGroesse.setToolTipText("");
		txtGroesse.setColumns(10);
		txtGroesse.setBounds(65, 29, 97, 26);
		contentPane.add(txtGroesse);
		
		lblNewLabel_3 = new JLabel("m");
		lblNewLabel_3.setBounds(174, 34, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblBmi = new JLabel("BMI");
		lblBmi.setBounds(6, 62, 61, 16);
		contentPane.add(lblBmi);
		
		txtBmi = new JTextField();
		txtBmi.setEditable(false);
		txtBmi.setColumns(10);
		txtBmi.setBounds(65, 57, 170, 26);
		contentPane.add(txtBmi);
		
		txtGewichtsklasse = new JTextField();
		txtGewichtsklasse.setEditable(false);
		txtGewichtsklasse.setColumns(10);
		txtGewichtsklasse.setBounds(65, 86, 170, 26);
		contentPane.add(txtGewichtsklasse);
		
		btnNewButton = new JButton("BMI berechnen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				geklicktBMIBerechnen();
			}
		});
		btnNewButton.setBounds(6, 124, 229, 29);
		contentPane.add(btnNewButton);
		
		btnLoeschen = new JButton("löschen");
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geklickLoeschen();
			}
		});
		btnLoeschen.setBounds(6, 165, 229, 29);
		contentPane.add(btnLoeschen);
	}

	protected void geklickLoeschen() {
		txtBmi.setText(null);
		txtGewichtsklasse.setText(null);
		txtGewicht.setText(null);
		txtGroesse.setText(null);
	}

	private void geklicktBMIBerechnen()
	{
		int gew;
		double gr;
		
		try
		{
			gew = Integer.parseInt(txtGewicht.getText());
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(this, "Nur ganze Zahlen zulässig!",
					"Gewicht", JOptionPane.ERROR_MESSAGE);
			txtGewicht.requestFocusInWindow();
			txtGewicht.selectAll();
			return;
		}
		
		try
		{
			gr = Double.parseDouble(txtGroesse.getText());
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(this, "Nur Kommazahlen zulässig!",
					"Größe", JOptionPane.ERROR_MESSAGE);
			txtGewicht.requestFocusInWindow();
			txtGroesse.selectAll();
			return;
		}
		Person diePerson = new Person(gew, gr);
		double bmi = diePerson.berechenBMI();
		txtBmi.setText(""+bmi);
		txtGewichtsklasse.setText(diePerson.ermittleGewichtsklasse());
	}
}
