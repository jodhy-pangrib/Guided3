package com.example.guided3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //  Fragment yang pertama kali terlihat adalah fragment mahasiswa
        changeFragment(FragmentMahasiswa())
    }

    //  Method untuk mengubah fragment
    fun changeFragment(fragment: Fragment?) {
        if (fragment != null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment, fragment)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Disini kita menghubungkan menu yang telah kita buat dengan activity ini
        val menuInflater = MenuInflater(this)
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_mahasiswa) {
            //  Jika menu yang dipilih adalah Mahasiswa maka ganti fragmentnya dengan FragmentMahasiswa
            changeFragment(FragmentMahasiswa())
        } else if (item.itemId == R.id.menu_dosen) {
            //  Jika menu yang dipilih adalah Dosen maka ganti fragmentnya dengan FragmentDosen
            changeFragment(FragmentDosen())
        } else {
            //  Jika menu yang dipilih adalah menu Exit, maka tampilkan sebuah dialog
            val builder: AlertDialog.Builder = AlertDialog.Builder(this@HomeActivity)
            builder.setMessage("Are you sure want to exit?")
                .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface, i: Int) {
                        //  Keluar dari aplikasi
                        finishAndRemoveTask()
                    }
                })
                .show()
        }
        return super.onOptionsItemSelected(item)
    }
}