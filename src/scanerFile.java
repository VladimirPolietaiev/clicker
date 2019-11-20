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
                System.out.println ( "-----------------------");
                System.out.println ( "scanner file : " + fileName + "  start  ");
                //write file
                FileWriter fstream = new FileWriter(getHomeDir()+"/screens/rezScan.txt",true);
                BufferedWriter out = new BufferedWriter(fstream);

                int rezultcointYpoint=0;
                for (int y = 0; y < image1.getHeight(); y++) {
                    for (int x = 0; x < image1.getWidth(); x++) {
                        int c = image1.getRGB(x,y);
                        Color color = new Color(c);
                        int cointYPoint= 0;
                        while(color.getRed() == 255 && color.getGreen() == 255 && color.getBlue() == 255) {
                            System.out.println ( "scan= " + x + " ^ " + y);
                            c = image1.getRGB ( x, y );
                            color = new Color ( c );
                        y = y + 1;
                        cointYPoint++;
                            if(cointYPoint == 9){
                                rezultcointYpoint = 1;
                            }
                        }
                    }
                }
                if(rezultcointYpoint ==1 ){
                    System.out.println ( "rezultcointYpoint = " + rezultcointYpoint);
                    out.write("Found object in file " + fileName);
                    out.newLine();
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
