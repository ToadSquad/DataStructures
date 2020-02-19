package Project5Tree;

public class Name<T> implements Comparable<T> {
	private String first;
	private String last;
	Name(String fullName){
		String[] nameArr = fullName.split(" ");
		this.first = nameArr[0];
		this.last = nameArr[1];
	}
	//Returns 0 if first Name is equal

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		double compare = this.first.compareTo(((Name)o).first);
		if(!(o instanceof Name)) {throw new IllegalStateException();}
		
		if(((Name)o).first.equals(this.first)) {
			return 0;
		}
		else if(compare>0){
			return 1;
		}
		else {
			return -1;
		}
	}
	@Override
	public String toString() {
		return first+" "+last;
	}
	
}
