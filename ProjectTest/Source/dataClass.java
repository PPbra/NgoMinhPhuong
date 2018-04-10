
import javax.swing.*;
import java.util.*;
/*
*
*Lua thong tin cac class phan tich duoc 
*/

import java.util.ArrayList;


public class dataClass {
    private ArrayList<classObject> listClass;
    private Vector<Vector<classObject>> a;
	dataClass(){
		listClass = new ArrayList<classObject>();
	}
	public ArrayList<classObject> getList(){
                this.setHas_isForEachClass();
		return this.listClass;
	}
	public void addClass(classObject tmp){
		this.listClass.add(tmp);
	}
	// public Vector<classObject> arrange (classObject a,classObject b,Vector<classObject> list){
	// 	if(a.getClassName().equals(b.getClassName())){
	// 		list.add(b);
	// 	}
	// 	return list;
	// }
	// public Vector<Vector<classObject>> ab(){
	// 	Vector<classObject> a = new Vector<classObject>();
	// 	for(classObject test:this.listClass){
	// 		if(!test.getIsExtends()){
	// 			a.add(test);
	// 		}
	// 	}
	// 	Vector<classObject> b = new Vector<classObject>();
	// 	for(int i =0 ; i < a.size() ; i++){
	// 		for(classObject test:this.listClass){
	// 			if(!test.getIsExtends()){
	// 				b.add(test);
	// 			}
	// 		}
	// 	}
	// 	for(int i =0 ; i < a.size() ; i++){
	// 		for(classObject test:this.listClass){
	// 			if(!test.getIsExtends()){
	// 				b.add(test);
	// 			}
	// 		}
	// 	}
	// }
	//in toan bo cac class ra
        public void setHas_isForEachClass(){
            for(int i = 0 ; i < this.listClass.size() ; i++){
                
                ArrayList<String> tmp = new ArrayList<String>();
                
                for(attribute atb : this.listClass.get(i).getListAttribute()){
                    
                    
                    for(int j = 0 ; j < this.listClass.size() ; j++){
                       
                        if(i!=j)
                            if(atb.getType()!=null&&this.listClass.get(j).getClassName()!=null)
                            if(atb.getType().contains(this.listClass.get(j).getClassName())){
                            
                                if(atb.getType().contains("ArrayList") 
                                   || atb.getType().contains("Vector")
                                   ||atb.getType().contains("[]")
                                   ||atb.getType().contains("List")){
                                    
                                        String s = "HasA" + this.listClass.get(j).getClassName();
                                        tmp.add(s);
                                        
                                }
                                else{
                                    String s = "IsA" + this.listClass.get(j).getClassName();
                                    tmp.add(s);
                                }
                            }
                    
                    }
                }
                
                this.listClass.get(i).setNameClassHas_is(tmp);
            }
        }
        
	public Vector<JList> printAllClass(){
		Vector<JList> list = new Vector<JList>();
		for(classObject test:this.listClass){
			JList a = new JList<String>(test.print());
			list.add(a);
		}
		return list;
	}

}
