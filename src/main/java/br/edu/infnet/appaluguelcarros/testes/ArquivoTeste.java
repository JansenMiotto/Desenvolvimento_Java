package br.edu.infnet.appaluguelcarros.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appaluguelcarros.exception.QtdeCondutoresException;
import br.edu.infnet.appaluguelcarros.exception.QtdeEixoException;
import br.edu.infnet.appaluguelcarros.exception.TotalPassageirosException;
import br.edu.infnet.appaluguelcarros.model.domain.Caminhao;
import br.edu.infnet.appaluguelcarros.model.domain.Cliente;
import br.edu.infnet.appaluguelcarros.model.domain.Economico;
import br.edu.infnet.appaluguelcarros.model.domain.Locacao;
import br.edu.infnet.appaluguelcarros.model.domain.Suv;
import br.edu.infnet.appaluguelcarros.model.domain.Veiculo;

public class ArquivoTeste {
	public static void main(String[] args) {
		String dir = "C:\\Users\\janse\\Desktop\\";
		String arq = "teste.txt";
		
		try {
			try {
				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);
				
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				BufferedWriter escrita= new BufferedWriter(fileW); 
				
				String linha = null;
				String [] campos;
				
				List<Veiculo> veiculos = new ArrayList<Veiculo>();
				Locacao loca = new Locacao();
				
				linha = leitura.readLine();
				
				while(linha != null) {
					campos = linha.split(";");
					
					if (campos.length == 5) {
						Cliente cliente = new Cliente(campos[2], campos[3], campos[4]);
						
						loca.setDescricao(campos[0]);
						loca.setGps(Boolean.valueOf(campos[1]));
						loca.setCliente(cliente);
					
					} else {

						switch(campos[0]) {
						case "E":
							Economico econ = new Economico(campos[1], campos[2], Integer.valueOf(campos[3]), Boolean.valueOf(campos[4]), Integer.valueOf(campos[5]));
							
							try {
								econ.setArCondicionado(Boolean.valueOf(campos[8]));
								econ.setAutomatico(Boolean.valueOf(campos[6]));
								econ.setQtdeCondutores(Integer.valueOf(campos[7]));
								veiculos.add(econ);
							} catch (QtdeCondutoresException e1) {
								System.out.println(e1.getMessage());
							}
							
							break;
						
						case "S":
							Suv suv = new Suv(campos[1], campos[2], Integer.valueOf(campos[3]), Boolean.valueOf(campos[4]), Integer.valueOf(campos[5]));

							try {
								suv.setMotor(Float.valueOf(campos[8]));
								suv.setSeguro(Boolean.valueOf(campos[6]));
								suv.setTotalPassageiros(Integer.valueOf(campos[7]));
								veiculos.add(suv);
							} catch (NumberFormatException | TotalPassageirosException e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case "C":
							Caminhao cam = new Caminhao(campos[1], campos[2], Integer.valueOf(campos[3]), Boolean.valueOf(campos[4]), Integer.valueOf(campos[5]));
							
							try {
								cam.setQtdeEixo(Integer.valueOf(campos[8]));
								cam.setCambioAutomatico(Boolean.valueOf(campos[6]));
								cam.setTipoCarroceria(campos[7]);
								veiculos.add(cam);
							} catch (QtdeEixoException | NumberFormatException e) {
								System.out.println(e.getMessage());
							}
							break;

						default:
							System.out.println("Locação sem tipo");
							break;
						}
					}
					

					linha = leitura.readLine();
				}
				
				loca.setVeiculos(veiculos);

				for(Veiculo loc : loca.getVeiculos()) {
					System.out.println(loc);
					escrita.write(loca.getCliente().getNome() + ";" + loc.getNomeCarro() + ";" + loc.valorAluguel() + ";" + loca.getDescricao() + "\r\n");
				}
				
				leitura.close();
				file.close();
				
				escrita.close();
				fileW.close();
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			System.out.println("Finalizado");
		}
		
	}

}
