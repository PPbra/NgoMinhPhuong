class Diagram{
	Scanner input = new Scanner(System.in);
	private ArrayList<Layer> testLayer;
	ArrayList<Shape> listShape = new ArrayList<Shape>();
	public Diagram(){
		testLayer = new ArrayList<Layer>();
		for(int i = 0 ; i < 5 ; i++){
			Layer tmp = new Layer();
			testLayer.add(tmp);
		}
	}



	/*public void addLayer(){
		//thêm chi tiết vao danh sach Layer
		int count;
		System.out.println("Number of Layer :");
		count = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < count ; i++ ){
			Layer a = new Layer();
			testLayer.add(a);
			int shapeCount;
			System.out.println("Number of Shape:");
			shapeCount = Integer.parseInt(input.nextLine());
			for(int  j = 0 ; j < shapeCount ; j++){
				testLayer.get(i).addAShape();
			}
		}
	}*/
	public void deleteCircle(){
		for(int  i = 0 ; i <  testLayer.size(); i++){
			testLayer.get(i).deleteType(4);
	}
		}
	public void classify (){
		for(int i = 0 ; i < listShape.size() ; i++){
			if(listShape.get(i) instanceof Square ){
				testLayer.get(0).addShape(listShape.get(i) );
			}else{
				if(listShape.get(i) instanceof Triagle ){
					testLayer.get(1).addShape(listShape.get(i) );
				}else{
					if(listShape.get(i) instanceof Circle ){
						testLayer.get(2).addShape(listShape.get(i) );
					}else{
						if(listShape.get(i) instanceof Retangle ){
							testLayer.get(3).addShape(listShape.get(i) );
						}else{
							if(listShape.get(i) instanceof Hexagon ){
								testLayer.get(4).addShape(listShape.get(i) );
							}
						}
					}
				}
			}
		}
	}

//xoa cac Shape trung nhau theo cac Layer duoc han loai san
public void DiagramXoaTrungNhau(){
		for(int i = 0 ; i < 5 ; i++){
			if(i==0){
				testLayer.get(0).xoaTrungNhau("Square");
			}
			else{
				if(i==1){
					testLayer.get(1).xoaTrungNhau("Triagle");
				}
				else{
						if(i==2){
							testLayer.get(2).xoaTrungNhau("Circle");
						}
						else{
								if(i==3){
									testLayer.get(3).xoaTrungNhau("Retangle");
								}
								else{
									if(i==4){
									testLayer.get(4).xoaTrungNhau("Hexagon");
									}
								}
						}
					}
			}
		}
	}
	public void print(){
		for(int i = 0 ; i < testLayer.size();i++){
			System.out.println("Loai hinh:"+i);//phan loai hinh thep thu tu
			testLayer.get(i).printLayer();
		}
	}

}

