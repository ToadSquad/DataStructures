package Lab6SortedList;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class PackageReciever {
	String file;
	
	PackageReciever(String file){
		this.file = file;
	}
	
	public LinkedList<Packet> getPackage() throws FileNotFoundException{
		LinkedList<Packet> unsortedList = new LinkedList<>();
		Scanner s = new Scanner(new File(file));
	
		while(s.hasNextLine()) {
			String seq = "";
			String data = "";
			String line = s.nextLine();
			//Seperate Sequence
			seq = line.split(" ")[0];
			data = line.replace(seq+" ", "");
			
			Packet newPacket = new Packet(Integer.valueOf(seq),data);
			 unsortedList.add(newPacket);
		}
		
		
		return unsortedList;
		
	}

	
}
