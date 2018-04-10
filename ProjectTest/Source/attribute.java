



public class attribute extends attributeAndMethod {
    attribute(String _level , String _isFinal , String _isStatic , String _type , String _name){
        this.name = _name;
        this.level = _level;
        this.isStatic = _isStatic;
        this.type = _type;
        this.isFinal = _isFinal;
    }
    //xu ly cac thong tin mac dinh bi thieu
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
    //in ra
    public String print(){
        this.fixThisProperties();
        String levelTmp = null;
        if(this.level!=null){
            if(this.level.equals("private")){
                levelTmp = "-";
            }else if(this.level.equals("protected")){
                levelTmp = "->";
            }else if(this.level.equals("public")){
                levelTmp = "+";
            }else if(this.level.equals("default")){
                levelTmp = "~";
            }
        }

        String s = null;
        if(this.name!=null){
            s = "("+levelTmp+")" +this.isStatic + "-"+ this.isFinal+ "-"+ this.name+":"+this.type;
        }
        return s;
    }
    
    
    @Override
        public String getType(){
            return this.type;
        }
}
