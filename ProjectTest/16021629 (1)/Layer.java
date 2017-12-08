class Layer{
	final int MAX = 100;
	private boolean visible ;
	private ArrayList <Shape> testShape;
	public Layer(){
		this.testShape = new ArrayList<Shape>();
		this.visible = true;
	}
	public void setVisible(boolean _visible){
		visible  = _visible;
	}
	public boolean isVisible(){
		return visible;
	}
	public void addShape(Shape a){
		testShape.add(a);
	}

/*	public void addAShape(){
		//Them một Shape theo loại 
		Scanner input = new Scanner(System.in);
		System.out.println("Choose type shape u wanna add:");
		System.out.println("1:Rectangle");
		System.out.println("2:Square");
		System.out.println("3:Triagle");
		System.out.println("4:Circle");
		int choice;
		choice = Integer.parseInt(input.nextLine());
		if(choice == 1){
			Shape  _a = new Retangle();
			Retangle _b = (Retangle)_a;
			testShape.add(_b);
		}
		else{
			if(choice  == 2){
				Shape _a =  new Square();
				Square _b = (Square)_a;
				testShape.add(_b);
			}
			else{
				if(choice == 3){
					Shape _a = new Triagle();
					Triagle _b = (Triagle)_a;
					testShape.add(_b);
					}
					else{
						if(choice == 4){
							Shape _a = new Circle();
							Circle _b = (Circle)_a;
							testShape.add(_b);
						}
					}
				}
			}
		}
*/


public void deleteType(int choice){
	//Xóa hết 1 loại shape
	if(choice == 1){
			for(int i = 0 ; i < testShape.size() ; i++){
					if(testShape.get(i) instanceof Retangle ){
						testShape.remove(testShape.get(i));  
			}
		}
	}
		else{
			if(choice  == 2){
						for(int i = 0 ; i < testShape.size() ; i++){
					if(testShape.get(i) instanceof Square ){
						testShape.remove(testShape.get(i));
			}
		}
			}
			else{
				if(choice == 3){
							for(int i = 0 ; i < testShape.size() ; i++){
					if(testShape.get(i) instanceof Triagle ){
						testShape.remove(testShape.get(i));
			}
		}
					}
					else{
						if(choice == 4){
									for(int i = 0 ; i < testShape.size() ; i++){
					if(testShape.get(i) instanceof Circle ){
						testShape.remove(testShape.get(i));
			}
		}
						}
					}
				}
			}

	}

//ham xoa trung nhau theo ten nhap vao
	public void xoaTrungNhau(String  _type){
		int k =testShape.size();
		switch (_type){
			case "Square":
				for(int i = 0 ; i < k;i++){
					Square A = (Square)testShape.get(i);
					for(int j = i+1 ; j < k;j++){

						Square B =(Square)testShape.get(j);
						if(Arrays.equals(A.getP(),B.getP())){
							testShape.remove(j);
							k--;
							j--;
						}

					}
				}
				break;
			case "Circle":

				for(int i = 0 ; i < k;i++){
					Circle A = (Circle)testShape.get(i);
					for(int j = i+1 ; j < k;j++){
						Circle B = (Circle)testShape.get(j);
						if(Arrays.equals(A.getP(),B.getP())){
							testShape.remove(testShape.get(j));
							k--;
							j--;
						}

					}
				}
				break;
			case "Retangle":

				for(int i = 0 ; i < k;i++){
					Retangle A = (Retangle)testShape.get(i);
					for(int j = i+1 ; j <k;j++){
						Retangle B = (Retangle)testShape.get(j);
						if(Arrays.equals(A.getP(),B.getP())){
							testShape.remove(testShape.get(j));
							k--;
							j--;
						}

					}
				}
				break;
			case "Triagle":

				for(int i = 0 ; i < k;i++){
					Triagle A = (Triagle)testShape.get(i);
					for(int j = i+1 ; j <k;j++){
						Triagle B = (Triagle)testShape.get(j);
						if(Arrays.equals(A.getP(),B.getP())){
							testShape.remove(testShape.get(j));
							k--;
							j--;
						}

					}
				}
				break;
			case "Hexagon":

				for(int i = 0 ; i < k;i++){
					Hexagon A = (Hexagon)testShape.get(i);
					for(int j = i+1 ; j <k;j++){
						Hexagon B = (Hexagon)testShape.get(j);
						if(Arrays.equals(A.getP(),B.getP())){
							testShape.remove(testShape.get(j));
							k--;
							j--;
						}

					}
				}
				break;
			default:
				break;
		}


	}

	public void printLayer(){
		for(int i = 0 ; i < this.testShape.size();i++){
			System.out.println(this.testShape.get(i).toStringShape());
		}
	}

}





