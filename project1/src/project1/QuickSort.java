package project1;

final public class QuickSort<T extends Comparable<T>> extends SortingArray<T> {

	public QuickSort(T[] arr) {
		super(arr);
		// TODO Auto-generated constructor stub
	}
	
	public QuickSort()
	{
		//did nothering
		super();
	}

	@Override
	public String getSortName()
	{
		return "quick_sort";
	}
	
	
	@Override
    public void sort(T[] arr, int p, int r) {//p=start r=end for the book
        if(p<r){ 
	        int q=partion(arr,p,r);        
	        sort(arr,p,q-1);
	        sort(arr,q+1,r);
        }
        
    }


    private int partion(T[] arr, int p, int r) {
        T x=arr[r];
        int i=p-1;     
        for(int j=p; j<=r-1; j++){
        	compTimes++;
        	if(arr[j].compareTo(x)<=0){
        		
        		i=i+1;
        		swap(arr,i,j);
        	}
        }
        swap(arr,i+1,r);
        return i+1;
    }

 //class end

}

