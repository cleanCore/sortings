package project1;



public class DataSetsForXml extends IXmlData {

	private String mName;
	private int mSize;
	private DataGenerateModel mModel;

	
	
	public DataSetsForXml(){
		mSize=-1;
		
	}
	
	public DataSetsForXml(String name, int size, String flag) {
		this.mName = name;
		this.mSize = size;
		this.mModel = DataGenerateModel.transferToModel(flag);
		
	}
	public int getSize() {
		return mSize;
	}
	
	public void setSize(int size) {
		this.mSize=size;
	}
	
	public void setSize(String sizeStr) {
		if(sizeStr==" ")
			this.mSize = -1;
		else
			this.mSize=Integer.parseInt(sizeStr);
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}


	public DataGenerateModel getModel() {
		return mModel;
	}

	public void setModel(String type) {
		this.mModel =DataGenerateModel.transferToModel(type);
		// if tpye is " ",then mModel==null;
	}	
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name:" + getName());
		sb.append(", ");
		sb.append("size:" + getSize());
		sb.append(", ");
		sb.append("model:");
		if(mModel== null)
			sb.append("null");
		else
			sb.append(getModel().toString());
		sb.append(".");
		
		return sb.toString();
	}

	@Override
	public void save(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=3)return;
		setName(args[0]);
		setSize(args[1]);
		setModel(args[2]);
		
		
	}

	@Override
	public String[] sendRequest() {
		// TODO Auto-generated method stub
		return new String[]{"name","size","model"};
	}
}