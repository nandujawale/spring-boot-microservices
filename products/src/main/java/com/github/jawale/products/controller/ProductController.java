package com.github.jawale.products.controller;

import com.github.jawale.products.dto.ProductRequest;
import com.github.jawale.products.dto.ProductResponse;
import com.github.jawale.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void addProduct(ProductRequest productRequest) {
		productService.addProduct(productRequest);
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
}
