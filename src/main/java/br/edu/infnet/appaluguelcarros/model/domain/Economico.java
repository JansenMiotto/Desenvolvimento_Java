package br.edu.infnet.appaluguelcarros.model.domain;

import br.edu.infnet.appaluguelcarros.exception.QtdeCondutoresException;

public class Economico extends Veiculo{
	private boolean automatico;
	private int qtdeCondutores;
	private boolean arCondicionado;
	
	public Economico(String nomeCarro, String cor, int qtdeDias, boolean disponivel, float valor) {
		super(nomeCarro, cor, qtdeDias, disponivel, valor);
	}

	@Override
	public float valorAluguel() {
		return qtdeCondutores > 1 || arCondicionado != false? getValor()*getQtdeDias()+100 : getValor()*getQtdeDias();
		//return qtdeCondutores > 1? getValor()*getQtdeDias()+100 : getValor()*getQtdeDias();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(automatico ? "Automatico" : "Manual");
		sb.append(";");
		sb.append(qtdeCondutores);
		sb.append(";");
		sb.append(arCondicionado ? "Com Ar" : "Sem Ar");
		sb.append(";");
		sb.append(valorAluguel());
		return sb.toString();
		
	}
	
	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public int getQtdeCondutores() {
		return qtdeCondutores;
	}

	public void setQtdeCondutores(int qtdeCondutores) throws QtdeCondutoresException {
		if(qtdeCondutores < 0 || qtdeCondutores > 3) {
			throw new QtdeCondutoresException("Quantidade de Condutores Inválida.");
		}
		this.qtdeCondutores = qtdeCondutores;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	
	

}
