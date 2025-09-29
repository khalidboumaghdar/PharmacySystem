package com.aplication.pharmacysystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fondateurs")
public class Fondateur extends User {
    @OneToMany(mappedBy = "fondateur")
    private List<Product> products = new ArrayList<>();
}
