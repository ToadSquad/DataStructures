package Lab6SortedList;



public class Message {
	Message(){
		
	}
	public static SortedLinkedList<Packet> sort(LinkedList<Packet> unsorted) {
		SortedLinkedList<Packet> packetsSorted = new SortedLinkedList<>();
		int lowestPosSeq = unsorted.getEntry(0).getSequenceNumeber();
		int lowestPos = 0;
		int lastLowestSeq = 0;
		int runs = 0;
		int length = unsorted.getLength();
		
		while(runs<length) {
				lowestPos = 0;
				lowestPosSeq = 21;
			for(int x=0;x<length;x++) {
				if((unsorted.getEntry(x).getSequenceNumeber()<lowestPosSeq)&&(unsorted.getEntry(x).getSequenceNumeber()>lastLowestSeq)) {
					lowestPos = x;
					lowestPosSeq = unsorted.getEntry(x).getSequenceNumeber();
					}
			}
			lastLowestSeq = lowestPosSeq;
			packetsSorted.addEntry(unsorted.getEntry(lowestPos));
			runs++;
		}
		
		return packetsSorted;
	}
	
	public static String getMessage(SortedLinkedList<Packet> sorted) {
		String message = "";
		for(int x=0;x<sorted.getLength();x++) {
			message += sorted.getEntry(x).getData();
		}
		
		
		return message;
		
	}
}
