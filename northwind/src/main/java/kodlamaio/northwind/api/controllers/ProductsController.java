package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.result.DataResult;
import kodlamaio.northwind.core.utilities.result.Result;
import kodlamaio.northwind.entites.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllDesc")
	 DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product porduct) {
		return this.productService.add(porduct);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName)
	{
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<Product> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam int categoryId)
	{
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
}
