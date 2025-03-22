<div align="center">
TUGAS PRAKTIK <br>
MANAJEMEN KONFIGURASI DAN EVOLUSI PERANGKAT LUNAK <br>


<img src="https://lac.telkomuniversity.ac.id/wp-content/uploads/2021/01/cropped-1200px-Telkom_University_Logo.svg-270x270.png" width="250px">

<br>

Disusun Oleh: <br>
Syahrul Zaki Khuzaini/2211104014 <br>
SE-06-01 <br>

<br>

Dosen Pengampu : <br>
Yudha Islami Sulistya, S.Kom., M.Cs <br>

<br>

PROGRAM STUDI S1 REKAYASA PERANGKAT LUNAK <br>
FAKULTAS INFORMATIKA <br> 
TELKOM UNIVERSITY PURWOKERTO <br>

</div>

# Penjelasan
setelah mengidentifikasi bad smell yang terdapat pada code awal di song.java saya melakukan refactoring pada beberapa poin yaitu: <br>
1. Long Parameter List: Pada constructor song yang sebelum di refactor, code tersebut mempunyai banyak parameter yang mana bisa dikemas dengan lebih simple dan efisien dalam objek Album dan Artist yang mana agar penggunaan parameter tidak berlebihan<br>
2. Primitive Obsession: Pada code sebelum refactor, Genre hanya menggunakan int untuk menentukan genre, sehingga dibuat class baru yaitu Genre untuk mendefinisikan konstanta dan menentukan nama Genre<br>
3. Feature Envy: Pada pengecekan album dan artis harus dilakukan dalam class tersebut, maka dari itu dibuatlah class Album dan Artist