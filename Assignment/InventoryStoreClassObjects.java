import java.util.*;
class products{
	double costant;
	int count;
	String specific;
	String Name;
	products(String name,String spec,double cost,int count){
		this.costant = cost;
		this.count = count;
		this.Name = name;
		this.specific = spec;
	}
	public int productCount() {
		return this.count;
	}
	public void productDetails() {
		System.out.println("product name : "+this.Name);
		System.out.println("product Specification : "+this.specific);
		System.out.println("product cost : "+this.costant);
		System.out.println("product count : "+this.count);
		System.out.println();
	}
	public void editOrUpdate(String spec) {
		this.specific = spec;
	}
	public void editProductName(String name) {
		this.Name = name;
	}
	public String getProduct() {
		return this.Name;
	}
	public void editOrUpdate(int count) {
		this.count = count;
	}
	public void editOrUpdate(double cost) {
		this.costant = cost;
	}
}

public class InventoryStoreClassObjects {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("No of products is\n ");
		int n = sc.nextInt();
		sc.nextLine();
		List<products>list = new ArrayList<products>();
		System.out.println("Enter productName,  Specification,  cost,  count : \n");
		for(int i = 0 ; i < n ; i++) {
			String t = sc.nextLine();
			String []arr = t.split(" ");
			String name = arr[0];
			String spec = arr[1];
			double cost = Double.parseDouble(arr[2]);
			int count = Integer.parseInt(arr[3]);
			products p1 = new products(name,spec,cost,count);
			list.add(p1);
			System.out.println();
		}
		boolean f = true;
		while(f != false) {
			System.out.println("==========================================");
			System.out.println("||       	1.Product List             ||");
			System.out.println("||       	2.Product count            ||");
			System.out.println("||       	3.Product details          ||");
			System.out.println("||       	4.Edit product details     ||");
			System.out.println("||       	5.Update Inventory         ||");
			System.out.println("||       	6.Exit                     ||");
			System.out.println("==========================================");
			System.out.println("	Enter your choice ");
			int choice = sc.nextInt();
			if(choice == 1) {
					productList(list);
			}else if(choice == 2) {
				productcount(list);
			}else if(choice == 3) {
				productdetails(list);
			}else if(choice == 4) {
				editproduct(list);
			}else if(choice == 5) {
				updateInventory(list);
			}else if(choice  == 6) {
				f = false;
			}else {
					System.out.println("Enter choice between 1 - 6 ");
			}
			
		}
		sc.close();
	}
	public static void productList(List<products> list) {
		if(list.size() == 0) {
			System.out.println("EMPTY...... ");
			return;
		}
		int i = 1 ;
		for(products p:list)
			System.out.println((i++) + " " +p.getProduct());
		System.out.println();
	}
	public static void updateInventory(List<products> list) {
		System.out.println("-----------------------");
		System.out.println("   1. Add poduct");
		System.out.println("   2. Delete product");
		System.out.println("Enter your choice");System.out.println();
		sc.nextLine();
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("Enter productName,Specification,cost,count : ");
			sc.nextLine();
			String t = sc.nextLine();
			String []arr = t.split(" ");
			String name = arr[0];
			String spec = arr[1];
			double cost = Double.parseDouble(arr[2]);
			int count = Integer.parseInt(arr[3]);
			products p1 = new products(name,spec,cost,count);
			list.add(p1);
		}else {
			System.out.println("Enter name to delete product : ");
			sc.nextLine();
			String pname = sc.nextLine();
			int i = 0;
			for(products p: list) {
				if((p.getProduct()).compareToIgnoreCase(pname) == 0) {
					break;
				}
				i++;
			}
			if(i == list.size())
				System.out.println("product not found");
			else {
				list.remove(i);
				System.out.println("Product removed successfully");
			}
		}
	}
	public static void editproduct(List<products> list) {
		System.out.println("Enter product name : ");
		sc.nextLine();
		String pname = sc.nextLine();
		for(products p: list) {
			if(p.getProduct().compareToIgnoreCase(pname) == 0) {
				System.out.println("what do you want to edit :\n1.Specification\n2.Cost\n3.Product count");
				int ch = sc.nextInt();
				if(ch == 1) {
					System.out.println("Enter product specification ");
					sc.nextLine();
					String st = sc.nextLine();
					p.editOrUpdate(st);
				}else if(ch == 2) {
					System.out.println("Enter product cost ");
					double cost = sc.nextDouble();
					p.editOrUpdate(cost);
				}else {
					System.out.println("\nEnter product count ");
					int count = sc.nextInt();
					p.editOrUpdate(count);
				}
				return;
			}System.out.println();
		}
		System.out.println("\nProduct not found");
	}
	public static void productdetails(List<products> list) {
		System.out.println("\nEnter product name : ");
		sc.nextLine();
		String pname = sc.nextLine();
		for(products p: list) {
			if(p.getProduct().compareToIgnoreCase(pname) == 0) {
				p.productDetails();
				return;
			}
		}
		System.out.println("\nProduct not found");System.out.println();
	}
	public static void productcount(List<products> list) {
		System.out.print("\nEnter product name : ");
		sc.nextLine();
		String pname = sc.nextLine();
		boolean f = false;
		for(products p: list) {
			if((p.getProduct()).compareToIgnoreCase(pname) == 0) {
				System.out.println("count of "+p.getProduct() + " is "+p.productCount());
				f = true;
				break;
			}
		}
		if(!f)
		System.out.println("Product not found");
	}
}