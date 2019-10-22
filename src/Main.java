import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.awt.event.KeyEvent.*;

////// will run when all windows close
public class Main {

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
            Thread.interrupted();
            clickRigth ( 700,10 );
            Thread.sleep(500);
            Thread.interrupted();
            mouseMove(700,10,750,260,1, 100 );
            clickLeft ( 750,260 );
            Thread.sleep(500);
            Thread.interrupted();
            mouseMove(750,260,1080,260,1, 100 );
            mouseMove(1080,260,1100,510,1, 100 );
            clickLeft ( 1100,510 );
            Thread.sleep(1000);
            Thread.interrupted();
            writeText ();
            Thread.sleep(1000);
            Thread.interrupted();
            mouseMove(1100,510,1120,100,1, 50 );
            Thread.sleep(500);
            Thread.interrupted();
            clickLeft ( 1120,100 );
            Thread.sleep(500);
            Thread.interrupted();
            mouseMove(1120,100,620,450,1, 50 );
            clickLeft ( 620,450 );
            Thread.sleep(500);
            Thread.interrupted();
            mouseMove(620,450,720,40,1, 50 );
            clickLeft ( 720,40 );
            clickLeft ( 720,40 );
            Thread.sleep(500);
            Thread.interrupted();
            mouseMove(720,40,1120,100,1, 50 );
            clickLeft ( 1120,100 );

            writeScreen();

        } catch (AWTException e) {
            e.printStackTrace ( );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        System.out.println("Hello World!");
    }

    public static void clickRigth(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

    }
    public static void clickLeft(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void writeText() throws AWTException, InterruptedException {
        Robot bot = new Robot();
        bot.keyPress ( VK_SHIFT );


        bot.keyPress ( VK_H );
        bot.keyRelease ( VK_H );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_E );
        bot.keyRelease ( VK_E );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_L );
        bot.keyRelease ( VK_L );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_L );
        bot.keyRelease ( VK_L );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_O );
        bot.keyRelease ( VK_O );
        Thread.sleep(1000);
        Thread.interrupted();


        bot.keyPress ( VK_SPACE );
        bot.keyRelease ( VK_SPACE );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_B );
        bot.keyRelease ( VK_B );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_R );
        bot.keyRelease ( VK_R );
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_O );
        bot.keyRelease ( VK_O );
        bot.keyRelease ( VK_SHIFT );

        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_ENTER );
        bot.keyRelease ( VK_ENTER );



        bot.keyPress ( VK_ENTER );
        bot.keyRelease ( VK_ENTER );

        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_H );
        bot.keyRelease ( VK_H );
        Thread.sleep(200);
        Thread.interrupted();

        bot.keyPress ( VK_E );
        bot.keyRelease ( VK_E );
        Thread.sleep(200);
        Thread.interrupted();

        bot.keyPress ( VK_L );
        bot.keyRelease ( VK_L );
        Thread.sleep(200);
        Thread.interrupted();

        bot.keyPress ( VK_L );
        bot.keyRelease ( VK_L );
        Thread.sleep(200);
        Thread.interrupted();

        bot.keyPress ( VK_O );
        bot.keyRelease ( VK_O );
        Thread.sleep(200);
        Thread.interrupted();


        bot.keyPress ( VK_SPACE );
        bot.keyRelease ( VK_SPACE );
        Thread.sleep(200);
        Thread.interrupted();

        bot.keyPress ( VK_W );
        bot.keyRelease ( VK_W );

        bot.keyPress ( VK_O );
        bot.keyRelease ( VK_O );

        bot.keyPress ( VK_R );
        bot.keyRelease ( VK_R );

        bot.keyPress ( VK_L );
        bot.keyRelease ( VK_L );

        bot.keyPress ( VK_D );
        bot.keyRelease ( VK_D );


    }

    public static void mouseMove(int x1, int y1, int x2, int y2, int t, int n){
        try {
            Robot bot = new Robot();
            double dx = (x2 - x1) / ((double) n);
            double dy = (y2 - y1) / ((double) n);
            double dt = t / ((double) n);
            for (int step = 1; step <= n; step++) {
                Thread.sleep((int) dt);
                bot.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
            }
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static BufferedImage grabScreen() {
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())) ;
        } catch (SecurityException e) {
        } catch (AWTException e) {
        }
        return null;
    }

    private static File getHomeDir() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        return fsv.getHomeDirectory();
    }

    ///////name file consist of "yyyyMMdd hh mm ss a"
    public static void writeScreen( ){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
        Calendar now = Calendar.getInstance();
        try {
            ImageIO.write(grabScreen(), "png", new File(getHomeDir(), "/screens/"+formatter.format(now.getTime())+".png"));
        } catch (IOException e) {
            System.out.println("IO exception"+e);
        }
    }



}
