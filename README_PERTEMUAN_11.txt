PROJECT CARDO_MOON - PENYESUAIAN MODUL PERTEMUAN 11

Penyesuaian yang ditambahkan:
1. TabLayout + ViewPager2 pada TenthActivity.
2. TabAFragment, TabBFragment, TabCFragment, dan TenthTabsAdapter.
3. Ikon dan badge pada tab A dan tab B.
4. RecyclerView pada Tab C dengan GridLayoutManager dan 50 data produk.
5. ProductModel, ProductAdapter, dan item_product.xml.
6. Tombol Pertemuan 10 pada HomeFragment.
7. Onboard/Tutorial Message berisi 3 fragment, ViewPager2, DotsIndicator,
   serta menu info pada toolbar MessageFragment.

Fitur dan halaman project sebelumnya dipertahankan.

CARA MENJALANKAN:
1. Ekstrak ZIP.
2. Buka folder cardo_moon melalui Android Studio.
3. Tunggu proses Gradle Sync selesai. Pastikan koneksi internet aktif agar
   Android Studio dapat mengunduh dependency ViewPager2, RecyclerView,
   dan DotsIndicator.
4. Pilih emulator/perangkat Android, lalu tekan Run.

CATATAN VALIDASI:
File XML sudah diperiksa dan seluruh referensi ID internal layout yang
ditemukan valid. Daftar activity pada AndroidManifest juga sudah diperiksa.
Build Gradle penuh tidak dapat dijalankan di lingkungan penyusunan ini karena
Gradle Wrapper perlu mengunduh Gradle 9.5.0 dari internet, sedangkan akses
jaringan tidak tersedia. Karena itu lakukan Gradle Sync dan Run pertama kali
di Android Studio dengan internet aktif.
