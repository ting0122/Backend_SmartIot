
import java.net.*;
import java.io.*;

public class abc {
    public static void main(String args[]) throws Exception {
        while(true){
            Socket s = new Socket("26.88.163.193", 80);
            BufferedReader din = new BufferedReader(new InputStreamReader(s.getInputStream()));
    
            System.out.println("Start working");
            String str2 = "";
            str2 = din.readLine();
            System.out.println("Server says: " + str2);
    
            s.close();
        }
        
    }
}
