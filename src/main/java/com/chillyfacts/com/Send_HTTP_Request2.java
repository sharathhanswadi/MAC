package com.chillyfacts.com;

import java.net.URLEncoder;


import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Send_HTTP_Request2 {
    public static void main(String[] args) {


        try {
            Send_HTTP_Request2.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        public static void call_me () throws Exception {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the MAC ID:");


            String q = sc.nextLine();
            String url =  "https://api.macvendors.com/"+q;
            url.replaceAll("\\s","%20");
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            System.out.println(response.toString());

        }
    }

