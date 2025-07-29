import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailNotifier {
    public static void sendEmail(String recipient, String subject, String messageText) {
        final String senderEmail = "your_email@example.com";
        final String senderPassword = "your_password";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            System.out.println("Email sent to " + recipient);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
