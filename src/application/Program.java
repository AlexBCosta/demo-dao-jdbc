package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST: 1 " + "seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		

		System.out.println("\n === TEST: 2 " + "seller findByDepartment ===");
		Department department = new Department(3, null);

		List<Seller> listaSeller = sellerDao.findByDepartment(department);

		for (Seller sellers : listaSeller) {
			System.out.println(sellers);
		}
		
		
		System.out.println("\n === TEST: 3 " + "seller insert ===");
		Department dep = new Department(2, null);
		Seller newSeller = new Seller(null, "Jabuticaba", "binha@gmail.com", new Date(), 3000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! new id = " + newSeller.getId());
		
		
		System.out.println("\n === TEST: 4 " + "seller findAll ===");

		List<Seller> SellerList = sellerDao.findAll();

		for (Seller sellers : SellerList) {
			System.out.println(sellers);
		}
		
	
	}

}
