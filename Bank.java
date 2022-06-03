import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Bank {

	private ArrayList<Account> accounts;	//hesaplar icin liste tuttuk
	LocalDate date;				//bankanin guncel tarihi
	
	public Bank(){
		accounts = new ArrayList<>();
		date = LocalDate.of(2019, 1, 1);
	}
	public ArrayList<Account> getAccount() {
		return accounts;
	}
	
	public LocalDate getDate(){
		return date;
	}
	public void hesapEkle(Account account){
		accounts.add(account);
	}
	public void deposit(int ID,double cash){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getID()==ID){
				accounts.get(i).deposit(cash);	//verilen id ye gore o id ye ait hesabi bulup ekleme yapiliyor
				break;
			}
		}
	}
	
	public void withdraw(int ID,double cash){
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getID()==ID){
				accounts.get(i).withdraw(cash); //verilen id ye gore o id ye ait hesabi bulup cikartma yapiliyor
				break;
			}
		}
	}
	
	public void sortition(){
		ArrayList<Integer> hesapCekilis=new ArrayList<>();
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i) instanceof Special){
				int puan=1+ (int)accounts.get(i).getBalance() /2000;
				for(int j=0;j<puan;j++)
					hesapCekilis.add(accounts.get(i).getID());
			}
		}
		int sansliHesapIDindex= (int)(Math.random() *hesapCekilis.size());
		int id=hesapCekilis.get(sansliHesapIDindex);
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getID()==id){
				accounts.get(i).deposit(10000);
			}
		}
	
		System.out.println("Sansli Hesap ID:"+id+" . Hesaba 10.000 yatýrýldý");
	}
	public void listAccounts(){
		for(int i=0;i<accounts.size();i++){
			System.out.println(i+1 +":\t "+accounts.get(i).getID()+" Balance:"+accounts.get(i).getBalance());
		}
	}
	public boolean idVarmi(int id){
		boolean result=false;
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getID()==id){	//hesap ekleme yapilirken belirlenen id de baska bir hesap olup olmadigini kontrol ediyor. Eger varsa ekleme yapilmiyor,kullanici uyariliyor
				result=true;
				break;
			}
		}
		return result;
	}
	public boolean ozelHesapVarmi(){
		boolean result=false;
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i) instanceof Special){ //sortition yapilabilmesi icin hesaplar icinde ozel hesap var mi onun kontrolu yapiliyor
				result=true;
				break;
			}
		}
		return result;
	}
	public void setDate(int day,int month,int year){
		date=LocalDate.of(year, month, day);
	}
}
