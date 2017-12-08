class Square extends Rectangle{
    public Square(){

    }

    public Square(double size){
        this.size.set(size, size);
    }

    public void setSize(double size){
        this.size.set(size, size);
    }

    public Vector2 getSize(){
        return size;
    }

    public String toString(){
        return "Square(" + size.toString() + ", " + position.toString() + ")";
    }
}
