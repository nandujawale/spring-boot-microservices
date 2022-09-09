package com.github.jawale.products.controller;

import com.github.jawale.products.dto.ProductRequest;
import com.github.jawale.products.dto.ProductResponse;
import com.github.jawale.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void addProduct(@RequestBody ProductRequest productRequest) {
		productService.addProduct(productRequest);
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
}
