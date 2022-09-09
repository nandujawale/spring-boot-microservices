package com.github.jawale.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.jawale.products.dto.ProductRequest;
import com.github.jawale.products.dto.ProductResponse;
import com.github.jawale.products.model.Product;
import com.github.jawale.products.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;

	public void addProduct(@RequestBody ProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());

		log.info("Saving product {}", product);
		productRepository.save(product);
		log.info("Saved product {}", product);
	}

	public List<ProductResponse> getAllProducts() {
		log.info("Getting all products...");
		return productRepository.findAll().stream()
				.map(this::toProductResponse)
				.toList();
	}

	private ProductResponse toProductResponse(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}
}
