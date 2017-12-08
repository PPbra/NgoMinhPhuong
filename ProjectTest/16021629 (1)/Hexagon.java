class Hexagon extends Shape{
	private point[] coordinates = new point[6];
	Hexagon(){}
	Hexagon(int a, int b, int c, int d,int e, int f, int g,int h,int i , int j ,int k, int l){
		coordinates[0] = new point();
		coordinates[1] = new point();
		coordinates[2] = new point();
		coordinates[3] = new point();
		coordinates[4] = new point();
		coordinates[5] = new point();
		coordinates[0].setX(a);
		coordinates[1].setX(c);
		coordinates[2].setX(e);
		coordinates[3].setX(g);
		coordinates[0].setY(b);
		coordinates[1].setY(d);
		coordinates[2].setY(f);
		coordinates[3].setY(h);
		coordinates[4].setX(i);
		coordinates[5].setX(k);
		coordinates[4].setY(j);
		coordinates[5].setY(l);
		
	

	}
	public int[] getP(){
		int[] a = new int[12];
		a[0] = coordinates[0].getX();
		a[1] = coordinates[1].getX();
		a[2] = coordinates[2].getX();
		a[3] = coordinates[3].getX();
		a[4] = coordinates[0].getY();
		a[5] = coordinates[1].getY();
		a[6] = coordinates[2].getY();
		a[7] = coordinates[3].getY();
		a[8] = coordinates[4].getX();
		a[9] = coordinates[5].getX();
		a[10] = coordinates[4].getY();
		a[11] = coordinates[5].getY();
		return a;
	}
	public String toStringShape(){
		return "A("+this.coordinates[0].getX()+","+this.coordinates[0].getY()+")"+","+"B("+this.coordinates[1].getX()+","+this.coordinates[1].getY()+")"+","+"C("+this.coordinates[2].getX()+","+this.coordinates[2].getY()+")"+","+"D("+this.coordinates[3].getX()+","+this.coordinates[3].getY()+")"+"E("+this.coordinates[4].getX()+","+this.coordinates[4].getY()+")"+"F("+this.coordinates[5].getX()+","+this.coordinates[5].getY()+")";
	}
	public void move(){}
}
class point{
	private int x;
	private int y;
	public void setX(int  _x){
		this.x = _x;
	}
	public int getX(){
		return x;
	}
	public void setY(int _y){
		this.y = _y;
	}

	public int getY(){
		return y;
	}

}