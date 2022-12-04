
public class searchbyproducts {
	private int productID;
	private String name;
	private String description;
	private float cost;
	
	public searchbyproducts(String name, String description, float cost) {
		super();
		this.name = name;
		this.description = description;
		this.cost = cost;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "searchbyproducts [productID=" + productID + ", name=" + name + ", description=" + description
				+ ", cost=" + cost + "]";
	}

	
	
	
	
	
	
	
	

}
