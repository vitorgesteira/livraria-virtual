package com.livrariavirtual.livrariavirtual.entities;

public class Eletronico extends Livro {
	
	private int tamanho;
	
	public Eletronico(String titulo, String autores, String editora, float preco, int tamanho) {
		super(titulo, autores, editora, preco);
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return super.toString() + "tamanho = " + tamanho + "KB";
	}
	
}
