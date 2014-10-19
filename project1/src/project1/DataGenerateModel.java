package project1;
//maohua zheng version 0.01
public enum DataGenerateModel {
	random,   //random without any sort or reverse
	sorted,   //random generate and sorted
	revesr_sort, //random generate and reverse
	identical;    //all the same number
	final static DataGenerateModel transferToModel(String flag)
	{
		switch(flag)
		{
			case "random":
				return random;
			case "sorted":
				return sorted;
			case "reverse_sort":
				return revesr_sort;
			case "identical":
				return identical;
			default:
				break;		
		}
		return null;
	}
}
