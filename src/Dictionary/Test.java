package Dictionary;

import java.io.*;

    public class Test {

        private final static String FILE_URL = "D:\\DictionaryofCuong\\src\\out\\dictionariesOUT.txt";

        public static void main(String[] args) throws IOException {
            String[] data = {
                    "Hello Java!",
                    "Good bye!"
            };
            File file = new File(FILE_URL);
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            for (String item: data){
                outputStreamWriter.write(item);
                // Dùng để xuống hàng
                outputStreamWriter.write("\n");
            }

            // Đây là phương thức quan trọng!
            // Nó sẽ bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
            outputStreamWriter.flush();
        }
    }
