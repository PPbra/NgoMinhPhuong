class Vector2{
    private double x;
    private double y;

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String toString(){
        return "(" + (new Double(x)).toString() + ", " + (new Double(y)).toString() + ")";
    }
}
