    package com.sfdc.controller;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.net.MalformedURLException;
    import java.net.URL;
    import java.security.cert.Certificate;
    import java.io.*;

    import javax.net.ssl.HttpsURLConnection;
    import javax.net.ssl.SSLPeerUnverifiedException;

    import static java.lang.System.*;
    import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;


    /**
     * Created by matro on 29-Jan-17.
     */
    @Controller
    @RequestMapping("/api")
    public class ApiController {

        private StringBuilder message = new StringBuilder();

        @RequestMapping(value = "")
        public String index(Model model) {
            out.println("*******************************");

           // System.setProperty("javax.net.ssl.trustStore","D:\\Development\\Projects\\Salesforce\\IDEA\\Hello\\src\\testkey.jks");
            //System.setProperty("javax.net.ssl.trustStorePassword","password ");


            out.println("*******************************");
            return "api";
        }

        @PostMapping("")
        public String index(@RequestParam("url") String data,Model model) {
            out.println("************POST***************");
            out.println(data);
            message = new StringBuilder();

            if(data.toLowerCase().contains("https"))
            {
                message.append(data + "<br>");
                testIt(data);
            }
            else
                message.append("Please enter correct url");


            model.addAttribute("message", message);

            return "api";
        }

        static {
            //for localhost testing only
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                    new javax.net.ssl.HostnameVerifier(){

                        public boolean verify(String hostname,
                                              javax.net.ssl.SSLSession sslSession) {
                            if (hostname.equals("localhost")) {
                                return true;
                            }
                            return false;
                        }
                    });
        }

        private void testIt(String https_url){

            //String https_url = "https://localhost:8000/test";
            URL url;
            try {

                url = new URL(https_url);
                HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

                //dumpl all cert info
                print_https_cert(con);

                //dump all the content
                print_content(con);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
        }

        }

        private void print_https_cert(HttpsURLConnection con){

            if(con!=null){

                try {
                    StringBuilder sb = new StringBuilder();

                    message.append("Response Code : " + con.getResponseCode() + "<br>");
                    message.append("Cipher Suite : " + con.getCipherSuite() + "<br>");
                    message.append("<br>");

                    out.println("Response Code : " + con.getResponseCode());
                    out.println("Cipher Suite : " + con.getCipherSuite());
                    out.println("\n");

                    Certificate[] certs = con.getServerCertificates();
                    for(Certificate cert : certs){
                        message.append( "Cert Type : " + cert.getType() + "<br>");
                        message.append("Cert Hash Code : " + cert.hashCode() + "<br>");
                        message.append("Cert Public Key Algorithm : "
                                + cert.getPublicKey().getAlgorithm() + "<br>");
                        message.append("Cert Public Key Format : "
                                + cert.getPublicKey().getFormat() + "<br>");
                        message.append("<br>");

                        out.println("Cert Type : " + cert.getType());
                        out.println("Cert Hash Code : " + cert.hashCode());
                        out.println("Cert Public Key Algorithm : "
                                + cert.getPublicKey().getAlgorithm());
                        out.println("Cert Public Key Format : "
                                + cert.getPublicKey().getFormat());
                        out.println("<br>");
                    }

                } catch (SSLPeerUnverifiedException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        private void print_content(HttpsURLConnection con){
            if(con!=null){

                try {
                    //message.append("****** Content of the URL ********" + "<br>");
                    out.println("****** Content of the URL ********");
                    BufferedReader br =
                            new BufferedReader(
                                    new InputStreamReader(con.getInputStream()));

                    String input;
                    while ((input = br.readLine()) != null){
                        out.println(input);
                        message.append(escapeHtml4(input) + "\n");
                    }

                    br.close();
                    //String source = "The less than sign (<) and ampersand (&) must be escaped before using them in HTML";
                    //String escaped = escapeHtml4(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
