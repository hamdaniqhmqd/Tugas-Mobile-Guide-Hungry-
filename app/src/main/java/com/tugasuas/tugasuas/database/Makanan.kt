package com.tugasuas.tugasuas.database

import com.ahmad.tugasuas.R
import java.io.Serializable

// enum class untuk pilihan jenis makanan
enum class JenisMakanan(val displayName: String) {
    MAKANAN_BERAT("Makanan Berat"),
    MAKANAN_RINGAN("Makanan Ringan"),
    KUE("Kue"),
    SAYUR("Sayur"),
    MINUMAN("Minuman");

    // untuk menampilkan value berupa string dari enum class jenisMakanan
    override fun toString(): String {
        return displayName
    }
}

// data class makanan
data class Makanan(
    val gambar: Int,
    val judul: String,
    val jenis: JenisMakanan,
    val waktu: String,
    val bahan: List<String>,
    val langkah: List<String>
) : Serializable

// untuk merubah dan menambahkan isi dari data makanan
fun DataMakanan(): MutableList<Makanan> {
    val data = mutableListOf<Makanan>()
    // per data
    data.add(
        Makanan(
            R.drawable.papeda, // masukan nama gambar
            "Papeda", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("250 gr tepung sagu","Air secukupnya","1/4 ikan kakap","1 ruas jari","1 ruas kunyit", "1 ruas lengkuas","3 siung bawang merah" ,"2 siung bawang putih" ,"5 buah cabai rawit","3 buah daun bawang","2 buah batang sereh","1 buah cabai merah","1 buah cabai hijau","Daun kemangi secukupnya", "Daun jeruk secukupnya","Air secukupnya", "Minyak goreng secukupnya"), // bahan
            listOf(" Untuk membuat papeda: siapkan wadah dan tambahkan tepung sagu.","Rebus air hingga mendidih dan tuang ke dalam wadah berisi tepung. Aduk hingga adonan lengket seperti lem." ,"Untuk membuat kuah kuning: haluskan bawang merah, bawang putih, cabai rawit, kunyit, jahe, dan lengkuas.","Geprek dan memarkan daun serai. ", "Iris halus daun bawang, daun jeruk, tomat, cabai merah, dan hijau. Sisihkan.","Siapkan wajan, tumis bumbu halus dan daun serai hingga wangi. Tambahkan air dan masukkan ikan. ", "Beri garam dan perasan jeruk nipis. Masak hingga ikan matang.","Koreksi rasa dan tambahkan bumbu jika kurang pas.","Tambahkan irisan batang bawang, cabai merah dan hijau, dan daun jeruk.","Siapkan piring, sajikan papeda dan ikan kuah kuning. ","Nikmati selagi hangat."), //langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.tumis, // masukan nama gambar
            "Tumis Kangkung", // nama makanan
            JenisMakanan.SAYUR, // jenis makanan
            "24.00", // waktu
            listOf("Satu ikan kangkung yang telah dibersihkan","2 siung bawang merah","5 siung bawang putih","5 buah cabai rawit","Garam, gula, kaldu ayam bubuk dan gula secukupnya"), // bahan
            listOf("Iris sebuah bumbu yang telah disediakan, lalu tumis bawang putih dan bawang merah.","Setelah mengeluarkan aroma wangi, masukkan cabai rawit dan tumis hingga matang.","Selanjutnya adalah memasukkan sayur kangkung dan aduk hingga rata.","Aduk hingga sayur kangkung layu, dan masukkan air panas secukupnya.","Tambahkan gula, garam dan kaldu bubuk.","Cicip rasa, jika telah pas dan sesuai selera, resep tumis kangkung satu ini siap dihidangkan."), //langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.asem, // masukan nama gambar
            "Sayur Asem", // nama makanan
            JenisMakanan.SAYUR, // jenis makanan
            "24.00", // waktu
            listOf("1 buah jagung manis, potong-potong","100 g melinjo muda","2 cm lengkuas, memarkan","2 lembar daun salam","1 buah labu siam, potong-potong","5 helai kacang panjang, potong-potong","50 g daun melinjo muda","3 buah asam muda","1 potong kecil gula aren","8 buah cabe merah keriting","5 buah cabe rawit merah","5 butir bawang merah","3 siung bawang putih","4 butir kemiri","1 potong terasi bakar","2 sdt garam"), // bahan
            listOf("Didihkan air secukupnya dalam panci, rebus jagung dan buah melinjo hingga lunak.","Dalam panci terpisah, rebus asam muda dengan sedikit air hingga lunak. Angkat, remas-remas, saring airnya sekitar 100 ml.","Giling atau tumbuk semau bahan bumbu hingga halus.","Masukkan bumbu dan gula ke dalam rebusan jagung, bersama lengkuas dan daun salam.","Tambahkan labu siam dan kacang panjang. Rebus hingga lunak.","Masukkan daun melinjo dan air asam muda, didihkan kembali.","Angkat dan sajikan hangat"), // langkah - langkah

        )
    )

    data.add(
        Makanan(
            R.drawable.ayamgoreng, // masukan nama gambar
            "Ayam Goreng", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("500 gram ayam broiler/pedaging (5 potong)","250 ml air","1/2 sdm garam","1 sdt kaldu bubuk","3 butir bawang merah","3 siung bawang putih","2 butir kemiri","1 cm jahe","2 cm kunyit","Sejempol lengkuas","1 sdt ketumbar","2 lembar daun salam","2 lembar daun jeruk","1 batang serai"), // bahan
            listOf("Cuci ayam dan kerat-kerat,haluskan bumbu lalu tumis beserta bumbu aromatik hingga harum.","Masukkan ayam, aduk dan tambahkan air, garam dan kaldu bubuk, ungkep sesekali balik hingga bumbu meresap dan asat.","Angkat ayam, goreng hingga tingkat kering yang diinginkan, angkat, tiriskan.","Sajikan dengan sambal, nikmat"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.cumigoreng, // masukan nama gambar
            "Cumi Goreng", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("1/2 kg cumi","10 sendok tepung terigu","3 sendok tepung maizena","1/2 sendok teh soda kue","Secukupnya penyedap rasa","Secukupnya ladaku","Secukupnya bawang putih bubuk","Secukupnya ketumbar bubuk","1 buah jeruk nipis","Secukupnya garam","1 buah telur"), // bahan
            listOf("Cuci bersih cumi lalu potong-potong membulat setelah itu pakai perasan jeruk nipis diamkan selama 10 atau 15 menit.","Setelah 10 atau 15 menit cuci kembali cumi lalu masukkan penyedap rasa, ladaku, ketumbar bubuk, bawang putih bubuk, dan garam, lalu diamkan 15 menit dan masukkan dalam kulkas.","Siapkan dahulu tepung terigu yang dicampurkan tepung maizena, lalu masukkan soda kue, lalu aduk sampai rata,ini untuk tepung kering ya.","Setelah 15 menit, ambil cumi yang tadi di kulkas lalu masukkan telur dan tepung (tepungnya ambil 3 sendok saja ditepung kering tadi). Setelah itu aduk sampai rata.","Sesudah diaduk rata ambil cumi satu persatu dan masukkan ke dalam tepung kering, balur dengan tepung, setelah itu panaskan minyak, masukan cumi dan goreng sampai coklat keemasan.","Setelah cumi matang,angkat dan tiriskan.","Dan siap disajikan."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.bebekgoreng, // masukan nama gambar
            "Bebek Goreng", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("1 ekor bebek, potong²","400-500 ml air","1 sdm ketumbar","5 butir kemiri","5 siung bawang putih","1 sdt lada bubuk","2 ruas kunyit","2 ruas jahe","2 ruas lengkuas","1/2 sdm garam (sesuai selera)","1 sdt kaldu bubuk","5 lembar daun jeruk","2 btg serai, geprek","5 lembar daun salam"), // bahan
            listOf("Cuci bersih daging bebek, tiriskan.","Taruh bebek kedlm panci, masukkan semua bumbu (bumbu halus dan bumbu aromatik)","Tambahkan air, aduk rata dan tutup pancinya. Masak bebek pake api sedang. Masak sekitar 45 - 60 menit sampai air menyusut dan bumbu meresap, koreksi rasa. ","Goreng sampai matang. Siapkan sambal kesukaan","bebek goreng siap disajikan"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.nastar, // masukan nama gambar
            "Nastar", // nama makanan
            JenisMakanan.KUE, // jenis makanan
            "24.00", // waktu
            listOf("200 gram Blueband","175 Gram room butter","3 butir Kuning telur","525 Gram tepung terigu pro rendah","40 Gram susu full cream","20 Gram tepung maizena","2 sendok makan gula halus","secukupnya Selai nanas","2 kuning telur + 1sdm minyak untuk olesan nastar"), // bahan
            listOf("Campur mentega room butter dan gula halus sampai rata","Kalo sudah merata masukan kuning telur,aduk sampai tercampur","Setelah itu masukan tepung sedikit demi sedikit sampai dirasa adonan pas","Jika dirasa sudah pas bisa langsung diisi dengan selai nanas","Panggang kurang lebih 20 menit lalu keluarkan,tunggu hingga dingin lalu olesi telur yg sudah dicampur minyak tadi.panggang sampai dirasa matang"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.donat, // masukan nama gambar
            "Donat Gula", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
        "24.00", // waktu
        listOf("200 gr kentang (dikukus buang kulitnya)","500 gr tepung terigu","1 saset susu bubuk putih(3 sdm)","2-3 butir kuning telur","100-150 gram gula pasir","150-200 gram mentega","1/4 sdt garam (untuk mengunci kelembutan)","3 sdt fermipan / ragi instan","150 ml air hangat + 1sdt gula","Gula "), // bahan
        listOf("Kukus kentang sampai matang, kemudian haluskan, sisihkan","Campurkan gula dengan kuning telur, kocok hingga gula larut. Kemudian campurkan dengan kentang halus","Siapkan air hangat, jangan terlalu panas ya untuk membuat biang, Air hangat di campur dengan sedikit gula (saya 1 sdt) dan di beri fermipan, aduk sebentar kemudian ditutup dan diamkan sampai berbuih","Campurkan tepung kedalam adonan kentang tadi, step by step. Masukkin juga susu dan raginya, aduk hingga tercampur rata dan kalis","Setelah adonan kalis, beri garam dan juga mentega, kemudian tutup dan diamkan sekitar 30 menit sampai mengembang","Setelah adonan mengembang, kempes kan adonan agar udara keluar, dan bulat bulatkan adonan. "," Setelah semuanya di timbang, bulat bulatkan adonan sampai mulus, kemudian tutup dengan lap bersih dan biarkan sampai mengembang, untuk di goreng","Setelah 15 menit di kembangkan, kita siapkan wajan berisi minyak panas, goreng adonan donat sampai kuning kecoklatan","Taburi gula halus"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.putri, // masukan nama gambar
            "Putri Salju", // nama makanan
            JenisMakanan.KUE, // jenis makanan
            "24.00", // waktu
            listOf("250 gr tepung terigu","50 gr tepung maizena","1 sdm susu bubuk (dancow)","185 gr margarin/mentega","50 gr gula galus","1 butir kuning telur","1/4 sdt garam","Secukupnya gula salju/gula halus untuk topping"), // bahan
            listOf("Siapkan wadah lalu masukkan mentega, gula halus dan kuning telur lalu mixer hingga rata kurleb 60 detik, setelah tercampur rata lalu masukkan tepung terigu, maizena, susu bubuk dan garam lalu aduk hingga adonan kalis","Jika adonan sudah kalis kemudian pipihkan di atas loyang dan bentuk sesuai selera. Setelah itu taruh adonan di atas loyang yg sudah di oles mentega"," Jika sudah terbentuk semua lalu masukkan loyang yg berisi adonan putri salju ke dalam oven, oven kurleb 40 menit. Jika sudah berwarna kekuningan lalu angkat dan dinginkan","Kemudian ambil putri salju tadi lalu campurkan menggunakan gula saju atau gula halus lalu aduk hingga rata"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.oyen, // masukan nama gambar
            "Es Oyen", // nama makanan
            JenisMakanan.MINUMAN, // jenis makanan
            "24.00", // waktu
            listOf("2 bungkus sagu mutiara","1 buah alpukat matang potongan buah nangka secukupnya","1 buah kelapa muda","Krimer carnation","6 SDM gula pasir","400 ml Air"), // bahan
            listOf("Rebus sagu mutiara sampai mndidih kurleb 15 menit. lalu matikan api kompor. tutup dg tutup panci, biarkan selama 30 menit","Rebus 6 SDM gula dg 400ml air..atau tergantung selera","Belah dan sisir kelapa","memanjang","Belah alpukat.ambil bijinya, kemudian siapkan es batu di mangkok","Racik diatas es batu yg di mangkok. 1 cintung sayur air gula, kelapa yg sdh di sisir,alpukat, potongan buah nangka dan krimer sesuai selera.","EsOyen siap dinikmati"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.tahu, // masukan nama gambar
            "Tahu Walik", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu
            listOf("10 buah Tahu pong","150 gr Tepung tapioka","75 gr Tepung terigu (penggunaan tapioka dan terigu 2:1, banyak tapioka)","6 siung bawang putih","1 sdt Garam","1 sdm Royco (boleh kurang atau lebih)","1/2 sdm Ladaku merica bubuk","2 batang Daun bawang (opsional) secukupnya Air"), // bahan
            listOf("Potong tahu pong menjadi 2 bagian, menjadi bentuk segitiga","Balik tahu pong, yang di dalam menjadi di luar. Keluarkan isi tahu pong kemudian sisihkan","Uleg bawang putih hingga halus","Masukkan bahan kering (tepung tapioka dan terigu) ke dalam wadah lalu campur","Setelah itu masukkan ulegan bawang putih, garam, lada, royco, isian tahu dan daun bawang ke dalam wadah tepung tadi","Campur semua bahan sebelum dimasukkan air","Setelah itu masukkan air secara perlahan sedikit demi sedikit agar tidak terlalu encer","Pastikan tekstur adonan tidak terlalu encer agar bisa dimasukkan ke dalam tahu (saran: tekstur adonan seperti adonan cilok)","Pastikan rasa adonan sudah pas tidak terlalu asin","Masukkan adonan ke dalam tahu satu per satu, jangan terlalu banyak agar bisa matang sempurna saat digoreng","Setelah selesai, kemudian panaskan minyak di minyak panas api kecil ke sedang agar tidak gosong. Minyak harus banyak sampai tahu terendam minyak"," Goreng tahu hingga kecoklatan dan krispi"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.tempe, // masukan nama gambar
            "Tempe Goreng", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu
            listOf("1/2 papan tempe","1/4 sdt Bubuk merica","1/4 sdt garam","1/4 sdt bubuk ketumbar","1/4 sdt kaldu bubuk"), // bahan
            listOf("Potong tempe tipis-tipis","Kerat bagian tengah tempe agar bumbu meresap","Masukkan garam, merica, ketumbar, dan kaldu bubuk ke dalam tempe lalu aduk merata","Simpan di kulkas selama 10-15 menit","Goreng Tempe hingga kecoklatan","Tempe siap dinikmati"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.nasigoreng, // masukan nama gambar
            "Nasi Goreng", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("1 piring Nasi putih","secukupnya Campuran sayuran,kacang,wortel, dan daging udang,terserah selera masing-masing","2 butir telur","Minyak goreng","Bawang merah atau putih"), // bahan
            listOf("Panaskan minyak, kocok telur dengan campuran irisan bawang merah dan digoreng hingga matang,terserah telur mau dicampur diaduk atau dipisah dengan nasi goreng."," Kalau mau dipisahkan telurnya,panaskan minyak lagi, gorengkan nasinya dengan campuran sayuran dan daging dan ditambahkan bumbu nasi goreng,sesuai selera. hingga kelihatan menjadi kecoklatan,setelah itu nasi gorengnya diangkat dituangkan kepiring.","Sesudah itu telur yg sudah digoreng diletakan diatas nasi gorengnya dan siap disajikan."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.omeltte, // masukan nama gambar
            "Omelette", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu
            listOf("2 BTR telur","3 siung bawang merah","2 buah cabe merah keriting","1/8 sdt garam","1/8 sdt kaldu jamur","1/8 sdt lada bubuk","1/2 SDM margarin"), // bahan
            listOf("Kupas bawang merah, cuci bersih, rajang, cuci bersih cabe merah, potong serong","Dadar telur dalam wadah, tambahkan bawang merah, lada bubuk, garam dan kaldu bubuk aduk hingga tercampur rata"," Lelehkan margarin dalam teflon tuang telur dadar, masak dengan api kecil hingga satu sisinya matang.","Setelah satu sisi dadar berwarna golden brown, balikkan telur dadar masak kembali hingga matang.","Omelette siap disajikan"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.telurdadar, // masukan nama gambar
            "Telur Dadar Campur", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu
            listOf("2 butir telur ayam","1 batang daun bawang, iris tipis","sejumput garam atau kaldu bubuk","5 sdm minyak goreng"), // bahan
            listOf("Siapkan 2 butir telur ayam dalam wadah. beri kaldu bubuk.","Kocok telur dan beri daun bawang","Goreng dalam minyak panas, api sedang sampai matang. jangan lupa dibalik supaya matang merata. siap disajikan."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.mieayam, // masukan nama gambar
            "Mie Ayam", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("1 pack mie telur basah siap pakai","500 gr ayam ","1 tangkai sereh ","3 lembar daun salam","3 lembar daun jeruk","2-3 Sdm kecap manis","2 Sdt kecap asin","1 Sdt lada bubuk","Secukupnya garam dan gula","7 siung bawang merah","4 siung bawang putih","2 butir kemiri (sangrai)","1 ruas kunyit","50-100 ml minyak sayur","kulit dan lemak ayam","3 siung bawang putih (cincang)","Tulang-tulang ayam (sy pakai tulang paha)","500-1000 ltr air","Secukupnya garam dan lada bubuk"), // bahan
            listOf("topping ayam : Pisahkan ayam dengan tulang dan kulit, ambil dagingnya saja, kemudian potong dadu (tulang untuk kaldu, kulit untuk minyak ayam)","Tumis bumbu halus dg sereh, daun salam dan daun jeruk hingga matang dan harum"," Masukkan daging ayam, masak sampai berubah warna, kemudian tambahkan kecap, lada bubuk, garam, gula dan air kaldu secukupnya"," Masak sampai kuah menyusut (jika suka manis bisa tambahkan kecap)","Ayam siap digunakan","Kuah Kaldu :  Rebus tulang dg air, tambahkan garam, lada bubuk dan daun jeruk (opsional), masak dengan api kecil sampai sari-sarinya keluar","Saring kuahnya","Kuah kaldu siap digunakan","Minyak Ayam : Pada wajan, tuang minyak sayur. Masukkan kulit dan lemak ayam","Masak dengan api kecil hingga kulit ayam kering, angkat kulit dan masukkan bawang putih cincang"," Masak sampai bawang putih kering","Minyak ayam siap digunakan","1 mangkuk mie ayam: Pada mangkuk : masukkan 1 Sdm minyak ayam, 1 Sdt kecap ikan dan 1/2 Sdt lada bubuk"," Rebus mie, tuang ke mangkuk, aduk rata mie dengan bumbu","Beri topping ayam, bakso, sawi, kuah kaldu, pangsit goreng","Taburkan daun bawang dan bawang goreng","Sajikan mie dengan sambal, saos dan kecap sesuai selera"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.bakso, // masukan nama gambar
            "Bakso", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("500 gr daging sapi","5 siung bawang merah, iris, goreng","5 siung bawang putih, iris, goreng ","2 siung bawang putih cincang","100 gram tapioka","1 sdt baking powder","1 sdt merica","2 sdt garam","100 gram tulang sumsum/ tulang iga","100 gram es","2 butir telur, ambil putihnya saja","200 gram es untuk rendam rebusan bakso","Bumbu Kuah:3 siung bawang putih","4 butir kemiri","5 cm daun bawang","Pelengkap:Soun, seledri, bawang merah goreng, cabai rawit, mie kuning"), // bahan
                    listOf("Rebus tulang dan 1,5 liter air selama 1 jam, matikan api."," Blender daging hingga halus, lalu masukkan bawang merah putih goreng, garam, baking powder, merica, dan putih telur."," Cetak bulat-bulat adonan, lalu masukkan ke dalam air panas rebusan tulang tadi. Jika baso mengapung segera angkat dan masukkan ke dalam air es. Tiriskan.","Kuah: Goreng kemiri, bawang putih lalu blender dan goreng dengan sedikit minyak hingga kecoklatan. Masukkan ke dalam air rebusan tulang tadi.","Masukkan bakso dan sajikan bersama pelengkap lainnya."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.rendang, // masukan nama gambar
            "Rendang", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu
            listOf("2 kilo daging padat potong-potong sesuai selera","1/4 cabe giling","1 Santan kental dari 8 butir kelapa","1 ons masing2 Bumbu halus","(bawang merah, bawang putih, jahe, lengkuas)","5 lembar daun salam","2 batang sereh geprek","Segenggam cabe rawit atau cabe setan untuk penambah rasa"), // bahan
            listOf("Perasan santan kental masukan kewajan bersama cabe dan bumbu halus beserta dedaunan"," Aduk sampai santan nya mendidih","Kalau sudah tanak Masukkan daging bersama cabe setannya","Masak dengan api kecil sampai berwarna coklat atau hitam","rendang siap disajikan"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.mochi, // masukan nama gambar
            "Mochi", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
        "24.00", // waktu
        listOf("Bahan kulit:  125 gr tepung ketan","135 ml air putih ","1/2 sdt garam","60 gr gula kastor","20 gr mentega putih","Pewarna makanan secukupnya","Bahan isian : Choco crunch","Bahan pelapis :Tepung maizena sangrai secukupnya"), // bahan
        listOf("Campur dan aduk hingga rata tepung ketan, air, garam, dan gula, lalu saring.","Kukus dalam wadah antilengket selama 25-30 menit atau sampai adonan transparan. Lalu angkat dan biarkan hangat.","Tambahkan mentega putih lalu uleni hingga kalis 5-10 menit. Beri beberapa tetes pewarna makanan sesuai selera.","Ambil kurang lebih 1 sendok adonan, beri bahan isian, lalu tutup dan rapatkan.","Kemudian gulingkan ke bahan pelapis. Lakukan hingga adonan habis.","Siap dinikmati."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.crepes, // masukan nama gambar
            "Crepes", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu
            listOf("120 gr tepung beras","25 gr tep terigu","40 gr tep maizena","1/2 sdt baking powder","75 gr gula pasir","30 gr kental manis","250 ml air bersih. Atau 200 ml air + 1 butir telur","Bahan Isi :Coklat ceres","Keju parut sesuai selera Atau lainnya"), // bahan
            listOf("Campurkan semua bahan crepes dan aduk rata.","Tuangkan ke wadah plastik bawaan dr wajan walik","Panaskan wajan walik dg api kecil hingga panas merata.","Celup bagian atas wajan ke dalam adonan lalu balikkan","wajannya dan masak di api kompor hingga permukaannya coklat. Beri topping atau isian.","Angkat crepes dan lakukan hingga selesai. Saat baru matang crepes masih lembek. Setelah hangat akan garing atau crispy.","Crepes siap dinikmati"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.pie, // masukan nama gambar
            "Pie", // nama makanan
            JenisMakanan.KUE, // jenis makanan
            "24.00", // waktu
            listOf("250 gr Tepung Terigu","1 Sdm susu bubuk","1 Sdt vanili","1 Sdm Gula halus","1 butir kuning telur","100 gr Margarin","10 gr butter anchor","Bahan isi :100 ml air","2 bungkus SKM","1 sdt vanili","1 sdm meizena","2 butir kuning telur"), // bahan
            listOf("Campur terigu,susu bubuk dan gula halus trus di ayak...lalu masukan margarin yang di bekukan terlebih dahulu di kulkas lalu diaduk2 sampe rata","Setelah itu masukan telur aduk sampe menjadi adonan kulit pie","Lanjut cetak kedalam cetakan pie.","Selanjutnya membuat isian pie susu","Campur air dan susu aduk sampe bercampur rata..lalu masukan vanili dan dan kuning telur aduk rata lagi","Terakhir masukan tepung meizena","Aduk lagi..lalu saring","Tuang isian susu ke blm kulit pie satu persatu.","Lalu oven dgn suhu 160°c Api atas bawah selama 30 sampe 40 menit tergantung oven masing2","Jika sudah, Pie siap dinikmati."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.pukis, // masukan nama gambar
            "Pukis", // nama makanan
            JenisMakanan.KUE, // jenis makanan
        "24.00", // waktu
        listOf("500 grm Tepung terigu","600 ml santan","4 butir telur","200 grm gula","100 grm margarin cair","1 SDM ragi instan","1/2 kaleng susu kental manis","1/2 SDM garam","2 lembar daun pandan","1 sdt coklat bubuk"), // bahan
        listOf(" Siapkan bahan2, rebus santan dengan garam beri daun pandan, aduk2 terus jgn sampai santan pecah rebus dengan api kecil hingga mendidih biarkan suam2 kuku.","Mixer telur dan gula hingga gula larut, lalu masukkan tepung terigu sedikit demi sedikit berbarengan dengan santan.","Masukkan susu kental manis mixer lagi sampai rata lalu masukkan margarin cair aduk2 hingga rata terakhir masukkan ragi instan, pastikan ragi instan masih aktif aduk rata lalu tutup dengan serbet bersih istirahat kan 1jam"), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.pancong, // masukan nama gambar
            "Pancong", // nama makanan
            JenisMakanan.KUE, // jenis makanan
        "24.00", // waktu
        listOf("500 gr Tepung terigu protein tinggi","100 gr gula","2 btr telur","50 gr mentega yg dicairkan","1 sdm vanili","1 sdt baking soda","Sejumput garam","500 ml air","Topping Mesis coklat"), // bahan
        listOf("Masukkan 2 telur, gula dan mentega dalam 1 wadah.","Mixer bahan tersebut sampai tercampur rata.","Masukkan 500 ml air, lalu mixer kembali.","Tambahkan 500 gr tepung, baking soda & vanili lalu mixer kembali hingga bahan tercampur rata.","Panaskan cetakan yang telah diolesi margarin.","Saat cetakan sudah panas, masukkan adonan yang telah dibuat, dan masak sampai adonan setengah matang (kira-kira 2 menit).","Setelah 2 menit pancong bisa diangkat dan diberi topping Mesis coklat.","Pancong lumer siap di hidangkan."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.kebab, // masukan nama gambar
            "Kebab", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu
            listOf("150 gr tepung terigu","1/2 sdt baking powder","3 sdm minyak goreng","1/2 sdt garam","60-80 ml air hangat","Isian :6 buah slice burger beef","6 lembar daun selada","6 buah sosis","2 buah tomat","Secukupnya mayonais","Secukupnya saos tomat","Secukupnya saos keju"), // bahan
            listOf("Campurkan semua bahan kulit, uleni sampai kalis, diamkan 45 menit.","Bagi menjadi 6 bagian, gilas tipis adonan lalu panggang di teflon sampai berubah warna.","Tumis burger beef dan sosis.","Tata kulit kebab, burger beef, tomat dan sosis, lalu tambahkan mayonais, saos tomat, saos keju lalu gulung","Kebab siap di sajikan."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.doger, // masukan nama gambar
            "Es Doger", // nama makanan
            JenisMakanan.MINUMAN, // jenis makanan
            "24.00", // waktu
            listOf("200 gram kelapa muda","2.500 gram es serut","25 gram sagu mutiara merah","25 gram sagu mutiara hijau","75 gram tape ketan hitam","125 gram alpukat","125 gram nangka","100 gram tape singkong","Bahan Sirup:250 gram kental manis","500 gram gula pasir","250 ml santan dari 1 butir kelapa","1/2 sendok teh garam","10 tetes pewarna merah muda"), //bahan
            listOf("Kelapa muda dan alpukat dikeruk lebar serta nangka dipotong-potong.","Sagu mutiara direbus terlebih dahulu.","Rebus hingga mendidih kental manis, gula pasir, santan, pewarna dengan api kecil.","Setelah matang, dinginkan beberapa saat.","Kemudian masukkan sirup ke dalam es serut, aduk rata dan masukkan ke dalam freezer.","Masukkan kelapa muda, sagu mutiara, tape ketan hitam, buah dan tape singkong ke dalam wadah.","Campurkan dan aduk dengan kental manis.","Es doger siap disajikan."), // langkah - langkah
        )
    )

    data.add(
        Makanan(
            R.drawable.dawet, // masukan nama gambar
            "Es Dawet", // nama makanan
            JenisMakanan.MINUMAN, // jenis makanan
            "24.00", // waktu
            listOf("100 gram tepung beras","4 sdm tepung tapioka","500 ml air","2 lembar daun pandan","Bahan juruh/gula cair:200 gram gula merah","500 ml air","Santan:300 ml air","65 ml santan instan"), // bahan
            listOf("Masak tepung beras, tapioka, dan air pandan sampai matang dan meletup-letup.","Angkat dan dinginkan.","Cetak dawet dengan saringan dan siapkan air es di bawahnya.","Masak gula merah dan air sampai mendidih. Masak santan."," Campurkan gula, santan, dan dawet. Beri es batu agar segar.","Sajikan."), // langkah - langkah
        )
    )
    return data // untuk mengembalikan atau mengeluarkan data
}


