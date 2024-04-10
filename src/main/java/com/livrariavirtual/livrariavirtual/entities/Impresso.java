package com.livrariavirtual.livrariavirtual.entities;

public class Impresso extends Livro {
	
	private float frete;
	private int estoque;
	
	public Impresso(String titulo, String autores, String editora, float preco, float frete, int estoque) {
		super(titulo, autores, editora, preco);
		this.frete = frete;
		this.estoque = estoque;
	}

	public float getFrete() {
		return frete;
	}

	public void setFrete(float frete) {
		this.frete = frete;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public void atualizarEstoque(int estoque) {
		this.estoque -= estoque;
	}

	@Override
	public String toString() {
		return 	super.toString()
				+ "frete: R$ " + String.format("%.2f", frete) 
				+ ", estoque: " + estoque;
	}
	
}
