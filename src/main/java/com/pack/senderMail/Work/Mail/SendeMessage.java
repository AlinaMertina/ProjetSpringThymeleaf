package com.pack.senderMail.Work.Mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendeMessage {
    public void sendMessage(String email) {
        System.out.println("tongasoa");

        // Informations sur le serveur de messagerie
        String host = "smtp.gmail.com";
        String port = "587"; // ou "465" pour SSL
        String username = "minoraherinirina72@gmail.com";
        String password = "kods duwe ajin tlau";
        // Paramètres de propriétés
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        // Création d'une session avec authentification
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("minoraherinirina72@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Message de validation de l'inscription ");
            // Partie texte du message
            String messageText = "Votre compte est activee";
            message.setText(messageText);

            // Envoi du message
            Transport.send(message);
            System.out.println("erororororr 1");
            System.out.println("E-mail envoyé avec succès!");

        } catch (MessagingException e) {
            System.out.println("erororororr");
            e.printStackTrace();
        }
    }
}
