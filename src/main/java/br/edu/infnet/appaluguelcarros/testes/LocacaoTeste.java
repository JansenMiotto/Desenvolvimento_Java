package br.edu.infnet.appaluguelcarros.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appaluguelcarros.exception.QtdeCondutoresException;
import br.edu.infnet.appaluguelcarros.exception.TotalPassageirosException;
import br.edu.infnet.appaluguelcarros.model.domain.Cliente;
import br.edu.infnet.appaluguelcarros.model.domain.Economico;
import br.edu.infnet.appaluguelcarros.model.domain.Locacao;
import br.edu.infnet.appaluguelcarros.model.domain.Suv;
import br.edu.infnet.appaluguelcarros.model.domain.Veiculo;

public class LocacaoTeste {

	public static void main(String[] args) {
	
		Cliente cliente = new Cliente("Joao", "123456789-10", "joao@joao.com");
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		List<Veiculo> listaCarroEco = new ArrayList<Veiculo>();
		
		try {
			Suv suv = new Suv("Honda BR-V", "Preto", 5, true, 130);
			suv.setMotor(2.6f);
			suv.setSeguro(true);
			suv.setTotalPassageiros(6);
			listaVeiculos.add(suv);
		} catch (TotalPassageirosException e) {
			System.out.println(e.getMessage());
		}
		

		try {
			Economico econ = new Economico("Ka", "Azul", 5, true, 80);
			econ.setArCondicionado(true);
			econ.setAutomatico(true);
			econ.setQtdeCondutores(1);
			listaVeiculos.add(econ);
		} catch (QtdeCondutoresException e) {
			System.out.println(e.getMessage());
		}
		

		try {
			Economico eco2 = new Economico("Fiat Argo", "Prata", 10, true, 70);
			eco2.setArCondicionado(true);
			eco2.setAutomatico(false);
			eco2.setQtdeCondutores(2);
			listaCarroEco.add(eco2);
		} catch (QtdeCondutoresException e) {
			System.out.println(e.getMessage());
			
		}

		
		Locacao carroEco = new Locacao();
		carroEco.setDescricao("Carro Economico");
		carroEco.setGps(true);
		carroEco.setCliente(cliente);
		carroEco.setVeiculos(listaCarroEco);
		System.out.println(carroEco);
		
		Locacao carroSuv = new Locacao();
		carroSuv.setCliente(cliente);
		carroSuv.setDescricao("Carro SUV");
		carroSuv.setGps(true);
		carroSuv.setVeiculos(listaVeiculos);
		System.out.println(carroSuv);
		
		}


}
