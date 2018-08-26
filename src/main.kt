package main

import java.util.*

private val tara=Scanner(System.`in`)

private val CepTelefonu = cepTelefonu("555-555-555")

fun main(args: Array<String>) {

    telefonuBaslat()
    menuGoster()

    var cikis:Boolean=false

    while (!cikis){
        println("Seçiminiz:(Menu ye Geçmek için 6 ya basınız)")

        var secim = tara.nextInt()

        when(secim){
            0 ->{
                println("Çıkış Yapılıyor.")
                cikis=true
            }
            1 -> CepTelefonu.tumKisileriListele()
            2 ->{
                yeniKisiEkleFonksiyonu()

            }
            3 ->{
                kisiSorgulaFonksiyonu()
            }
            4 ->{
                kisiSilMethodu()
            }
            5 ->{
                kisiGuncelleMethodu()
            }
            6 ->{
                menuGoster()
            }

            else -> println("Yanlış bir Seçim Yaptınız.")
        }


    }


}

fun kisiGuncelleMethodu() {
    println("Güncellenecek Kişinin Adı : ")
    var isim=tara.next()

    val bulunacakKisi = CepTelefonu.isimSorgula(isim)

    if (bulunacakKisi == null){
        println("Kayıt Bulunamadı")
        return
    }

    println("Yeni adı giriniz.")

    println("Yeni Kişinin Adını Giriniz. ")
    val yeniisim = tara.next()

    println("Yeni Kişinin Numarasını Giriniz. ")
    val yeninumara = tara.next()

    CepTelefonu.kisiGuncelle(bulunacakKisi, Kisi.kisiOlustur(yeniisim,yeninumara))

}

fun kisiSilMethodu() {
    println("Silinecek Kişinin Adını Giriniz.")

    val isim = tara.next()

    val bulunanKisi = CepTelefonu.isimSorgula(isim)

    if (bulunanKisi != null) {

        if (CepTelefonu.kisiSil(bulunanKisi!!)) {
            println("Silme İşlemi Gerçekleitirildi. ")
        } else {
            println("Silme işlemi Gerçekleştirilmedi.")
        }
    }else {
        println("Kişi Yok")
    }
}

fun yeniKisiEkleFonksiyonu() {
    println("Yeni Kişinin Adını Giriniz. ")
    val isim = tara.next()

    println("Yeni Kişinin Numarasını Giriniz. ")
    val numara = tara.next()

    CepTelefonu.ekleYeniKisi(Kisi.kisiOlustur(isim,numara))

}

fun menuGoster(){

    println("************************** MENU *************************\n")
    println("0 - CIKIŞ \n 1 - Tüm Kişileri Listele \n 2 - Yeni Kişi Ekle \n 3 - Kiş Sorgula \n 4 - Kişi Sil \n 5 - Kişi Güncelle \n 6 - Menu Göster")
}

fun telefonuBaslat(){
    println("Telefon Başlatılıyor.")
}

fun kisiSorgulaFonksiyonu(){
    println("Aranacak Kişi Adını giriniz ")
    val isim = tara.next()

    val bulunanKisi = CepTelefonu.isimSorgula(isim)

    if (bulunanKisi == null){
        println("Rehberde Böyle Bir kişi YOK !!!!")
    }else {
        println("Bulunan kişi : ${bulunanKisi.isim} ------ ${bulunanKisi.telNo}")
    }

}