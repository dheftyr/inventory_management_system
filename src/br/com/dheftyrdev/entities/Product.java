package br.com.dheftyrdev.entities;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private int quantity;

	private Category category;

	public Product() {

	}

	public Product(int id, String name, double price, int quantity, Category category) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public int getQuantity() {

		return quantity;
	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public void addStock(int quant){

		if(quant > 0) {
			this.quantity += quant;
		}
	}

	public Category getCategory() {

		return category;
	}

	public void setCategory(Category category) {

		this.category = category;
	}

	public boolean removeStock(int quant){


		if(quant > 0 && this.quantity >= quant) {
	
			this.quantity -= quant;
	
			return true;
	
		}else {
	
			System.out.println("Erro: Saldo insuficiente ou quantidade inválida.");
			return false;
		}
	}

	@Override
	public String toString(){

		return "Id: " + this.id
		+ "\nNome: " + this.name
		+ "\nQuantidade: " + this.quantity
		+ "\nPreço: " + this.price
		+ "\nCategoria: " + this.category.toString();
	}
}
