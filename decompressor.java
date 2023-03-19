package compressor_decompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);

        GZIPInputStream gzipIS = new GZIPInputStream(fis);

        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFileCheck.txt");


        byte[] buffer = new byte[1024];


        int len;
        while ((len = gzipIS.read(buffer)) != -1) {
            System.out.println("length of file" + len);
            fos.write(buffer, 0, len);

        }
        gzipIS.close();
        fis.close();
        fos.close();


    }

    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\dipak\\Downloads\\compress_decom\\Compressedfile.gz");
        method(path);

    }
}
