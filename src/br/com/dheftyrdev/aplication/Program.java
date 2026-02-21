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
				case 3:
					System.out.println("--------------------------------------------");
					System.out.println("-           Adicionar Quantidade           -");
					System.out.println("--------------------------------------------\n");
					
					addQuantity();
					
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
	
	public static void addQuantity() {
		System.out.println("Qual produto você que adicionar a quantidade?(Selecione pelo código)");
		
		stock.generateReport();
		
		System.out.print("Seliecione o código: ");
		int cod = sc.nextInt();
		sc.nextLine();
		
		while(true) {
			Product result = stock.searchById(cod);
			if(result == null) {
				System.out.println("Produto não existe com esse código");
				
				System.out.print("Seliecione o código ou 0 para sair: ");
				cod = sc.nextInt();
				sc.nextLine();
				if(cod == 0) {
					break;
				}
			}else {
				System.out.print("Qual a qauntidade que deseja adicionar: ");
				int quantity = sc.nextInt();
				result.addStock(quantity);
				sc.nextLine();
				System.out.println("Valor adicionado com sucesso!");
				break;
			}
		}
		
	}
}