import java.util.LinkedList;
import java.util.*;
public class LinkedList11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> list1=new LinkedList();
		//list1.addFirst("Mangoo");
		list1.add("Orange");
		list1.add("Kiwi");
		list1.add("Strawberry");
		System.out.println(list1);

		// Find middle element of Linked List
		LinkedList<Integer> list2=new LinkedList(Arrays.asList(10,20,30,40,50));
		int mid=(list2.size())/2;
		System.out.println("Middle Element : "+list2.get(mid));

		//Remove the duplicates from LinkedList
		LinkedList<Integer> list3=new LinkedList(Arrays.asList(10,20,20,40,40,50,50,70));
		System.out.println("Input list "+list3);
		Set<Integer> set1=new LinkedHashSet(list3);
		/* A Set do not allowed Duplicates
		* LinkHashSet is type of Set that remembers the insertion order
		*/
		list3.clear();     //removes the linked list
		list3.addAll(set1);
		System.out.println("Output list "+list3);

		// Convert LinkedList to Array
		LinkedList<Integer> list4=new LinkedList<>();
		list4.add(10);
		list4.add(20);
		list4.add(30);
		list4.add(40);
		list4.add(50);
		System.out.println("Input list "+list4);
		Integer[] arr = list4.toArray(new Integer[0]);
		for(int i:arr)
		{
           System.out.println(i+" ");
		}


		//

        




	}

	

}
