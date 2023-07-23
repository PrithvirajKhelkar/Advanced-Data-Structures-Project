import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class SnakeBody {
	Node head;
	int dx,dy;
	int normalSize;
	int FoodSize;
	int displacement;
	int WINDOW_WIDTH;
	int WINDOW_HEIGHT;
	int edge;
	int foodX;
	int foodY;
	int score;
	Color face,body,belly,foodColor;
	Random random=new Random();
	public SnakeBody(int x,int y){
		displacement=dx=1;
		dy=0;
		edge = 50;
		WINDOW_WIDTH=x*2;
		WINDOW_HEIGHT=y*2;
		normalSize=15;
		FoodSize=20;
		score = 0;
		foodColor=new Color(255,0,0);
		face = (Color.GREEN);
		body = new Color(0,255,0);
		belly = body;
		setFoodLocation();
		head = new Node(x,y,normalSize,face);
		head.next=new Node(x-(normalSize),y,normalSize,body);
		head.next.next=new Node(x-(2*normalSize),y,normalSize,body);
		head.next.next.next=new Node(x-(3*normalSize),y,normalSize,body);
		}
	public void updateNodes(int x,int y,int size,Node pass,Color color){
		if(pass.next!=null)
			updateNodes(pass.x,pass.y,pass.size,pass.next,new Color(color.getRed(),color.getGreen()-(250/((score+3)*2)),color.getBlue()));
		else if(pass.size!=size)
			pass.next=new Node(pass.x,pass.y,size,color);
			
		
		pass.x=x;
		pass.y=y;
		pass.size=size;
		pass.color=color;
	}
	public void move(int dx,int dy){
		if(dx==displacement && dy ==0 && this.dx==0 && this.dy !=0){
			this.dx=dx;
			this.dy=0;
			return;
		}
		if(dx==-1*displacement && dy ==0 && this.dx==0 && this.dy!=0){
			this.dx=dx;
			this.dy=0;
			return;
		}
		if(dx==0 && dy ==displacement && this.dx!=0 && this.dy==0){
			this.dx=0;
			this.dy=dy;
			return;
		}
		if(dx==0 && dy ==-1*displacement && this.dx!=0 && this.dy==0){
			this.dx=0;
			this.dy=dy;
			return;
		}
	}
	public void moveSnake(){
		if(head.x>WINDOW_WIDTH-edge)
			head.x=edge;
		else if(head.x<edge)
			head.x=WINDOW_WIDTH-edge;
		if(head.y>WINDOW_HEIGHT-edge)
			head.y=edge;
		else if(head.y<edge)
			head.y=WINDOW_HEIGHT-edge;
		if(Math.sqrt(Math.pow(head.x-foodX, 2)+Math.pow(head.y-foodY, 2))<=(head.size/2)+(FoodSize/2)){
			score++;
			updateNodes(head.x+(dx*head.size/2),head.y+(dy*head.size/2),FoodSize,head,belly);
			setFoodLocation();
		}
		else updateNodes(head.x+(dx*head.size/2),head.y+(dy*head.size/2),normalSize,head,body);
	}
	public void paintSnake(Graphics g){
		g.setColor(new Color(153,76,0));
		g.fillRect(edge, edge, WINDOW_WIDTH-(2*edge), WINDOW_HEIGHT-(2*edge));
		Node temp = head;
		g.setColor(foodColor);
		g.fillOval(foodX-(FoodSize/2), foodY-(FoodSize/2), FoodSize, FoodSize);
		g.setColor(new Color(0,150,0));
		g.fillOval(temp.x-(temp.size/2), temp.y-(temp.size/2), temp.size, temp.size);
		g.setColor(face);
		g.fillOval(temp.x-((temp.size*3/4)/2), temp.y-((temp.size*3/4)/2), (temp.size*3/4), (temp.size*3/4));
		
		temp=temp.next;
		while(temp.next!=null){
			
			if(temp.size==normalSize)
				g.setColor(temp.color);
			else{ g.setColor(new Color(temp.color.getGreen()/2,temp.color.getGreen(),temp.color.getBlue()));
					
			}
			g.fillOval(temp.x-((temp.size*3/4)/2), temp.y-((temp.size*3/4)/2), (temp.size*3/4), (temp.size*3/4));
			temp=temp.next;
		}
		g.setColor(Color.WHITE);
		g.drawString("Score :"+score, WINDOW_WIDTH-100, 20);
	}
	public void setFoodLocation(){
		foodX=edge + random.nextInt(WINDOW_WIDTH -(2*edge) + 1);
		foodY=edge + random.nextInt(WINDOW_HEIGHT -(2*edge) + 1);
	}
	public boolean bitesItself(){
		Node temp = head;
		temp=temp.next.next.next;
		while(temp.next!=null){
			if(  normalSize/2  > Math.sqrt(Math.pow(head.x-temp.x, 2)+Math.pow(head.y-temp.y, 2)))
				return true;
			temp=temp.next;
		}
		return false;
	}
}
