package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.Projections.SaleSumProjection;

public class SaleSumPerSellerDTO {

	private String sellerName;
	private Double total;
	
	public SaleSumPerSellerDTO(String sellerName, Double total) {
		this.sellerName = sellerName;
		this.total = total;
	}

	public SaleSumPerSellerDTO(SaleSumProjection projection) {
		sellerName = projection.getSellerName();
		total = projection.getTotal();
	}

	public String getSellerName() {
		return sellerName;
	}

	public Double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "SaleSumPerSellerDTO [sellerName=" + sellerName + ", total=" + total + "]";
	}
	
	
	
}
