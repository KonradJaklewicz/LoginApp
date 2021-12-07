import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Canva extends JPanel implements MouseInputListener {

    boolean checkSquare=false;
    boolean checkCircle=false;
    int mouseX;
    int mouseY;
    int size=50;

    public Canva(){
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar()==107){
                    checkSquare=true;
                }
                if(e.getKeyChar()==111){
                    checkCircle=true;
                }
                repaint();
            }
        });
        addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void paint(Graphics g){
        if(checkSquare){
            g.setColor(Color.red);
            g.fillRect(mouseX-size/2, mouseY-size/2, size, size);
            checkSquare=false;
        }
        if(checkCircle){
            g.setColor(Color.red);
            g.fillOval(mouseX-size/2, mouseY-size/2, size, size);
            checkCircle=false;
        }
    }

}