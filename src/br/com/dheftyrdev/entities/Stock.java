package br.com.dheftyrdev.entities;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Product> product;

	public Stock() {

		this.product = new ArrayList<>();
	}

	public List<Product> getProduct() {

		return product;
	}

	public void registerProduct(Product prod){

		product.add(prod);
	}


	public Product searchById(int id) {

		for(Product p: product) {
			
			if(p.getId() == id) {
	
				return p;
			}
		}

		return null;
	}


	public void generateReport() {

		System.out.println("Relatorio dos Produtos");
		
		for(Product p: product) {
	
			System.out.println(p.toString());
		}
	}
}
