

/*
*
*
*doc va phan tich mot file trong folder
*
*/


import java.io.*;
import java.util.*;



public class readOneFile{

    private ArrayList<String> loadPropertiesClass(String PathFile){
        
        preprocessorOneClass testPreprocessor = new preprocessorOneClass();
        ArrayList<String> listLines = new ArrayList<String>();
        listLines = testPreprocessor.removeComment(PathFile);
        return listLines;
    }

    public classObject analyzeOneFile(String pathFile){
        /*
        *
        *
        phan tich mot file chua class
        *
        *
        *
        */
        classObject testClass = new classObject();
        ArrayList<String> listLines = new ArrayList<String>();
        listLines = this.loadPropertiesClass(pathFile);
        boolean insideMethod = false;//xet xem co trong thuoc tinh hay khong
        String classNameTemp = null;

        for(int i = 0 ; i < listLines.size() ; i++){

            String line = listLines.get(i);

            if(line.contains("interface")){

                String[] arrayString = line.split(" ");
                for(int j = 0 ; j < arrayString.length ; j++){
                    if(arrayString[j].equals("interface")){
                        testClass.setIsInterface(true);
                        if(arrayString[j+1].contains("{")){
                            testClass.setClassName(arrayString[j+1].split("\\{")[0].trim());
                        }else{
                            testClass.setClassName(arrayString[j+1].trim());
                        }
                        //System.out.println(testClass.getClassName());
                        
                    }
                }
            }
        }

        for(int i = 0 ; i < listLines.size() ; i++){
            String line = listLines.get(i);
            if(line.contains("class")){
                /*
                *
                *lay ten class*
                *
                */
                String[] arrayString = listLines.get(i).split(" ");
                for(int j = 0 ; j < arrayString.length ; j++){

                    if(arrayString[j].equals("class")){
                        if(arrayString[j+1].contains("{")){
                            testClass.setClassName(arrayString[j+1].split("\\{")[0].trim());
                        }else{
                            testClass.setClassName(arrayString[j+1].trim());
                        }

                            classNameTemp = arrayString[j+1];
                        if(arrayString.length >= j+3){
                            if(arrayString[j+2].equals("extends"))
                                if(arrayString[j+3].contains("{")){
                                    testClass.setFatherName(arrayString[j+3].split("\\{")[0].trim());
                                }else{
                                    testClass.setFatherName(arrayString[j+3].trim());
                                }
                        }
                        if(arrayString.length >= j+5){
                            if(arrayString[j+4].equals("implements")){
                                testClass.setIsImplementsed(true);
                                testClass.setImplementsName(line.split("implements")[1].trim());
                                //System.out.println(testClass.getImplementsName());
                            }
//                                if(arrayString[j+5].contains("{")){
//                                    testClass.setImplementsName(arrayString[j+5].split("\\{")[0].trim());
//                                }else{
//                                    testClass.setImplementsName(arrayString[j+5].trim());
//                                }
                        }
                    }
                }
                continue;
            }
                /*
                *
                *phan tich de lay mot thuoc tinh 
                *
                */
                //Khong phai la import
            if(line.endsWith(";") && insideMethod == false&&!line.contains("package")){
                //khi co nhieu thuoc tinh tren 1 dong
                if(line.contains(",")){
                    if(line.contains("{")&&line.contains("}")&&line.contains("=")){
                        attribute testAttribute;
                        String[] attributePropertiesContainer = line.split("\\=")[0].trim().split(" ");
                        String[] propertiseAttribute = analyzeattributeMethod(attributePropertiesContainer);
                        testAttribute = new attribute(  propertiseAttribute[0],
                                                        propertiseAttribute[1],
                                                        propertiseAttribute[2],
                                                        propertiseAttribute[3],
                                                        propertiseAttribute[4]);
                        if(propertiseAttribute[4]!=null){
                            testClass.addAttribute(testAttribute);
                        }
                    }else{
                    String attributeProperties = line.split("\\=")[0].trim();
                    String[] attributePropertiesContainer = attributeProperties.split(" ");
                    attribute testAttribute;
                    String[] propertiseAttribute = analyzeattributeMethod(attributePropertiesContainer);
                    testAttribute = new attribute(  propertiseAttribute[0],
                                                    propertiseAttribute[1],
                                                    propertiseAttribute[2],
                                                    propertiseAttribute[3],
                                                    propertiseAttribute[4]);
                    String[] ortherattributeNameContainer = line.split("\\,");

                    ArrayList<String> ortherattributeName = new ArrayList<String>();
                    //su ly cac truong hop dac biet
                    for(String tmp:ortherattributeNameContainer){
                        //khi co chua dau "=""

                        if(tmp.contains("=")){
                            tmp = tmp.split("\\=")[0];
                            //khi ten canh dau ";"
                            if(tmp.contains(";")){
                                ortherattributeName.add(tmp.trim().split("\\;")[0].trim());
                            }else{
                                      ortherattributeName.add(tmp.trim());
                                }
                        }else{
                                if(tmp.contains(";")){
                                    ortherattributeName.add(tmp.trim().split("\\;")[0].trim());
                                }else{
                                    ortherattributeName.add(tmp.trim());
                                    }
                            }

                    }
                    ArrayList<attribute> ortherTestattribute = new ArrayList<attribute>();
                    for(int j = 1 ; j < ortherattributeName.size() ; j++){
                        if(ortherattributeName.get(j).equals(testAttribute.getName())){
                                                    attribute ortherattribute = new attribute(  propertiseAttribute[0],
                                                                    propertiseAttribute[1],
                                                                    propertiseAttribute[2],
                                                                    propertiseAttribute[3],
                                                                    ortherattributeName.get(j));
                        //khong nhap vao thuoc tinh co ten rong
                        if(propertiseAttribute[4].equals(null)){
                            ortherTestattribute.add(ortherattribute);//luu thuoc tinh vao class
                        }
                        }

                    }
                    for(int j = 0 ; j < ortherTestattribute.size()+1 ; j++){
                        if(j==0){
                            testClass.addAttribute(testAttribute);
                        }else{
                            testClass.addAttribute(ortherTestattribute.get(j-1));
                        }
                    }
                    }
                }else{
                    if(!line.contains("=")){
                        attribute testAttribute;
                        String[] attributePropertiesContainer = line.split(";")[0].split(" ");
                        String[] propertiseAttribute = analyzeattributeMethod(attributePropertiesContainer);
                        testAttribute = new attribute(  propertiseAttribute[0],
                                                        propertiseAttribute[1],
                                                        propertiseAttribute[2],
                                                        propertiseAttribute[3],
                                                        propertiseAttribute[4]);
                        if(propertiseAttribute[4]!=null)
                            testClass.addAttribute(testAttribute);
                    }else if(line.contains("=")){
                        attribute testAttribute;
                        String[] attributePropertiesContainer = line.split("=")[0].split(" ");
                        String[] propertiseAttribute = analyzeattributeMethod(attributePropertiesContainer);
                        testAttribute = new attribute(  propertiseAttribute[0],
                                                        propertiseAttribute[1],
                                                        propertiseAttribute[2],
                                                        propertiseAttribute[3],
                                                        propertiseAttribute[4]);
                        if(propertiseAttribute[4]!=null){
                            testClass.addAttribute(testAttribute);
                        }
                    }


                }
            }else {
                /*
                *
                *lay mot phuong thuc
                *
                *
                */
                //truong hop dong chua thong tin phuong thuoc co dang "A B C D E(){""
                if (line.contains("{")) {
                    insideMethod = true;
                    //kiem tra xem co dang trong va tren dong cua phuong thuc khong
                    if (insideMethod == true) {
                        if (line.contains("(") && line.contains(")")) {
                            method testMethod;
                            String[] methodLineContainer = line.split("\\(");
                            String[] methodPropertiesContainer = methodLineContainer[0].trim().split(" ");
                            String[] methodArgumentsCotainer = null;
                            String[] methodProperties = analyzeattributeMethod(methodPropertiesContainer);
                            ArrayList<String> testArguments;
                            //khi kha nang co tham so dau vao
                            if(!line.contains("()")){
                                testArguments = new ArrayList<String>();
                                methodArgumentsCotainer = methodLineContainer[1].split("\\)")[0].split("\\,");
                            }else{
                                testArguments = null;
                                }
                            if(methodArgumentsCotainer != null){
                                for(String argument : methodArgumentsCotainer ){
                                //String[] OneArguemntContainer = argument.split(" ");
                                testArguments.add(argument) ;
                                }
                            }
                        if(methodProperties[4] != null)
                            //Loai cac phuong thuc main va khoi tao
                            if(!methodProperties[4].equals("main")&&!methodProperties[4].equals(classNameTemp)){
                                testMethod = new method(methodProperties[0],
                                                        methodProperties[1],
                                                        methodProperties[2],
                                                        methodProperties[3],
                                                        methodProperties[4],
                                                        testArguments);
                                if(methodProperties[4]!=null)//loai bo phuong thuc co ten rong
                                    testClass.addMethod(testMethod);//luu phuong thuc vao class
                            }

                        }
                    }
                    //truong hop dong chua thong tin phuong thuoc co dang "A B C D E()"
                }else if(line.contains("(")&& line.contains(")")&&insideMethod == false){
                            insideMethod = true;
                            method testMethod;
                            String[] methodLineContainer = line.split("\\(");
                            String[] methodPropertiesContainer = methodLineContainer[0].trim().split(" ");
                            String[] methodArgumentsCotainer = null;
                            String[] methodProperties = analyzeattributeMethod(methodPropertiesContainer);
                            ArrayList<String> testArguments;
                            if(!line.contains("()")){
                                testArguments = new ArrayList<String>();
                                methodArgumentsCotainer = methodLineContainer[1].split("\\)")[0].split("\\,");
                            }else{
                                testArguments = null;
                            }
                            if(methodArgumentsCotainer != null){
                                for(int j = 0 ; j < methodArgumentsCotainer.length ; j++){
                                String[] OneArguemntContainer = methodArgumentsCotainer[j].split(" ");
                                testArguments.add(OneArguemntContainer[0]);
                                }
                            }
                            if(methodProperties[4] != null)
                                if(!methodProperties[4].equals("main")&&!methodProperties[4].equals(classNameTemp)){
                                    testMethod = new method(methodProperties[0],
                                                            methodProperties[1],
                                                            methodProperties[2],
                                                            methodProperties[3],
                                                            methodProperties[4],
                                                            testArguments);
                                if(methodProperties[4]!=null)
                                    testClass.addMethod(testMethod);
                                }

                        }

                        if (line.contains("}")) {
                            insideMethod=false;
                        }

                }
        }

        return testClass;
    }

