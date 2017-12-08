import java.util.*;

class Diagram{
    private ArrayList<Layer> layers;

    public Diagram(){
        layers = new ArrayList<Layer>();
    }

    public void addLayer(Layer layer){
        layers.add(layer);
    }

    public void delCircles(){
        for (int i = 0; i < layers.size(); i++)
            layers.get(i).delCircle();
    }

    public String toString(){
        String str = new String("");
        for (int i = 0; i < layers.size(); i++){
            str += layers.get(i).toString() + "\n";
        }
        return str;
    }
}
