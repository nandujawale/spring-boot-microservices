package com.github.jawale.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jawale.inventory.dto.InventoryResponse;
import com.github.jawale.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCodes) {
		return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
				.map(inventory -> new InventoryResponse(inventory.getSkuCode(), inventory.getQuantity() > 0))
				.toList();
	}
}
