import java.util.Scanner;

public class BankDemo {

	
	public static void main(String[] args){
		Bank bank = new Bank();
		Scanner k = new Scanner(System.in);
		while(true){
			System.out.println("Yapmak istediginiz islemin numarasini giriniz");
			System.out.println("1)Kýsa vadeli hesap ac");
			System.out.println("2)Uzun vadeli hesap ac");
			System.out.println("3)Ozel hesap ac");
			System.out.println("4)Cari hesap ac");
			System.out.println("5)Hesaba para ekle");
			System.out.println("6)Hesaptan para cek");		//kullaniciya islemler sunuluyor ve secime gore islemler yapiliyor
			System.out.println("7)Tarihi ayarla");
			System.out.println("8)Hesaplarý goster");
			System.out.println("9)Hesap id lerini listele");
			System.out.println("10)Hesaplar icin cekilis yap");
			System.out.println("11)Hesaplar icin kar hesaplamasi yap");
			System.out.println("12)Cikis yap");
			int secim = k.nextInt();
			if(secim==1){
				System.out.println("Id girisi yapiniz");
				int id=k.nextInt();
				if(!bank.idVarmi(id)){
					System.out.println("Baslangic parayi giriniz:");
					int balance=k.nextInt();
					if(balance>=1000){		//kýsa vadeli hesap acilirken en az 1000 TL olmak zorunda
						bank.hesapEkle(new ShortTerm(id,balance,bank.getDate()));
					}
					else
						System.out.println("Kýsa vadeli hesaplarda balance degeri 1000 TL nin altinda olamaz");
				}
				else
					System.out.println("Girdiginiz id baska bir hesaba aittir.Hesap acilamadi");
			}
			else if(secim==2){
				System.out.println("Id girisi yapiniz");
				int id=k.nextInt();
				if(!bank.idVarmi(id)){
					System.out.println("Baslangic parayi giriniz:");
					int balance=k.nextInt();
					if(balance>=1500){ //uzun vadeli hesap acilirken en az 1000 TL olmak zorunda
						bank.hesapEkle(new LongTerm(id,balance,bank.getDate()));
					}
					else
						System.out.println("Kýsa vadeli hesaplarda balance degeri 1500 TL in altinda olamaz");
				}
				else
					System.out.println("Girdiginiz id baska bir hesaba aittir.Hesap acilamadi");
			}
			else if(secim==3){
				System.out.println("Id girisi yapiniz");
				int id=k.nextInt();
				if(!bank.idVarmi(id)){
					System.out.println("Baslangic parayi giriniz:");
					int balance=k.nextInt();
					bank.hesapEkle(new Special(id,balance,bank.getDate()));
				}
				else
					System.out.println("Girdiginiz id baska bir hesaba aittir.Hesap acilamadi");
			}
			else if(secim==4){
				System.out.println("Id girisi yapiniz");
				int id=k.nextInt();
				if(!bank.idVarmi(id)){
					System.out.println("Baslangic parayi giriniz:(Para olmasini istemiyorsaniz 0 giriniz)");
					int balance=k.nextInt();
					bank.hesapEkle(new Current(id,balance,bank.getDate()));
				}
				else
					System.out.println("Girdiginiz id baska bir hesaba aittir.Hesap acilamadi");
			}
			else if(secim==5){
				System.out.println("Para eklenecek hesabýn Id girisi yapiniz");
				int id=k.nextInt();
				if(bank.idVarmi(id)){	//hesap var mý yok mu diye kontrol ediliyor
					System.out.println("Eklenecek parayý giriniz");
					int cash=k.nextInt();
					bank.deposit(id, cash);
				}
				else
					System.out.println("Girdiginiz hesaba ait id bulunamamistir.Para eklenemedi");
			}
			else if(secim==6){
				System.out.println("Para cekilecek hesabýn Id girisi yapiniz");
				int id=k.nextInt();
				if(bank.idVarmi(id)){
					System.out.println("Cekilecek parayý giriniz");
					int cash=k.nextInt();
					bank.withdraw(id, cash);
				}
				else
					System.out.println("Girdiginiz hesaba ait id bulunamamistir.Para eklenemedi");
			}
			else if(secim==7){
				System.out.println("Lutfen Yýlý giriniz:");
				int year=k.nextInt();
				System.out.println("Lutfen ayý giriniz");
				int month=k.nextInt();
				System.out.println("Lutfen günü giriniz");
				int gun=k.nextInt();
				bank.setDate(gun, month, year);
			}
			else if(secim==8){
				for(int i=0;i<bank.getAccount().size();i++){
					bank.getAccount().get(i).showIslemGecmisi();
				}
			}
			else if(secim==9){
				bank.listAccounts();
			}
			else if(secim==10){
				if(bank.ozelHesapVarmi())
					bank.sortition();
				else
					System.out.println("Bankada ozel hesap yoktur. Cekilis yapilamadi.");
			}
			else if(secim==11){
				for(int i=0;i<bank.getAccount().size();i++){
					System.out.println("ID:"+bank.getAccount().get(i).getID()+"\t Kar:"+bank.getAccount().get(i).Benefit(bank.getDate()));
				}
			}
			else if(secim==12){
				System.out.println("Sistem kapatiliyor...");
				System.exit(0);
			}
		}
	}
}
