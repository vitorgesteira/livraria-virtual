package com.livrariavirtual.livrariavirtual.entities;

import java.util.Scanner;

public class LivrariaVirtual {

	private static final int MAX_IMPRESSOS = 10;
	private static final int MAX_ELETRONICOS = 20;
	private static final int MAX_VENDAS = 50;

	private Impresso[] impressos;
	private Eletronico[] eletronicos;
	private Venda[] vendas;

	private int numImpressos;
	private int numEletronicos;
	private int numVendas;

	public LivrariaVirtual() {
		this.impressos = new Impresso[MAX_IMPRESSOS];
		this.eletronicos = new Eletronico[MAX_ELETRONICOS];
		this.vendas = new Venda[MAX_VENDAS];
		this.numImpressos = 0;
		this.numEletronicos = 0;
		this.numVendas = 0;
	}

	public void cadastrarLivro(Scanner sc) {
		System.out.println();
		System.out.print("Tipo do livro (1-impresso | 2-eletronico | 3-ambos): ");
		int tipoLivro = sc.nextInt();
		sc.nextLine();

		while (tipoLivro != 1 && tipoLivro != 2 && tipoLivro != 3) {
			System.out.println();
			System.out.println("Opção invalida!");
			System.out.print("Digite a opção correta (1-impresso | 2-eletronico | 3-ambos): ");
			tipoLivro = sc.nextInt();
			sc.nextLine();
		}

		System.out.print("\nInforme os dados do livro ");
		if (tipoLivro == 1) {

			System.out.println("impresso:");

			if (numImpressos < MAX_IMPRESSOS) {
				System.out.print("\nTitulo: ");
				String titulo = sc.nextLine();

				System.out.print("Autores: ");
				String autores = sc.nextLine();

				System.out.print("Editora: ");
				String editora = sc.nextLine();

				System.out.print("Preco R$ ");
				float preco = sc.nextFloat();

				System.out.print("Frete: R$ ");
				float frete = sc.nextFloat();

				System.out.print("Estoque: ");
				int estoque = sc.nextInt();

				Impresso novoImpresso = new Impresso(titulo, autores, editora, preco, frete, estoque);
				impressos[numImpressos] = novoImpresso;
				numImpressos++;
			} else {
				System.out.println("\nNão há mais espaço para cadastrar livros impressos.\n");
			}

		}
		if (tipoLivro == 2) {

			System.out.println("eltronico:");

			if (numEletronicos < MAX_ELETRONICOS) {
				System.out.print("\nTitulo: ");
				String titulo = sc.nextLine();

				System.out.print("Autores: ");
				String autores = sc.nextLine();

				System.out.print("Editora: ");
				String editora = sc.nextLine();

				System.out.print("Preco R$ ");
				float preco = sc.nextFloat();

				System.out.print("Tamanho: ");
				int tamanho = sc.nextInt();

				Eletronico novoEletronico = new Eletronico(titulo, autores, editora, preco, tamanho);
				eletronicos[numEletronicos] = novoEletronico;
				numEletronicos++;
			} else {
				System.out.println("\nNão há mais espaço para cadastrar livros eletronico.\n");
			}

		}
		if (tipoLivro == 3) {
			System.out.println("impresso e eletronico:");

			System.out.print("\nTitulo: ");
			String titulo = sc.nextLine();

			System.out.print("Autores: ");
			String autores = sc.nextLine();

			System.out.print("Editora: ");
			String editora = sc.nextLine();

			System.out.print("Preco R$ ");
			float preco = sc.nextFloat();

			System.out.print("Frete: R$ ");
			float frete = sc.nextFloat();

			System.out.print("Estoque: ");
			int estoque = sc.nextInt();

			System.out.print("Tamanho: ");
			int tamanho = sc.nextInt();

			Impresso novoImpresso = new Impresso(titulo, autores, editora, preco, frete, estoque);
			impressos[numImpressos] = novoImpresso;
			numImpressos++;

			Eletronico novoEletronico = new Eletronico(titulo, autores, editora, preco, tamanho);
			eletronicos[numEletronicos] = novoEletronico;
			numEletronicos++;

		}

	}

	public void realizarVenda(Scanner sc) {

		if (numVendas < MAX_VENDAS) {
			
			sc.nextLine();
			System.out.print("\nNome: ");
			String nome = sc.nextLine();
			
			Venda novaVenda = new Venda(nome);

			System.out.print("\nQuantidade de livros que deseja comprar: ");
			int qtdLivros = sc.nextInt();

			for (int i = 0; i < qtdLivros; i++) {
				
				sc.nextLine();
				System.out.print("\nEscolha o tipo de livro (impresso ou eletrônico): ");
				String tipoLivro = sc.nextLine();

				if (tipoLivro.equalsIgnoreCase("impresso")) {
					
					listarLivrosImpressos();
					
					System.out.print("\nEscolha o livro pelo codigo: ");
					int cod = sc.nextInt();
					
					if (cod >= 0 && cod < impressos.length) {
						
	                    novaVenda.addLivro(impressos[cod - 1]);
	                    
	                } else {
	                    System.out.println("\nCódigo do livro impresso inválido.");
	                    i--;
	                    continue;
	                }
					
				} else if (tipoLivro.equalsIgnoreCase("eletronico")) {
					
					listarLivrosEletronicos();
					
					System.out.print("\nEscolha o livro pelo codigo: ");
					int cod = sc.nextInt();
					
					if (cod >= 0 && cod < eletronicos.length) {
	                    
						novaVenda.addLivro(eletronicos[cod - 1]);
						
	                } else {
	                	
	                    System.out.println("\nCódigo do livro eletrônico inválido.");
	                    i--;
	                    continue;
	                    
	                }
					
				} else {
					
					System.out.println("\nTipo de livro inválido. Por favor, insira 'impresso' ou 'eletronico'.");
					i--;
					continue;
					
				}	
				
			}
			
			vendas[numVendas] = novaVenda;
			numVendas ++;
			
		}
		else {
			System.out.println("Não ha espaço para realizar vendas!");
		}

	}

	public void listarLivrosImpressos() {

		System.out.println("\nLivros Impresso Cadastrados:");
		System.out.println();
		for (int i = 0; i < impressos.length; i++) {

			if (impressos[i] != null) {
				System.out.println("Codigo " + (i+1) + " - " + impressos[i].toString());
			}

		}

	}

	public void listarLivrosEletronicos() {

		System.out.println("\nLivros Eletronico Cadastrados:");
		System.out.println();

		for (int i = 0; i < eletronicos.length; i++) {

			if (eletronicos[i] != null) {
				System.out.println("Codigo " + (i+1) + " - " + eletronicos[i].toString());
			}

		}

	}

	public void listarLivros() {

		listarLivrosImpressos();
		listarLivrosEletronicos();
	}

	public void listarVendas() {
		System.out.println("\nVendas realizadas:");
		System.out.println();
		
		for (int i = 0; i < vendas.length; i++) {
			
			if (vendas[i] != null) {
				System.out.println(vendas[i].toString());
				System.out.println();
			}
		}
	}
}
