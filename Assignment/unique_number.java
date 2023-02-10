import java.util.*;
public class unique_number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();   
        for (int j = 0; j < n; j++) {   
            map.put(arr[j], j);   
        }   
        System.out.println(map.keySet());  
    }
}
