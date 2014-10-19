package project1;
//designed by maohua zheng version 0.01
public interface ISorting {
	public void sort();//use interface, a reference to array must be stored.
	// it have default behavior from 0 to the end of an array
	//if want to sort any array from start to end, just use the start and end params
	public String getSortName();
	public long getComparTimes();
}
