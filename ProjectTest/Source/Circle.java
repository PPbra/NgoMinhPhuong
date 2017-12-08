class Circle extends Shape{
    private double radius;

    public Circle(){
        radius = 1;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public void setSize(double radius){
        this.radius = radius;
    }

    public double getSize(){
        return radius;
    }

    public String toString(){
        return "Circle(" + (new Double(radius)).toString() + ", " + position.toString() + ")";
    }
}
