
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OgrenciIslemleri {
    ArrayList<Ogrenci> cikti = new ArrayList<Ogrenci>();
    
         File file = new File("C:\\Users\\MURAT\\Desktop\\test.txt");
         Scanner scanner = null;
     
    
    public ArrayList<Ogrenci> ogrencileriGetir() throws FileNotFoundException {
        
           scanner = new Scanner(file);
    
          
            while(scanner.hasNext()) {

            int no =Integer.parseInt(scanner.next());
            String ad =scanner.next();
            String soyad= scanner.next();
            int kredi= Integer.parseInt(scanner.next());
            float gpa =Float.parseFloat(scanner.next());
            
           
           cikti.add(new Ogrenci(no, ad, soyad, kredi, gpa));
                
           }     
            
           
            scanner.close();
            return cikti;
          
        
    
    }
    public void ogrenciGuncelle(int no,String yeni_ad,String yeni_soyad,int yeni_kredi,float yeni_gpa) throws FileNotFoundException, IOException {
      
        
       
        int a=0;
            for (Ogrenci ogrenci : cikti) {
                int nos=no;
                if(nos==ogrenci.getNo())
                {  
                     cikti.set(a, new Ogrenci(no, yeni_ad,yeni_soyad, yeni_kredi, yeni_gpa));
                }
                 if( yeni_gpa<0.00||yeni_gpa>4.0)
                 {
                     
                   JOptionPane.showMessageDialog(null, "Lütfen notu 0.0 ile 4.0 arasında giriniz");
                     break;   
                     
                 }
          
                   if(yeni_kredi<0||yeni_kredi>150)
                   {
                     JOptionPane.showMessageDialog(null, "Lütfen krediyi 0 ile 150 arasında giriniz");
                     break;
                   }
             a++;
                
             }
            
        dosyaYazma();     
      
    }
    public void ogrenciSil(int no) throws FileNotFoundException, IOException {
        
        
        int a=0;
            for (Ogrenci ogrenci : cikti) {
                int nos=no;
                if(nos==ogrenci.getNo())
                {  
                     cikti.remove(a);
                     break;
                }
                
             a++;
                
             }
            
        dosyaYazma();     
              
          
    }
    
    public int ogrenciEkle(int no,String ad,String soyad,int kredi,float gpa) throws FileNotFoundException, IOException {
         
         
        int a=0;
            for (Ogrenci ogrenci : cikti) {
                int nos=no;
                if(nos==ogrenci.getNo())
                {  
                    JOptionPane.showMessageDialog(null, "Lütfen farklı bir No girin");
                     a=a+1;
                     break;
                }
                 if( gpa<0.00||gpa>4.00)
                 {
                     
                   JOptionPane.showMessageDialog(null, "Lütfen notu 0.0 ile 4.0 arasında giriniz");
                     a=a+1;
                     break;   
                     
                 }
          
                   if(kredi<0||kredi>150)
                   {
                     JOptionPane.showMessageDialog(null, "Lütfen krediyi 0 ile 150 arasında giriniz");
                     a=a+1;
                     break;
                   }
             
                     
             }
            
          if(a==0){  
               
               cikti.add(new Ogrenci(no, ad, soyad, kredi, gpa));
               dosyaYazma();     
              
               
          } 
          return a;
    }
    
    
    
 public void dosyaYazma() throws IOException{
    
         
String yol="C:\\Users\\MURAT\\Desktop\\test.txt";
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(yol, false)));

for(int i=0;i<cikti.size();i++){
String s=cikti.get(i).getNo() +" " +cikti.get(i).getAd() +" "+cikti.get(i).getSoyad()+" "+cikti.get(i).getKredi() +" " +cikti.get(i).getGpa();
out.println("\n" + s);
 }

out.close();
    
 
 }
    
    
 
 
  public  Ogrenci ogrencileriBul(int no) throws FileNotFoundException
  {
      ogrencileriGetir();
       
  
        int a=0,i=0;
            for (Ogrenci ogrenci : cikti) {
                int nos=no;
                if(nos==ogrenci.getNo())
                {  i=-1;
                   break;
                }
           a++;
             
            }
            
          if(i!=-1){  
               JOptionPane.showMessageDialog(null, "Lütfen farklı bir No girin");
              return null;
          } 
          else 
                 return(cikti.get(a));
         
      

  }
          
 
 public float maxnot() throws FileNotFoundException{
       ogrencileriGetir();
   float max=0;
       for(int i=0;i<cikti.size();i++)
       {
           if(cikti.get(i).getGpa() >max)
               max=cikti.get(i).getGpa();
              
       }
     
     
        return max;
 
 }
 
  public float minnot() throws FileNotFoundException{
       ogrencileriGetir();
   float min=4;
       for(int i=0;i<cikti.size();i++)
       {
           if(cikti.get(i).getGpa() <min)
              min=cikti.get(i).getGpa();
              
       }
     
     
        return min;
 
 }
 
  
   public float ortnot() throws FileNotFoundException{
       ogrencileriGetir();
   float ort=0,toplam =0;
       for(int i=0;i<cikti.size();i++)
          toplam=toplam + cikti.get(i).getGpa();
              
     
     ort =toplam /cikti.size();
     
        return ort;
 
 }
    
    public OgrenciIslemleri() {
        
        
}

}