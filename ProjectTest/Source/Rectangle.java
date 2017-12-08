class Rectangle extends Shape{
    protected Vector2 size;

    public Rectangle(){
        size = new Vector2(1, 1);
    }

    public Rectangle(double x, double y, double width, double length){
        super(x, y);
        size = new Vector2(width, length);
    }

    public void setSize(Vector2 size){
        this.size = size;
    }

    // public void setSize(double width, double length){
    //     this.size.set(width, length);
    // }

    public Vector2 getSize(){
        return size;
    }

    public String toString(){
        return "Rectangle(" + size.toString() + ", " + position.toString() + ")";
    }
}
