# scrumtracker backend

Trello linki : https://trello.com/b/ddcUpIx0/ara%C5%9Ft%C4%B1rma-problemleri

## Proje Detayları

- git pull ile projeyi çekebiliriz.

- intellij ayarlarından eclipse code formatter yüklenmesi gerekli, daha sonra plugin ayarlarından eclipse code formatter'ın bakacağı yer seçilecek. bu dosya files altında mevcut.

- java 15 kullanıyoruz, gradle ayarlarından "gradle jvm" için 15 seçilecek, File - Project Structure kısmına gelip Project SDK için de java 15 seçilmeli.

- openjdk-15 intellij ile birlikte indirilebiliyor, rahat bir şekilde import edilebilir.

- vue.js için yine plugini indirilmeli.

## Projeyi çalıştırmak için

- Projeyi indirdikten sonra gradle build yapılmalı
- Console'dan npm install ile vue.js için gerekli olan node'lar yüklenmeli
- Daha sonra Java Server'i ve Vue.js projesi çalıştırılmalı
- localhost:3000 üzerinden proje çalışmaktadır
- Eğer isterseniz application.properties dosyasına kendi mongodb url'inizi yazarak kendi local database'inize de bağlayabilirsiniz
