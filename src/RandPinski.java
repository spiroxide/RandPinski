import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandPinski {
    private JFrame frame = new JFrame();
    private static final int FRAME_WIDTH = 1009;
    private static final int FRAME_HEIGHT = 780;
    private static final int BORDER = 100;
    private static final int GUIDE_SIZE = 20;
    private static final int POINT_SIZE = 10;
    private static final int POINT_DENSITY = 500;

    public static void main(String[] args) {
        new RandPinski();
    }

    public RandPinski() {
        RandPinski.DrawPinski pinski = new RandPinski.DrawPinski();
        this.frame.setBounds(-7, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setDefaultCloseOperation(3);
        this.frame.add(pinski);
        pinski.setBackground(Color.BLACK);
        this.frame.setVisible(true);
    }

    private int[] randPoint(int minX, int maxX, int minY, int maxY) {
        int x = (int)(Math.random() * (double)(maxX + 1 - minX) + (double)minX);
        int y = (int)(Math.random() * (double)(maxY + 1 - minY) + (double)minY);
        int[] p = new int[]{x, y};
        return p;
    }

    private int[] midpoint(int[] p1, int[] p2) {
        int[] midP = new int[]{(p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2};
        return midP;
    }

    public class DrawPinski extends JPanel {
        private static final long serialVersionUID = 1L;

        public DrawPinski() {
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int[] tempP = new int[2];
            tempP = RandPinski.this.randPoint(BORDER, RandPinski.this.frame.getWidth() - BORDER, BORDER, RandPinski.this.frame.getHeight() - BORDER);
            int[] p1 = RandPinski.this.randPoint(BORDER, RandPinski.this.frame.getWidth() - BORDER, BORDER, RandPinski.this.frame.getHeight() - BORDER);
            int[] p2 = RandPinski.this.randPoint(BORDER, RandPinski.this.frame.getWidth() - BORDER, BORDER, RandPinski.this.frame.getHeight() - BORDER);
            int[] p3 = RandPinski.this.randPoint(BORDER, RandPinski.this.frame.getWidth() - BORDER, BORDER, RandPinski.this.frame.getHeight() - BORDER);

            for(int i = 0; i < POINT_DENSITY; ++i) {
                g.setColor(new Color((int)(Math.random() * 256.0D), (int)(Math.random() * 256.0D), (int)(Math.random() * 256.0D)));
                g.fillOval(tempP[0] - 1, tempP[1] - 1, 2, 2);
                switch((int)(Math.random() * 3.0D)) {
                    case 0:
                        tempP = RandPinski.this.midpoint(tempP, p1);
                        break;
                    case 1:
                        tempP = RandPinski.this.midpoint(tempP, p2);
                        break;
                    case 2:
                        tempP = RandPinski.this.midpoint(tempP, p3);
                }
            }

            g.setColor(Color.RED);
            g.fillOval(p1[0] - 10, p1[1] - 10, 20, 20);
            g.fillOval(p2[0] - 10, p2[1] - 10, 20, 20);
            g.fillOval(p3[0] - 10, p3[1] - 10, 20, 20);
        }
    }
}
