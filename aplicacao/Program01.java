package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import aplicacao.entidades.ContratoHoras;
import aplicacao.entidades.Departamento;
import aplicacao.entidades.Trabalhador;
import aplicacao.entidades.enums.NivelTrabalhador;

public class Program01 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Base salarial: R$ ");
		double baseSalario = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), baseSalario, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos que adicionar a esse Trabalhador? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Entre com os dados, contrato #" + i + ":");
			System.out.print("Data (DD/MM/AAAA): ");
			Date contratoData = sdf.parse(sc.next());
			System.out.print("Valor por hora: R$ ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			ContratoHoras contrato = new ContratoHoras(contratoData, valorPorHora, horas);
			trabalhador.addContratos(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e o ano que deseja consultar a renda (MM/AAAA): ");
		String mes_e_ano = sc.next();
		int mes = Integer.parseInt(mes_e_ano.substring(0, 2));
		int ano = Integer.parseInt(mes_e_ano.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda para: " + mes_e_ano + ": R$ " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		sc.close();
	}
}
