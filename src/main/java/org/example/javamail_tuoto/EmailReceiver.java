package org.example.javamail_tuoto;
import java.util.Properties;
import javax.mail.*;

public class EmailReceiver {

    public static void main(String[] args) {
        // Configuration des propriétés pour le serveur IMAP
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        props.put("mail.imaps.host", "imap.gmail.com");
        props.put("mail.imaps.port", "993");
        props.put("mail.imaps.ssl.enable", "true");

        final String username = "sihamkhiar18@gmail.com";
        final String password = "etld xioo kulq mvxx";

        try {
            // Création de la session avec les propriétés
            Session session = Session.getDefaultInstance(props, null);

            // Connexion au store IMAP
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", username, password);

            // Connexion à la boîte de réception (INBOX)
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Récupération des messages
            Message[] messages = inbox.getMessages();
            System.out.println("Nombre de messages : " + messages.length);

            // Lecture des messages
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("Message " + (i + 1));
                System.out.println("De : " + message.getFrom()[0]);
                System.out.println("Sujet : " + message.getSubject());
                System.out.println("Contenu : " + message.getContent().toString());
                System.out.println("------------------------------------");
            }

            // Fermeture de la boîte de réception et déconnexion
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

