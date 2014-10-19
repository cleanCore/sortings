package project1;

import java.util.ArrayList;


public class MergeSort <T extends Comparable<T>> extends SortingArray<T> {

	public MergeSort(T[] arr) {
		super(arr);
		// TODO Auto-generated constructor stub
	}
	
	public MergeSort()
	{
		//did nothering
		super();
	}

	@Override
	public String getSortName()
	{
		return "Merge_sort";
	}
	
	@Override
    public void sort(T[] arr, int start, int end) {
        //do something in maohua's framework
		mergeSort(arr,start,end);
    }
	
	
	private void mergeSort(T[] arr, int p, int r) {
        if(p>=r)
            return;
    
        int q = (p + r) / 2;
        
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);

    }
	
	private void merge(T[] arr, int p, int q, int r) {
		ArrayList<T> tempArr=new ArrayList<T>(); 
	    int right = q+1; //
	    int left = p;
	    while(left<=q && right<=r){ //until reach the end of left or right
	    	//more effective than the two arrays solution in the book
	    	compTimes++;
	        if(arr[left].compareTo(arr[right])<=0){
	        	
	        	tempArr.add(arr[left++]);
	         }else{
	        	 tempArr.add(arr[right++]);
	        }
	    }	
	     while(left<=q){  //put the left memebrs of left or right in the temparray
	    	 tempArr.add(arr[left++]); 
	     }
	     while(right<=r){
	    	tempArr.add(arr[right++]);
	     }
	
	    for(int i=p;i<=r;i++)
	    {
	    	arr[i]=tempArr.get(i-p);
	     }
	    tempArr.clear();
	 }

	
	
 //class end
}


