import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Account {

	//Gereken degiskenler
	private int ID;
	private double balance; 
	private double faizOrani;
	public ArrayList<String> islemGecmisi=new ArrayList<String>(); //islem gecmisi icin liste tutuluyor
	private LocalDate hesapAcmaTarihi; 
	
	public void setHesapAcmaTarihi(LocalDate current){
		hesapAcmaTarihi=current;
	}
	public double getFaizOrani() {
		return faizOrani;
	}
	public void setFaizOrani(double faizOrani) {
		this.faizOrani = faizOrani;
	}
	public void deposit(double money){
		balance+=money;
		islemGecmisi.add(0,"Hesaba "+money+" yatirildi"); //her islemde ilk indexe o islem konuyor
	}
	public abstract void withdraw(double money); //withdraw kýsmý her hesapta farklý oldugu icin abstract tanýmlanddi
	
	public void showIslemGecmisi(){
		System.out.println(ID+" numarali hesabin islem özeti:");
		for(int i=0;i<islemGecmisi.size();i++){
			if(i==5)	//5 islem gosterilecegi icin 6.ya geldiginde cikis yapiliyor
				break;
			System.out.println(islemGecmisi.get(i));
		}
		System.out.println();
	}
	public double getBalance(){
		return balance;
	}
	
	public int getID(){
		return ID;
	}
	public void setID(int ID){
		this.ID=ID;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double Benefit(LocalDate current){
		double yillikKazanc=(balance*faizOrani)/100.0;
		double days=(double) ChronoUnit.DAYS.between(hesapAcmaTarihi, current); //tarihler arasindaki gun farkini hesapliyor
		double benefit=(365/days)*yillikKazanc;
		return benefit;
	}
	
	
}
