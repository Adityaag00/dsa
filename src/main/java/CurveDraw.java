import javax.swing.*;
import java.awt.*;

public class CurveDraw extends JFrame {
    static pnlMain panel;
    public CurveDraw() {
        panel = new pnlMain();
        this.getContentPane().add(panel);
    }

    public static void main(String[] args) {
        CurveDraw main = new CurveDraw();
        main.setSize(new Dimension(400,500));
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.draw();
    }
}
