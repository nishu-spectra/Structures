package Structures;
class LinkedList
{
	Node head;
	class Node
	{
		int element;
	    Node next;
		Node(int element)
		{
			this.element= element;
			this.next = null;
		}
	}
	//checks if the list is empty or not
		boolean isEmpty()
		{
			if(head==null)
				return true;
			else
				return false;
		}
	//adds the specified element at last by default
	void add(int element)
	{
		Node new_node = new Node(element);
	    if(isEmpty()==true)
		{
			head = new_node;
		}
	    else
	    {
	    	Node current  = head;
	    	while(current.next!=null)
			{
				current=current.next;
			}
	    	current.next=new_node;
	    }
	}
	//adds the specified element in the beginning of the list 
	void addFirst(int element)
	{
		Node new_node = new Node(element);
		if(isEmpty()==true)
		{
			head=new_node;
		}
		else
		{
			new_node.next=head;
			head=new_node;
		}
	}
	//adds the specified element at the end of the list
	void addLast(int element)
	{
		Node new_node = new Node(element);
	    if(isEmpty()==true)
		{
			head = new_node;
		}
	    else
	    {
	    	Node current  = head;
	    	while(current.next!=null)
			{
				current=current.next;
			}
	    	current.next=new_node;
	    }
	}
	//adds the element at the specified index
	void add(int index , int element)
	{
		Node new_node = new Node(element);
		
		if(isEmpty()==true)
			return;
		else if(index==0)
		{
			new_node.next=head;
			head=new_node;
		}
		else
		{
			Node current = head;
			int count=0;
			while(current!=null && count<index-1)
			{
				count++;
				current=current.next;
			}
			if(current==null)
				return;
			new_node.next=current.next;
			current.next=new_node;
		}
	}
	//removes the element from beginning of the list by default
	void remove()
	{
		if(isEmpty()==true)
		{
			System.out.println("List empty.");
		}
		else if(head.next==null)
		{
			head=null;
		}
		else
		{
			head=head.next;
		}
	}
	//removes the element from beginning of the list
	void removeFirst()
	{
		if(isEmpty()==true)
		{
			System.out.println("List empty.");
		}
		else if(head.next==null)
		{
			head=null;
		}
		else
		{
			head=head.next;
		}
	}
	//removes the element from end of the list
	void removeLast()
	{
		if(isEmpty()==true)
		{
			System.out.println("List empty!");
		}
		else if(head.next==null)
		{
			head=null;
		}
		else
		{
			Node current=head;
			Node previous= null;
			while(current.next!=null)
			{
				previous=current;
				current=current.next;
			}
			previous.next=null;
		}
	}
	//removes the element from the specified index
	void removeIndex(int index)
	{
		if(isEmpty()==true)
		{
			System.out.println("List empty!");
		}
		if(index==0)
		{
			head=head.next;
		}
		else
		{
			Node current=head;
			Node previous=null;
			int count=0;
			while(current!=null && count<index)
			{
				previous=current;
				current=current.next;
				count++;
			}
			if(current!=null)
			{
				previous.next=current.next;
			}
		}
	}
	//removes the first occurrence of the specific element if present
	void remove(int element)
	{
		
		if(isEmpty()==true)
		    return;
		else if(head.element==element)
		{
			head=head.next;
			return;
		}
		else
		{
			Node current=head;
			Node previous =null;
			while(current!=null)
			{
				if(current.element==element)
				{
					previous.next=current.next;
				}
				previous=current;
				current=current.next;	
			}		
		}
	}
	//retrieves the data from specified index without removing
	Object get(int index)
	{
		if(isEmpty()==true)
			return null;
		else if(index==0)
			return head.element;
		else
		{
			Node current=head;
			int count=0;
			while(current!=null && count<index)
			{
			     current= current.next;
			     count++;
			}
			if(current!=null)
			    return current.element;
			else
				return null;
		}	
	}
	//returns the first element in the linked list
	Object getFirst()
	{
		if(head==null)
		  return null;
		else 
			return head.element;
	}
	//return the last element in the linked list
	Object getLast()
	{
		if(head==null)
			return null;
		else
		{
			Node current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			return current.element;
		}
	}
	//replaces the data of the specified index
	void set(int index, int element)
	{
		if(isEmpty()==true)
		{
			return;
		}
		else
		{
			Node current =head;
			int count=0;
			while(current!=null && count<index)
			{
				current=current.next;
				count++;
			}
			current.element=element;
		}
	}
	//reverses the present list
	void reverse()
	{
		Node current=head;
		Node previous = null;
		Node next =null;
		//System.out.print("[");
		while(current!=null)
		{
			next=current.next;
			current.next=previous;
		    previous= current;
		    current=next;
		}
		head=previous;
	}
	//returns the size of the list
	int size()
	{
		Node current= head;
		int count=0;
		while(current.next!=null)
		{
			count++;
			current=current.next;
		}
		return count+1;
	}
	//checks if the specified element is present in the list or not
	boolean contains(int element)
	{
		Node current =head;
		while(current!=null)
		{
			if(current.element==element)
			{
				return true;
			}
			current=current.next;
		}
		return false;
	}	
	//converts the list into array
	int[] toArray()
	{
		Node current = head;
		Node check= head;
		int i=0,size=0;
		while(current!=null)
		{
			current=current.next;
			size++;
		}
		int array[]= new int[size];
		while(check!=null)
		{
			array[i]=check.element;
			check=check.next;
			i++;
		}
		return array;
	}

