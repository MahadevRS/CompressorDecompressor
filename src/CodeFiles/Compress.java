
package CodeFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compress {
    
    public static void compressFunction (File file) throws FileNotFoundException, IOException {
        
        String fileDirectory=file.getParent();
        System.out.println(fileDirectory);
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos= new FileOutputStream(fileDirectory+"/Compressedfile.gz");
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos);
        
        byte[]buffer =new byte[2];
        int len;
        
        while((len=fis.read(buffer))!=-1){
            gzipOS.write(buffer,0,len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
   
    public static void main(String[] args) throws IOException,FileNotFoundException {
        
        File path =new File("\\‪C:\\Users\\mahad\\OneDrive\\Desktop\\TestDoc.txt");
        
        compressFunction(path);
    }
}