package Structures;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.Set;

class Custom_HashMap<K,V> // generic
{
	class Node
	{
		K key;
		V value;
		Node(K key, V value)
		{
			this.key= key;
			this.value= value;
		}
	}
	int n; //no. of nodes
	int N; // no. of buckets

    LinkedList<Node>[] buckets; // N= buckets.length
	@SuppressWarnings ("unchecked")
    public Custom_HashMap()
    {
    	this.n=0;
    	this.N= 4;
		
			this.buckets=  new LinkedList[N];
		
    	
    	for(int i=0;i<buckets.length;i++)
    	{
    		this.buckets[i]= new LinkedList<>(); // to create empty or null linked list
    	}
    }
    
    //adds key value pair in hashmap
    public void put(K key, V value)
    {
    	int bi= hashFunction(key); // returns bucketIndex
    	int di = searchInLL(key, bi); //returns data index
    	if(di == -1) // if key does not exist
    	{
    		buckets[bi].add(new Node(key, value));
    		n++;
    	}
    	else // if key already exists
    	{
    		Node node= buckets[bi].get(di);
    		node.value = value;
    	}
    	double lamda = (double)n/N;
    	if(lamda> 2.0) //rehashing
    	{
             rehash();  		
    	}
    	
    }
    
    /*if the value of lambda is more than the specified value, rehash
     *for new lambda value i.e new number of bucket or array size*/
	@SuppressWarnings ("unchecked")
    private void rehash()
    {
    	LinkedList<Node> oldbuckets[] = buckets;
		
    	buckets= new LinkedList[2*N];
    	
    	for(int i=0;i<2*N;i++)
    	{
    		buckets[i]= new LinkedList<>();//to create empty or null linkedlist
    	}
    	for(int i=0;i<oldbuckets.length;i++)
    	{
    		LinkedList<Node> ll = oldbuckets[i];
    		for(int j=0;j<ll.size();j++)
    		{
    			Node node= ll.get(j);
    			put(node.key, node.value);
    		}
    	}
    }
    
    //return the data index of the key in its specified bucket
    private int searchInLL(K key, int bi)
    {
    	LinkedList<Node> ll = buckets[bi];
    	for(int i=0;i<ll.size();i++)
    	{
    		if(ll.get(i).key.equals(key))
    		{
    			return i;
    		}
    	}
    	return -1;
    }
    
    //changes the form of the key // returns the bucket index for specified key
    private int hashFunction(K key)
    {
        int bi = key.hashCode(); // can return any value more than or less than the number of bucket index
        return Math.abs(bi)%N; //returns bi(bucket index) between 0 to N-1
        
    }
 
