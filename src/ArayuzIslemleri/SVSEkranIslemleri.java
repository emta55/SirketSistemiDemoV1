
package ArayuzIslemleri;

import Kullanıcılar.Kullanıcı;
import Paneller.PanelAtama;
import Paneller.PanelDepartman;
import Paneller.PanelKullanıcı;
import Paneller.PanelOlcek;
import Paneller.PanelSirket;
import javax.swing.JToggleButton;


public class SVSEkranIslemleri {
    
    private PanelKullanıcı panelKullanıcı;
    private PanelAtama panelAtama;
    private PanelSirket panelSirket;
    private PanelDepartman panelDepartman;
    private PanelOlcek panelOlcek;
    private Kullanıcı kullanıcı;
    
    ColorAndIcons colorAndIcons = new ColorAndIcons();

    public SVSEkranIslemleri(PanelKullanıcı panelKullanıcı, PanelAtama panelAtama, PanelSirket panelSirket, PanelDepartman panelDepartman, PanelOlcek panelOlcek, Kullanıcı kullanıcı) {
        this.panelKullanıcı = panelKullanıcı;
        this.panelAtama = panelAtama;
        this.panelSirket = panelSirket;
        this.panelDepartman = panelDepartman;
        this.panelOlcek = panelOlcek;
        this.kullanıcı = kullanıcı;
    }

    public SVSEkranIslemleri(PanelKullanıcı panelKullanıcı, PanelAtama panelAtama, PanelSirket panelSirket, PanelDepartman panelDepartman, PanelOlcek panelOlcek) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void initComponent_UI(){
        
        panelKullanıcı.getUiKullanıcı().kullanıcıEkBilgilerBaslangıc();
        
        if(this.kullanıcı.getRole().equals("Mudur")){
            Mudur_Ekranı();
        }else if(this.kullanıcı.getRole().equals("Admin")){
            admin_Ekranı();
        }else if(this.kullanıcı.getRole().equals("BirimSorumlusu")){
            BirimSorumlusu_Ekranı();
        }else if(this.kullanıcı.getRole().equals("Personel")){
            Personel_Ekranı();
        }else{
            System.out.println("Kullanıcı Rolü Tanımlanamadı");
        }
    }
    
    protected void Mudur_Ekranı(){
        
        panelKullanıcı.getUiKullanıcı().getjComboBox_Role().setModel(colorAndIcons.getModelMudur());
        panelKullanıcı.getjToggleButton().setSelected(true);
        panelAtama.getjToggleButton().setVisible(false);
        panelSirket.getjToggleButton().setVisible(false);
        panelDepartman.getjToggleButton().setVisible(false);
        panelOlcek.getjToggleButton().setVisible(false);
        
    }
    
    protected void admin_Ekranı(){
        
        panelKullanıcı.getUiKullanıcı().getjComboBox_Role().setModel(colorAndIcons.getModelAdmin());
        panelKullanıcı.getjToggleButton().setSelected(true);
        panelDepartman.getjToggleButton().setVisible(false);
        panelOlcek.getjToggleButton().setVisible(false);

    }
    
    protected void BirimSorumlusu_Ekranı(){
        
        panelDepartman.getjToggleButton().setSelected(true);
        panelOlcek.getjToggleButton().setVisible(false);
        panelKullanıcı.getjToggleButton().setVisible(false);
        panelAtama.getjToggleButton().setVisible(false);
        panelSirket.getjToggleButton().setVisible(false);
        
    }
    protected void Personel_Ekranı(){
        
        panelOlcek.getjToggleButton().setSelected(true);
        panelKullanıcı.getjToggleButton().setVisible(false);
        panelDepartman.getjToggleButton().setVisible(false);
        panelSirket.getjToggleButton().setVisible(false);
        panelAtama.getjToggleButton().setVisible(false);
        
    }
    
    public void btnItemStateChanged(JToggleButton jToggleBtn){
        
        if(jToggleBtn == panelKullanıcı.getjToggleButton()){
            
            if(panelKullanıcı.getjToggleButton().isSelected() && !panelKullanıcı.isBtnSeciliMi()){
                ekran_Kullanıcı();
            }
            if(panelKullanıcı.isBtnSeciliMi()){
                panelKullanıcı.getjToggleButton().setSelected(true);
            }
            
        }else if(jToggleBtn == panelAtama.getjToggleButton()){
            if(panelAtama.getjToggleButton().isSelected() && !panelAtama.isBtnSeciliMi()){
                ekran_Atama();
            }
            if(panelAtama.isBtnSeciliMi()){
                panelAtama.getjToggleButton().setSelected(true);
            }
        }else if(jToggleBtn == panelSirket.getjToggleButton()){
            if(panelSirket.getjToggleButton().isSelected() && !panelSirket.isBtnSeciliMi()){
                ekran_Sirket();
            }
            if(panelSirket.isBtnSeciliMi()){
                panelSirket.getjToggleButton().setSelected(true);
            }
        }else if(jToggleBtn == panelDepartman.getjToggleButton()){
            if(panelDepartman.getjToggleButton().isSelected() && !panelDepartman.isBtnSeciliMi()){
                ekran_Departman();
            }
            if(panelDepartman.isBtnSeciliMi()){
                panelDepartman.getjToggleButton().setSelected(true);
            }
        }else if(jToggleBtn == panelOlcek.getjToggleButton()){
            if(panelOlcek.getjToggleButton().isSelected() && !panelOlcek.isBtnSeciliMi()){
                ekran_Olcek();
            }
            if(panelOlcek.isBtnSeciliMi()){
                panelOlcek.getjToggleButton().setSelected(true);
            }
        }
        
    }
    
