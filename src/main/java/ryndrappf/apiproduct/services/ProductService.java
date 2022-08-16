package ryndrappf.apiproduct.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ryndrappf.apiproduct.models.entities.Product;
import ryndrappf.apiproduct.models.repos.ProductRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> temp = productRepo.findById(id);
        if (!temp.isPresent()){
            return null;
        }
        return temp.get();
    }

    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }

    public void removedOne(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findByNameContains(String name){
        return productRepo.findByNameContains(name);
    }
}
