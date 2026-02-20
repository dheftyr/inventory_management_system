package br.com.dheftyrdev.aplication;

import java.util.Scanner;

import br.com.dheftyrdev.entities.Category;
import br.com.dheftyrdev.entities.Product;
import br.com.dheftyrdev.entities.Stock;

public class Program {
	
	private static Scanner sc = new Scanner(System.in);
	private static Stock stock = new Stock();

	public static void main(String[] args) {	
		
		int op;
		
		do {
			
			Program.menu();
			op = sc.nextInt();
			sc.nextLine();			
			switch(op) {
				case 1:
					System.out.println("--------------------------------------------");
					System.out.println("-           Cadastro de Produtos           -");
					System.out.println("--------------------------------------------");
					
					Program.createdProduct();
					
					
					
					break;
				case 2:
					System.out.println("--------------------------------------------");
					System.out.println("-          Listagem de Relatorios          -");
					System.out.println("--------------------------------------------\n");
					stock.generateReport();
					
					break;
			}
		}while(op != 0);
		
	}

	public static void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("-    Sistema de gerenciamento de Estoque   -");
		System.out.println("--------------------------------------------");
		System.out.println("- 1 -> Cadatro de Produto                  -");
		System.out.println("- 2 -> Listar Relatorio                    -");
		System.out.println("- 3 -> Adicionar Quantidade                -");
		System.out.println("- 0 -> Sair                                -");
		System.out.println("--------------------------------------------");
		System.out.println("Escolha um número referente a opção que deseja!");
	}
	
	public static void createdProduct() {
		System.out.print("Código: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Preço: ");
		double price = sc.nextDouble();
		System.out.print("Quantidade: ");
		int quantity = sc.nextInt();
		sc.nextLine();
		System.out.print("Categoria: ");
		String nameCategory = sc.nextLine();
			
			int idCategory = (int)(Math.random() * 100) + 1;
			
			Product prod = new Product(id, name, price, quantity, new Category(idCategory, nameCategory));
			
			stock.registerProduct(prod);
		}		
}
