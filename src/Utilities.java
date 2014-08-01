import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;


public class Utilities
{
    static void douwnLoadStatsFile() {
        String args[] = {"http://www.cs.colostate.edu/helpdocs/vi.html",
        "kolo.html"};
        if (args.length!=2){
            System.out.println(
              "Proper Usage: java FileDownloader RemoteFileURL LocalFileName");
            System.exit(0);
          }

        DataInputStream in=null;
        DataOutputStream out=null;
        FileOutputStream fOut=null;

        try{
          URL remoteFile=new URL(args[0]);
          URLConnection fileStream=remoteFile.openConnection();

          // Open the input streams for the remote file 
          fOut=new FileOutputStream(args[1]);

          // Open the output streams for saving this file on disk
          out=new DataOutputStream(fOut);

          in=new DataInputStream(fileStream.getInputStream());

          // Read the remote on save save the file
          int data;
          while((data=in.read())!=-1){
               fOut.write(data);
          }  
          System.out.println("Download of " + args[0] + " is complete." );
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           try{
             in.close();
             fOut.flush(); 
             fOut.close();      
           } catch(Exception e){e.printStackTrace();}
           
          }

    }
}
