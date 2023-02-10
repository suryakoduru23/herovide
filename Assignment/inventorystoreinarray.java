import java.util.*;
public class inventorystoreinarray {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter no of products : ");
		int a = sc.nextInt();
		sc.nextLine();
		HashMap<String,ArrayList> map = new HashMap<>();
		System.out.println("Enter productName,  Specification,  cost,  count : \n");
		for(int i = 0 ; i < a  ; i++ ) {
			
			String line  = sc.nextLine();
			String[] arr = line.split(" ");
			ArrayList list = new ArrayList() ;
			String productname = arr[0];
			String pspec = arr[1];
			double cost = Double.parseDouble(arr[2]);
			int count = Integer.parseInt(arr[3]);
			list.add(pspec);
			list.add(cost);
			list.add(count);
			map.put(productname, list);
		}
		boolean flag = true;
		while(flag != false) {
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
					productList(map);
			}else if(choice == 2) {
				productcount(map);
			}else if(choice == 3) {
				productdetails(map);
			}else if(choice == 4) {
				editproduct(map);
			}else if(choice == 5) {
				updateInventory(map);
			}else if(choice  == 6) {
				flag = false;
			}else {
					System.out.println("Enter choice between 1 - 6 ");
			}
			
		}
	}
	public static void productList(HashMap<String,ArrayList> mp) {
		int i = 1;
		for(String st : mp.keySet()) {
			System.out.println(i + " "+st);
			i++;
		}
	}
	public static void updateInventory(HashMap<String,ArrayList> mp) {
		System.out.println(" 1. Adding poduct");
		System.out.println(" 2. Delete product");
		System.out.println("Enter your choice");
		sc.nextLine();
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("Enter productName,Specification,cost,count : ");
			sc.nextLine();
			String t = sc.nextLine();
			String []arr = t.split(" ");
			String productname = arr[0];
			String spec = arr[1];
			double cost = Double.parseDouble(arr[2]);
			int count = Integer.parseInt(arr[3]);
			ArrayList list = new ArrayList();
			list.add(spec);
			list.add(cost);
			list.add(count);
			mp.put(productname, list);
		}else {
			System.out.println("Enter product name to delete product : ");
			String productname = sc.nextLine();
			if(mp.containsKey(productname)) {
				mp.remove(productname);
				System.out.println("Product removed Successfully");
			}else {
				System.out.println("Product Not Found");
			}
		}
	}
	public static void editproduct(Map<String,ArrayList> mp) {
		System.out.println("Enter product name : ");
		sc.nextLine();
		String productname = sc.nextLine();
		if(mp.containsKey(productname)) {
			System.out.println("what do you want to edit :\n1.Specification\n2.Cost\n3.Product count");
			int ch = sc.nextInt();
			if(ch == 1) {
				System.out.println("Enter product specification ");
				String st = sc.nextLine();
				ArrayList list = mp.get(productname);
				list.remove(0);
				list.add(0, st);
				mp.put(productname, list);
			}else if(ch == 2) {
				System.out.println("Enter product cost ");
				double cost = sc.nextDouble();
				ArrayList list = mp.get(productname);
				list.remove(1);
				list.add(1, cost);
				mp.put(productname,list);
			}else {
				System.out.println("\nEnter product count ");
				int count = sc.nextInt();
				ArrayList list = mp.get(productname);
				list.remove(2);
				list.add(count);
				mp.put(productname,list);
			}
			return;
		}else {
			System.out.println("Product not found");
		}
	}
	public static void productcount(HashMap<String,ArrayList> mp) {
		System.out.println("Enter product name");
		sc.nextLine();
		String productname = sc.nextLine();
		if(mp.containsKey(productname)) {
			ArrayList temp = mp.get(productname);
			System.out.println("count of "+productname+" is "+temp.get(2));
		}else {
			System.out.println("Product not found");
		}
	}
	public static void productdetails(HashMap<String,ArrayList> mp) {
		System.out.println("Enter product name");
		sc.nextLine();
		String productname = sc.nextLine();
		if(mp.containsKey(productname)) {
			System.out.println("Product Name : "+productname);
			System.out.println("Product Specification : "+mp.get(productname).get(0));
			System.out.println("Product Cost : "+mp.get(productname).get(1));
			System.out.println("Product count : "+mp.get(productname).get(2));
		}else {
			System.out.println("Product not found");
		}
	}
}