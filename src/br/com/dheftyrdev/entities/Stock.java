package br.com.dheftyrdev.entities;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Product> product;
	
	public Stock() {
		product = new ArrayList<>();
	}
	
	public List<Product> getProduct() {
		return product;
	}
	
	public void addProduct(Product product) {
		this.product.add(product);
	}
	
	public void removeProduct(Product product) {
		this.product.remove(product);
	}
	
	public boolean removeStock(int quantity, int id) {
		for(Product pro : product) {
			if(pro.getId() == id) {
				if(quantity <= 0 || pro.getQuantity() < 0) {
					System.out.println("Quantidade inválida ou estoque insufisiente");
					return false;	
				}else {
					pro.setQuantity(pro.getQuantity() - quantity);
					System.out.println("Estoque removido com sucesso!");
					return true;
				}
			}
		}
		
		System.out.println("Produto com ID " + id + " não encontrado");
		return false;
	}
	
	public boolean addStock(int quantity, int id) {
		for(Product pro : product) {
			if(pro.getId() == id) {
				if(quantity <= 0) {
					System.out.println("Quantidade inválida");
					return false;	
				}else {
					pro.setQuantity(pro.getQuantity() + quantity);
					System.out.println("Estoque adicionado com sucesso!");
					return true;
				}
			}
		}
		
		System.out.println("Produto com ID " + id + " não encontrado");
		return false;
	}
	
	public Product searchById(int id) {
		for(Product pro : product) {
			if(pro.getId() == id) {
				return pro;
			}
		}
		
		System.out.println("Produto com ID " + id + " não encontrado");
		
		return null;
	}
	
	public void genereteReport() {
		for(Product prod : product) {
			System.out.println(prod.toString());
		}
	}
}
