package project1;
//designed by maohua zheng version 0.01
public abstract class SortingArray<T extends Comparable<T>> implements ISorting {
	//the T class must implements comparable interface
	// so it could sorting any objects in an array
	private T[] array=null;
	protected long compTimes=0;
	public abstract void sort(T[] arr,int start ,int end);
	public  long getComparTimes(){
		return compTimes;
	};
	
	public void sort()
	{
		if(array!=null){
			compTimes=0;
			sort(array,0,array.length-1);
		}

	}
	public void setArray(T[] arr)
	{
		array=arr;
	}
	
	public SortingArray(T[] arr)//constructor
	{
		array=arr;
	}

	public SortingArray()//constructor
	{
		array=null;
	}
	
	public String getSortName()
	{
		return "error";
	}
	 protected final void swap(T[] arr,int from ,int to) //can not be overrided
     {
		 if(from==to)return;
         T tmp=arr[from];
         arr[from]=arr[to];
         arr[to]=tmp;
     }
}

/*public abstract class SortingList<List<T extends Comparable<T>>> implements ISorting {
	//I will implements it in the future for any list sorting like tree
	public abstract void sort(List<T> list,int length);
	public void sort();
	public void setArray(List<T> arr);

}*/