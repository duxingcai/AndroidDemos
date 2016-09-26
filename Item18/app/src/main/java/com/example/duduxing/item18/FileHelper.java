package com.example.duduxing.item18;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileHelper {
    private Context context;

    public FileHelper() {

    }

    public FileHelper(Context context) {
        super();
        this.context = context;
    }

    public void saveFile(String fileName, String fileContent) throws Exception {
        FileOutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        outputStream.write(fileContent.getBytes());
        outputStream.close();
    }

    public String readFile(String fileName) throws IOException {
        FileInputStream inputStream = context.openFileInput(fileName);
        byte[] temp = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder("");
        int len = 0;
        while((len = inputStream.read(temp)) > 0) {
            stringBuilder.append(new String(temp, 0, len));
        }
        inputStream.close();
        return stringBuilder.toString();
    }
}
