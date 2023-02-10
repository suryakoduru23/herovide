import java.util.*;
class missing_number
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.print("Missing_Numbers are : "+"");
        int j=arr[0],i=0;
        while(i<n)
        {
            if(j==arr[i])
            {
                j++;
                i++;
                continue;
            }
            System.out.print(j+" ");
            j++;
        }
        sc.close();
    }
}