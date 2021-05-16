package oopIntro;

public class Product {
	private int _id;
	private String _name;
	private double _unitPrice;
	private String _detail;
	private double _discount;

	
	public Product() {
		
		System.out.println("Ürün eklemesi baþarýlý.");
		
	}
	public Product(int id, String name,String detail, double unitPrice,double discount)
	{
		this();
		set_id(id);
		set_name(name);
		set_unitPrice(unitPrice);
		set_detail(detail);
		set_discount(discount);
	}
	
	public double get_unitPriceAfterDiscount() {
		return _unitPrice-(_unitPrice*10/100);
	}
	
	
	public double get_discount() {
		return _discount;
	}
	public void set_discount(double _discount) {
		this._discount = _discount;
	}
	public String get_detail() {
		return _detail;
	}
	public void set_detail(String _detail) {
		this._detail = _detail;
	}
	public double get_unitPrice() {
		return _unitPrice;
	}
	public void set_unitPrice(double _unitPrice) {
		this._unitPrice = _unitPrice;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	

	
	

}
