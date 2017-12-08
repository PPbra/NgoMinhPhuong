import java.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class test_6{

	public static void main(String[] args) {
		Diagram dg = new Diagram();
		Square s1 = new Square(1,2,3,4,5,2,1,2);
		dg.listShape.add(s1);
		Square s2 = new Square(1,2,3,4,5,2,1,2);
		dg.listShape.add(s2);
		Square s3 = new Square(2,3,4,7,5,9,4,0);
		dg.listShape.add(s3);
		Triagle t1 = new Triagle(2,5,4,3,7,4);
		dg.listShape.add(t1);
		Triagle t2 = new Triagle(1,1,3,2,4,3);
		dg.listShape.add(t2);
		Retangle r1 = new Retangle(1,2,4,6,4,5,6,3);
		dg.listShape.add(r1);
		Circle c1 = new Circle(1,1,5);
		dg.listShape.add(c1);
		Circle c2 = new Circle(1,1,5);
		dg.listShape.add(c2);
		Circle c3 = new Circle(1,1,3);
		dg.listShape.add(c3);
		Hexagon h1 = new Hexagon(1,3,4,5,6,3,2,8,6,9,4,7);
		Hexagon h2 = new Hexagon(1,3,4,5,6,3,2,8,6,9,4,7);
		Hexagon h3 = new Hexagon(2,3,1,8,2,3,2,8,3,9,6,10);
		dg.listShape.add(h1);
		dg.listShape.add(h2);
		dg.listShape.add(h3);
		dg.classify();//Phan loai vao tung Layer
		dg.DiagramXoaTrungNhau();//Xoa cac hinh trung nhau
		dg.print();//in ra cac hinh sau khi da xoa trung nhau

		//Diagram a = new Diagram();
		//a.addLayer();
		//phan nay em them chi tiet bao nhieu Layer , va moi Layer co bao nhieu Shape va loai Shape , thay dien vao so luong de test a
		//a.deleteCircle();
		//test kha nang xoa Cỉcle

		/*sakjhkajhsdkahskdjhkjhjahskd*/
	}

}
