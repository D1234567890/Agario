import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements MouseListener, ActionListener {

	ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	public static int worldSize = 700;
	
	Player player = new Player(50);

	public void paint(Graphics g) {

		super.paintComponent(g);

		for (int i = 0; i < enemies.size() - 1; i++) {

			for (int j = i + 1; j < enemies.size(); j++) {

				double distance = Math.sqrt(Math
						.pow((enemies.get(i).getX() + enemies.get(i).getRad() - enemies.get(j).getX()
								- enemies.get(j).getRad()), 2)
						+ Math.pow((enemies.get(i).getY() + enemies.get(i).getRad() - enemies.get(j).getY()
								- enemies.get(j).getRad()), 2));

				if (distance < enemies.get(i).getRad() + enemies.get(j).getRad()) {

					if (enemies.get(i).getRad() >= enemies.get(j).getRad()) {

						enemies.remove(enemies.indexOf(enemies.get(j)));

					} else if (enemies.get(i).getRad() < enemies.get(j).getRad()) {

						enemies.remove(enemies.indexOf(enemies.get(i)));

					}
				}
			}
		}

		for (Enemy e : enemies) {

			e.paint(g);

		}
		
		player.paint(g);
	}

	public Driver() {

		JFrame frame = new JFrame("Agar.io");

		frame.setSize(worldSize, worldSize);
		frame.add(this);

		/*
		
		for (int i = 0; i < 10; i++) {
			enemies.add(new Enemy());
		}

		*/

		Timer t = new Timer(16, this);
		t.start();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
