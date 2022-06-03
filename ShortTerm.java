import java.time.LocalDate;
import java.util.Date;

public class ShortTerm extends Account {

	public ShortTerm(int ID,int balance,LocalDate date){
		setID(ID);
		setBalance(balance);
		setFaizOrani(17);
		setHesapAcmaTarihi(date);
		islemGecmisi.add("Hesap "+balance +" ile olusturuldu");
	}
	@Override
	public void withdraw(double money){
		if(getBalance()-money>=1000){ //en az 1000 TL olmasi gerekiyor, bundan dolayi 
			setBalance(getBalance()-money);
			System.out.println("Withdraw islemi basarili");
			islemGecmisi.add(0,"Hesaptan "+money+" cekildi");
		}
		else
			System.out.println("Withdraw islemi basarsiz.Para cekimi sonucunda olusacak deger 1000TL nin altinda");
	}
}
