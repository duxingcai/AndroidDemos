package com.example.duduxing.item19;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SDFileHelper {
    private Context context;

    public SDFileHelper() {

    }

    public SDFileHelper(Context context) {
        super();
        this.context = context;
    }

    public void saveFileToSD(String fileName, String fileContent) throws Exception {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            fileName = Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + fileName;
            FileOutputStream outputStream = new FileOutputStream(fileName);
            outputStream.write(fileContent.getBytes());
            outputStream.close();
        } else {
            Toast.makeText(context, "SD卡不存在或不可读写", Toast.LENGTH_SHORT);
        }
    }

    public String readFileFromSD(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("");
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            fileName = Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + fileName;
            FileInputStream inputStream = new FileInputStream(fileName);
            byte[] temp = new byte[1024];
            int len = 0;
            while((len = inputStream.read(temp)) > 0) {
                stringBuilder.append(new String(temp, 0, len));
            }
            inputStream.close();
        }
        return stringBuilder.toString();
    }
}
