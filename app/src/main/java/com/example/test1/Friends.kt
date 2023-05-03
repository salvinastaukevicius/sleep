package com.example.test1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Friends.newInstance] factory method to
 * create an instance of this fragment.
 */
class Friends : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var recyclerView: RecyclerView
    private lateinit var peopleList: ArrayList<People_friends>
    private lateinit var peopleAdapter: PeopleAdapter_friends

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friends, container, false);
        // Inflate the layout for this fragment
        return view;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewFriends)
        recyclerView.layoutManager = LinearLayoutManager(context)

        peopleList = ArrayList()
        peopleList.add(People_friends(R.drawable.lola , name = "Lola", startingtime = "Starting at 4:50PM", schedule = "Lower body", schedule2 = "Core", schedule3 = "Upper body", schedule4 = "Cardio", location = "Studentensportcentrum Eindhoven"))
        peopleList.add(People_friends(R.drawable.erik , name = "Erik", startingtime = "Starting at 5:30PM", schedule = "Cardio", schedule2 = "Upper body", schedule3 = "Lower body", schedule4 = "Core", location = "TrainMore Eindhoven"))
        peopleList.add(People_friends(R.drawable.mike , name = "Mike", startingtime = "Starting at 9:30PM", schedule = "Upper body", schedule2 = "Core", schedule3 = "Lower body", schedule4 = "Cardio", location = "BasicFit Eindhoven"))

        peopleAdapter = PeopleAdapter_friends(peopleList)
        recyclerView.adapter = peopleAdapter


/*

        val buttonJoin = view.findViewById<Button>(R.id.joinButton) as Button
        buttonJoin.setOnClickListener {
            val intent = Intent(context, ButtonJoin::class.java)
            startActivity(intent)
        }*/

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Friends.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Friends().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

//    override fun onItemClick(position: Int) {
//        val fragment = ButtonFragment()
//        val transaction = requireActivity().supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.frame_layout, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

}