

/*
*
*doi tuong class
*
*/

import java.util.*;

public class classObject {

    private String className;
    private String fatherClass;
    private String implementsClass;
    private ArrayList<attribute> listAttribute;
    private ArrayList<method> listMethod;
    private int[] location;
    private boolean isExtends;
    private boolean isImplements;
    private boolean isInterface;
    private boolean isImplementsed;
    private  ArrayList<String> nameClassHas_is;

    public boolean isIsImplementsed() {
        return isImplementsed;
    }

    public void setIsImplementsed(boolean isImplementsed) {
        this.isImplementsed = isImplementsed;
    }

	classObject(){
            
            location = null;
            this.nameClassHas_is = null;
            this.isImplementsed  = false;
            this.fatherClass = null;
            this.implementsClass = null;
            this.className = null;
            this.isInterface = false;
            this.listAttribute = new ArrayList<attribute>();
            this.listMethod = new ArrayList<method>();

	}

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public ArrayList<String> getNameClassHas_is() {
        return nameClassHas_is;
    }

    public void setNameClassHas_is(ArrayList<String> nameClassHas_is) {
        this.nameClassHas_is = nameClassHas_is;
    }





    public ArrayList<attribute> getListAttribute() {
        return listAttribute;
    }

    public void setListAttribute(ArrayList<attribute> listAttribute) {
        this.listAttribute = listAttribute;
    }


    public void setIsInterface(boolean _a){
        this.isInterface = _a;
    }


    public boolean getIsInterface(){
        return this.isInterface;
    }


	public String getClassName(){
		return this.className;
	}


	public void setClassName(String s){
		this.className = s;
	}


	public String getFatherName(){
        
		return this.fatherClass;
	}


    public String getImplementsName(){

        return this.implementsClass;
    }


    public void addAttribute(attribute a){
            this.listAttribute.add(a);
    }


    public void addMethod(method a){
            this.listMethod.add(a);
    }


    public void setFatherName(String a){

        this.isExtends = true;
    	this.fatherClass=a;
    }


    public void setImplementsName(String a){
        
        this.implementsClass=a;
        this.isImplements = true;

    }


    public boolean getIsExtends(){
        
        return this.isExtends;
    }


    public boolean getIsImplements(){
        
        return this.isImplements;
    }

    //in class nay ra
    public Vector<String> print(){
        
        Vector<String> list = new Vector<String>();
        list.add(this.className);
        
        for(attribute a : this.listAttribute){
            list.add(a.print());
        }
        
        for(method a : this.listMethod){
            list.add(a.print());
        }

    	// if(this.fatherClass != null){
    	// 	System.out.println("------->Class name:  "+this.className +  " extends " + this.fatherClass);
    	// 	System.out.println("--->Attributes: ");
    	// 	for(attribute a:this.listAttribute){
    	// 		a.print();
    	// 	}
    	// 	System.out.println("--->Methods: ");
    	// 	for(method b:this.listMethod){
    	// 		b.print();
    	// 	}
    	// }else{
    	// 	System.out.println("------->Class name:  "+this.className);
    	// 	System.out.println("--->Attributes: ");
    	// 	for(attribute a:this.listAttribute){
    	// 		a.print();
    	// 	}
    	// 	System.out.println("--->Methods: ");
    	// 	for(method b:this.listMethod){
    	// 		b.print();
    	// 	}
    	// }
        return list;
	}

}
