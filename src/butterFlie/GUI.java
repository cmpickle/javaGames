package butterFlie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	public static Dimension size = new Dimension(800, 600);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		MyPanel panel = new MyPanel();
		panel.draw();
	}

	static class MyPanel extends JPanel {

		private static JFrame frame;
		private JPanel panel;
		private String title = "Butter Flie";
		private static final long serialVersionUID = -4854372374813473718L;
		public int xPos = 390;
		public static int yPos = 300;
		private int draw = 0;

		public boolean someCondition = false;
		

		public MyPanel()
		{
			setBorder(BorderFactory.createLineBorder(Color.BLACK));

			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e)
				{
					yPos -= 70;
					repaint();
				}
			});

		}

		private void draw()
		{
			frame = new JFrame(title);
			panel = new MyPanel();
			frame.setSize(size);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(panel);
			panel.setBackground(Color.BLUE);
			frame.pack();
			frame.setVisible(true);
			try
			{
				Thread.sleep(300);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (true)
			{
				yPos += 3;

				// panel.addMouseListener(new MouseAdapter() {
				// public void mousePressed(MouseEvent e)
				// {
				// someCondition = true;
				// while (someCondition)
				// {
				// yPos += 60;
				// repaint();
				// }
				//
				// repaint();
				// }
				//
				// public void mouseReleased(MouseEvent e)
				// {
				// someCondition = false;
				// repaint();
				// draw();
				// }
				// });

				frame.repaint();
				
				try
				{
					Thread.sleep(20);
				} catch (Exception e)
				{
					// TODO: handle exception
				}
			}

		}

		public Dimension getPreferredSize()
		{
			return new Dimension(GUI.size);
		}
		
		@Override
		    public void update(Graphics g) {
		        paint(g);
		    }

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			g.setColor(Color.yellow);
			g.fillOval(xPos, yPos, 30, 30);
			
			if(yPos > 600)
			{
				g.setColor(Color.red);
				System.out.println("Game Over..." + draw);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
				g.drawString("Game Over", 100, 300);
				repaint();
			}
		}

	}
}