    /*
    *
    *
    *phan tich va lay ra thong tin cu the cua dong chua Phuong thuc va Thuoc tinh
    *
    *
    */
    public String[] analyzeattributeMethod (String[] propertiesContainer){
        String _type = null;
        String _name = null;
        String _level = null;
        String _isFinal = null;
        String _isStatic = null;
        if(propertiesContainer.length == 5){
            for(int i = 0 ; i < 3 ; i++){
                if( propertiesContainer[i].equals("private")
                    ||propertiesContainer[i].equals("public")
                    ||propertiesContainer[i].equals("protected")){
                        _level = propertiesContainer[i];
                }
                if(propertiesContainer[i].equals("static")){
                    _isStatic = propertiesContainer[i];
                }
                if(propertiesContainer[i].equals("final")){
                    _isFinal = propertiesContainer[i];
                }
            }
            _type = propertiesContainer[3];
            _name = propertiesContainer[4];
        }else if(propertiesContainer.length == 4){
                if(isLevel(propertiesContainer[0])){
                    if(propertiesContainer[1].equals("static")){
                        _type = propertiesContainer[2];
                        _name = propertiesContainer[3];
                        _level = propertiesContainer[0];
                        _isStatic = propertiesContainer[1];
                        _isFinal = "non-final";
                    }else if(propertiesContainer[1].equals("final")){
                            _type = propertiesContainer[2];
                            _name = propertiesContainer[3];
                            _level = propertiesContainer[0];
                            _isFinal = propertiesContainer[1];
                            _isStatic = "non-static";
                            }
                }else{
                    if(propertiesContainer[0].equals("static")){
                        if(isLevel(propertiesContainer[1])){
                            _type = propertiesContainer[2];
                            _name = propertiesContainer[3];
                            _level = propertiesContainer[1];
                            _isStatic = propertiesContainer[0];
                            _isFinal = "non-final";
                        }else   if(propertiesContainer[1].equals("final")){
                                    _type = propertiesContainer[2];
                                    _name = propertiesContainer[3];
                                    _isStatic = propertiesContainer[0];
                                    _isFinal = propertiesContainer[1];
                                    _level = "default";
                                }
                    }else{
                        if(propertiesContainer[0].equals("final")){
                            if(isLevel(propertiesContainer[1])){
                                _type = propertiesContainer[2];
                                _name = propertiesContainer[3];
                                _level = propertiesContainer[1];
                                _isFinal = propertiesContainer[0];
                                _isStatic = "non-static";
                            }else   if(propertiesContainer[1].equals("static")){
                                        _type = propertiesContainer[2];
                                        _name = propertiesContainer[3];
                                        _isStatic = propertiesContainer[1];
                                        _isFinal = propertiesContainer[0];
                                        _level = "default";
                                    }
                        }
                        }

                    }
                }else   if(propertiesContainer.length == 3){
                            if(isLevel(propertiesContainer[0])){
                                _type = propertiesContainer[1];
                                _name = propertiesContainer[2];
                                _level = propertiesContainer[0];
                                _isFinal = "non-final";
                                _isStatic = "non-static";
                            }else   if(propertiesContainer[0].equals("static")){
                                        _type = propertiesContainer[1];
                                        _name = propertiesContainer[2];
                                        _isStatic = propertiesContainer[0];
                                        _isFinal = "non-final";
                                        _level = "default";
                                    }else{
                                        _type = propertiesContainer[1];
                                        _name = propertiesContainer[2];
                                        _isFinal = propertiesContainer[0];
                                        _level = "default";
                                        _isStatic = "non-static";
                            }
                    }else{
                        if(propertiesContainer.length == 3){
                            _type = propertiesContainer[0];
                            _name = propertiesContainer[1];
                            _level = "default";
                            _isFinal = "non-final";
                            _isStatic = "non-static";
                        }
                    }
    String[] getValue = new String[5];
    getValue[0] = _level;
    getValue[1] = _isFinal;
    getValue[2] = _isStatic;
    getValue[4] = _name;
    getValue[3] = _type;
    return getValue;
    }

private boolean isLevel(String tmp){
    if(tmp.equals("private")||tmp.equals("protected")||tmp.equals("public"))
        return true;
    else
        return false;
}


}

 
