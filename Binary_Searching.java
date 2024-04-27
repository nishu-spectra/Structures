package Structures;
import java.util.Scanner;
class BinarySearch
{
	int Search(int array[], int searchValue)
	{
		int front =0;
		int rear= array.length-1;	
		while(front!=rear)
		{
		    int middle= (front+rear)/2;
			if(searchValue==array[middle])
				return middle;
			if(searchValue>array[middle])
			{
				front= middle+1;
			}
			if(searchValue<array[middle])
			{
				rear= middle-1;
			}
		}	
		return -1;
	}
}
//for demonstration
public class Binary_Searching 
{
	public static void main(String[] args)
	{
		BinarySearch bs = new BinarySearch();
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter the searching element: ");
		int s= obj.nextInt();
		int array[]= {10,12,13,23,90,98,101};
		
		int result = bs.Search(array, s);
		if(result==-1)
		{
			System.out.println(s+" is not found.");
		}
		else
		{
			System.out.println(s+" is found at index ["+result+"]");
		}
		obj.close();
	}
}
