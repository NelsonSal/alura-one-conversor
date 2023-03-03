package Conversor;

import javax.swing.JPanel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuMoneda extends JPanel {
	private String cantidadDinero;
	
	
	
	public MenuMoneda(String cantidadDinero) {
		super();
		this.cantidadDinero = cantidadDinero;
	}

	public String getCantidadDinero() {
		return cantidadDinero;
	}

	public void setCantidadDinero(String cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
	}

	/**
	 * Create the panel.
	 */
	public MenuMoneda() {
		setLayout(null);
		
		Moneda ArrayMonedas[] = new Moneda[5];
		ArrayMonedas[0] = new Moneda("Dolares US$", 5000);
		ArrayMonedas[1] = new Moneda("Euros €", 6000);
		ArrayMonedas[2] = new Moneda("UK libras ", 8000);
		ArrayMonedas[3] = new Moneda("Yen Japones ¥", 6000);
		ArrayMonedas[4] = new Moneda("Won Surcoreano ₩", 6000);
		
		JPanel panelMoneda = new JPanel();
		panelMoneda.setBounds(0, 0, 320, 174);
		add(panelMoneda);
		panelMoneda.setLayout(null);
		
		TipoConversor traer = new TipoConversor();
		cantidadDinero=traer.getCantMoneda();
		JOptionPane.showMessageDialog(null, "Valor traido" + cantidadDinero);
		BigDecimal cantMonedaBig = new BigDecimal(cantidadDinero);
		
		JButton btnNewButton = new JButton("Cancel Moneda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel.setVisible(false);
				TipoConversor tipoConv = new TipoConversor();
				tipoConv.setBounds(0, 0, 320, 174);
				tipoConv.setSize(320, 174);
				tipoConv.setLocation(0, 0);
				panelMoneda.removeAll();
				panelMoneda.setLayout(null);
				panelMoneda.add(tipoConv);
				panelMoneda.revalidate();
				panelMoneda.repaint();
				
				
				
			}
		});
		btnNewButton.setBounds(169, 91, 89, 23);
		panelMoneda.add(btnNewButton);
		
		JComboBox comboBoxMoneda = new JComboBox();
		comboBoxMoneda.setModel(new DefaultComboBoxModel(new String[] {"De Pesos a Dolares USA", "De Pesos a Euros", "De Pesos a Libras Esterlinas", "De Pesos a Yen Japones", "De Pesos a Won Surcoreano", "De Dolares USA a Pesos", "De Euros a Pesos", "De Libras Esterlinas a Pesos", "De Yen Japones a Pesos", "De Won Surcoreano a Pesos"}));
		comboBoxMoneda.setBounds(67, 37, 190, 22);
		panelMoneda.add(comboBoxMoneda);
		
		JButton btnNewButton_1 = new JButton("OK money");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//conversion
				int tipoCambio = comboBoxMoneda.getSelectedIndex();// retorna index seleccionado al dar OK
				
				//Manejo de decimales y error: 5,RoundingMode.HALF_UP
				JOptionPane.showMessageDialog(null, "Tipo cambio: "+tipoCambio+ " cantidad= "+cantMonedaBig);
				if (tipoCambio <= 4) {
					BigDecimal divisor = new BigDecimal(ArrayMonedas[tipoCambio].getValor());
					BigDecimal conversion= (cantMonedaBig.divide(divisor,5,RoundingMode.HALF_UP));
					JOptionPane.showMessageDialog(null, "El valor de " + cantMonedaBig + " pesos es de: "
							+ conversion + "  " + (ArrayMonedas[tipoCambio].getNombreMoneda()));
				} else {
					tipoCambio = tipoCambio - 5;
					BigDecimal divisor = new BigDecimal(ArrayMonedas[tipoCambio].getValor());
					
					JOptionPane.showMessageDialog(null,
							"El valor de " + cantMonedaBig + " " + (ArrayMonedas[tipoCambio].getNombreMoneda())
									+ " es de: $" + (divisor.multiply(cantMonedaBig) + " pesos  "));
				}
				int continuar= JOptionPane.showConfirmDialog(btnNewButton_1,"¿Desea continuar?", "CONtiNUAR", JOptionPane.YES_NO_CANCEL_OPTION);
				if (continuar==JOptionPane.YES_OPTION) {
					TipoConversor tipoConv = new TipoConversor();
					tipoConv.setBounds(0, 0, 320, 174);
					tipoConv.setSize(320, 174);
					tipoConv.setLocation(0, 0);
					panelMoneda.removeAll();
					panelMoneda.setLayout(null);
					panelMoneda.add(tipoConv);
					panelMoneda.revalidate();
					panelMoneda.repaint();
				}else if(continuar==JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null,"Programa Terminado");
					System.exit(0);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(40, 91, 89, 23);
		panelMoneda.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Elija la converción deseada");
		lblNewLabel.setBounds(67, 11, 160, 14);
		panelMoneda.add(lblNewLabel);

	}
}
