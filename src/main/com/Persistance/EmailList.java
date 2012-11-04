package com.Persistance;

/**
 * Class: ShoppingLists
 * Description: Displays all the Shopping Lists created
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/28/12
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EmailList {

    public EmailList(String emailAddress, List shoppingList) {

        String strData = "";
        StringBuilder sb = new StringBuilder(strData);
        //build a new string with each item on a new line
        for (Object i : shoppingList) {
            sb.append(i.toString() + "\n");
        }
        strData = sb.toString();
        //setup the smtp properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("UMLEffectiveJava@gmail.com", "effectivejava");
            }
        });

        try {
            //build the message and send
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("UMLEffectiveJava@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("brianarnold789@gmail.com"));
            message.setSubject("Shopping List");
            message.setText(strData);

            Transport.send(message);

            System.out.println("e-mail sent");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}