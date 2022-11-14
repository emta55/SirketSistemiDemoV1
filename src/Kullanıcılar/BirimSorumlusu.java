
package Kullanıcılar;

public class BirimSorumlusu extends Kullanıcı{
    
    private Integer birimsorumlusuBaslangicTarihi;
    private String departman;
    private String performansÖlçütü;

    public BirimSorumlusu(Integer birimsorumlusuBaslangicTarihi, String departman, String performansÖlçütü, Integer id, Integer yas, String isim, String soyIsım, String kullanıcıAdı, String kullanıcıSifre, String role, String EMail) {
        super(id, yas, isim, soyIsım, kullanıcıAdı, kullanıcıSifre, role, EMail);
        this.birimsorumlusuBaslangicTarihi = birimsorumlusuBaslangicTarihi;
        this.departman = departman;
        this.performansÖlçütü = performansÖlçütü;
    }

    

    public Integer getBirimsorumlusuBaslangicTarihi() {
        return birimsorumlusuBaslangicTarihi;
    }

    public String getDepartman() {
        return departman;
    }

    public String getPerformansÖlçütü() {
        return performansÖlçütü;
    }
    
    
}
