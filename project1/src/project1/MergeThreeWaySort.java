package project1;

import java.util.ArrayList;

public class MergeThreeWaySort <T extends Comparable<T>> extends SortingArray<T> {

	public MergeThreeWaySort(T[] arr) {
		super(arr);
		// TODO Auto-generated constructor stub
	}
	
	public MergeThreeWaySort()
	{
		//did nothering
		super();
	}

	@Override
	public String getSortName()
	{
		return "3_way_Merge_sort";
	}
	
	@Override
    public void sort(T[] arr, int start, int end) {
        //do something in maohua's framework
		mergeSort(arr,start,end);
    }
	
	
	private void mergeSort(T[] arr, int p, int r) {
        if((p+1)<r){   
	        int q1=p+(r-p+1)/3;
	        int q2=p+(r-p+1)*2/3;
	        mergeSort(arr, p, q1);
	        mergeSort(arr, q1+1, q2);
	        mergeSort(arr, q2 + 1, r);
	        merge(arr, p, q1,q2, r);
        }else{
        	//System.out.println("p="+Integer.toString(p)+" r="+Integer.toString(r));
        	if(p<r){
	        	if(arr[p+1].compareTo(arr[p])<0){
	        		compTimes++;
	        		swap(arr,p+1,p);
	        	}
        	}
        		
        }

    }
	
	
	//designed by maohua zheng. If you want details,please contact me
	private void merge(T[] arr,int p,int q1,int q2,int r)
	{
		int left=p;
		int mid=q1+1;
		int right=q2+1;
		ArrayList<T> tempArr=new ArrayList<T>(); 
		while(left<=q1 && mid<=q2&&right<=r){ //until reach the end of left or right
	    	
			compTimes+=2;
	        if(arr[left].compareTo(arr[right])<=0
	        		&&arr[left].compareTo(arr[mid])<=0){
	        	
	        	tempArr.add(arr[left++]);
	         }else{
	        	 compTimes+=2;
	        	 if(arr[mid].compareTo(arr[right])<=0
	        		&&arr[mid].compareTo(arr[left])<=0){
	        		 
	        		 tempArr.add(arr[mid++]);
	        	 }else{
	        		 tempArr.add(arr[right++]);
	        	 }
	        }
	    }	
		
		
		//left means left start of left subarray
		//q means the left end of left subarray
		//right means the right start of right subary
		//r right means the right end of right subary
		//store r first
		int tempr=r;
		int q=p;
		
		if(left>q1&&mid<=q2&&right<=r){
			left=mid;
			q=q2;
		}else if(mid>q2&&left<=q1&&right<=r){
			q=q1;
		}else if(right>r&&left<=q1&&mid<=q2){
			right=mid;
			q=q1;
			r=q2;
		}
		if(q>p){
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
		}
		
		r=tempr;
		
		//for debug
		/*System.out.println("p="+Integer.toString(p)+" r="+Integer.toString(r)+" size="
								+Integer.toString(tempArr.size()));
		if(tempArr.size()<r-p+1){
			int test=0;
			test=1;
		}*/
		//for debug
		
	    for(int i=p;i<=r;i++)
	    {
	    	arr[i]=tempArr.get(i-p);
	     }
	    tempArr.clear();
		
		
	}
	
	
	//end class
}