package com.devsuperior.dsmeta.services;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmeta.Projections.SaleReportProjection;
import com.devsuperior.dsmeta.Projections.SaleSumProjection;
import com.devsuperior.dsmeta.dto.SaleFullDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSumPerSellerDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	LocalDate todayMinusYear = today.minusYears(1L);
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate maxDateAux;
	LocalDate minDateJpql, maxDateJpql;
		
	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	/*============================================================================================
	 * SUMMARY DE VENDAS
	 * =========================================================================================*/
	@Transactional(readOnly = true)
	public List<SaleSumPerSellerDTO> findAll(String minDate, String maxDate) {
		if (maxDate == "") {
			maxDate = today.format(fmt1);
		}
		if(minDate == "") {
			maxDateAux = LocalDate.parse(maxDate, fmt1);
			minDate = maxDateAux.minusYears(1L).format(fmt1);
		}
		List<SaleSumProjection> result = repository.searchSaleSum(minDate, maxDate);
		return result.stream().map(x -> new SaleSumPerSellerDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public List<SaleSumPerSellerDTO> findAllJpql(String minDate, String maxDate) {
		if (maxDate.isBlank() || maxDate.isEmpty()) {
			maxDateJpql = today;
		} else {
			maxDateJpql = LocalDate.parse(maxDate, fmt1);
		}
		if(minDate.isBlank() || minDate.isEmpty()) {
			minDateJpql = maxDateJpql.minusYears(1L);
		} else {
			minDateJpql = LocalDate.parse(minDate, fmt1);
		}
		List<SaleSumPerSellerDTO> result = repository.searchSaleSumJpql(minDateJpql, maxDateJpql);
		return result;
	}


	/*============================================================================================
	 * REPORT DE VENDAS
	 * =========================================================================================*/
	@Transactional(readOnly = true)
	public List<SaleFullDTO> findAll(String minDate, String maxDate, String name){
		if (maxDate == "") {
			maxDate = today.format(fmt1);
		}
		if(minDate == "") {
			maxDateAux = LocalDate.parse(maxDate, fmt1);
			minDate = maxDateAux.minusYears(1L).format(fmt1);
		}
		List<SaleReportProjection> resultRep = repository.searchSaleRep(minDate, maxDate, name);
		return resultRep.stream().map(x -> new SaleFullDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public Page<SaleFullDTO> findAllJpql(String minDate, String maxDate, String name, Pageable pageable){
		
		if (maxDate.isEmpty() || maxDate.isBlank()) {
			maxDateJpql = today;
		} else {
			maxDateJpql = LocalDate.parse(maxDate, fmt1);
		}
		if(minDate.isEmpty() || minDate.isBlank()) {
			minDateJpql = maxDateJpql.minusYears(1L);
		} else {
			minDateJpql = LocalDate.parse(minDate, fmt1);
		}

		Page<SaleFullDTO> resultRep = repository.searchSaleRepJpql(minDateJpql, maxDateJpql, name, pageable);
		return resultRep;

	}

}
