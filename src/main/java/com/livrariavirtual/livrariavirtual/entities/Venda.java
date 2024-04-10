package com.livrariavirtual.livrariavirtual.entities;

import java.util.ArrayList;
import java.util.List;

public class Venda {

	private List<Livro> livros;
	private static int numVendas;
	private int numero;
	private String cliente;
	private float valor;
	
	public Venda(String cliente) {
		this.livros = new ArrayList<>();
		numVendas ++;
		numero = numVendas;
		this.cliente = cliente;
		this.valor = 0;
	}
	
	public void addLivro(Livro livro) {
		this.livros.add(livro);		
		
		for(Livro x : livros) {
			if(x instanceof Impresso) {
				valor += ((Impresso)x).getFrete();
			}
		}
		valor += livro.getPreco();
	}
	
	public void listarLivros() {
		System.out.println("Livros da venda número " + numero + " para o cliente " + cliente + ":");
		for (Livro livro : livros) {
			System.out.println("- " + livro.getTitulo() + " R$ " + String.format("%.2f\n", livro.getPreco()));
		}
	}

	@Override
	public String toString() {
		return "Venda " + numero + "\n" 
				+ "cliente: " + cliente + " - "
				+ "livros: " + livros + ", "
				+ "valor total: R$ " + String.format("%.2f", valor);
	}		
	
}
