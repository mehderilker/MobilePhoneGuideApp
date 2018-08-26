package main

class cepTelefonu(var kendiNumaram:String){

    private val rehber: ArrayList<Kisi>


    init {
        this.rehber=ArrayList()
    }

    fun ekleYeniKisi(yeniKisi:Kisi):Boolean{

        if(kisiSorgula(yeniKisi.isim) >= 0){
            println("${yeniKisi.isim} Sistemde Kayıtlı !!!! ")
            return false
        }

        this.rehber.add(yeniKisi)
        println("Başarılı Şekilde Eklendi...")
        return true
    }

    fun kisiSorgula(aranacakKisi: Kisi):Int{

        return this.rehber.indexOf(aranacakKisi)
    }

    ///Rehberdeki Kişi ile Yeni Girilecek İsmin Karşılaştırılması
    fun kisiSorgula(isim:String):Int{

        for (i:Int in rehber.indices){

            val oankiKisi=rehber[i]

            if (oankiKisi.isim.equals(isim)){
                return i
            }
        }

        return -1
    }

    fun tumKisileriListele(){
        println("************* REHBER **********")
        if (rehber.size == 0){
            println("Kayıtlı Kişi YOK !!!!!!")
            return
        }

        for (oankiKisi:Kisi in rehber){
            println("* ${oankiKisi.isim } - ${oankiKisi.telNo}")
        }
    }

    fun isimSorgula(isim : String):Kisi?{
        val pozisyon = kisiSorgula(isim)

        return if(pozisyon >= 0){
            rehber[pozisyon]
        }else null
    }

    fun kisiSil(silinecekKisi:Kisi): Boolean{
        val pozisyon = kisiSorgula(silinecekKisi)
        if (pozisyon <0){
            println("Böyle Bir kişi yok !!!")
            return false
        }

        this.rehber.remove(silinecekKisi)
        println("Kişi silindi")
        return true
    }

    fun kisiGuncelle(eskiKisi:Kisi,yeniKisi: Kisi):Boolean{
        val bulunanPozisyon = kisiSorgula(eskiKisi)
        if (bulunanPozisyon < 0 ){
            println("Böyle Bir kayıt yok ")
            return false
        }

        rehber[bulunanPozisyon]=yeniKisi

        println("${eskiKisi.isim} kişisi ${yeniKisi.isim} ile güncellenmiştir.")
        return true

    }

}