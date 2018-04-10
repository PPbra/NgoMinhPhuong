


import java.util.ArrayList;


public class method extends attributeAndMethod{

    private ArrayList<String> arguments;
    method(String _level , String _isFinal , String _isStatic , String _type , String _name , ArrayList<String> _arguments){
        this.name = _name;
        this.level = _level;
        this.isStatic = _isStatic;
        this.type = _type;
        this.isFinal = _isFinal;
        this.arguments = _arguments;
    }
    //xu ly neu cac thong tin mac dinh khi phan tich bi thieu
    private void fixThisProperties(){
        if(this.level == null){
            this.level = "default";
        }
        if(this.isStatic == null){
            this.isStatic = "non-static";
        }
        if(this.isFinal == null){
            this.isFinal = "non-final";
        }
    }
    //in ra phuong thuc
    public String  print(){
        this.fixThisProperties();
        String levelTmp = null;
        if(this.level.equals("private")){
            levelTmp = "-";
        }else if(this.level.equals("protected")){
            levelTmp = "->";
        }else if(this.level.equals("public")){
            levelTmp = "+";
        }else if(this.level.equals("default")){
            levelTmp = "~";
        }
        String s = null;
        if(this.name!=null){
            if(this.arguments!=null){
                String listArguments = null;
                if(this.arguments.size() > 1){
                    for(int i = 0 ; i  < arguments.size() ; i++ ){
                        listArguments=arguments.get(i)+":";
                    }
                }
                else{

                    listArguments=this.arguments.get(0);
                }
                s = "("+levelTmp+")"  +this.name+"("+listArguments+")" + ":" +this.type;
            }
            else{
                s = "("+levelTmp+")" + this.name+"()" + ":" +this.type;

            }
        }
        
        return s;

        
        
    }
}
