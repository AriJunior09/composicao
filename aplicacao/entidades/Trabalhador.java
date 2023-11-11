package aplicacao.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import aplicacao.entidades.enums.NivelTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private Double baseSalario;
	
	private Departamento departamentos;
	private List<ContratoHoras> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double baseSalario, Departamento departamentos) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.departamentos = departamentos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalario() {
		return baseSalario;
	}

	public void setBaseSalario(Double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public Departamento getDepartamento() {
		return departamentos;
	}

	public void setDepartamento(Departamento departamentos) {
		this.departamentos = departamentos;
	}

	public List<ContratoHoras> getContratos() {
		return contratos;
	}

	public void addContratos(ContratoHoras contrato) {
	 contratos.add(contrato);
	}
	
	public void removeContratos(ContratoHoras contrato) {
	 contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = baseSalario;
		Calendar cal = Calendar.getInstance();
		for (ContratoHoras c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.totalValor();
			}
		}
		return soma;
	}
}
