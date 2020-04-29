/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telpo.usb.finger.upload;

/**
 * @author Junior
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Uploader {

    private static final int CONNECTION_TIMEOUT = 10 * 1000;
    private static final int READ_TIMEOUT = 10 * 1000;
    final private String protocol;
    final private String server;

    public Uploader(String protocol, String server) {
        this.protocol = protocol;
        this.server = server;
    }

    protected HttpURLConnection getBaseConnection(String endpoint) throws IOException {
        HttpURLConnection connection;
        URL url;

        try {
            url = new URL(protocol + "://" + server + "/" + endpoint);
            connection = (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new IOException("Malformed URL");
        }
        connection.setDoInput(true);
        connection.setConnectTimeout(CONNECTION_TIMEOUT);
        connection.setReadTimeout(READ_TIMEOUT);
        return connection;
    }

    public String upload(String endpoint, PostData postData) throws IOException {
        HttpURLConnection connection = null;

        connection = getBaseConnection(endpoint);
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Charset", "utf-8");
        connection.setRequestProperty("Content-Type", postData.getContentType());
        connection.setRequestProperty("Accept", "text/json");
        OutputStream out = new BufferedOutputStream(connection.getOutputStream(), 8192);
        postData.write(out);
        out.flush();
        String response = null;
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // reads server's response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = reader.readLine();
            //System.out.println("Server's response: " + response);
        } else {
            System.out.println("Server returned non-OK code: " + responseCode);
        }
        connection.disconnect();
        return response;
    }
}
