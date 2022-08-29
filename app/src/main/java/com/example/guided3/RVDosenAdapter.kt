package com.example.guided3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guided3.entity.Dosen

class RVDosenAdapter(private val data: Array<Dosen>) : RecyclerView.Adapter<RVDosenAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        //  Disini kita menghubungkan layout item recycler view kita
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_dosen, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        //  Karena kita sudah mendefinisikan dan menghubungkan view kita,
        //  kita bisa memakai view tersebut dan Melakukan set text pada view tersebut
        val currentItem = data[position]
        holder.tvNamaDosen.text = currentItem.name
        holder.tvDetailsDosen.text = currentItem.pengajar
    }

    override fun getItemCount(): Int {
        //  Disini kita memberitahu jumlah dari item pada recycler view kita.
        return data.size
    }

    // Kelas ini berguna untuk menghubungkan view view yang ada pada item di recycler view kita.
    class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaDosen : TextView = itemView.findViewById(R.id.tv_nama_dosen)
        val tvDetailsDosen : TextView = itemView.findViewById(R.id.tv_details_dosen)
    }
}