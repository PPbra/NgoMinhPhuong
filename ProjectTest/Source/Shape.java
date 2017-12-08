class Shape{
    protected Vector2 position;
    protected String color;
    protected boolean isFilled;
    protected boolean isMove;

    public Shape(){
        position = new Vector2(0, 0);
        color = new String("white");
        isFilled = true;
        isMove = false;
    }

    public Shape(double x, double y){
        position = new Vector2(x, y);
        color = new String("white");
        isFilled = true;
        isMove = false;
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }

    public void setPosition(double x,double y){
        this.position.set(x, y);
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setFilled(boolean filled){
        this.isFilled = filled;
    }

    public void setMove(boolean move){
        this.isMove = move;
    }

    public Vector2 getPosition(){
        return position;
    }

    public String getColor(){
        return color;
    }

    public boolean isFilled(){
        return isFilled;
    }

    public boolean isMove(){
        return isMove;
    }
}
