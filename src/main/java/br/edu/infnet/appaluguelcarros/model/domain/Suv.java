package br.edu.infnet.appaluguelcarros.model.domain;

import br.edu.infnet.appaluguelcarros.exception.TotalPassageirosException;

public class Suv extends Veiculo{
	private boolean seguro;
	private int totalPassageiros;
	private float motor;

	public Suv(String nomeCarro, String cor, int qtdeDias, boolean disponivel, float valor) {
		super(nomeCarro, cor, qtdeDias, disponivel, valor);
	}

	@Override
	public float valorAluguel() {
		return seguro != false? getValor()*getQtdeDias()+100*(totalPassageiros*0.2f) : getValor()*getQtdeDias()*(totalPassageiros*0.2f);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(seguro ? "Seguro Ativo" : "Sem Seguro");
		sb.append(";");
		sb.append(totalPassageiros);
		sb.append(";");
		sb.append(motor);
		sb.append(";");
		sb.append(valorAluguel());
		return sb.toString();
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public int getTotalPassageiros() {
		return totalPassageiros;
	}

	public void setTotalPassageiros(int totalPassageiros) throws TotalPassageirosException {
		if(totalPassageiros < 5 || totalPassageiros > 6) {
			throw new TotalPassageirosException("Quantidade de Passageiros Inválida!");
		}
		this.totalPassageiros = totalPassageiros;
	}

	public float getMotor() {
		return motor;
	}

	public void setMotor(float motor) {
		this.motor = motor;
	}
	
}
