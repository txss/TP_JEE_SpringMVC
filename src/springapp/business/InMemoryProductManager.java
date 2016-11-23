package springapp.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import springapp.model.Product;
import springapp.model.ProductCode;

@Service("productManager")
public class InMemoryProductManager implements ProductManager {

    final Map<Integer, Product> products;
    int maxId = 0;

    public InMemoryProductManager() {
        this.products = new HashMap<Integer, Product>();
        ProductCode pc1 = new ProductCode();
        pc1.setBase("A");
        pc1.setNumber(1000);
        Product p1 = new Product();
        p1.setNumber(100);
        p1.setName("Car");
        p1.setPrice(2000.0);
        p1.setCode(pc1);
        p1.setDescription("Small car");
        products.put(p1.getNumber(), p1);
        Product p2 = new Product();
        ProductCode pc2 = new ProductCode();
        pc2.setBase("B");
        pc2.setNumber(2000);
        p2.setNumber(200);
        p2.setName("Gift");
        p2.setPrice(100.0);
        p2.setCode(pc2);
        p2.setDescription("Big gift");
        products.put(p2.getNumber(), p2);
        maxId = 300;
    }

    @Override
    public Collection<Product> findAll() {
        return products.values();
    }

    @Override
    public void save(Product p) {
        if (p.getNumber() == null) {
            p.setNumber(maxId++);
        }
        products.put(p.getNumber(), p);
    }

    @Override
    public Product find(int number) {
        Product p = products.get(number);
        if (p == null) {
            throw new IllegalArgumentException("no product " + number);
        }
        return p;
    }
}