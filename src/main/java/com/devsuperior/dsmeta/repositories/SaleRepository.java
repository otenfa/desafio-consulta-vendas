package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.Projections.SaleReportProjection;
import com.devsuperior.dsmeta.Projections.SaleSumProjection;
import com.devsuperior.dsmeta.dto.SaleFullDTO;
import com.devsuperior.dsmeta.dto.SaleSumPerSellerDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {


//--- SUMMARY	
	@Query(nativeQuery = true, value="SELECT tb_seller.name AS sellerName, SUM(tb_sales.amount) AS total "
			+ "FROM tb_sales "
			+ "INNER JOIN tb_seller ON tb_seller.id = tb_sales.seller_id "
			+ "AND tb_sales.date BETWEEN :minDate AND :maxDate "
			+ "GROUP BY tb_seller.name")
	List<SaleSumProjection> searchSaleSum(String minDate, String maxDate);
	
	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSumPerSellerDTO(obj.seller.name, SUM(obj.amount)) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :minDate AND :maxDate "
			+ "GROUP BY obj.seller.name")
	List<SaleSumPerSellerDTO> searchSaleSumJpql(LocalDate minDate, LocalDate maxDate);
	

//--- REPORT	
	@Query(nativeQuery = true, value="SELECT tb_sales.id, tb_sales.date, "
			+ "tb_sales.amount, tb_seller.name AS sellerName "
			+ "FROM tb_sales "
			+ "INNER JOIN tb_seller ON tb_seller.id = tb_sales.seller_id "
			+ "WHERE tb_sales.date BETWEEN :minDate AND :maxDate "
			+ "AND UPPER(tb_seller.name) LIKE UPPER(CONCAT('%',:name,'%'))")
	List<SaleReportProjection> searchSaleRep(String minDate, String maxDate, String name);
	
	@Query("SELECT new com.devsuperior.dsmeta.dto.SaleFullDTO(obj.id, obj.date, "
			+ "obj.amount, obj.seller.name AS sellerName) "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :minDate AND :maxDate "
			+ "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%',:name,'%'))")
	Page<SaleFullDTO> searchSaleRepJpql(LocalDate minDate, LocalDate maxDate, String name, Pageable pageable);
	
}
