import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class Main extends JFrame{
	static double WINDOW_WIDTH;
	static double WINDOW_HEIGHT;
	static double SCREEN_WIDTH;
	static double SCREEN_HEIGHT;
Main(){
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	SCREEN_WIDTH=screenSize.getWidth();
	SCREEN_HEIGHT=screenSize.getHeight();
	WINDOW_HEIGHT=SCREEN_HEIGHT*3/4;
	WINDOW_WIDTH=SCREEN_WIDTH/2;
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocation((int)(SCREEN_WIDTH-WINDOW_WIDTH)/2, (int)(SCREEN_HEIGHT-WINDOW_HEIGHT)/2);
	this.setSize((int) WINDOW_WIDTH,(int) WINDOW_HEIGHT);
	this.add(new Arena((int) WINDOW_WIDTH,(int) WINDOW_HEIGHT));
	this.setVisible(true);
	this.setResizable(false);
	
}
	public static void main(String[] args) {
		new Main();

	}

}
