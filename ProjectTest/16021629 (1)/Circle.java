class Circle extends Shape{
	private point A;
	private int radius;
	Circle(){
		this.A = new point();
		this.radius = 0;
	}
	Circle(int a , int b ,int c){
		A = new point();
		A.setX(a);
		A.setY(b);
		this.radius = c;
	}
	public int[] getP(){
		int[] a = new int[3];
		a[0] = A.getX();
		a[1]  = A.getY();
		a[2] = this.radius;
		return a;
	}
	public int getRadius(){
		return this.radius;
	}
	public String toStringShape(){
		return "O("+this.A.getX()+","+this.A.getY()+")" + " Radius:" + this.getRadius();
	}
	public void move (){}
}

