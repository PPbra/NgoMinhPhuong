


public class attributeAndMethod{
	/*
	*int,float,...
	*
	*/
	protected String type;
	/*
	*Private
	*Public
	*Protected
	*Pakage
	*/
    protected String level;
    /*
	*Name of this.
	*/
    protected String name;
    /*
	*Stactic-nonStatic
	*/
    protected String isStatic;
	/*
	*Final-nonFinal
	*/
	protected String isFinal;
    /*
	*phuong thuc Set/Get 
	*/
	public void setIsStatic(String a){
		this.isStatic = a;
	}

	public String getIsStatic(){
		return this.isStatic;
	}
	public void setisFinal(String a){
		this.isFinal = a;
	}
	public String getIsFinal(){
		return this.isFinal;
	}
    public void setName(String a){
        this.name = a;
    }
    public void setType(String a){
        this.type = a;
    }
    
    public void setLevel(String a){
        this.level = a;
    }
    public String getType(){
        return this.type;
    }
    public String getLevel(){
        return this.level;
    }
    public String getName(){
    	return this.name;
    }
    

}