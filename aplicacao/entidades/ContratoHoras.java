package aplicacao.entidades;

import java.util.Date;

public class ContratoHoras {

	private Date data;
	private Double valorPorHora;
	private Integer hora;
	
	public ContratoHoras() {
	}

	public ContratoHoras(Date data, Double valorPorHora, Integer hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return hora;
	}

	public void setHoras(Integer hora) {
		this.hora = hora;
	}
	
	public double totalValor() {
		return valorPorHora * hora;
	}
}
