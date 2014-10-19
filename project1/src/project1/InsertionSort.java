package project1;

final public class InsertionSort<T extends Comparable<T>> extends SortingArray<T> {

	public InsertionSort(T[] arr) {
		super(arr);
		// TODO Auto-generated constructor stub
	}
	
	public InsertionSort()
	{
		//did nothering
		super();
	}

	@Override
	public String getSortName()
	{
		return "Insert_sort";
	}
	
	@Override
	public void sort(T[] arr, int start, int end) {
		// TODO Auto-generated method stub
		// if want just sort from a special index with length subarry.could just call this fuction
		//and ignore the interface Isorting call sort()
		T tmp=null;
		if(end>=arr.length||start>=end)return; //can not exceed the array start=p end=r
		
        for(int i=start+1;i<=end;i++)
        {
            tmp=arr[i];
            int j=i;
            for(;j>start;j--)
            {
            	compTimes++;
                if(tmp.compareTo(arr[j-1])<0)
                {
                    arr[j]=arr[j-1]; //keep to move the large number to right like card game
                    
                }
                else break;
            }
            arr[j]=tmp;
        }

	}

	//end class
}
