import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;
public class Products {
	
	private ArrayList<Products> Products;
	private Connection connectin = null;
	private Statement statement = null;
	private PreparedStatement prepStatement = null;
	private ResultSet resultSet = null;
	
	public Products() {
		Products = new ArrayList<>();
	}
	public ArrayList<Products> getAll(){

		try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/myStore","root","root");
		statement = connection.createStatement();
		resultSet = statement.executeQuery("Select * from Products");
		System.out.println();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString(2));
			
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Products;
	}
	public void addProduct(Products p) {
		if (p != null) {
			Products.add(p);
		}
	}
	public ArrayList<Products> searchbyName(String name){
		ArrayList<Products> results = new ArrayList<>();
		if(Products != null){
			for (Products product : Products) {
				if (product.getName().contains(name)) {
				results.add(product);
			}
		}
		}	
	return results;
	}
private ArrayList<Products> getName() {
		// TODO Auto-generated method stub
		return null;
	}
public void printAll() {
	for(Products product : Products) {
		System.out.println(product.getName() + " " + product.getProdID());
	}
}
private ArrayList<Products> getProdID() {
	// TODO Auto-generated method stub
	return null;
}

}
