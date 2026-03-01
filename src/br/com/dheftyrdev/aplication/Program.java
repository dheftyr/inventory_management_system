package br.com.dheftyrdev.aplication;

import java.util.List;
import java.util.Scanner;

import br.com.dheftyrdev.entities.Category;
import br.com.dheftyrdev.entities.Product;
import br.com.dheftyrdev.entities.Stock;
import br.com.dheftyrdev.services.FileService;

public class Program {

	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int op = 5;
		
		Stock stock = new Stock();
		FileService fs = new FileService();
		
		List<Product> listFromFile = fs.load(); 
		for (Product p : listFromFile) {
		    stock.addProduct(p);
		}
		
		
		
		do {
			
			menu();
			op = readInt("Ecolha a opção desejada referente ao menu: \n-> ");
			
			switch(op) {
				case 1:
						System.out.println("-------------------------------------------");
						System.out.println("|          Cadastro de produtos           |");
						System.out.println("-------------------------------------------");
						
							int idAdd = stock.getProduct().size() + 1;
							String nameAdd = readString("Nome: ");
							double priceAdd = readDouble("Preço: ");
							String descriptionAdd = readString("Descrição: ");
							int quantityAdd = readInt("Quantidade: ");
							String nameCategoriaAdd = readString("Categoria: ");
							int idCategoryAdd = stock.getProduct().size() + 1;
							
							Product prod = new Product(idAdd, nameAdd, priceAdd, descriptionAdd, quantityAdd, new Category(idCategoryAdd, nameCategoriaAdd));
							
							stock.addProduct(prod);
							
							fs.save(stock.getProduct());
					
					break;
				case 2:
						System.out.println("-------------------------------------------");
						System.out.println("|            Remover do Estoque           |");
						System.out.println("-------------------------------------------");
						
						stock.genereteReport();
						
						int idRemoveStock = readInt("Id que deseja adicionar: ");
						int quantityRemoveStock = readInt("Quantidade que deseja adicionar: ");
						
						stock.removeStock(quantityRemoveStock, idRemoveStock);
						
						fs.save(stock.getProduct());
					
					break;
				case 3:
						System.out.println("-------------------------------------------");
						System.out.println("|           Adicionar no Estoque          |");
						System.out.println("-------------------------------------------");
						
						stock.genereteReport();
						
						int idAddStock = readInt("Id que deseja adicionar: ");
						int quantityAddStock = readInt("Quantidade que deseja adicionar: ");
						
						stock.addStock(quantityAddStock, idAddStock);
						
						fs.save(stock.getProduct());
						
					break;
				case 4: 
						System.out.println("-------------------------------------------");
						System.out.println("|          Relatório dos Produtos         |");
						System.out.println("-------------------------------------------");
						
						stock.genereteReport();
						
					break;
				case 5:
						System.out.println("-------------------------------------------");
						System.out.println("|             Procurar pelo ID            |");
						System.out.println("-------------------------------------------");
						
						int searchById = readInt("Id que deseja procurar: ");
						Product returnProduct = stock.searchById(searchById);
						System.out.println(returnProduct);
						
					break;
				case 0:
						System.out.println("Saindo do programa!");
						
					break;
				default:
						System.out.println("Digite apenas a opção referente ao menu.");
						
					break;
					
			}
			
			
		}while(op != 0);
		
		keyboard.close();

	}
	
	public static void menu() {
		
		System.out.println("-------------------------------------------");
		System.out.println("|    Gestão de Gereciamento de Estoque    |");
		System.out.println("-------------------------------------------");
		System.out.println("|  -> 1 Cadatrar produtos                 |");
		System.out.println("|  -> 2 Remover do estoque                |");
		System.out.println("|  -> 3 Adicionar no estoque              |");
		System.out.println("|  -> 4 Relatório dos produtos            |");
		System.out.println("|  -> 5 Procurar pelo ID                  |");
		System.out.println("|  -> 0 Sair                              |");
		System.out.println("-------------------------------------------");
	}
	
	public static int readInt(String mensagem) {
        int number = 0;
        
        while (true) {
            System.out.print(mensagem);
            String prohibited = keyboard.nextLine();

            try {
                number = Integer.parseInt(prohibited.replace(",", "."));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: '" + prohibited + "' não é um número válido. Tente novamente.");
            }
        }
       
        return number;
        
    }
	
	public static String readString(String mensagem) {
	    String text = "";

	    while (true) {
	        System.out.print(mensagem);
	        text = keyboard.nextLine().trim(); 

	        if (!text.isEmpty()) {
	            break; 
	        } else {
	            System.out.println("Erro: O nome do produto não pode ficar em branco.");
	        }
	    }
	    
	    return text;
	}
	
	public static double readDouble(String mensagem) {
	    double number = 0;

	    while (true) {
	        System.out.print(mensagem);
	        String prohibited = keyboard.nextLine();

	        try {
	            number = Double.parseDouble(prohibited.replace(",", "."));
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("Erro: '" + prohibited + "' não é um valor decimal válido. Tente novamente.");
	        }
	    }
	    
	    return number;
	}
}
