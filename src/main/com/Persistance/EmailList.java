package com.Persistance;


import com.Category;
import com.Product;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Class: ShoppingLists
 * Description: Displays all the Shopping Lists created
 * Author: Brian Arnold & Guadalupe Robles Gil
 * Date: 10/28/12
 */

public class EmailList {

    /**
     * Constructor for EmailList class
     *
     * @throws ClassNotFoundException if an unrecognized class is passed in
     */
    public EmailList(String emailAddress, List myList) throws ClassNotFoundException {
        String strData = "";
        String subject;
        StringBuilder sb = new StringBuilder(strData);

        // test the lists and iterate over the appropriate class to create a StringBuilder containing
        // the contents of the list
        if (myList.contains(Product.class)) {
            subject = "Product List";
            Iterator iterator = myList.iterator();
            while (iterator.hasNext()) {
                Product product = (Product) iterator.next();
                sb.append(product.getItemName() + " : ");
                sb.append(product.getItemCategory().getItemName() + " : ");
                sb.append(product.getItemShop().getItemName() + " : ");
                sb.append(Integer.toString(product.getItemQuantity()) + " ");
                sb.append(product.getItemUnit());
                sb.append("\n");
            }
        } else if (myList.contains(Category.class)) {
            subject = "Category List";
            Iterator iterator = myList.iterator();
            while (iterator.hasNext()) {
                Category category = (Category) iterator.next();
                sb.append(category.getItemName() + "\n");
            }
        } else {
            throw new ClassNotFoundException("");
        }
        strData = sb.toString();

        sendMsg(strData, subject, emailAddress);
    }

    public void sendMsg(String body, String subject, String destinationAddress) {
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
                    InternetAddress.parse(destinationAddress));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("e-mail sent");
        } catch (MessagingException e) {
            System.out.println("e-mail NOT sent\n\n");
            e.printStackTrace();
        }
    }
}