package br.edu.infnet.appaluguelcarros.model.domain;

import br.edu.infnet.appaluguelcarros.exception.QtdeEixoException;

public class Caminhao extends Veiculo {
	private String tipoCarroceria;
	private boolean cambioAutomatico;
	private int qtdeEixo;

	public Caminhao(String nomeCarro, String cor, int qtdeDias, boolean disponivel, float valor) {
		super(nomeCarro, cor, qtdeDias, disponivel, valor);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(cambioAutomatico ? "Automatico" : "Manual");
		sb.append(";");
		sb.append(tipoCarroceria);
		sb.append(";");
		sb.append(qtdeEixo);
		sb.append(";");
		sb.append(valorAluguel());
		return sb.toString();
	}


	
	@Override
	public float valorAluguel() {
		return cambioAutomatico != false? getValor()*getQtdeDias()+100*(qtdeEixo * 0.2f) : getValor()*getQtdeDias()*(qtdeEixo * 0.2f);
	}

	public String getTipoCarroceria() {
		return tipoCarroceria;
	}

	public void setTipoCarroceria(String tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}

	public boolean isCambioAutomatico() {
		return cambioAutomatico;
	}

	public void setCambioAutomatico(boolean cambioAutomatico) {
		this.cambioAutomatico = cambioAutomatico;
	}

	public int getQtdeEixo() {
		return qtdeEixo;
	}

	public void setQtdeEixo(int qtdeEixo) throws QtdeEixoException {
		if(qtdeEixo < 5 || qtdeEixo > 9) {
			throw new QtdeEixoException("Quantidade de Eixo inválida");
		}
		this.qtdeEixo = qtdeEixo;
	}
	
	
	

}
