package Lab6SortedList;

public class Packet implements Comparable<Packet> {
	
	private int sequenceNumeber;
	private String data;
	
	public int getSequenceNumeber() {
		int sequenceNumeber = this.sequenceNumeber;
		return sequenceNumeber;
	}
	public void setSequenceNumeber(int sequenceNumeber) {
		this.sequenceNumeber = sequenceNumeber;
	}
	public String getData() {
		String data = this.data;
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	Packet(int seq,String data){
		this.sequenceNumeber = seq;
		this.data = data;
	}
	@Override
	public int compareTo(Packet o) {
		// TODO Auto-generated method stub
		if(o.getSequenceNumeber()>this.sequenceNumeber) {
			return -1;
		}
		else if(o.getSequenceNumeber()<this.sequenceNumeber) {
			return 1;
		}
		return 0;
	}


}
