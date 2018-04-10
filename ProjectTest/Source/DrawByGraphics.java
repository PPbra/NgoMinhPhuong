import java.util.*;
import java.awt.*;
import javax.swing.*;


public class DrawByGraphics extends JPanel {

	private ArrayList<vector> linesExtends;
	private ArrayList<vector> linesImplements;
        private ArrayList<vector> linesHas;
        private ArrayList<vector> linesIs;
	private int maxHeight;
        private int HeightTotal;
        
        
    private void doDrawing(Graphics g){

         Graphics2D g2d = (Graphics2D)g;

         for(vector tmp:this.linesExtends){

         	Triangle Tr = new Triangle(15,20,Color.BLACK);
         	Tr.drawMe(g2d,tmp.getX1()-7,tmp.getY1()+17);
         	drawAnExtendsRelation(g2d,tmp);

         }

         for(vector tmp :this.linesImplements){

         	drawAnImplementsRelation(g2d,tmp);
         	
         }
         
         for(vector tmp:this.linesHas){
             drawHas(g2d,tmp);
             drawRhombus(g2d,tmp.getX1(),tmp.getY1());
             
         }
         
         for(vector tmp:this.linesIs){
             drawIs(g2d,tmp);
         }

    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }


    public void setLinesToDraw(ArrayList<vector> _linesExtends ,
                               ArrayList<vector> _linesImplements ,
                               ArrayList<vector> _linesHas,
                               ArrayList<vector> _linesIs,
                               int _maxHeight,
                                int height){
    	this.linesExtends = _linesExtends;
    	this.linesImplements = _linesImplements;
        this.linesHas = _linesHas;
        this.linesIs = _linesIs;
    	this.maxHeight = _maxHeight;
        this.HeightTotal = height;
    }


    private void drawAnExtendsRelation(Graphics2D g2d,vector tmp){
        
        
    	int a,b;
    	int c,d;
    	a = tmp.getX1();
  	b = tmp.getY2()-(tmp.getY2()/2-tmp.getY1()/2);
  	c = tmp.getX2();
  	d = tmp.getY2()-(tmp.getY2()/2-tmp.getY1()/2);
    	g2d.fillOval(a-3, b-3, 7, 7);
        g2d.fillOval(c-3, d-3, 7, 7);
  		
    	g2d.drawLine(a,tmp.getY1()+17,a,b);
    	g2d.drawLine(c,d,c,tmp.getY2());
    	g2d.drawLine(c,d,a,b);

    } 

    private void drawAnImplementsRelation(Graphics2D g,vector tmp){

    	int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6;
    	x1 = tmp.getX1() + 50;
    	y1 = tmp.getY1();
    	x2 = tmp.getX1() + 50;
    	y2 = this.maxHeight + 50;
    	x3 = linesExtends.size()*300+tmp.getX1() + 50;
    	y3 = this.maxHeight + 50;
    	x4 = linesExtends.size()*300+tmp.getX1() + 50;
    	y4 = tmp.getY2() + this.maxHeight;
    	x5 = tmp.getX2() + 50;
    	y5 = tmp.getY2() + this.maxHeight;
    	x6 = tmp.getX2() + 50;
    	y6 = tmp.getY2();

        Graphics2D g2d = (Graphics2D) g.create();
        
        float[] dash1 = {2f, 0f, 2f};
        float[] dash2 = {1f, 1f, 1f};
        float[] dash3 = {4f, 0f, 2f};
        float[] dash4 = {4f, 4f, 1f};
        BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                			  BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);
        g2d.setStroke(bs3);

        g2d.fillOval(x1-3, y1-3, 7, 7);
        g2d.fillOval(x2-3, y2-3, 7, 7);
        g2d.fillOval(x3-3, y3-3, 7, 7);
        g2d.fillOval(x4-3, y4-3, 7, 7);
        g2d.fillOval(x5-3, y5-3, 7, 7);
        g2d.fillOval(x6-3, y6-3, 7, 7);
    	g2d.drawLine(tmp.getX1(), tmp.getY1(), x1, y1);
    	g2d.drawLine(x1, y1, x2, y2);
    	g2d.drawLine(x3, y3, x2, y2);
    	g2d.drawLine(x3, y3, x4, y4);
    	g2d.drawLine(x4, y4, x5, y5);
    	g2d.drawLine(x6, y6, x5, y5);
    	g2d.drawLine(tmp.getX2(), tmp.getY2(), x6, y6);

