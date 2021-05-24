package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class ProductManager implements ProductService {

	ProductDao productDao;
	LoggerService _loggerService;
	public ProductManager(ProductDao productDao, LoggerService loggerService) {
		super();
		_loggerService=loggerService;
		this.productDao = productDao;
	}

	@Override
	public void add(Product product) {
		if(product.getCategoryId()==1) {
			System.out.println("Bu kategoride ürün kabul edilmiyor...");
		return;
		}
		this.productDao.add(product);
		_loggerService.logToSystem("Ürün eklemesi yapýldý :"+ product.getName());
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
