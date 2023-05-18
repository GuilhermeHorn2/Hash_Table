package misc;

import java.util.ArrayList;


public class Hash_Table<T,K> {
	//the Hash_Table will be an array of linked lists
	
	public static class Key<T,K>{//this is an empty node that will just carry the key and point to the head of the list
		private T key;
		private Node<K> head;	
		
		public Key(T k,Node<K> h){
			key = k;
			head = h;
		}
		public T get_key(){
			return key;
		}
		public Node<K> get_head() {
			return head;
		}
		
	}
	
	public static class Node<K>{
		
		private K data;
		private Node<K> next;
		
		public Node(K d) {
			data = d;
		}
		public K get_data() {
			return data;
		}
		public Node<K> get_next(){
			return next;
		}
		public void set_next(Node<K> n){
			next = n;
		}
	}
	
	ArrayList<Key<T,K>> table = new ArrayList<>();
	
	public Hash_Table() {}
	
	public boolean contains_key(T key) {
		//check if key is on the table
		for(int i = 0;i < table.size();i++){
			if(table.get(i).get_key().equals(key)){
				return true;
			}
		}
		return false;
	}	
	
	//aux method:find key
	
	public Key<T,K> find_key(T key) {
		Key<T,K> k = null;
		for(int i = 0;i < table.size();i++) {
			if(table.get(i).get_key().equals(key)) {
				k = table.get(i);
			}
		}
		return k;
	}
	
	//
	
	public void check_data(T key) {
		//prints the data that the key points to
		
		
		Key k = find_key(key);
		
		//Now adding the contents of the linked list to data
		Node n = k.get_head();
		while(n.get_next() != null) {
			System.out.print(n.get_data() +" -> ");
			n = n.get_next();
		}
		//the end node
		System.out.print(n.get_data());
		
	}
	
	//methods to get data from a key
	public K get_data(T key,int i){
		
		Key<T,K> k = find_key(key);
		
		Node<K> n = k.get_head();
		int j = 0;
		while(j != i && n != null){
			n = n.get_next();
			j++;
		}
		return n.get_data();	
	}
	
	public K get_data(T key) {
		Key<T,K> k = find_key(key);
		
		Node<K> n = k.get_head();
		
		return n.get_data();
	}
	//
	
	
	public void add(T key,K data){
		//add a key and a initial data,if the key already exists this will be a collision
		
		Key<T,K> k = find_key(key);
		if(k == null) {
			Node<K> head = new Node<>(data); 
			Key<T,K> novo = new Key<>(key,head);
			head.set_next(null);
			table.add(novo);
			return;
		}
		//collision:
		Node<K> n = k.get_head();
		while(n.get_next() != null){
			n = n.get_next();
		}
		Node<K> novo = new Node<>(data);
		novo.set_next(null);//end node points to null
		n.set_next(novo);//novo is the new next of the previous last node
		
		
	}
	public T remove_key(T key) {
		//remove a key,with its entire data
		Key<T,K> k = find_key(key);
		table.remove(k);
		return k.get_key();
	}
	
	

}