    	g2d.dispose();
    	// int x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6;
    	// x1 = tmp.getX1() + 50;
    	// y1 = tmp.getY1();
    	// x2 = tmp.getX1() + 50;
    	// y2 = this.maxHeight + 50;
    	// x3 = linesExtends.size()*300+tmp.getX1() + 50;
    	// y3 = this.maxHeight + 50;
    	// x4 = linesExtends.size()*300+tmp.getX1() + 50;
    	// y4 = tmp.getY2() + this.maxHeight;
    	// x5 = tmp.getX2() + 50;
    	// y5 = tmp.getY2() + this.maxHeight;
    	// x6 = tmp.getX2() + 50;
    	// y6 = tmp.getY2();
    	// g2d.drawLine(tmp.getX1(), tmp.getY1(), x1, y1);
    	// g2d.drawLine(x1, y1, x2, y2);
    	// g2d.drawLine(x3, y3, x2, y2);
    	// g2d.drawLine(x3, y3, x4, y4);
    	// g2d.drawLine(x4, y4, x5, y5);
    	// g2d.drawLine(x6, y6, x5, y5);
    	// g2d.drawLine(tmp.getX2(), tmp.getY2(), x6, y6);

    }
    
    public void drawHas(Graphics2D g,vector tmp){
        
        int x1 = tmp.getX1()-tmp.getY2()%150;
        int y1 = tmp.getY1();
        int x2 = tmp.getX1()-tmp.getY2()%150;
        int y2 = this.HeightTotal+tmp.getY2()%150;
        int x3 = tmp.getX2()-tmp.getY2()%100;
        int y3 = this.HeightTotal+tmp.getY2()%150;
        int x4 = tmp.getX2() - tmp.getY2()%100;
        int y4 = tmp.getY2();
        
        
        
        Graphics2D g2d = (Graphics2D) g.create();
        BasicStroke bs2 = new BasicStroke(4, BasicStroke.CAP_ROUND,
                                            BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        
        
        
        g2d.drawLine(tmp.getX1()-20,tmp.getY1(),x1,y1);
        g2d.drawLine(x2,y2,x1,y1);
        g2d.drawLine(x2,y2,x3,y3);
        g2d.drawLine(x4,y4,x3,y3);
        g2d.drawLine(tmp.getX2(),tmp.getY2(),x4,y4);
        
        g2d.dispose();
        
    }
    
    public void drawIs(Graphics2D g,vector tmp){
        
        int x1 = tmp.getX1()-tmp.getY2()%150;
        int y1 = tmp.getY1();
        int x2 = tmp.getX1()-tmp.getY2()%150;
        int y2 = this.HeightTotal+tmp.getY2()%150;
        int x3 = tmp.getX2()-tmp.getY2()%100;
        int y3 = this.HeightTotal+tmp.getY2()%150;
        int x4 = tmp.getX2() - tmp.getY2()%100;
        int y4 = tmp.getY2();
        
        
        
        Graphics2D g2d = (Graphics2D) g.create();
        BasicStroke bs2 = new BasicStroke(4, BasicStroke.CAP_ROUND,
                                            BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        
        
        
        g2d.drawLine(tmp.getX1(),tmp.getY1(),x1,y1);
        g2d.drawLine(x2,y2,x1,y1);
        g2d.drawLine(x2,y2,x3,y3);
        g2d.drawLine(x4,y4,x3,y3);
        g2d.drawLine(tmp.getX2(),tmp.getY2(),x4,y4);
        
        g2d.dispose();
        
    }
    
    public void drawRhombus(Graphics2D g2d , int x ,int y){
         int x2 = x-10;
         int y2 = y - 10;
         int x3 = x - 20;
         int y3 = y;
         int y4 = y + 10;
         int x4 = x-10;
         
         g2d.drawLine(x,y,x2,y2);
         g2d.drawLine(x3,y3,x2,y2);
         g2d.drawLine(x3,y3,x4,y4);
         g2d.drawLine(x4,y4,x,y);
         
        }
            
}




class Triangle
        
{
	protected int height;
	protected int width;
	protected Color color;


	public Triangle(int width, int height, Color color)
	{
		this.height = height;
		this.width = width;
		this.color = color;
		
		
	}

	
	public void drawMe(Graphics2D g, int x,int y)
	{
		g.setColor(color);
		Point point2 = new Point(x+width,y);
		Point point3 = new Point(x+(width/2),y - height);
		g.drawLine(x,y,point2.x,point2.y);
		g.drawLine(x,y,point3.x,point3.y);
		g.drawLine(point2.x,point2.y,point3.x,point3.y);
					
	}
        
        
        
}


