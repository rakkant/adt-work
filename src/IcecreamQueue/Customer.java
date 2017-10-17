package IcecreamQueue;

public class Customer implements Comparable<Customer> {
	public int age;
	public int id;
	
	public Customer (int i, int a){
		id = i; 
		age = a;
	}
	
	public int getAge() {
		return age;
	}

	

	public int getId() {
		return id;
	}

	


	public int compareTo(Customer o) {
		if( age < o.age){
			return -1;
		}else if (age > o.age){
			return 1;
		}else{
			return 0;
		}
	}
}
