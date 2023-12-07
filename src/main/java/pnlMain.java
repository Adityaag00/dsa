import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class pnlMain extends JPanel {
    public pnlMain() {
        this.setSize(400,500);
    }
    int[] arr = new int[4];
    int[] arr2 = new int[4];

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            if(arr[i]!=0) {
                System.out.println("test");
                g.drawLine(arr[i],arr2[i],arr[i],arr2[i]);
            }
        }
        for (double t = 0; t <=1 ; t+=0.001) {
            if(arr[0]==0 || arr[1]==0 || arr[2]==0 || arr[3]==0) {
                break;
            }
            double x= Math.pow(1-t,3)*arr[0] +3*t*Math.pow(1-t,2)*arr[1]+3*t*t*(1-t)*arr[2]+Math.pow(t,3)*arr[3];
            double y= Math.pow(1-t,3)*arr2[0] +3*t*Math.pow(1-t,2)*arr2[1]+3*t*t*(1-t)*arr2[2]+Math.pow(t,3)*arr2[3];
            g.drawLine((int)x,(int)y,(int)x,(int)y);
        }
    }

    public void draw() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <4; i++) {
            System.out.println("Enter coordinate");
            arr[i]=in.nextInt();
            arr2[i]= in.nextInt();
            repaint();
        }
        repaint();
    }
}
