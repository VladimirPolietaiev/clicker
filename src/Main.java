import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

////// will run when all windows close
public class Main {

    public static void main(String[] args) {
        try {
            Thread.sleep(6000);
            Thread.interrupted();
            clickRigth ( 700,10 );
            Thread.sleep(3000);
            Thread.interrupted();
            clickLeft ( 740,260 );
            Thread.sleep(3000);
            Thread.interrupted();
            clickLeft ( 980,520 );
            Thread.sleep(3000);
            Thread.interrupted();
            writeText ();

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
        Thread.sleep(1000);
        Thread.interrupted();

        bot.keyPress ( VK_ENTER );
        bot.keyRelease ( VK_ENTER );

    }

}
