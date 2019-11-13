import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

public class scanerFile {
    public static void main(String args[]) throws IOException{
        final File folder = new File(getHomeDir()+ "/screens/");

        listFilesForFolder(folder );

    }

    public static void scanOneFile( String fileName){

            try {
                //read image file
                File file1 = new File(getHomeDir()+"/screens/" + fileName);
                BufferedImage image1 = ImageIO.read(file1);


//                listFilesForFolder( folder);
                System.out.println ( "-----------------------");
                System.out.println ( "scanner file : " + fileName + "  start  ");

                //write file
                FileWriter fstream = new FileWriter(getHomeDir()+"/screens/rezScan.txt",false);
                BufferedWriter out = new BufferedWriter(fstream);


                for (int y = 0; y < image1.getHeight(); y++) {
//                System.out.println ( "getHeight()=" + image1.getHeight ());
//                System.out.println ( "scan= y:" + y);

                    for (int x = 0; x < image1.getWidth(); x++) {
//                    System.out.println ( "scan= x:" + x);
//                    System.out.println ( "getWidth()=" + image1.getWidth ());
                        int c = image1.getRGB(x,y);
                        Color color = new Color(c);

                        int rezultcointXpoint=0;
                        int rezultcointYpoint=0;
                        int cointXpoint= 0;
                        int cointYPoint= 0;
                        while(color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255) {
                            System.out.println ( "scan= " + x + " ^ " + y);
                            c = image1.getRGB ( x, y );
                            color = new Color ( c );




                            while(color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255) {
                                System.out.println ( "scan 2 = " + x + " ^ " + y);
                                c = image1.getRGB ( x, y );
                                color = new Color ( c );
                                x = x + 6;
                                cointXpoint++;
                                if(cointXpoint == 3){
                                     rezultcointXpoint = 1;
                                }
                            }
                            y = y + 4;
                            cointYPoint++;

                            if(cointYPoint == 3){
                                rezultcointYpoint = 1;
                            }

                            System.out.println ( "rezultcointYpoint= " + rezultcointYpoint + " rezultcointXpoint " + rezultcointXpoint);
                            if(rezultcointYpoint ==1 || rezultcointXpoint==1){
                                System.out.println ( "rezultcointYpoint 2= " + rezultcointYpoint + " rezultcointXpoint 2 " + rezultcointXpoint);
                                out.write("Found object in file " + fileName);
                                out.newLine();
                            }
                        }


                    }
                }
                out.close ();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println ( "scanner file : " + fileName + "  finished  ");
            System.out.println ( "-----------------------");

    }

    private static File getHomeDir() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        return fsv.getHomeDirectory();
    }

    public static void listFilesForFolder(File folder) {
        String temp = "";
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                // System.out.println("Reading files under the folder "+folder.getAbsolutePath());
                listFilesForFolder(fileEntry);
            } else {
                if (fileEntry.isFile()) {
                    temp = fileEntry.getName();
                    if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("png"))
                        scanOneFile ( fileEntry.getName () );
                        System.out.println("File= " + folder.getAbsolutePath()+ "\\" + fileEntry.getName());
                        System.out.println("File name= "  + fileEntry.getName());
                }

            }
        }
    }

}
