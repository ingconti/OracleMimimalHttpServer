package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        InputStream is = exchange.getRequestBody();

        URI uri = exchange.getRequestURI();
        System.out.println(uri);

        String method = exchange.getRequestMethod();
        System.out.println(method);

        String s = read(is); // .. read the request body
        System.out.println(s);

        //String response = "MyJava Sample";
        String response = process(s);

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }



    private String process( String body){

        String[] splitted = body.split("&");
        if (splitted.length == 0)
            return "no data\n";

        //return "args: " + splitted.length + "\n";
        String cmd = splitted[0].split("=")[0];
        String options = splitted[0].split("=")[1];
        String user = splitted[1].split("=")[1];

        System.out.println(cmd);
        System.out.println(options);

        if (cmd.equals("gimmeanswer") &&
                options.equals("please"))
            return "Hello " + user + "\n";

        if (cmd.equals("gimmeanswer"))
            return "You are unpolite, " + user + "\n";

        return "bad request";
    }

/*
    public void handle(HttpExchange t) throws IOException {
        InputStream is = t.getRequestBody();

        URI uri = t.getRequestURI();
        String query = uri.getQuery();

        String s = read(is); // .. read the request body

        String response = "<!doctype html>\n" +
                "<html lang=en>\n" +
                "<head>\n" +
                "<meta charset=utf-8>\n" +
                "<title>MyJava Sample</title>\n" +
                "</head>\n" +
                "<body>\n" +

                "</br>The content:" +
                "</br>\n" +
                s +

                "</br>query:" +
                "</br>\n" +
                query +
                "</body>\n" +
                "</html>\n";

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
/*

 */
    private String read(InputStream is) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));

        System.out.println("\n");
        String received = "";
        while (true) {
            String s = "";
            try {
                if ((s = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            received += s;

        }
        return received;
    }

}