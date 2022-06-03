import java.time.LocalDate;
import java.util.Date;

public class Special extends Account{

	
	public Special(int ID,int balance,LocalDate date){
		setID(ID);
		setBalance(balance);
		setFaizOrani(12);
		setHesapAcmaTarihi(date);
		islemGecmisi.add("Hesap "+balance +" ile olusturuldu");
	}
	
	@Override
	public void withdraw(double money){
		if(getBalance()-money>=0){
			setBalance(getBalance()-money);
			System.out.println("Withdraw islemi basarili");
			islemGecmisi.add(0,"Hesaptan "+money+" cekildi");
		}
		else
			System.out.println("Withdraw islemi basarsiz.Para cekimi sonucunda olusacak deger 0TL nin altinda");
	}
}
