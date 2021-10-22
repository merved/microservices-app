package com.haydikodlayalim.accountservice.api;

import com.haydikodlayalim.accountservice.entity.Account;
import com.haydikodlayalim.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Bunun bi arayüzü olmalıydı.O arayüzün bu class sadece implementasyonu olmalıydı


@RestController
@RequestMapping("account")
public class AccountApi {


    //ResponseEntity tipinde bi Account nesnesi geri dönsün
/*son kullanıcı tarafında , frontend tarafında bu api client olacak
    clienların tipi veya kim old. yada her kim ise
    bu api a bağlanırken , bunu özel bi geri dönüş nesnesi oluşturmaya
çalışıyoruz. Üzerinde;
status , responsetime,  statuscode geri dönüş tipleri var.Bu tip ortak
mesajlar oluşturabilmek için spring framework içinde yer alan kullanılabilecek
responseEntity diye bi class var. Tüm api larda aynı tipte bi mesaj geri döndürebilirsiniz
yada geri dönüş nesnelerinize aynı tiple sarmalayabilirsiniz.
    */
    /*context içerisinde bi nesne var. onu bana ver 1. yol autowitred etmek
     @Autowired
    AccountService accountService;*/
/*
* 2.yol
* constructor yoluyla bu nesne oluşturuken,  neye ihtiyacı varsa inject edilsin diye
* constructor injection yapılabilirdi.
* construction injection için aşağıdaki yapı kullanılır.
*aşağıdaki haliyle de bi anatasyon kullanmadan  construction injectionla bunu doldurmuştuk
* */
    private final AccountService accountService;
    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    //sunucudaki bi datayı istemek için
    public ResponseEntity<Account> get(@PathVariable("id") String id){
        /*servisin kullanımı: get metodunu bize parametre gelen id ile çalıştırsın.
        * ve ordan gelen sonucu şu ResponseEntity nesnesine  sarmalamamız gerekiyor  yani bu nesne tipi ile döndürmemiz gerekiyor*/
        /*ok metoduyla dönen nesneyi responseEntity e sarmalıyoruz */

       return  ResponseEntity.ok( accountService.get(id));
       /*öaet olarak service in get metoduna id ile  gittik. O bize bi kayıt verdi.
       * o kaydı http ok ile geri döndürdük
       * ok=> http 200 kodunu döndürür  */

    }
@PostMapping
//Path verilmesine gerek yok body de alıcaz. Body de almak içinde anatasyon kullanıcaz
//sunucuda yeni bi kayıt oluşturmak için http isteğiyle. Dosya yüklemede olabilir.Veritabanı bazında düşünmemek lazım
    public ResponseEntity<Account> save(@RequestBody Account account){
        return  ResponseEntity.ok( accountService.save(account));

    }
@PutMapping
    public ResponseEntity<Account> update(Account account){
        return  ResponseEntity.ok( accountService.update(account));

    }
    //httpde sunucudaki bi kaydı silmek için http delete metodu kullanılır
@DeleteMapping
    public void delete(String id){
        /*delete den bişe geri dönmüyordu bu nedenle , metot çağrılacak bu metot çağrıldıktan sonra geri dönüş yok
        * */
        accountService.delete(id);

    }
    /*
//sayfalayarak kayıtlaar geri dönecek
    public ResponseEntity<Account> pagination(){

    }*/
}
/*
* api katmanın service katmanını kullanması gerekiyor
* daha sonra servis katmanı gidip başka bi şey kullanacak belki.
* veritabanından mı getirecek kuyruklaa mı çalışacak vs gibi işleri bu servis katmanı yönetiyor olacak.
* hem git kuruktan al hemed git veritabanından kontrol et sonra api a cevap ver . gibi dağıtımı yönetimide
* gerçekleştiryor olacak bu servis katmanı... Bunun altında o işler için bi servis katmanı daha olabilirdi.
* o belkşi transaction scope ları ile ilgilenecekti ya da kuyruklarla bi çok aşama için farklı katmanlar konulabilinirdi.
* bunu gereksinimi projeden gelmeli.proje tipine farklı   gerreksinşmler olabilir.   */

/*önemli 1
* dependecy injection;
* Bu classın spring context i içerisinde nesnesinin oluşturulması bi instance nın oluşturulması için
* spring annotasion a sahip olması gerrkiyor.Fakat sadece bunun bi instancenın oluşup ram de bi nesnesinin
* oluşup, bi şekilde hizmet vermesi anlamına geliyor bu instancedan kasıt.Bunun oluşup çalışması yetmiyor
* Bu oluştuktan sonra dış dünyaya açılması lazım. Dış dünyaya  açılması için ise başka bi özelik kazandırılması
* gerekecek.Dış dünyaya da açıldıktan sonra bunun bşr de api yani bi webservice api olmasını bekliyoruz.
* Bunun içinde başka bi özellik kazandırılması gerekiyor.
* yani spring in @service diye bi anatasyon kullanılır.Bu bir instance oluşturur.o instance bi şekilde ram de yaşar.
* kim bunu kullanırsa jvm içerisinde ona hizmet eder.Fakat bizim daha farklı @RestController anatasyonu;
* web katmanında dış dünyaya açılan bi class olacağını bi instance oluşturacağını, onun aracılığıyla da bi takım
* http metotlarına hizmet eden bi takım mettolar yayınlayacağını söyleyen anatasyon string contextinde @RestController
*RestController la dışarıya açtık.
* açtıktan sonra bi adres ataması yapılması lazım.Adres için gerekli anatasyon @RequestMapping(account);
* şu adreste yayınlasın gibi
* Bu uygulama çalıştıgında defaultta ( localhost:8080/) bizim makine üzerinde değişiklik yapmazsak böyle bi adrreste ayaga kalkıyor
* localhost:8080/
* adres sonuna requestMapping içinde yazdıgımız path eklenmiş olur
* localhost:8080/account --> bunun altında ise yazılan meotlar yer alacak.
*20.dk...kaaldı
*aralık var
* ---
* 24 dk
* AccountService ın de  bi spring component olması lazım.Coomponentten kasıt onunda bi tane anatasyona sahip olup
* o anatasyon aracılığıyla application context in içerisine uygulamamızın bağlamında bi tane nesne olup hafızada ram de
* durması  yada jvm içerisinde durması gerekiyor.Biz ne zaman ihtiyaç duyarsak o nesnenin referansına her yerden erişebilmeliyiz.
* Bunu sağlamak içinde Account Service ında bi anatasyona sahip olması lazım.
*  */