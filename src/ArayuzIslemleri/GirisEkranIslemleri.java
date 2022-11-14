
package ArayuzIslemleri;

import java.util.Objects;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GirisEkranIslemleri {
    //Component
    private JTextField jTextField_KullanıcıAdı;
    private JTextField jTextField_KurtarmaKodu;
    private JPasswordField jPasswordField_sifre;
    
    private String girilenKullaniciAdi;
    private String girilenSifre;
    private String girilenKurtarmaKodu;
    
    //variable
    private String sonucMesaj;
    
    private String sonucKurtarma_BosAlan;
    private String sonucKurtarma_Mesaj;

    public GirisEkranIslemleri(JTextField jTextField_KullanıcıAdı, JTextField jTextField_KurtarmaKodu, JPasswordField jPasswordField_sifre) {
        this.jTextField_KullanıcıAdı = jTextField_KullanıcıAdı;
        this.jTextField_KurtarmaKodu = jTextField_KurtarmaKodu;
        this.jPasswordField_sifre = jPasswordField_sifre;
        
        this.girilenKullaniciAdi = jTextField_KullanıcıAdı.getText();
        this.girilenSifre = new String(jPasswordField_sifre.getPassword());
        this.girilenKurtarmaKodu = jTextField_KurtarmaKodu.getText();
        
    }
    
    public boolean bosGirisKontrol(){
        
        if(girilenKullaniciAdi.equals("") && (girilenSifre.equals(""))){
            this.sonucMesaj = "Kullanıcı Adı ve Şifre Giriniz";
            return false;
        }
        else if(girilenKullaniciAdi.equals("")){
            this.sonucMesaj = "Kullanıcı Adı Giriniz";
            return false;
        }
        else if(girilenSifre.equals("")){
            this.sonucMesaj = "Şifre Giriniz.";
            return false;
        }
        else{
            this.sonucMesaj = "Giriş Başarılı";
            return true;
        }
    }
    
    // Password Methods
    
    public boolean sifreKurtar(String kurtarmaKodu){
        
        boolean bosKurtarmaAlanKontrol = bosKurtarmaKontrol();
        boolean kurtarmaKoduKontrol = kurtarmaKoduKontrol(kurtarmaKodu);
        
        if (!bosKurtarmaAlanKontrol) {
            this.sonucMesaj = this.sonucKurtarma_BosAlan;
            return false;
        }else if(!kurtarmaKoduKontrol){
            this.sonucMesaj = this.sonucKurtarma_Mesaj;
            return false;
        }else{
            this.sonucMesaj = "Giriş Başarılı";
            return true;
        }
        
    }
    protected boolean bosKurtarmaKontrol(){
        
        if (!girilenKurtarmaKodu.equals("")) {
            
            this.sonucKurtarma_BosAlan = "Kod Girişi Başarılı";
            return true;
        }else{
            this.sonucKurtarma_BosAlan = "Kurtarma Kodu Girmediniz";
            return false;
        }
    }
    
    protected boolean kurtarmaKoduKontrol(String kurtarmaKodu){
        
        if(girilenKurtarmaKodu.equals(kurtarmaKodu)){
            this.sonucKurtarma_Mesaj = "Kod Girişi Başarılı";
            return true;
        }else{
            this.sonucKurtarma_Mesaj = "Kurtarma Kodu Yanlış";
            return false;
        }
        
    }

    public String getSonucMesaj() {
        
        return sonucMesaj;
    }
    
}
