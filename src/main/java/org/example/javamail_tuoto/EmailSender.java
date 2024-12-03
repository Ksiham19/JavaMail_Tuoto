package org.example.javamail_tuoto;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {
        // Configuration des propriétés pour le serveur SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Serveur SMTP de Gmail
        props.put("mail.smtp.port", "587");           // Port SMTP
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Authentification de l'utilisateur
        String username = "sihamkhiar18@gmail.com"; // Remplacez par votre email
        String password = "etld xioo kulq mvxx"; // Utilisez un mot de passe d'application Gmail

        // Création de la session avec authentification
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sihamkhiar18@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinataire@example.com")); // Email du destinataire
            message.setSubject("Test JavaMail");
            message.setText("Ceci est un email envoyé depuis un programme Java utilisant JavaMail.");

            // Envoi du message
            Transport.send(message);

            System.out.println("Email envoyé avec succès !");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Échec de l'envoi de l'email.");
        }
    }
}
