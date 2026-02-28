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
	
	public void saveFile(List<Product> product) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			for(Product prod : product) {
				bw.write(prod.getId() + ";" 
					   + prod.getName() + ";"
					   + prod.getPrice() + ";"
					   + prod.getDescription() + ";"
					   + prod.getQuantity() + ";"
					   + prod.getCategory().getId() + ";"
					   + prod.getCategory().getName());
				bw.newLine();
			}
			
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public List<Product> fileReader() {
	 		
	 		List<Product> list = new ArrayList<>();
	 		
	 		 try(BufferedReader br = new BufferedReader(new FileReader(path))){
	 			 
	 			 String line = br.readLine();
	 			
	 			 while(line !=  null) {
	 				 String vector[] = line.split(";");
	 				 
	 				 int idReader = Integer.parseInt(vector[0]);
	 				 String nameReader = vector[1];
	 				 double priceReader = Double.parseDouble(vector[2]);
	 				 String descriptionReader = vector[3];
	 				 int quantityReader = Integer.parseInt(vector[4]);
	 				 int idCategoryReader = Integer.parseInt(vector[5]);
	 				 String nameCategoryReader = vector[6];
	 				 
	 				Product product = new Product(idReader, nameReader, priceReader, descriptionReader, quantityReader, new Category(idCategoryReader, nameCategoryReader));
	 				list.add(product);
	 				 
	 				line = br.readLine();
	 				 
	 			 }
	 		 }
	 		 catch(IOException e) {
	 			System.out.println("Erro: " + e.getMessage());
	 		 }
	 		 
	 		return list;
	 	}
	
}