    protected void ekran_Kullanıcı(){
        
        panelKullanıcı.setBtnSeciliMi(true);
        panelAtama.setBtnSeciliMi(false);
        panelSirket.setBtnSeciliMi(false);
        panelDepartman.setBtnSeciliMi(false);
        panelOlcek.setBtnSeciliMi(false);
        
        panelKullanıcı.getjToggleButton().setSelected(true);
        panelAtama.getjToggleButton().setSelected(false);
        panelSirket.getjToggleButton().setSelected(false);
        panelDepartman.getjToggleButton().setSelected(false);
        panelOlcek.getjToggleButton().setSelected(false);
        
        panelKullanıcı.getjPanel().setVisible(true);
        panelAtama.getjPanel().setVisible(false);
        panelSirket.getjPanel().setVisible(false);
        panelDepartman.getjPanel().setVisible(false);
        panelOlcek.getjPanel().setVisible(false);
        
    }
    protected void ekran_Atama(){
        
        panelKullanıcı.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(true);
        panelSirket.setBtnSeciliMi(false);
        panelDepartman.setBtnSeciliMi(false);
        panelOlcek.setBtnSeciliMi(false);
        
        panelKullanıcı.getjToggleButton().setSelected(false);
        panelAtama.getjToggleButton().setSelected(true);
        panelSirket.getjToggleButton().setSelected(false);
        panelDepartman.getjToggleButton().setSelected(false);
        panelOlcek.getjToggleButton().setSelected(false);
        
        panelKullanıcı.getjPanel().setVisible(false);
        panelAtama.getjPanel().setVisible(true);
        panelSirket.getjPanel().setVisible(false);
        panelDepartman.getjPanel().setVisible(false);
        panelOlcek.getjPanel().setVisible(false);
        
    }
    protected void ekran_Sirket(){
        
        panelKullanıcı.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(false);
        panelSirket.setBtnSeciliMi(true);
        panelDepartman.setBtnSeciliMi(false);
        panelOlcek.setBtnSeciliMi(false);
        
        panelKullanıcı.getjToggleButton().setSelected(false);
        panelAtama.getjToggleButton().setSelected(false);
        panelSirket.getjToggleButton().setSelected(true);
        panelDepartman.getjToggleButton().setSelected(false);
        panelOlcek.getjToggleButton().setSelected(false);
        
        panelKullanıcı.getjPanel().setVisible(false);
        panelAtama.getjPanel().setVisible(false);
        panelSirket.getjPanel().setVisible(true);
        panelDepartman.getjPanel().setVisible(false);
        panelOlcek.getjPanel().setVisible(false);
        
    }
    protected void ekran_Departman(){
        
        panelKullanıcı.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(false);
        panelSirket.setBtnSeciliMi(false);
        panelDepartman.setBtnSeciliMi(true);
        panelOlcek.setBtnSeciliMi(false);
        
        panelKullanıcı.getjToggleButton().setSelected(false);
        panelAtama.getjToggleButton().setSelected(false);
        panelSirket.getjToggleButton().setSelected(false);
        panelDepartman.getjToggleButton().setSelected(true);
        panelOlcek.getjToggleButton().setSelected(false);
        
        panelKullanıcı.getjPanel().setVisible(false);
        panelAtama.getjPanel().setVisible(false);
        panelSirket.getjPanel().setVisible(false);
        panelDepartman.getjPanel().setVisible(true);
        panelOlcek.getjPanel().setVisible(false);
        
    }
    protected void ekran_Olcek(){
        
        panelKullanıcı.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(false);
        panelSirket.setBtnSeciliMi(false);
        panelDepartman.setBtnSeciliMi(false);
        panelOlcek.setBtnSeciliMi(true);
        
        panelKullanıcı.getjToggleButton().setSelected(false);
        panelAtama.getjToggleButton().setSelected(false);
        panelSirket.getjToggleButton().setSelected(false);
        panelDepartman.getjToggleButton().setSelected(false);
        panelOlcek.getjToggleButton().setSelected(true);
        
        panelKullanıcı.getjPanel().setVisible(false);
        panelAtama.getjPanel().setVisible(false);
        panelSirket.getjPanel().setVisible(false);
        panelDepartman.getjPanel().setVisible(false);
        panelOlcek.getjPanel().setVisible(true);
        
    }

    public PanelKullanıcı getPanelKullanıcı() {
        return panelKullanıcı;
    }

    public PanelAtama getPanelAtama() {
        return panelAtama;
    }

    public PanelSirket getPanelSirket() {
        return panelSirket;
    }

    public PanelDepartman getPanelDepartman() {
        return panelDepartman;
    }

    public PanelOlcek getPanelOlcek() {
        return panelOlcek;
    }
    
}
