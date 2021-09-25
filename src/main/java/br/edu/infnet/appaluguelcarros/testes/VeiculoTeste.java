package br.edu.infnet.appaluguelcarros.testes;

import br.edu.infnet.appaluguelcarros.exception.QtdeCondutoresException;
import br.edu.infnet.appaluguelcarros.exception.QtdeEixoException;
import br.edu.infnet.appaluguelcarros.exception.TotalPassageirosException;
import br.edu.infnet.appaluguelcarros.model.domain.Caminhao;
import br.edu.infnet.appaluguelcarros.model.domain.Economico;
import br.edu.infnet.appaluguelcarros.model.domain.Suv;

public class VeiculoTeste {

	public static void main(String[] args) {
		
		try {
			Economico eco = new Economico("Celta", "Prata", 5, true, 50);
			eco.setArCondicionado(false);
			eco.setAutomatico(false);
			eco.setQtdeCondutores(1);
			System.out.println(eco);
		} catch (QtdeCondutoresException e) {
			System.out.println(e.getMessage());
		}
		

		try {
			Suv suv = new Suv("Fiat Pulse" , "Vermelho", 5 , true, 120);
			suv.setMotor(2.0f);
			suv.setSeguro(true);
			suv.setTotalPassageiros(5);
			System.out.println(suv);
		} catch (TotalPassageirosException e) {
			System.out.println(e.getMessage());
		}

		try {
			Caminhao truck = new Caminhao("Carreta", "Branco", 5, true, 200);
			truck.setCambioAutomatico(false);
			truck.setQtdeEixo(5);
			truck.setTipoCarroceria("Liquido Inflamavel");
			System.out.println(truck);
		} catch (QtdeEixoException e) {
			System.out.println(e.getMessage());
		}

	}
}
