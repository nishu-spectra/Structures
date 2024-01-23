package Structures;
class DoublyLinkedList
{
	Node head;
	Node tail;
	class Node
	{
		int data;
		Node next;
		Node previous;
		Node(int data)
		{
			this.data=data;
			this.next=null;
			this.previous= null;
		}
	}
	DoublyLinkedList()
	{
		this.head=null;
		this.tail=null;
	}
	//checks if the linked list is empty or not
	boolean isEmpty()
	{
		if(head==null)
			return true;
		else
		return false;
	}
	//returns the number of element in the list
	int size()
	{
		if(head==null)
			return 0;
		else if(head.next==null)
			return 1;
		else
		{
			Node current = head;
			int count=0;
			while(current!=null)
			{
				count++;
				current= current.next;
			}
			return count;
		}
	}
	//adds the specified element at last of the list by default
	void add(int data)
	{
		Node new_node = new Node(data);
		if(head==null)
		{
			head= new_node;
			tail=new_node;
		}
		else
		{
			Node current = head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=new_node;
			new_node.previous=current;
		}
	}
	//adds the specified element at the beginning of the list
	void addFirst(int data)
	{
		Node new_node = new Node(data);
		if(head==null)
		{
			head=new_node;
		}
		else
		{
			head.previous=new_node.next;
            new_node.next= head;
            head=new_node;
		}
	}
	//adds the specified element at last of the list
	void addLast(int data)
	{
		Node new_node = new Node(data);
		if(head==null)
		{
			head=new_node;
		}
		else
		{
			Node current= head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=new_node;
			new_node.previous=current;
		}
	}
	//adds the element at the specified position
	void add(int index, int element)
	{
		Node new_node= new Node(element);
		if(index==0)
		{
			new_node.next=head;
			if(head!=null)
			{
				head.previous=new_node;
			}
			head=new_node;
		}
		else 
		{
			Node current= head;
			int count =0;
			while(current!=null && count<index-1)
			{
				current=current.next;
				count++;
			}
			if(current==null)
			     return;
			else
			{
				new_node.next=current.next;
				new_node.previous=current;
				if(current.next!=null)
				{
					current.next.previous=new_node;
				}
				current.next=new_node;				
			}
		}
	}
	//removes from the beginning of the list by default
	void remove()
	{
		if(head==null)
			return;
		else if(head.next==null)
			head=null;
		else
		{
			head.next.previous=null;
			head=head.next;	
		}
	}
	//removes from the beginning of the list by default
	void removeFirst()
    {
		if(head==null)
			return;
		else if(head.next==null)
			head=null;
		else			{
			head.next.previous=null;
			head=head.next;	
		}
	}
	//removes the element from the end
	void removeLast()
	{
		if(head==null)
			return;
		else if(head.next==null)
			head=null;
		else
		{
			Node current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.previous.next=null;
		}
	}
	//removes the element from the specified position
	void remove(int index)
	{
		if(head==null)
			return;
		else if(index==0)
		{
			head.next.previous=null;
			head=head.next;
		}
		else
		{
			//Node new_node = new Node(data);
			Node current=head;
			int count=0;
			while(current!=null && count<index-1)
			{
				current=current.next;
				count++;
			}
			current.next=current.next.next;
			if(current.next.next!=null)
			{
				current.next.next.previous=current;
			}	
		}	
	}
	//returns the data of specified index without deleting 
	Object get(int index)
	{
		if(head==null)
			return null;
		else if(index==0)
			return head.data;
		else
		{
			Node current=head;
			int count=0;
			while(current!=null && count<index)
			{
				current=current.next;
				count++;
			}
			if(current!=null)
			    return current.data;
			else
				return null;
		}
	}
	//returns the data at the beginning of the list
	Object getFirst()
	{
		if(head==null)
			return null;
		else
			return head.data;
	}
	//returns the data at the end of the list
	Object getLast()
	{
		if(head==null)
			return null;
		else if(head.next==null)
			return head.data;
		else
		{
			Node current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			return current.data;
		}
	}
	//replaces the data of the specified index
	void set(int index, int data)
	{
		 if(head==null)
			 return ;
		 else if(index==0)
		 {
			 head.data=data;
		 }
		 else
		 {
			 Node current=head;
			 int count=0;
			 while(current!=null && count<index)
			 {
				 current=current.next;
				 count++;
			 }
			 if(current!=null)
			     current.data=data;
			 else
				 return;
		 }
	}
	//reverses the list
	void reverse()
	{
		Node current=head;
		Node next=null;
		Node previous=null;
		while(current!=null)
		{
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
	}
	//checks if the specified data is present or not
	boolean contains(int data)
	{
		if(head==null)
			return false;
		else
		{
			Node current=head;
			while(current!=null)
			{
				if(current.data==data)
				{
					return true;
				}
				current=current.next;
			}
			return false;
		}	
	}
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
			array[i]=check.data;
			check=check.next;
			i++;
		}
		return array;
	}
	//returns the index of first occurrence of the specified data by default
	int indexOf(int data)
	{
		if(head.data==data)
			return 0;
		else
		{
			if(contains(data)==true)
			{
				Node current=head;
				int count=0;
				while(current.data!=data)
				{
					current=current.next;
					count++;
				}
				return count;
			}
			else
				return -1;
		}	
	}
	//returns the index of the first occurrence of the specified data
	int firstIndexOf(int data)
	{
		Node current=head;
		int count=-1;
		while(current!=null)
		{
			count++;
			if(current.data==data)
				return count;
			current=current.next;
		}
		return -1;
	}
	//returns the index of last occurrence of the specified data
	int lastIndexOf(int data)
	{
		Node current=head;
		int count=-1;
		int lastindex=-1;
		while(current!=null )
		{
			count++;
			if(current.data==data)
			{
				lastindex=count;
			}
			current=current.next;
		}
		return lastindex;
	}
	//gives a view of the portion between the specified index
	void sublist(int fromIndex, int toIndex)
	{
		Node current=head;
		int count=0;
		DoublyLinkedList obj = new DoublyLinkedList();
		while(current!=null)
		{
			if(count>=fromIndex && count<=toIndex)
			{
				obj.add(current.data);	
			}
			count++;
			current=current.next;
		}
		System.out.println(obj);
	}
	//retrieves the data of head without removing it from the list
	Object peek()
	{
		if(head==null)
			return null;
		else
			return head.data;
	}
	//retrieves the first data in the list
	Object peekFirst()
	{
		if(head==null)
			return null;
		else
			return head.data;
	}
	//retrieves the data at the end of the list
	Object peekLast()
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
			return current.data;
		}
	}
	//displays the list without any different function creation
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node current=head;
		while(current!=null)
		{
			sb.append(current.data);
			if(current.next!=null)
			{
				sb.append(",");
			}
			current=current.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
public class DoublyLinkedLists {
    public static  void main(String[]args)
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(3);
        list.add(4);
        list.add(6);
        list.addFirst(10);
        list.addLast(67);
        list.add(5,45);
        list.add(78);
        System.out.println(list);
        list.remove();
        list.removeLast();
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.add(67);
        System.out.println(list);
        System.out.println("First index of 67= "+list.firstIndexOf(67));
        System.out.println("Last index of 67= "+list.lastIndexOf(67));
        System.out.println("Data at index 3: "+list.get(3));
        System.out.println("Data at beginning: "+list.getFirst());
        System.out.println("Data at end: "+list.getLast());
        list.set(3, 0);
        System.out.println(list);
        list.reverse();
        System.out.println("Reversed list is "+list);
        System.out.println("6 is in the list: "+list.contains(6));
        int array[]= list.toArray();
        System.out.print("Array list = [");
        for(int i=0;i<array.length;i++)
        {
        	System.out.print(array[i]+",");
        }
        System.out.print("]\n");
        System.out.println("Index of 1= "+list.indexOf(1));
        System.out.print("Sublist= ");
        list.sublist(1, 5);
        System.out.println("Data at the beginning= "+list.peekFirst());
        System.out.println("Data at the end= "+list.peekLast());
    }
}
