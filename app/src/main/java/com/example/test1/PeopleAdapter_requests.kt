package com.example.test1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter_requests (private val peopleList:ArrayList<People_requests>) : RecyclerView.Adapter<PeopleAdapter_requests.PeopleViewHolder>(){

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)
        val textViewUsername : TextView = itemView.findViewById(R.id.textViewUsername)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_person_requests, parent, false)
        return PeopleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = peopleList[position]
        holder.imageView.setImageResource(people.image)
        holder.textView.text = people.name
        holder.textViewUsername.text = people.username
    }

}