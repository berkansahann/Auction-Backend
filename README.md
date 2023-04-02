# Kartaca-Backend

kartaca test case backend

Merhaba, bu projenin ön yüzünde react, arka yüzünde spring, database olarak ise postgresql kullandım. Projeyi monolithic mimaride geliştirdim.

Kullanıcı üyeliği yapma, oturum açma ve kapatma özellikleri tamamen aktif bir şekilde çalışıyor. 

Üyelerin yeni eşyaları açık arttırmaya çıkartabilmesi için ana sayfaya "new auction" sekmesini ekledim. Kullanıcılar buradaki panel sayesinde gerekli bilgileri doldurarak yeni eşyaları da açık arttırmaya sunabilecekler.

Oturum açmamış, yani gerekli token'a sahip olmayan kullanıcılar oturum açma sayfasına yönlendiriliyor.

Ana sayfada istenilen ürün için offer tuşuna basılırsa teklif verebileceği bir sayfaya yönlendirilir.

Maalesef docker ile derlemeyi denesem de çözemediğim hatalarla karşılaştım, bu yüzden bunu yapamadım. Docker branchinde son gelebildiğim kısım bulunuyor. AWS üzerinden bir mysql serveri açtım ve o branchin bağlantılarını o şekilde bıraktım.

Keyin ilk hali 3851w0827yx989x48y8763zu37y341u815yyx2u29vu8xyvxw26737zzxyxw5yu9

Çözülmüş hali  3851d0827bc989c48b8763af37b341f815bbc2f29ef8cbecd26737aacbcd5bf9

Register Page

![image](https://user-images.githubusercontent.com/55889142/229372786-5388a0b6-4cfe-4d81-9773-4b4a14439e06.png)

Login Page

![image](https://user-images.githubusercontent.com/55889142/229371057-a3ce6a4d-1cdb-471f-ada4-e79309cee73f.png)
Home Page

![image](https://user-images.githubusercontent.com/55889142/229372771-148d970f-c598-4b55-ac13-9e87916f5549.png)

New Auction Page

![image](https://user-images.githubusercontent.com/55889142/229372757-937829dc-533c-49d0-88f9-15832cda83e1.png)

Bid Page

![image](https://user-images.githubusercontent.com/55889142/229372838-2ceb97ba-34f3-47f8-ac84-d9212e5e5883.png)
