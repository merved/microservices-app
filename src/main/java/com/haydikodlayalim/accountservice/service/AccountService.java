package com.haydikodlayalim.accountservice.service;

import com.haydikodlayalim.accountservice.entity.Account;
import com.haydikodlayalim.accountservice.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

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
@RequiredArgsConstructor
@Service
public class AccountService {
/*get metodu neye göre kayıt getirecek
* bi parametre alacak.*/
    /*bi id parametre alacak bu id ye göre kaydı geri döndürsün*/

    //lombo
    //Account repository e bağlanacağız.
    //final constructor da injection yapacak..Constructorda injection da constructor oluşturmayacağız.
    //onun yerine lombonun RequiredArgsConstructor kullanılır
    // RequiredArgsConstructor : gereken  constructor varsa onunla inject et
    private final AccountRepository accountRepository;

    public Account get(String id){
        //parametre gelen id li kaydı döndüren metot bulunur
        //bulursa datanın kendisini değilse hata verir(exception)
        return accountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException());

    }
//kayıt yaparken account nesnesini keayıt etsin.
    public Account save(Account account){
        return accountRepository.save(account);

    }
//Account nesnesi update edilsin
    public Account update(String id, Account account){
        //id null ise mesaj ver
        Assert.isNull(id,"Id cannot be null " );
        //idyi nesneyi account olarak getirip, o account u aktarım yapıp öyle gönderme
        return accountRepository.save(account);

    }
// ya id ile yada nesnenin kendisi ile delete edilebilir.
    //api levelinde çalışılıyorsa account ddiye bi nesneyi gereksiz yere sunucuya gönderip
    //kaydı sildirmenin bi anlamı yok.Verilen id silinmesi şeklinde olabilir
    //daha az veri göndermiş oluruz sunucuya
    public void delete(String id){

    }

    public List<Account> findAll() {
       return  accountRepository.findAll();
    }
    /*sayfalayarak kayıtlaar geri dönecek*/
    /*spring in pageAble diye bi classı kullanılacak.
    * */
   /* public Account pagination(){

    }*/
}
