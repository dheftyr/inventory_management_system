package br.com.dheftyrdev.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.dheftyrdev.entities.Category;
import br.com.dheftyrdev.entities.Product;

public class FileService {
	
	private String path = "data.csv";
	
	public void save(List<Product> products) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			for(Product prod : products) {
				
				bw.write(prod.getId() + ";" 
					   + prod.getName() + ";"
					   + prod.getPrice() + ";"
					   + prod.getDescription() + ";"
					   + prod.getQuantity() + ";"
					   + prod.getCategory().getId() + ";"
					   + prod.getCategory().getName());
				
				bw.newLine();
			}
		}catch(IOException e) {
			
			System.out.println("Erro ao salvar arquivo: " + e.getMessage());
		}
	}
	
	public List<Product> load() {
	 		
		List<Product> products = new ArrayList<>();
	 		
	 		try(BufferedReader br = new BufferedReader(new FileReader(path))){
	 			 
	 			String line = br.readLine();
	 			
	 			 while(line !=  null) {
	 				 
	 				 if(!line.trim().isEmpty()) {
	 				 
		 				 String fields[] = line.split(";");
		 				 
		 				 int id = Integer.parseInt(fields[0]);
		 				 String name = fields[1];
		 				 double price = Double.parseDouble(fields[2]);
		 				 String description = fields[3];
		 				 int quantity = Integer.parseInt(fields[4]);
		 				 int categoryId = Integer.parseInt(fields[5]);
		 				 String categoryName = fields[6];
		 				 
		 				Product product = new Product(id, name, price, description, quantity, new Category(categoryId, categoryName));
		 				products.add(product);
	 				 }
		 				
	 				line = br.readLine();
	 			 }
	 		 }catch(IOException e) {
	 			 
	 			System.out.println("Erro ao ler arquivo: " + e.getMessage());
	 		 }
	 		 
	 		return products;
	}
}