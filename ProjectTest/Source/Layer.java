import java.util.*;

class Layer{
    private ArrayList<Shape> shapes;
    public Layer(){
        shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void delTriangle(){
        for (int i = 0; i < shapes.size(); ){
            if ( shapes.get(i) instanceof Triangle ){
                shapes.remove(shapes.get(i));
            }
            else{
                i++;
            }
        }
    }

    public void delCircle(){
        for (int i = 0; i < shapes.size(); ){
            if ( shapes.get(i) instanceof Circle ){
                shapes.remove(shapes.get(i));
            }
            else{
                i++;
            }
        }
    }

    public String toString(){
        String str = new String("");
        for (int i = 0; i < shapes.size(); i++){
            str += shapes.get(i).toString() + "\n";
        }
        return str;
    }
}
