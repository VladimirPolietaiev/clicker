import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

public class scanerFile {
    public static void main(String args[]) throws IOException{
        try {
            //read image file
            File file1 = new File(getHomeDir()+"/screens/scrWindow20191022 07 02 43 ПП.png");
            BufferedImage image1 = ImageIO.read(file1);

            System.out.println ( "file was reading");

            //write file
            FileWriter fstream = new FileWriter(getHomeDir()+"/screens/rezScan.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            int cointColorPoint = 0;
            for (int y = 0; y < image1.getHeight(); y++) {
//                System.out.println ( "getHeight()=" + image1.getHeight ());
//                System.out.println ( "scan= y:" + y);

                for (int x = 0; x < image1.getWidth(); x++) {
//                    System.out.println ( "scan= x:" + x);
//                    System.out.println ( "getWidth()=" + image1.getWidth ());
                    int c = image1.getRGB(x,y);
                    Color color = new Color(c);


                    if (color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255) {
                        System.out.println ( "scan= " + x + " ^ " + y);
                        y = y + 4;
                        System.out.println ( "scan= " + x + " ^ " + y);
                        if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                            y = y + 4;
                            System.out.println ( "scan= " + x + " ^ " + y);
                            if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                x = x + 6;
                                System.out.println ( "scan= " + x + " ^ " + y);
                                if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                    y = y - 4;
                                    System.out.println ( "scan= " + x + " ^ " + y);
                                    if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                        y = y - 4;
                                        System.out.println ( "scan= " + x + " ^ " + y);
                                        if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                            x = x + 3;
                                            System.out.println ( "scan= " + x + " ^ " + y);
                                            if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                                y = y + 4;
                                                System.out.println ( "scan= " + x + " ^ " + y);
                                                if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                                    y = y + 4;
                                                    System.out.println ( "scan= " + x + " ^ " + y);
                                                    if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                                        x = x + 3;
                                                        System.out.println ( "scan= " + x + " ^ " + y);
                                                        if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                                            y = y - 4;
                                                            System.out.println ( "scan= " + x + " ^ " + y);
                                                            if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
                                                                y = y - 4;
                                                                System.out.println ( "scan= " + x + " ^ " + y);
                                                                if (color.getRed ( ) == 255 && color.getGreen ( ) == 255 && color.getBlue ( ) == 255) {
//                                                                    System.out.println ( "scaner found white point " + x + " , " + y );
                                                                    cointColorPoint++;
                                                                    out.write("WhitePixel found at=" + x + "," + y);
                                                                    out.newLine();
                                                                }

                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }


                }
            }
            System.out.println ( "scaner found cointColorPoint  " + cointColorPoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println ( "scaner the end  ");
    }

    private static File getHomeDir() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        return fsv.getHomeDirectory();
    }


}
