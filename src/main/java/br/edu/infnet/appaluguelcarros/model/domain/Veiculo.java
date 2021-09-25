package br.edu.infnet.appaluguelcarros.model.domain;

public abstract class Veiculo {
	private String nomeCarro;
	private String cor;
	private int qtdeDias;
	private boolean disponivel;
	private float valor;
	
	
	public Veiculo(String nomeCarro, String cor, int qtdeDias, boolean disponivel, float valor) {
		this.nomeCarro = nomeCarro;
		this.cor = cor;
		this.qtdeDias = qtdeDias;
		this.disponivel = disponivel;
		this.valor = valor;
	}
	
	public abstract float valorAluguel();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nomeCarro);
		sb.append(";");
		sb.append(cor);
		sb.append(";");
		sb.append(qtdeDias);
		sb.append(";");
		sb.append(disponivel ? "Disponível" : "Indisponível");
		sb.append(";");
		sb.append(valor);
		return sb.toString();
	}

	public String getNomeCarro() {
		return nomeCarro;
	}

	public String getCor() {
		return cor;
	}

	public int getQtdeDias() {
		return qtdeDias;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public float getValor() {
		return valor;
	}
	
	
}
