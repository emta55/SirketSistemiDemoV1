
package SQLIslemleri;

import Kullanıcılar.Admin;
import Kullanıcılar.BirimSorumlusu;
import Kullanıcılar.Kullanıcı;
import Kullanıcılar.Mudur;
import Kullanıcılar.Personel;
import MailConfig.MailIslemleri;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.mail.MessagingException;


public class SQLKullaniciIslemleri extends SQLBaglanti{
    
//sql user
    private final String KULLANICI_ADI_SIFRESI = "SELECT * FROM kullanıcı WHERE kullanıcıAdı=? AND kullanıcıSifre=?";
    private final String KULLANICI_ADI = "SELECT * FROM kullanıcı WHERE kullanıcıAdı=?";
//sql admin
    private final String ADMIN_ID = "SELECT * FROM admin WHERE id=?";
    
//sql personel
    private final String PERSONEL_ID = "SELECT * FROM personel WHERE id=?";
    
//sql birimsorumlusu
    private final String BIRIMSORUMLUSU_ID = "SELECT * FROM birimsorumlusu WHERE id=?";
    
//sql mudur
    private final String MUDUR_ID = "SELECT * FROM birimsorumlusu INNER JOIN mudur WHERE birimsorumlusu.id=?";
    
    
    
    
    //class
    private MailIslemleri mail;
    
    public SQLKullaniciIslemleri(MailIslemleri mail, String DBIsmi){
        super(DBIsmi);
        this.mail = mail;
    }
    
    public Kullanıcı kullanıcıBul(String girilenKullanıcıAdı)throws SQLException{
        Kullanıcı kullanıcı = null;  
        
        komuttamamlayici = baglanti.prepareStatement(KULLANICI_ADI);
        komuttamamlayici.setString(1, girilenKullanıcıAdı);
        
        ResultSet sonuc = komuttamamlayici.executeQuery();
        
        while(sonuc.next()){
        
            kullanıcı = new Kullanıcı(
            
                    sonuc.getInt("id"),
                    sonuc.getInt("yas"),
                    sonuc.getString("isim"),
                    sonuc.getString("soyIsim"),
                    sonuc.getString("kullanıcıAdı"),
                    sonuc.getString("kullanıcıSifre"),
                    sonuc.getString("role"),
                    sonuc.getString("EMail")
                    
            );
        }       
        return kullanıcı;
        
    }    
    public Kullanıcı kullaniciBul(String girilenKullanıcıAdı, String girilenKullanıcıSifre) throws SQLException{
        
        Kullanıcı kullanıcı = null;
        String role = "";
        
        
        komuttamamlayici = baglanti.prepareStatement(KULLANICI_ADI_SIFRESI);
        komuttamamlayici.setString(1, girilenKullanıcıAdı);
        komuttamamlayici.setString(2, girilenKullanıcıSifre);

        ResultSet sonuc = komuttamamlayici.executeQuery();
        
        while(sonuc.next()){
            
            role = sonuc.getString("role");
            
            switch (role) {
                case "Admin":
                    kullanıcı = ekBilgileriBul(ADMIN_ID, sonuc);
                    break;
                case "Personel":
                    kullanıcı = ekBilgileriBul(PERSONEL_ID, sonuc);
                    break;
                case "BirimSorumlusu":
                    kullanıcı = ekBilgileriBul(BIRIMSORUMLUSU_ID, sonuc);
                    break;
                case "Mudur":
                    kullanıcı = ekBilgileriBul(MUDUR_ID, sonuc);
                    break;
                default:
                    kullanıcı = null;
                    break;
            }
            
            
        }
        
        return kullanıcı;
    }
    
    
    protected Kullanıcı ekBilgileriBul(String SQL,ResultSet sonuc) throws SQLException{
        
        Kullanıcı kullanıcı = null;
        Integer id = sonuc.getInt("id");
        String role = sonuc.getString("role");
        
        komuttamamlayici = baglanti.prepareStatement(SQL);
        komuttamamlayici.setInt(1, id);
        ResultSet sonucYeni = komuttamamlayici.executeQuery();
        
        while(sonucYeni.next()){
            switch (role) {
                case "Admin":
                    kullanıcı = new Admin(
                            
                            sonucYeni.getInt("adminSifresi"),
                            sonuc.getInt("id"),
                            sonuc.getInt("yas"),
                            sonuc.getString("isim"),
                            sonuc.getString("soyIsim"),
                            sonuc.getString("kullanıcıAdı"),
                            sonuc.getString("kullanıcıSifre"),
                            sonuc.getString("role"),
                            sonuc.getString("EMail")
                    );  break;
                case "Personel":
                    kullanıcı = new Personel(
                            
                            sonucYeni.getInt("iseBaslamaTarihi"),
                            sonucYeni.getString("egitimSeviyesi"),
                            sonucYeni.getString("medeniDurum"),
                            sonuc.getInt("id"),
                            sonuc.getInt("yas"),
                            sonuc.getString("isim"),
                            sonuc.getString("soyIsim"),
                            sonuc.getString("kullanıcıAdı"),
                            sonuc.getString("kullanıcıSifre"),
                            sonuc.getString("role"),
                            sonuc.getString("EMail")
                            
                    );  break;
                case "BirimSorumlusu":
                    kullanıcı = new BirimSorumlusu(
                            sonucYeni.getInt("birimsorumlusuBaslangicTarihi"),
                            sonucYeni.getString("departman"),
                            sonucYeni.getString("performansÖlçütü"),
                            sonuc.getInt("id"),
                            sonuc.getInt("yas"),
                            sonuc.getString("isim"),
                            sonuc.getString("soyIsim"),
                            sonuc.getString("kullanıcıAdı"),
                            sonuc.getString("kullanıcıSifre"),
                            sonuc.getString("role"),
                            sonuc.getString("EMail")
                    );  break;
                default:
                    kullanıcı = new Mudur(
                            sonucYeni.getInt("mudurlukBaslangicTarihi"),
                            sonucYeni.getInt("birimsorumlusuBaslangicTarihi"),
                            sonucYeni.getString("departman"),
                            sonucYeni.getString("performansÖlçütü"),
                            sonuc.getInt("id"),
                            sonuc.getInt("yas"),
                            sonuc.getString("isim"),
                            sonuc.getString("soyIsim"),
                            sonuc.getString("kullanıcıAdı"),
                            sonuc.getString("kullanıcıSifre"),
                            sonuc.getString("role"),
                            sonuc.getString("EMail")
                            
                    );  break;
            }
        }
        
        return kullanıcı;
    }
    
    public boolean sifremiUnuttum(Kullanıcı kullanıcı) throws MessagingException{
        
        
        
        if(!kullanıcı.getEMail().equals("")){
            System.out.println("Mail Gönderme Islemlerine Devam Edilecek..");
            mail.mailGonder(kullanıcı.getEMail());
            return true;
            
        }else{
            
            System.out.println("Kullanici Maili Bulunamadi");
            return false;
        }
        
        
    }
    
    
}
