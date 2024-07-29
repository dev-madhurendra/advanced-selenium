package com.zemoso.madhurendra.mailReport;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class SendMailWithProperties {

    public static void main(String[] args) throws EmailException, IOException {

        // Load properties from file
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream("/home/madhurendra.tiwari/Desktop/Zemoso-Training/Docker-Learning/advanced-selenium/src/main/resources/config.properties")) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Failed to load properties file.");
            e.printStackTrace();
            return;
        }

        // Get properties
        String host = props.getProperty("mail.smtp.host");
        String port = props.getProperty("mail.smtp.port");
        String username = props.getProperty("mail.username");
        String password = props.getProperty("mail.password");
        String recipient_mail = props.getProperty("mail.recipient");

        System.out.println(host + " " + port + " " + username + " " + password);

        String messageBody = new String(Files.readAllBytes(Paths.get("extent-report.html")));
        Email email = new HtmlEmail();
        email.setHostName(host);
        email.setSmtpPort(Integer.parseInt(port));
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
        email.setFrom(username);
        email.setSubject("Subject of the email");
        // email.setMsg("Hello!");
        email.setMsg(messageBody);

        email.addTo(recipient_mail);
        System.out.println("Email sending .......");
        email.send();
        System.out.println("Email sent successfully!");
    }
}
