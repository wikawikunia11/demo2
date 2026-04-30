package com.example.demo2.service;

import com.example.demo2.dto.ProductDTO;
import com.example.demo2.model.Product;
import com.example.demo2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> products= productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product prod : products){
            ProductDTO dto = new ProductDTO(
                prod.getId(),
                prod.getName(),
                prod.getPrice()
            );
            productDTOs.add(dto);
        }

        return productDTOs;
    }

//    public List<ProductDTO> getAllproducts(){
//        return productRepository.findAll()
//                .stream().map(product -> new ProductDTO(
//                        product.getId(),
//                        product.getName(),
//                        product.getPrice()
//                ))
//                .toList();
//        }
//    }
}
