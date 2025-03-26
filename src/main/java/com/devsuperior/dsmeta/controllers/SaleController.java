package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleFullDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSumPerSellerDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	@ResponseBody
	public ResponseEntity<Page<SaleFullDTO>> getReport(
			@RequestParam(defaultValue = "") String minDate,
			@RequestParam(defaultValue = "") String maxDate,
			@RequestParam(defaultValue = "") String name, 
			Pageable pageable) {
		//List<SaleFullDTO> result = service.findAll(minDate, maxDate, name);
		Page<SaleFullDTO> result = service.findAllJpql(minDate, maxDate, name, pageable);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleSumPerSellerDTO>> getSummary(
		@RequestParam(defaultValue = "") String minDate,
		@RequestParam(defaultValue = "") String maxDate) {
		//List<SaleSumPerSellerDTO> result = service.findAll(minDate, maxDate);
		List<SaleSumPerSellerDTO> result = service.findAllJpql(minDate, maxDate);		
		return ResponseEntity.ok(result);
	}
}
