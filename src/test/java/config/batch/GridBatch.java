package config.batch;

import config.FrameworkException;
import java.io.IOException;
import java.io.InputStream;


public class GridBatch {
   private static Process p;

    public static void  startGridBatch(String gridbatchURL){
        try {
            String[] command = {"cmd.exe", "/C", "start",gridbatchURL};
            p =  Runtime.getRuntime().exec(command);

        } catch (IOException ex) {
            throw new FrameworkException(ex.getMessage());
        }
        }


    public static void endGridBatch() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C","netstat -ano | findstr :4444");
        Process process = builder.start();
        process.waitFor();
        String o=printProcessStream(process.getInputStream());
        String PID=o.substring(o.length()-7,o.length()-1);
        try {
            Runtime.getRuntime().exec("taskkill /PID "+PID+" /F");
            Runtime.getRuntime().exec("taskkill /im cmd.exe /f") ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String printProcessStream(InputStream inputStream) throws IOException
    {
        int bytesRead = -1;
        byte[] bytes = new byte[1024];
        String output = "";
        while((bytesRead = inputStream.read(bytes)) > -1){
            output = output + new String(bytes, 0, bytesRead);
        }
        System.out.println(" The netstat command response is \r\n"+output);
       return output;
    }
}
