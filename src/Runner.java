// Sorting07.java
// The last sort to be shown is the ultrafast recursive Merge Sort


import java.util.*;


public class Runner
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter list size      ===>>  ");
		int listSize = input.nextInt();
		System.out.print("Enter minimum value  ===>>  ");
		int listMin = input.nextInt();
		System.out.print("Enter maximum value  ===>>  ");
		int listMax = input.nextInt();
		List array = new List(listSize,listMin,listMax);
      
		array.display();
		array.pause();
		array.mergeSort(0,listSize-1);
		array.display();
		array.pause();
		System.out.println();
	}
}


class List
{
	private int[] intArray;	
   private int[] tempArray;
	private int size;  		
   
   public List(int s, int min, int max)
	{
		size = s;
		System.out.println("Constructing List with values in [" + min + ".." + max + "] range");
		intArray = new int[size];
      tempArray = new int[size];
		int range = max - min + 1;
		for (int k = 0; k < size; k++)
			intArray[k] = (int) (Math.random() * range + min);
	}

	public void display()
	{
		System.out.println("\nDisplaying array elements");
      for (int k = 0; k < size; k++)
      {
			System.out.print(intArray[k] + "  ");
         if (k > 1 && k % 15 == 0)
		      System.out.println();
      }
      System.out.println();
	}

	public void pause()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("\nPress <Enter> to continue  ===>>  ");
		String dummy = input.nextLine();
	}


	public void mergeSort(int first, int last)
	{
		if (first < last)
		{
			int mid = (first + last) / 2;
			mergeSort(first,mid);
			mergeSort(mid+1,last);
			merge(first,mid,last);
   	}
	}

   private void merge(int first, int mid, int last)
	{
	   
	   /*
	    * p = first index of whatever sublist you are working on
	    * q = middle index of what is being broken down into sublist
	    * k = temporary (temp) value for first index of sublist
	    * 
	    */
		int p = first; 
		int q = mid+1;
		int k = first;
		//First is less than mid and mid+1 is less than last you have to subsets of more than one array
		while (p <= mid && q <= last)
		{
			//If first number is less than middle+1 (last number of subset) 
			if (intArray[p] <= intArray[q])
			{
				//Set tempArray equal to this smaller number
				tempArray[k] = intArray[p];
				p++;
			}
			//If first number is not less, add middle number to temp array
			else
			{
				//Set tempArray equal to the smaller beginning of the second subset
				tempArray[k] = intArray[q];
				q++;
			}
			k++;
   	}
		//Take values from intArray and place then into the tempArray from your first subset
		while (p <= mid)
		{
			tempArray[k] = intArray[p];
			p++;
			k++;
   	}
		//Take values from intArray and place then into the tempArray from your second subset
		while (q <= last)
		{
			tempArray[k] = intArray[q];
			q++;
			k++;
   	}
		//Take values from tempArray and place them into the intArray
		for (int h = first; h <= last; h++)
			intArray[h] = tempArray[h];
	}

}