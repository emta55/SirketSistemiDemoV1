
package Kullanıcılar;

public class Mudur extends BirimSorumlusu{
    
    private Integer mudurlukBaslangicTarihi;

    public Mudur(Integer mudurlukBaslangicTarihi, Integer birimsorumlusuBaslangicTarihi, String departman, String performansÖlçütü, Integer id, Integer yas, String isim, String soyIsım, String kullanıcıAdı, String kullanıcıSifre, String role, String EMail) {
        super(birimsorumlusuBaslangicTarihi, departman, performansÖlçütü, id, yas, isim, soyIsım, kullanıcıAdı, kullanıcıSifre, role, EMail);
        this.mudurlukBaslangicTarihi = mudurlukBaslangicTarihi;
    }



    public Integer getMudurlukBaslangicTarihi() {
        return mudurlukBaslangicTarihi;
    }
    
}
