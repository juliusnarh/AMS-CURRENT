package com.telpo.usb.finger.utils;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

public class WriteResponseBodyToDisk {
    public static String TAG = "FARMERDOWNLOAD";
    private ResponseBody body;
    private String url;

    public WriteResponseBodyToDisk(ResponseBody body, String url) {
        this.body = body;
        this.url = url;
    }

    public boolean writeResponseBodyToDisk() {
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(AndroidUtils.downloadDirectoryPath() + File.separator + getFileName(url.split("/")));

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    public String getFileName(String[] parts) {
        for (String item : parts) {
            if (item.contains(".json")) {
                Log.e("FileName", item);
                return item;
            }
        }
        return "";
    }
}
