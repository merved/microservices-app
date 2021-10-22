package com.haydikodlayalim.accountservice.service;

import com.haydikodlayalim.accountservice.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//Api a datayı sunacak olan bi katmanın olması gerekiyor.
/*Bu katman için oluşturuldu.Bu class işi yüklencek.
ccountApi de ki benzer metotların burda da olması gerekiyor.
çünkü Bu servis cevaplayacak.Bu Metotlara hitap edecek şeylerin
burdada karşılıgının olması gerekiyor.
//Bu katmanda request response işlerini bilmiyoruz.Kendi nesne tipimizi bilmemiz gerekiyor.

*/
/*kullanılabilecek anatasyonlar
* @service , @component, @repository
* @service: belli iş mantıgını barındıran metotlarımızın sahip olması gereken anatasyon
* @component: web bileşenleri içerisinde utlity gibi kullanabileceğimiz classlarımıza vermemiz gereken anatsasyon
* @repository: özellikle entegrasyon noktalarında bu bi veritabanı olabilirdi
* veritabanına çıkış  noktamız olan classın sahip olması gereken anatasyon
* */
 @Service
public class AccountService {
/*get metodu neye göre kayıt getirecek
* bi parametre alacak.*/
    /*bi id parametre alacak bu id ye göre kaydı geri döndürsün*/
    public Account get(String Id){
return new Account("test-id");

    }
//kayıt yaparken account nesnesini keayıt etsin.
    public Account save(Account account){
        return new Account("test-id");

    }
//Account nesnesi update edilsin
    public Account update(Account account){
        return new Account("test-id");

    }
// ya id ile yada nesnenin kendisi ile delete edilebilir.
    //api levelinde çalışılıyorsa account ddiye bi nesneyi gereksiz yere sunucuya gönderip
    //kaydı sildirmenin bi anlamı yok.Verilen id silinmesi şeklinde olabilir
    //daha az veri göndermiş oluruz sunucuya
    public void delete(String id){

    }
    /*sayfalayarak kayıtlaar geri dönecek*/
    /*spring in pageAble diye bi classı kullanılacak.
    * */
   /* public Account pagination(){

    }*/
}
