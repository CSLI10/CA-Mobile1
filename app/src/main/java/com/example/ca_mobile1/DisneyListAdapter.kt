package com.example.ca_mobile1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ca_mobile1.data.Disney
import com.example.ca_mobile1.databinding.ListItemBinding
import android.content.Context

class DisneyListAdapter(val context: Context,
                        private val characterList: List<Disney>,
                        private val listener: ListItemListener) :

    RecyclerView.Adapter<DisneyListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        // binding to list_item.xml
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // list_item is a layout file, ctrl/cmd click will bring you to this file
        // you must create list_item.xml and design it as you want for one list item
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = characterList.size

    // each time data is passed to the RecyclerView's row you need to bind the data to that ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        with(holder.binding) {
            disneyName.text = character.name
            // load the image from the web(imageName)
            // into the plantImage object in the layout
            Glide.with(context)
                .load(character.imageUrl)
                .into(characterImage)
            characterImage.setOnClickListener{
                listener.onItemClick(character)
            }}}

    interface ListItemListener {
        fun onItemClick(character: Disney)
    }
}