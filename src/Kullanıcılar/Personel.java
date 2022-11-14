
package Kullanıcılar;

public class Personel extends Kullanıcı{
    
    private Integer iseBaslamaTarihi;
    private String egitimSeviyesi;
    private String medeniDurum;

    public Personel(Integer iseBaslamaTarihi, String egitimSeviyesi, String medeniDurum, Integer id, Integer yas, String isim, String soyIsım, String kullanıcıAdı, String kullanıcıSifre, String role, String EMail) {
        super(id, yas, isim, soyIsım, kullanıcıAdı, kullanıcıSifre, role, EMail);
        this.iseBaslamaTarihi = iseBaslamaTarihi;
        this.egitimSeviyesi = egitimSeviyesi;
        this.medeniDurum = medeniDurum;
    }



    public Integer getIseBaslamaTarihi() {
        return iseBaslamaTarihi;
    }

    public String getEgitimSeviyesi() {
        return egitimSeviyesi;
    }

    public String getMedeniDurum() {
        return medeniDurum;
    }
    
}
