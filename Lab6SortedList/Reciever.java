package Lab6SortedList;

import java.io.FileNotFoundException;

public class Reciever {
	public static void main(String[] args) throws FileNotFoundException {
		PackageReciever r =  new PackageReciever("C:\\Users\\parkerj12\\Desktop\\Summer\\DataStructures\\src\\encoded");
		System.out.print(Message.getMessage(Message.sort(r.getPackage())));
	}
}
