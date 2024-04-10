package com.livrariavirtual.livrariavirtual;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livrariavirtual.livrariavirtual.entities.LivrariaVirtual;
import com.livrariavirtual.livrariavirtual.entities.Venda;

@SpringBootApplication
public class LivrariavirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariavirtualApplication.class, args);

		Scanner sc = new Scanner(System.in);

		LivrariaVirtual livraria = new LivrariaVirtual();

		int opcao = 0;

		do {
			menu();
			if (sc.hasNextInt()) {
				opcao = sc.nextInt();
			} else {
				System.out.print("\nPor favor, digite um número inteiro válido: ");
				sc.nextLine();
				opcao = sc.nextInt();
			}
			
			switch (opcao) {
			case 1:
				livraria.cadastrarLivro(sc);
				break;
			case 2:
				livraria.realizarVenda(sc);
				break;
			case 3:
				livraria.listarLivros();
				break;
			case 4:
				livraria.listarVendas();
				break;
			case 5:
				System.out.println("\nFim do programa! Até logo!");
				break;
			default:
				System.out.println("\nOpção invalida! Digite uma opção de 1 a 5\n");
				break;
			}

		} while (opcao != 5);

		sc.close();
	}

	public static void menu() {

		System.out.print("Menu:\n" 
				+ "	1 - Cadastrar livro\n" 
				+ "	2 - Realizar uma venda\n" 
				+ "	3 - Listar livros\n"
				+ "	4 - Listar vendas\n" 
				+ "	5 - sair do programa\n" + "\n" 
				+ "Digite o valor da opção desejada: ");

	}

}
