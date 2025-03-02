//package com.main.MySQLdb1.Excel;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//public class Helper {
//
//	// check that file is of excel type or not
//	public static boolean checkExcelFormat(MultipartFile file) {
//		
//		String contentType = file.getContentType();
//		
//		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
//	
//	// Convert excel to list of products
//	
//	public List<Product> convertExcelToListOfProducts(InputStream is){
//		List<Product> list = new ArrayList<>();
//		try {
//			
//		    XSSFWorkbook workbook	= new XSSFWorkbook(is);
//			XSSFSheet sheet =workbook.getSheet("data");
//			
//			int rowNumber = 0; 
//			Iterator<Row> iterator = sheet.iterator();
//			
//			while(iterator.hasNext()) {
//				Row row = iterator.next();
//				if(rowNumber == 0) {
//					rowNumber++;
//					continue;
//				}
//				
//			    Iterator<Cell> cells = row.iterator();
//			     
//	//		    int 
//			    
//			    
//			}
//			
//		}catch (Exception e) {
// 			e.printStackTrace();
//		}
//		
//	}
//	
//}
