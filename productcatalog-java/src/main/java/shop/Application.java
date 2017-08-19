package shop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
	private ProductRepository productRepository;

    @RequestMapping("/health")
    public @ResponseBody String health() {
        return "ProductCatalog 1.6";
    }

    @RequestMapping("/api/products")
    public @ResponseBody Iterable<Product> products() {
        return productRepository.findAll();
    }

    @RequestMapping("/api/products-memory")
    public @ResponseBody List<Product> productsMemory() {
        List<Product> products=new ArrayList<Product>();
        products.add(new Product("product1"));
        products.add(new Product("product2"));
        products.add(new Product("product3"));
        return products;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
