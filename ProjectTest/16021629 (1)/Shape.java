abstract class Shape implements testInterface1 {
	protected int x;
	protected int y;
	protected String color;
	protected boolean isColored;
	protected boolean isMoved;
	private int type;

	public Shape(){
		this.x = 0;
		this.y = 0;
		this.color = "white";	
		this.isColored = true;
		this.isMoved = false;
	}

	public void setColor(String _color){
		this.color = _color;
	}


	public void setIsMove(boolean _move){
		this.isMoved = _move;
	}

	public void setIsColored(boolean _colored){
		this.isColored = _colored;
	}

	public boolean  isColored(){
		return isColored;
	}

	public boolean isMoved(){
		return isMoved;
	}
	abstract String toStringShape();
	abstract void move();

}

