import java.io.FileInputStream;

public class SamTwo {
    public static void main(String[] args) {
        try (FileInputStream fin=new FileInputStream("C:\\janf_config.txt")){
            int i=0;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
        }
        catch(Exception e){System.out.println(e);}

    }
}
