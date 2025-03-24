package com.devsuperior.dsmeta;

//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.devsuperior.dsmeta.dto.SaleFullDTO;
//import com.devsuperior.dsmeta.dto.SaleSumPerSellerDTO;
//import com.devsuperior.dsmeta.services.SaleService;

@SpringBootApplication
public class DsmetaApplication implements CommandLineRunner{

	
//	LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
//	LocalDate todayMinusYear = today.minusYears(1L);
//	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	LocalDate minDateJpql, maxDateJpql;
//	String minDate, maxDate, sellerName;
	
	@Autowired
//	private SaleService service; 
	
	public static void main(String[] args) {
		SpringApplication.run(DsmetaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

/*
		System.out.println("today "+ today);
		System.out.println("today "+ todayMinusYear);
		
		//.INPUTS SUMMARY
		minDate = "2022-01-01";
		maxDate = "2022-06-30";
		
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("==== SUMÁRIO DE VENDAS : minDate=2022-05-01 & maxDate=2022-05-31 & nome=odison ===");				
		System.out.println();
				
		System.out.println("minDate, maxDate " + minDate + " " + maxDate);
		
		List<SaleSumPerSellerDTO> list1 = service.findAll(minDate, maxDate);

		System.out.println();
		System.out.println("=== RESULT SQL NATIVE ========================================================================");
		System.out.println();
		for(SaleSumPerSellerDTO obj : list1) {
			System.out.println(obj);
		}

		System.out.println();
		
		List<SaleSumPerSellerDTO> result1 = service.findAllJpql(minDate, maxDate);
		
		for(SaleSumPerSellerDTO obj : result1) {
			System.out.println(obj);
		}

		
		System.out.println();
		System.out.println("==============================================================================================");
		System.out.println("==== RELATÓRIO DE VENDAS : minDate=2022-05-01 & maxDate=2022-05-31 & nome=odison ===");				
		System.out.println();

		//.INPUTS REPORT
		minDate = "2022-05-01";
		maxDate = "2022-05-31";
		sellerName = "ODINSON";

		System.out.println("minDate, maxDate e sellerName " + minDate + " " + maxDate + " " + sellerName);
		
		List<SaleFullDTO> list2 = service.findAll(minDate, maxDate, sellerName);
		
		System.out.println();
		System.out.println("=== RESULT SQL NATIVE ========================================================================");
		System.out.println();
		for(SaleFullDTO obj : list2) {
			System.out.println(obj);
		}

		System.out.println();
		
		List<SaleFullDTO> result3 = service.findAllJpql(minDate, maxDate, sellerName);

		System.out.println();
		System.out.println("=== RESULT PLQL ==============================================================================");
		System.out.println();
		for(SaleFullDTO obj : result3) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("==============================================================================================");		
*/		
		
	}
}
