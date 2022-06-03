import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Current extends Account{
	
	public Current(int ID,int balance,LocalDate date){
		setID(ID);
		setBalance(balance);
		setFaizOrani(0);
		setHesapAcmaTarihi(date);
		islemGecmisi.add("Hesap "+balance +" ile olusturuldu");
	}
	@Override
	public void withdraw(double money){
		if(getBalance()-money>=0){	//hesapta olandan fazla para cekilmek isteniyorsa hata veriyor
			setBalance(getBalance()-money);
			System.out.println("Withdraw islemi basarili");
			islemGecmisi.add(0,"Hesaptan "+money+" cekildi");
		}
		else
			System.out.println("Withdraw islemi basarsiz.Para cekimi sonucunda olusacak deger 0TL nin altinda");
	}

	@Override
	public double Benefit(LocalDate current){ // faiz orani 0 oldugu icin kar direkt 0
		return 0;
	}
}
