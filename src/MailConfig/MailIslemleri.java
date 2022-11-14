package MailConfig;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailIslemleri {
    
    private String mailAdresim = "sirketsmssistemi@gmail.com";
    private String mailSifrem = "ysuivxflxlxddodz";
    private String sifreKurtarmaKodu = "";
    private String mailIcerigi_1 = "Merhaba,\n\nŞifrenizi Öğrenmek İçin Aşağıdaki Kodu Kullanınız:\n\n";
    private String mailIcerigi_2 = "\n\nİyi Günler..";
    private String mailBasligi = "SBSUI Şifre Kurtarma Kodu";
    
    Properties properties;
    Session session;
    Message mesaj;

    public MailIslemleri() {
        
        propertiesDegerleriniOlustur();
        sessionDegerleriniOlustur();
        
    }
    
    protected void propertiesDegerleriniOlustur(){
        properties = System.getProperties();
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls.enable", "true");
        this.properties.put("mail.smtp.host", "smtp.gmail.com");
        this.properties.put("mail.smtp.port", "587");
        this.properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
}

    
    protected void sessionDegerleriniOlustur(){
      
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                return new PasswordAuthentication(mailAdresim, mailSifrem);
                
            }
        });  
    }
    
    public void mailGonder(String mailAtilacakAdres) throws AddressException, MessagingException{
        
        
        this.sifreKurtarmaKodu = kurtarmaSifresiUret();
        
        mesaj = new MimeMessage(session);
        mesaj.setFrom(new InternetAddress(mailAdresim));
        mesaj.setRecipient(Message.RecipientType.TO, new InternetAddress(mailAtilacakAdres));
        mesaj.setText(mailIcerigi_1 + this.sifreKurtarmaKodu + mailIcerigi_2);
        mesaj.setSubject(mailBasligi);
        
        Transport.send(mesaj);
        
    }
    public String kurtarmaSifresiUret(){
        
        int sifreUzunlugu = 10;
        String buyukHarfler = "ABCDEFGHIJKLMNOPRSTWQYZ";
        String kucukHarfler = buyukHarfler.toLowerCase();
        String rakamlar = "1234567890";
        String rakamVeHarfler = buyukHarfler + kucukHarfler + rakamlar;
        Random rand = new Random();
        
        StringBuilder sifreOlusturucu = new StringBuilder();
        for(int i = 0; i<sifreUzunlugu; i++){
            sifreOlusturucu.append(rakamVeHarfler.charAt(rand.nextInt(rakamVeHarfler.length())));
        }
      return sifreOlusturucu.toString();
    }
    public String getSifreKurtarmaKodu(){
        return sifreKurtarmaKodu;
    }
    
}