    // remove the node of specified key
    public void remove(K key)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key, bi);
    	if(di==-1) // if key does not exist
    	{
    		return;
    	}
    	else // if key exists
    	{
    		LinkedList<Node> ll= buckets[bi] ;
    		Node node = buckets[bi].get(di);
    		ll.remove(node); // removing the node
    		n--;
    	}
    }
    
    //removes the specified key-value pair
    public void remove(K key, V value)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key, bi);
    	if(di==-1)
    	{
    		return;
    	}
    	else
    	{
    		for(int i=0;i<buckets.length;i++)
    		{
    			LinkedList<Node> ll = buckets[bi];
    			for(int j=0;j<ll.size();j++)
    			{
    				if(ll.get(j).key.equals(key) && ll.get(j).value.equals(value))
    				{
    					Node node = buckets[bi].get(di);
    					ll.remove(node);
    					n--;
    				}
    			}
    		}
    	}
    }
    
    //checks if specified key is present in hashmap  or not
    public boolean containsKey(K key)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key,bi);
    	if(di!=-1)
    	{
    		return true;
    	}
    	return false;
    }
    
    // checks if the specified value is present in hashmap or not
    public boolean containsValue(V value)
    {
    	for(int i=0;i<buckets.length;i++)
    	{
    		LinkedList<Node> ll = buckets[i];
    		for(int j=0;j<ll.size();j++)
    		{
    			if(ll.get(j).value.equals(value))
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    //returns the value of the specified key
    public V get(K key)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key, bi);
    	if(di!=-1)
    	{
    		LinkedList<Node> ll= buckets[bi];
        	Node node = ll.get(di);
        	return node.value;
    	}
    	return null;	
    }
    
    //adds the key-value pair if it is not added previously
    public void putIfAbsent(K key, V value)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key, bi);
    	if(di!=-1)
    	{
    		return;
    	}
    	else
    	{
    		buckets[bi].add(new Node(key,value));
    		n++;
    	}
    }
    
    //deletes the entire hashmap
    public void clear()
    {
       for(int i=0;i<buckets.length;i++)
       {
    	   buckets[i].clear();    
       }
       n=0;
    }
    
    //return the number of key-value pairs in hashmap
    public int size()
    {
    	
    	/*int count = 0;
    	for(int i=0;i<buckets.length;i++)
    	{
    		LinkedList<Node> ll = buckets[i];
    		for(int j=0;j<ll.size();j++)
    		{
    			count++;
    		}
    	}
    	return count;*/
    	      //OR
    	return n;
    }
    
    //replaces the new value for the specified key
    public void replace(K key, V value)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key, bi);
    	if(di==-1)
    		return;
    	else
    	{
    		for(int i=0;i<buckets[bi].size();i++)
    		{
    			Node node = buckets[bi].get(di);
    			node.value = value;
    		}
    	}
    }
    
    //Replaces the value of the specified key only if it's currently mapped to the oldValue.
    public void replace(K key, V oldValue, V newValue)
    {
    	int bi = hashFunction(key);
    	int di = searchInLL(key, bi);
    	if(di==-1)
    		return;
    	else
    	{
    		for(int i=0;i<buckets[bi].size();i++)
    		{
    			Node node = buckets[bi].get(di);
    			if(node.value.equals(oldValue))
    			{
    				node.value = newValue;
    			}
    		}
    	}
    }
    
    //checks if the map is empty 
    public boolean isEmpty()
    {
    	if(n==0)
    		return true;
    	else
    		return false;
    }
   
    //creates a new entry map with all the key-value pairs 
    public void putAll(Map<? extends K, ? extends V> oldMap)
    {
    	for(Map.Entry<? extends K,? extends V> newMap : oldMap.entrySet())
    	{
    		put(newMap.getKey(), newMap.getValue());
    	}
    }
    
    //creates a new hashmap with all the key-value pairs 
    public void  putAll(Custom_HashMap<K,V> oldMap)
    {
    	 for(LinkedList<Node> newBucket: oldMap.buckets)
    	 {
    		 for(Node node: newBucket)
    		 {
    			 put(node.key, node.value);
    		 }
    	 }
    }
    
    //returns a set of all the keys in the map
    public Set<K> keySet()
    {
    	Set<K> keys = new HashSet<>();
    	for(int i=0;i<buckets.length;i++)
    	{
    		LinkedList<Node> ll = buckets[i];
    		for(int j=0;j<ll.size();j++)
        	{
        		keys.add(ll.get(j).key);
        	}
    	}
    	return keys;
    }
    
    //returns a collection of values in the map
    public Collection<V> values()
    {
    	Collection<V> values = new HashSet<>();
    	for(int i=0;i<buckets.length;i++)
    	{
    		LinkedList<Node> ll = buckets[i];
    		for(int j=0;j<ll.size();j++)
    		{
    			values.add(ll.get(j).value);
    		}
    	}
    	return values;
    }
    
    //creates a set of key=value pair in entry
    public Set<Entry<K,V>> entrySet()
    {
    	Set<Entry<K,V>> entryset = new HashSet<>();
        for(LinkedList<Node> bucket : buckets)
        {
        	for(Node node: bucket)
        	{
    			entryset.add(new MyEntry<>(node.key, node.value));
    		}
    	}
    	return entryset;
    }
    
    private  static class MyEntry<K, V> implements Map.Entry<K, V>
    {
        private final K key;
        private V value;
        
        MyEntry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
        public K getKey()
        {
    	    return key;
        }
        public V getValue()
        {
    	    return value;
        }
        public V setValue(V value)
        {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
    
   // displays the key value pair buckets wise
    public void display() 
    {
        for (int i = 0; i < N; i++) 
        {
            LinkedList<Node> bucket = buckets[i];
            System.out.print("Bucket " + i + ": ");
            for (Node node : bucket) 
            {
                System.out.print("[" + node.key + " : " + node.value + "] ");
            }
            System.out.println();
        }
    }
    
    //displays the key value pair
    public String toString() 
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("{");
    	for(int i=0;i<N;i++)
    	{
    		LinkedList<Node> bucket = buckets[i];
    		for(Node node: bucket)
    		{
    			sb.append(node.key+"="+node.value+",");
    		}
    	}
    	sb.append("}");
    	return sb.toString();
    }
}
public class HashMap {
    public static void main(String[]args)
    {
       
		Custom_HashMap<Integer, String> hm = new Custom_HashMap<>();
		hm.put(0,"Nidhi");
		hm.put(3, "Pappu");
		hm.put(7, "Nishu");
		System.out.println(hm);
		if(hm.containsKey(3)==true)
		{
			System.out.println("Key is present.");
		}
		else
		{
			System.out.println("Key is not present.");
		}
		System.out.println(hm);
        hm.remove(7);
        System.out.println(hm);
        hm.remove(3,"Pappu");
        System.out.println(hm);
        System.out.println("Value of the key 0 is "+hm.get(0));
        hm.putIfAbsent(2,"Pappu");
        System.out.println(hm);
        System.out.println("Total number of key-value pairs is: "+hm.size());
        hm.replace(0, "Nishu");
        System.out.println(hm);
        hm.replace(0,"Nishu","Rahul");
        System.out.println(hm);
        Custom_HashMap<Integer,String> mp = new Custom_HashMap<>();
        mp.putAll(hm);
        System.out.println(mp);
        Set<Integer> keyset = hm.keySet();
        System.out.println("Set of keys = "+keyset);
        Collection<String> values = hm.values();
        System.out.println("Set of values = "+values);
        Set<Entry<Integer,String>> entryset = hm.entrySet();
        for (Map.Entry<Integer, String> entry : entryset)
        {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        hm.clear();
        System.out.println(hm);
        System.out.println("Total number of key-value pairs is: "+hm.size());    
	}
    
}
