import java.io.*;

public class SamThree {

    public static void main(String[] args) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("C:\\data\\output-text.txt");
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);

        try {
            outputStreamWriter.write("Hello World1");
            outputStreamWriter.flush();
            outputStreamWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
