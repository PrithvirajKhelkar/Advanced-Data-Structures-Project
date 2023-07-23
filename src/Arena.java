import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JOptionPane;
public class Arena extends JPanel implements ActionListener , KeyListener {
	int WINDOW_WIDTH;
	int WINDOW_HEIGHT;
	Timer loop;
	SnakeBody snake;
Arena(int WINDOW_WIDTH, int WINDOW_HEIGHT){
	
	this.WINDOW_HEIGHT=WINDOW_HEIGHT;
	this.WINDOW_WIDTH=WINDOW_WIDTH;
	this.setLocation(0, 0);
	this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	this.addKeyListener(this);
	this.setFocusable(true);
	this.getFocusListeners();
	loop=new Timer(100,this);
	snake = new SnakeBody(WINDOW_WIDTH/2,WINDOW_HEIGHT/2);
	loop.start();
	this.setVisible(true);
}

    @Override
	public void paintComponent(Graphics g){
    	g.setColor(new Color(51,25,0));
    	g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    	snake.paintSnake(g);
    }
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			snake.move(snake.displacement, 0);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			snake.move(-1*snake.displacement, 0);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			snake.move(0,-1*snake.displacement);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			snake.move(0,snake.displacement);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		this.repaint();
		if(snake.bitesItself()){
			loop.stop();
			JOptionPane.showMessageDialog(null,"Your Score is :"+snake.score);
			System.exit(0);
		}
		snake.moveSnake();
		
	}

}
