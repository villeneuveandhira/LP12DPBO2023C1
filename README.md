NIM : 2108067
Nama : Villeneuve Andhira Suwandhi
Program Studi : Ilmu Komputer C1 2021

# LP12DPBO2023C1

# Format Janji
Saya Villeneuve Andhira Suwandhi NIM 2108067 mengerjakan Latihan Praktikum 12
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan.
Aamiin.

# MVVM
Alasan, karena ;
1. Pisah logika game (model), antarmuka tampilan (view), logika tampilan (viewmodel),
2. Belajar MVVM untuk mengerjakan TMD DPBO,
3. Memudahan pengubahan. Pakai MVVM jika ingin mengubah logika permainan bisa terpisah dari tampilan, jika terjadi perubahan atau pembaruan pada logika permainan, bisa langsung dengan mudah memodifikasi Model tanpa mengganggu tampilan gamenya.

# UPDATED (perbedaan LP12 dengan TMD DPBO)
Game.java di LP12 berada di file directory 'view' sedangkan TMD ada di 'viewmodel'. Seharusnya yang benar adalah di 'viewmodel' karena logic-logic bisnis seharusnya berada di file 'viewmodel' bukan di 'view'. 'View' seharusnya hanya menjadi tampilan UI saja tidak ada logic, dan 'viewmodel' adalah logic logic untuk menjalankan fungsi terutam gamenya. Untuk sisanya, seperti GameObject, Player di 'model', dan Display dengan Menu-nya sudah berada di 'view' sudah benar. Menurut saya, file yang sudah tersusun benar MVVM-nya adalah yang TMD karena 'model' yang mewakili komponenen memberi akses data, view sebagai representasi visual tampilan UI, dan 'viewmodel' sebagai perantara dari 'model' dan 'view' menyediakan logic logic metode dan properti yang diperlukan view untuk menampilkan data dengan mengelola logika yang mengambil data dari 'model'. Mohon maaf jika salah, mohon kritik dan sarannya. Terima kasih.
