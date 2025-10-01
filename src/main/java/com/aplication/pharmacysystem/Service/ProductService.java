package com.aplication.pharmacysystem.Service;

import com.aplication.pharmacysystem.DTO.ProductDTO;
import com.aplication.pharmacysystem.DTO.ProductCreateDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO createProduct(ProductCreateDTO dto);
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProduct(Long id);
    ProductDTO updateProduct(Long id, ProductCreateDTO dto);
    void deleteProduct(Long id);
}
