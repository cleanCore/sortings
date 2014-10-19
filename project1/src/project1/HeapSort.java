package project1;

final public class HeapSort <T extends Comparable<T>> extends SortingArray<T> {

	public HeapSort(T[] arr) {
		super(arr);
		// TODO Auto-generated constructor stub
	}
	
	public HeapSort()
	{
		//did nothering
		super();
	}

	@Override
	public String getSortName()
	{
		return "Heap_sort";
	}
	
	private void heapSort(T[] arr){
        int arrayLength=arr.length;
        for(int i=0;i<arrayLength-1;i++){ 
            buildMaxHeap(arr,arrayLength-1-i);
            swap(arr,0,arrayLength-1-i);
        }
	}
	
	private  void buildMaxHeap(T[] arr, int lastIndex) {

        for(int i=(lastIndex-1)/2;i>=0;i--){
      
            int k=i;
            
            while(k*2+1<=lastIndex){ //using bottom-up to maintain maxmium heap proprerty 
            	
            	
            	
                int biggerIndex=2*k+1; //left child first
                
                if(biggerIndex<lastIndex){
                	compTimes++;
                    if(arr[biggerIndex].compareTo(arr[biggerIndex+1])<0){
                        
                    	
                        biggerIndex++; //rigth child
                    }
                }
                compTimes++;
                if(arr[k].compareTo(arr[biggerIndex])<0){//if it is smaller than any children
                    
                    swap(arr,k,biggerIndex);//exchage parent with the biggest child
                    
                    k=biggerIndex; //k to children keep goiong to check with children
                    //the book use recussive, but actually it does not need. while loop is 
                    //good enough. some algorithms in the book is not good. that is maohua's personal opinion
                }else{
                    break;
                }
            }
        }
    }
	
	@Override
    public void sort(T[] arr, int unusedStart, int unusedEnd) {
        //did nothing
		heapSort(arr);
    }

//end class
}