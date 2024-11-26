package ma.ensa.javaProject.Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private static final String host = "smtp.gmail.com";
    private static final String username = "elmouktadirmohamed@gmail.com";
    private static final String password = "xbbmdisdjsdeblvn";

    public static void emailSender(String DestinataireMail){

        //System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true"); // Use SSL
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try{
            // Construction du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Expéditeur
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(DestinataireMail) // Destinataire(s)
            );

            message.setSubject("sujet de email de test");
            message.setText("Bonjour les amis j'envoie un mail à moi meme hhhhh.");

            System.out.println("Sending...");
            Transport.send(message);
            System.out.println("Email envoyé avec succès à : " + DestinataireMail);
        } catch (MessagingException e) {
            //System.out.println("Erreur lors de l'envoi de l'email "+e.getCause());
            e.printStackTrace();
        }

    }
}
