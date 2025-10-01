package com.aplication.pharmacysystem.Service;

import com.aplication.pharmacysystem.Repository.ProductRepository;
import com.aplication.pharmacysystem.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepo.findById(id);
    }

    public Product updateProduct(Long id, Product updated) {
        return productRepo.findById(id).map(product -> {
            product.setName(updated.getName());
            product.setDescription(updated.getDescription());
            product.setPrice(updated.getPrice());
            product.setQuantityInStock(updated.getQuantityInStock());
            return productRepo.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}

