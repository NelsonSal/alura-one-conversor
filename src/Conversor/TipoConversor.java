package Conversor;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TipoConversor extends JPanel {
	//VARIABLES
	private static String cantMoneda;
	
	public static String getCantMoneda() {
		return cantMoneda;
	}


	public static void setCantMoneda(String cantMoneda) {
		TipoConversor.cantMoneda = cantMoneda;
	}


	/**
	 * Create the panel.
	 */
	public TipoConversor() {
		setLayout(null);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setBounds(0, 0, 320, 174);
		add(panelTipo);
		panelTipo.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Convertir Dinero", "Convertir Temperatura"}));
		comboBox.setBounds(67, 37, 190, 22);
		panelTipo.add(comboBox);
		
		JButton btnNewButton = new JButton("OK tipo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tipoConver = comboBox.getSelectedIndex();// retorna index seleccionado al dar OK
				JOptionPane.showMessageDialog(null, "posicion; " + tipoConver);
				if (tipoConver==0) {
					cantMoneda = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero a convertir:");
					if (cantMoneda != null) {
						MenuMoneda menuMon = new MenuMoneda();
						menuMon.setBounds(0, 0, 320, 174);
						menuMon.setSize(320, 174);
						menuMon.setLocation(0, 0);
						panelTipo.removeAll();
						panelTipo.setLayout(null);
						panelTipo.add(menuMon);
						panelTipo.revalidate();
						panelTipo.repaint();
					}//fin if cantMneda
					}
			}
		});
		btnNewButton.setBounds(43, 95, 89, 23);
		panelTipo.add(btnNewButton);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Programa Terminado");
				System.exit(0);
			}
		});
		btnSalir.setBounds(188, 95, 89, 23);
		panelTipo.add(btnSalir);
		
		JLabel lbMenuPpal = new JLabel("Seleccione una opción de Conversión");
		lbMenuPpal.setBounds(53, 12, 214, 14);
		panelTipo.add(lbMenuPpal);

	}

}
