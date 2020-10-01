
import java.io.*;

    public class Test {

        private final static String FILE_URL = "D:\\Dictionary\\src\\dictionary\\dictionaries.txt";

        public static void main(String[] args) throws IOException {
            File file = new File(FILE_URL);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = "";
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
    }
