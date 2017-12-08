// class Triangle extends Shape{
//     private Vector2 a;
//     private Vector2 b;
//     private Vector2 c;
//
//     public Triangle(){
//         a = new Vector2(0, 0);
//         b = new Vector2(0, 0);
//         c = new Vector2(0, 0);
//         this.position.set(0, 0);
//     }
//
//     public Triangle(Vector2 a, Vector2 b, Vector2 c){
//         this.a = a;
//         this.b = b;
//         this.c = c;
//         double x = (a.getX() + b.getX() + c.getX()) / 3;
//         double y = (a.getY() + b.getY() + c.getY()) / 3;
//         this.position.set(x, y);
//     }
//
//     public void setA(Vector2 a){
//         this.a = a;
//         double x = (this.a.getX() + this.b.getX() + this.c.getX()) / 3;
//         double y = (this.a.getY() + this.b.getY() + this.c.getY()) / 3;
//         this.position.set(x, y);
//     }
//
//     public void setB(Vector2 b){
//         this.b = b;
//         double x = (this.a.getX() + this.b.getX() + this.c.getX()) / 3;
//         double y = (this.a.getY() + this.b.getY() + this.c.getY()) / 3;
//         this.position.set(x, y);
//     }
//
//     public void setC(Vector2 c){
//         this.c = c;
//         double x = (this.a.getX() + this.b.getX() + this.c.getX()) / 3;
//         double y = (this.a.getY() + this.b.getY() + this.c.getY()) / 3;
//         this.position.set(x, y);
//     }
//
//     public Vector2 getA(){
//         return a;
//     }
//
//     public Vector2 getB(){
//         return b;
//     }
//
//     public Vector2 getC(){
//         return c;
//     }
// }


class Triangle extends Shape{
    private double a;
    private double b;
    private double c;

    public Triangle(){
        a = 3;
        b = 4;
        c = 5;
    }

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setSize(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public double getC(){
        return c;
    }

    public String toString(){
        return "Triangle((" + (new Double(a)).toString() + (new Double(b)).toString()
        + (new Double(c)).toString() + "), " + position.toString() + ")";
    }

}
