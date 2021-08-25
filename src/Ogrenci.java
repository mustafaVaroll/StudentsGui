
public class Ogrenci {
    
    private int no;
    private String ad;
    private String soyad;
    private int kredi;
    private float gpa;

    
    public Ogrenci(int no, String ad, String soyad, int kredi, float gpa) {
        this.no = no;
        this.ad = ad;
        this.soyad = soyad;
        this.kredi=kredi;
        this.gpa= gpa;
    }
      
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

   
    public int getKredi() {
        return kredi;
    }

    public void setKredi(int kredi) {
        this.kredi = kredi;
    }
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    
}
