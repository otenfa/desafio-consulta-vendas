package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.Projections.SaleReportProjection;
import com.devsuperior.dsmeta.entities.Sale;

public class SaleFullDTO {

	private Long id;
	private LocalDate date;
	private Double amount;
	private String sellerName;
	
	public SaleFullDTO(Long id, LocalDate date, Double amount, String sellerName) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.sellerName = sellerName;
	}
	
	public SaleFullDTO(SaleReportProjection projection) {
		id = projection.getId();
		amount = projection.getAmount();
		date = projection.getDate();
		sellerName = projection.getSellerName();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public String getSellerName() {
		return sellerName;
	}

	@Override
	public String toString() {
		return "SaleFullDTO [id=" + id 
				+ ", date=" + date 
				+ ", amount=" + amount 
				+ ", sellerName=" + sellerName + "]";
	}
	
	
	
	
}
