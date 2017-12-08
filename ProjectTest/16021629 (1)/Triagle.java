class Triagle extends Shape implements testInterface1,testInterface2,testInterface3{
	private point[] coordinates = new point[4];
	Triagle(){}
	Triagle(int a, int b, int c,int d,int e,int f){
		coordinates[0] = new point();
		coordinates[1] = new point();
		coordinates[2] = new point();
		coordinates[0].setX(a);
		coordinates[1].setX(c);
		coordinates[2].setX(e);
		coordinates[0].setY(b);
		coordinates[1].setY(d);
		coordinates[2].setY(f);
	}
	public int[] getP(){
		int[] a = new  int[6];
		a[0] = coordinates[0].getX();
		a[1] = coordinates[1].getX();
		a[2] = coordinates[2].getX();
		a[3] = coordinates[0].getY();
		a[4] = coordinates[1].getY();
		a[5] = coordinates[2].getY();
		return a;
	}
	public String toStringShape(){
		return "A("+this.coordinates[0].getX()+","+this.coordinates[0].getY()+")"+","+"B("+this.coordinates[1].getX()+","+this.coordinates[1].getY()+")"+","+"C("+this.coordinates[2].getX()+","+this.coordinates[2].getY()+")";
	}
	public void move(){}
}

