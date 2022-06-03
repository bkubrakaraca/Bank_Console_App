import java.time.LocalDate;
import java.util.Date;

public class LongTerm extends Account{

	public LongTerm(int ID,int balance,LocalDate date){
		setID(ID);
		setBalance(balance);
		setFaizOrani(24);
		setHesapAcmaTarihi(date);
		islemGecmisi.add("Hesap "+balance +" ile olusturuldu");
	}
	
	@Override
	public void withdraw(double money){
		if(getBalance()-money>=1500){ //en az 1500 TL olmasi gerektigi icin kalan parayi kontrol ediyor
			setBalance(getBalance()-money);
			System.out.println("Withdraw islemi basarili");
			islemGecmisi.add(0,"Hesaptan "+money+" cekildi");
		}
		else
			System.out.println("Withdraw islemi basarsiz.Para cekimi sonucunda olusacak deger 1500TL nin altinda");
	}
}
