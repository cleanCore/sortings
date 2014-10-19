package project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//provide int array to sorting algorithms
//will make the array generic in the future. I dont have time to design it now.
//maohua zheng
public class IntArray {
	private Integer[] array=null;
	private List<Integer> internData=null;
	private String xmlName="dataSettings.xml";//must be in the root of project1
	private XmlParse<DataSetsForXml> xmlParse=new XmlParse<DataSetsForXml>(DataSetsForXml.class,"file");
	ArrayList<DataSetsForXml> dataSetsList;
	//file is tag
	public Integer[] getIntegerArray()
	{
		return array;
	}
	
	public IntArray(String name)
	{
		this();
		xmlName=name;
		
	}
	
	public IntArray()
	{
		if(null!=xmlParse){
			dataSetsList=xmlParse.runXmlParse(xmlName);
			//System.out.println(dataSetsList.get(0).toString());//for my testing. the xml class.
		}
	}
	
	public void printOut(int index)
	{
		if(index>=DataSetsTotal()||index<=-1)return;
		System.out.print(//" file name="+dataSetsList.get(index).getName()+
						 " size="+Integer.toString(dataSetsList.get(index).getSize())+ 
						 " model="+dataSetsList.get(index).getModel().toString());
	}
	
	public void reSet(){
		if(internData!=null){
			if(array==null||array.length!=internData.size())//empty or changed to another size
				array=new Integer[internData.size()];
			
			for(int i=0; i<internData.size();i++){
				array[i]=new Integer(internData.get(i).intValue());  //a lot of gc action may happen
			}
			System.gc();//suggest gc but not guarantee
		}	
	}
	
	public int DataSetsTotal()
	{
		if(xmlParse!=null&&dataSetsList!=null)return dataSetsList.size();
		return 0;
	}
	
	public void load(int index){
		
		 if(index>=DataSetsTotal()||index<=-1)return;
		 try {  
			DataSetsForXml dataSet=dataSetsList.get(index);
			if(dataSet==null)throw new Exception("load datasets fail");
			String pathname =dataSet.getName();
			if(dataSet.getSize()<=0)
				throw new Exception("the size in dataset file:"
						+pathname+" does not match the size in datasetting.xml ");
			
			internData=new ArrayList<Integer>();
			
			File filename = new File(pathname);  
			InputStreamReader reader = new InputStreamReader(  
											new FileInputStream(filename));
			@SuppressWarnings("resource")
			BufferedReader bufferReader= new BufferedReader(reader);  
			String line = "";  
			line =bufferReader.readLine();  
			while (line != null) {  
				if(line.trim().length() == 0)continue;//ignore blank
				internData.add(new Integer(Integer.parseInt(line)));
				if(internData.size()>=dataSet.getSize())break;
				line = bufferReader.readLine();
				
			}  
			if(internData.size()<dataSet.getSize())throw new Exception
								("the size in datasetting.xml is large than the acctual size(lines) in "
										+pathname);
			
			
		 	} catch (Exception e) {  
		 		e.printStackTrace();  
		 	}  

		
	}
	
		
		
	public void load(DataGenerateModel model,int size,int value)//from intern data generation for test
	{
		switch(model)
		{
			case random:
				internData=GenerateIntegerDataset.Generate("",new int[]{size});
				break;
			case sorted:
				internData=GenerateIntegerDataset.Generate("sorted",new int[]{size});
				break;
			case revesr_sort:
				internData=GenerateIntegerDataset.Generate("reversed",new int[]{size});
				break;
			case identical:
				internData=GenerateIntegerDataset.Generate("",new int[]{size,value});
				break;
			default:
				break;
		}
			
	}
	
	
	//end class
}
