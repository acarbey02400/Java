
public class Product {
	private int id;
	private String name;
	private double price;
	private double discount;
	private double priceAfterDiscount;
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPriceAfterDiscount() {
		priceAfterDiscount=price-price*discount/100;
		return priceAfterDiscount;
	}
}
