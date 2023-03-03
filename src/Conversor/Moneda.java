package Conversor;

public class Moneda {
	private String nombreMoneda;
	private double valor;

	public Moneda(String nombreMoneda, double valor) {
		super();
		this.nombreMoneda = nombreMoneda;
		this.valor = valor;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
