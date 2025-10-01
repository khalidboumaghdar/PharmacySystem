package com.aplication.pharmacysystem.Repository;

import com.aplication.pharmacysystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
