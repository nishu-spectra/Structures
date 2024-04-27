package Structures;
import java.util.Scanner;
public class String_subsetANDposition {
    public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter the string: ");
		String string = obj.nextLine();
		String array[]= string.split(" ");
		String new_array1[]= new String[array.length+1];
		new_array1[0]= "";
		for(int i=1;i<new_array1.length;i++)
		{
			new_array1[i]= array[i-1];
		}
		int count=0;
		String new_array2[]= new String[array.length*array.length];
		int m=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				new_array2[m]= array[i]+","+array[j];
				count++;
				m++;
			}
		}
        obj.close();
       String rank[]= new String[new_array1.length+count];
       int i=0;
       for(i=0;i<new_array1.length;i++)
       {
    	   rank[i]= new_array1[i];
       }
       int j=i;
       for(int k=0;k<count;k++)
       {
    	   rank[j]= new_array2[k];
    	   j++;
       }
       System.out.println("The array string of subsets is ");
       for(int l=0;l<rank.length;l++)
       {
    	   System.out.println("{"+rank[l]+"}");
       }
       System.out.print("Enter the rank you want to dispay: ");
	   int rank_display = obj.nextInt();
	   if(rank_display<=rank.length)
	   {
	   System.out.println("The subset at "+rank_display+" is "+rank[rank_display-1]);
	   }
	   else
	   {
		   System.out.println("Subset position is invalid. ");
	   }
       
	}
}
