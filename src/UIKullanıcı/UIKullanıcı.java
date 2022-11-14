
package UIKullanıcı;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class UIKullanıcı {
    
    private JTextField jTextField_isim;
    private JTextField jTextField_soyisim;
    private JTextField jTextField_kullanıcıAdı;
    private JTextField jTextField_KullanıcıŞifre;
    private JTextField jTextField_EMail;
    private JButton jButton_Yenile;
    private JButton jButton_KayıtOlustur;
    private JComboBox jComboBox_Role;
    private JSpinner jSpinner_Yas;
    private JPanel jPanel_BirimSorumlusuEkBilgiler;
    private JPanel jPanel_PersonelEkBilgiler;
    private JComboBox jComboBox_PersonellikBaslangıc;
    private JSpinner jSpinner_atamaPuanı;
    private JComboBox jComboBox_Departman;
    private JComboBox jComboBox_MudurlukBaslangıc;
    private JComboBox jComboBox_PersonelBaslangıc;
    private JPanel jPanel_DosyaOku;

    public UIKullanıcı(JTextField jTextField_isim, JTextField jTextField_soyisim, JTextField jTextField_kullanıcıAdı, JTextField jTextField_KullanıcıŞifre, JTextField jTextField_EMail, JButton jButton_Yenile, JButton jButton_KayıtOlustur, JComboBox jComboBox_Role, JSpinner jSpinner_Yas, JPanel jPanel_BirimSorumlusuEkBilgiler, JPanel jPanel_PersonelEkBilgiler, JComboBox jComboBox_PersonellikBaslangıc, JSpinner jSpinner_atamaPuanı, JComboBox jComboBox_Departman, JComboBox jComboBox_MudurlukBaslangıc, JComboBox jComboBox_PersonelBaslangıc, JPanel jPanel_DosyaOku) {
        this.jTextField_isim = jTextField_isim;
        this.jTextField_soyisim = jTextField_soyisim;
        this.jTextField_kullanıcıAdı = jTextField_kullanıcıAdı;
        this.jTextField_KullanıcıŞifre = jTextField_KullanıcıŞifre;
        this.jTextField_EMail = jTextField_EMail;
        this.jButton_Yenile = jButton_Yenile;
        this.jButton_KayıtOlustur = jButton_KayıtOlustur;
        this.jComboBox_Role = jComboBox_Role;
        this.jSpinner_Yas = jSpinner_Yas;
        this.jPanel_BirimSorumlusuEkBilgiler = jPanel_BirimSorumlusuEkBilgiler;
        this.jPanel_PersonelEkBilgiler = jPanel_PersonelEkBilgiler;
        this.jComboBox_PersonellikBaslangıc = jComboBox_PersonellikBaslangıc;
        this.jSpinner_atamaPuanı = jSpinner_atamaPuanı;
        this.jComboBox_Departman = jComboBox_Departman;
        this.jComboBox_MudurlukBaslangıc = jComboBox_MudurlukBaslangıc;
        this.jComboBox_PersonelBaslangıc = jComboBox_PersonelBaslangıc;
        this.jPanel_DosyaOku = jPanel_DosyaOku;
    }
    
    public void kullanıcıEkBilgilerBaslangıc(){
        
        jPanel_BirimSorumlusuEkBilgiler.setVisible(true);
        jPanel_PersonelEkBilgiler.setVisible(false);
        
        jComboBox_PersonellikBaslangıc.setSelectedIndex(0);
        jComboBox_PersonelBaslangıc.setSelectedIndex(0);
        jComboBox_MudurlukBaslangıc.setSelectedIndex(0);
        jComboBox_Departman.setSelectedIndex(0);
        
        jComboBox_PersonellikBaslangıc.setEnabled(false);
        jComboBox_PersonelBaslangıc.setEnabled(false);
        jComboBox_MudurlukBaslangıc.setEnabled(false);
        jComboBox_Departman.setEnabled(false);
        
        jSpinner_atamaPuanı.setValue(50);
        jSpinner_Yas.setValue(25);
        jSpinner_atamaPuanı.setEnabled(false);
        
    }
    public void kullanıcıRole_Component(String role){
        
        if(role.equals(" ")){
            kullanıcıEkBilgilerBaslangıc();
        }else if(role.equals("BirimSorumlusu")){
            BirimSorumlusu_Component();
        }else if(role.equals("Mudur")){
            Mudur_Component();
        }else if(role.equals("Personel")){
            Personel_Component();
        }
        
    }
    protected void BirimSorumlusu_Component(){
        
        jPanel_BirimSorumlusuEkBilgiler.setVisible(true);
        jPanel_PersonelEkBilgiler.setVisible(false);
        jComboBox_PersonellikBaslangıc.setEnabled(true);
        jComboBox_Departman.setEnabled(true);
        jComboBox_MudurlukBaslangıc.setEnabled(false);
        jComboBox_MudurlukBaslangıc.setSelectedIndex(0);
        
        jSpinner_atamaPuanı.setEnabled(true);
    }
    protected void Mudur_Component(){
        jPanel_BirimSorumlusuEkBilgiler.setVisible(true);
        jPanel_PersonelEkBilgiler.setVisible(false);
        jComboBox_PersonellikBaslangıc.setEnabled(true);
        jComboBox_Departman.setEnabled(true);
        jComboBox_MudurlukBaslangıc.setEnabled(true);
        jSpinner_atamaPuanı.setEnabled(true);
    }
    protected void Personel_Component(){
        jPanel_PersonelEkBilgiler.setVisible(true);
        jPanel_BirimSorumlusuEkBilgiler.setVisible(false);
        
        jComboBox_MudurlukBaslangıc.setEnabled(false);
        jComboBox_PersonellikBaslangıc.setEnabled(false);
        jComboBox_Departman.setEnabled(false);
        jSpinner_atamaPuanı.setEnabled(false);
        
        jComboBox_MudurlukBaslangıc.setSelectedIndex(0);
        jComboBox_PersonellikBaslangıc.setSelectedIndex(0);
        jComboBox_Departman.setSelectedIndex(0);
        jSpinner_atamaPuanı.setValue(50);
        
        
    }

    public JTextField getjTextField_isim() {
        return jTextField_isim;
    }

    public JTextField getjTextField_soyisim() {
        return jTextField_soyisim;
    }

    public JTextField getjTextField_kullanıcıAdı() {
        return jTextField_kullanıcıAdı;
    }

    public JTextField getjTextField_KullanıcıŞifre() {
        return jTextField_KullanıcıŞifre;
    }

    public JTextField getjTextField_EMail() {
        return jTextField_EMail;
    }

    public JButton getjButton_Yenile() {
        return jButton_Yenile;
    }

    public JButton getjButton_KayıtOlustur() {
        return jButton_KayıtOlustur;
    }

    public JComboBox getjComboBox_Role() {
        return jComboBox_Role;
    }

    public JSpinner getjSpinner_Yas() {
        return jSpinner_Yas;
    }

    public JPanel getjPanel_BirimSorumlusuEkBilgiler() {
        return jPanel_BirimSorumlusuEkBilgiler;
    }

    public JPanel getjPanel_PersonelEkBilgiler() {
        return jPanel_PersonelEkBilgiler;
    }

    public JComboBox getjComboBox_PersonellikBaslangıc() {
        return jComboBox_PersonellikBaslangıc;
    }

    public JSpinner getjSpinner_atamaPuanı() {
        return jSpinner_atamaPuanı;
    }

    public JComboBox getjComboBox_Departman() {
        return jComboBox_Departman;
    }

    public JComboBox getjComboBox_MudurlukBaslangıc() {
        return jComboBox_MudurlukBaslangıc;
    }

    public JComboBox getjComboBox_PersonelBaslangıc() {
        return jComboBox_PersonelBaslangıc;
    }

    public JPanel getjPanel_DosyaOku() {
        return jPanel_DosyaOku;
    }
    
    
}
