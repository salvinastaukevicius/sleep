package com.example.test1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter_friends(private val peopleList: ArrayList<People_friends>) :
    RecyclerView.Adapter<PeopleAdapter_friends.PeopleViewHolder>() {

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textViewStartingTime: TextView = itemView.findViewById(R.id.textViewStartingTime)
        val textViewSchedule: TextView = itemView.findViewById(R.id.textViewSchedule)
        val textViewSchedule2: TextView = itemView.findViewById(R.id.textViewSchedule2)
        val textViewSchedule3: TextView = itemView.findViewById(R.id.textViewSchedule3)
        val textViewSchedule4: TextView = itemView.findViewById(R.id.textViewSchedule4)
        val textViewLocation: TextView = itemView.findViewById(R.id.textViewLocation)
        val buttonJoin: Button = itemView.findViewById(R.id.joinButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.each_person_friends, parent, false)
        return PeopleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = peopleList[position]
        holder.imageView.setImageResource(people.image)
        holder.textView.text = people.name
        holder.textViewStartingTime.text = people.startingtime
        holder.textViewSchedule.text = people.schedule
        holder.textViewSchedule2.text = people.schedule2
        holder.textViewSchedule3.text = people.schedule3
        holder.textViewSchedule4.text = people.schedule4
        holder.textViewLocation.text = people.location

        holder.buttonJoin.setOnClickListener {
            val fragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, ButtonFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}