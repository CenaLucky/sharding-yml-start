package com.cs.yml.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 4:20 PM
 * @description:
 */
public class IoUtil {

    public static byte[] toBytes(InputStream input) throws Exception {
        byte[] data = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int read;
            while ((read = input.read(b)) > 0) {
                byteOut.write(b, 0, read);
            }
            data = byteOut.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
        return data;
    }
}
