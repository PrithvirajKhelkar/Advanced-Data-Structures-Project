import java.awt.Color;

public class Node {
int x,y,size;
Node next;
Color color;
public Node(int x, int y, int size,Color color){
	this.x=x;
	this.y=y;
	this.size=size;
	this.color=color;
	Node next=null;
}
}