	//returns the index of first occurrence of the element by default
	int indexOf(int element)
	{
		Node current=head;
		int count=-1;
		while(current!=null)
		{
			count++;
			if(current.element==element)
				return count;
			current=current.next;
		}
		return -1;
	}
	//returns the index of first occurrence of the element
		int firstIndexOf(int element)
		{
			Node current=head;
			int count=-1;
			while(current!=null)
			{
				count++;
				if(current.element==element)
					return count;
				current=current.next;
			}
			return -1;
		}
	//returns the index of last occurrence of the element
	int lastIndexOf(int element)
	{
		Node current=head;
   	    int  count=0;
   	    int lastindex=-1;
   	    while(current.next!=null)
   	    {
   		    if(current.element==element)
   		    {
   		    	lastindex=count;
   		    }
   		  current=current.next;
   		  count++;
   	    }
   	        return lastindex;
	}
	//gives a view of the portion between the specified index
	void subList(int fromIndex, int toIndex)
	{
		Node current= head;
		 int count=-1;
		 LinkedList obj = new LinkedList();
		while(current!=null)
		{
			count++;
			if(count>=fromIndex && count<=toIndex)
			{
				obj.add(current.element);
			}
			current= current.next;
		}
		obj.show();
	}
	//retrieves the head of the list without removing it
     Object peek()
	{
		if(head==null)
			return null;
		return head.element;
	}
     //retrieves the first element of the list
     Object peekFirst()
     {
    	 if(isEmpty()==true)
    		 return null;
    	 else
    		 return head.element;
     }
     //retrieves the last element of the list
     Object peekLast()
     {
    	 if(isEmpty()==true)
    	     return null;
    	 else
    	 {
    		 Node current = head;
    		 while(current.next!=null)
    		 {
    			 current=current.next;
    		 }
    		 return current.element;
    	 }
     }
     //creates a shallow copy of the original list
     public LinkedList clone()
     {
    	 LinkedList clonelist = new LinkedList();
    	 if(head==null)
    		 return null;
    	 else
    	 {
    		 Node current=head;
    		 Node new_node = new Node(current.element);
    		 clonelist.head=new_node;
    		 current=current.next;
    		 while(current!=null)
    		 {
    			 clonelist.add(current.element);
    			 current=current.next;
    		 }
    		 return clonelist;
    	 }
     }
   //deletes the list
 	void clear()
 	{
 		head=null;
 	}
 	Object midElement()
 	{
 		if(head==null)
 			return null;
 		else if(head.next==null)
 		    return head.element;
 		else
 		{
 			int k=size()/2;
 			if(size()%2==0)
 			{
 				 k= (size()-1)/2;
 			}
 			int count=0;
 			Node current=head;
 			System.out.println(k);
 			while(current.next!=null && count<k)
 			{
 				current=current.next;
 				count++;
 			}
 			return current.element;
 		}
 	}
	//displays the list
	void show()
	{
		if(isEmpty()==true)
		{
			System.out.println("[ ]");
		}
		else if(head.next==null)
		{
			System.out.println("["+head.element +"]");
		}
		else
		{
			Node current=head;
			System.out.print("[");
			while(current!=null)
			{
				System.out.print(current.element+",");
				current=current.next;
			}
			System.out.print("]");
			System.out.println();
		}
	}
	//prints the list automatically without any separate function
	@Override
    public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.element).append(" ");
            if(current.next!=null)
            {
            	sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class SingltLinkedList_Structure {
    public static void mainn(String []args)
    {
        LinkedList link = new LinkedList();
		link.add(89);
		link.add(78);
		link.add(56);
        link.addFirst(98);
        link.show();
        link.addLast(23);
        link.show();
        link.addLast(23);
        link.add(5,90);
        link.show();
        System.out.println(link);
        System.out.println("Element at index 7: "+link.get(7));
        link.removeFirst();
        link.show();
        if(link.contains(45)==true)
        {
        	System.out.println("Present.");
        }
        else
        {
        	System.out.println("Not Present.");
        }
        link.set(2, 45);
        link.show();
        System.out.println("Element at peek: "+link.peek());
        LinkedList list=link.clone();
        System.out.print("Cloned list= ");
        list.show();
        link.add(51);
        link.show();
        int array[]= link.toArray();
        System.out.print("Array list = [");
        for(int i=0;i<array.length;i++)
        {
        	System.out.print(array[i]+",");
        }
        System.out.print("]\n");
        link.reverse();
        System.out.println("Reversed lit= "+link);
        link.remove(23);
        link.show();
        System.out.println("Size: "+link.size());
        System.out.println("Midlle element= "+link.midElement());
        link.removeIndex(1);
        link.show();
        System.out.print("Sublist: ");
        link.subList(2,4);
        System.out.println("Index of 23: "+link.indexOf(23));
        System.out.println("Last index of 23: "+link.lastIndexOf(23));
        System.out.println("Element at first: "+link.getFirst());
        System.out.println("Element at last: "+link.getLast());
        link.clear();
        link.show();
        System.out.println("Element at peek: "+link.peek());
        System.out.println(link);
        System.out.println("34 in the list: "+link.contains(34));
    }
    
}
