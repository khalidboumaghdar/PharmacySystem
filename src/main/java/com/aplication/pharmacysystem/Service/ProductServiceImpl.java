package com.aplication.pharmacysystem.Service;

import com.aplication.pharmacysystem.Repository.ProductRepository;
import com.aplication.pharmacysystem.model.Product;
import com.aplication.pharmacysystem.DTO.ProductDTO;
import com.aplication.pharmacysystem.DTO.ProductCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public ProductDTO createProduct(ProductCreateDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantityInStock(dto.getQuantityInStock());

        Product saved = productRepo.save(product);
        return convertToDTO(saved);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProduct(Long id) {
        return productRepo.findById(id).map(this::convertToDTO);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductCreateDTO dto) {
        return productRepo.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setQuantityInStock(dto.getQuantityInStock());
            return convertToDTO(productRepo.save(product));
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    private ProductDTO convertToDTO(Product p) {
        return new ProductDTO(p.getName(), p.getDescription(), p.getPrice(), p.getQuantityInStock());
    }
}
