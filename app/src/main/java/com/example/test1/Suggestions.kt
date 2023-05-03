package com.example.test1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Suggestions.newInstance] factory method to
 * create an instance of this fragment.
 */
class Suggestions : Fragment() {
    // TODO: Rename and change types of parameters

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var peopleList: ArrayList<People>
    private lateinit var peopleAdapter: PeopleAdapter

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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_suggestions, container, false)


        // Get a reference to the profileImage ImageView
        val profileImage = view.findViewById<ImageView>(R.id.profileImage)

        // Add a click listener to the profileImage ImageView
        profileImage.setOnClickListener {
            // Create an intent to open the new ProfileActivity
            val intent = Intent(requireContext(), ProfileActivity::class.java)

            // Start the new activity using the created intent
            startActivity(intent)
        }

        return view
       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        peopleList = ArrayList()
        peopleList.add(People(R.drawable.antonio , name = "Antonio", username = "@antoniotest"))
        peopleList.add(People(R.drawable.hope , name = "Hope", username = "@hopetest"))
        peopleList.add(People(R.drawable.lina , name = "Lina", username = "@linatest"))
        peopleList.add(People(R.drawable.victor , name = "Victor", username = "@victortest"))
        peopleList.add(People(R.drawable.mani , name = "Mani", username = "@manitest"))
        peopleList.add(People(R.drawable.bread , name = "Bread", username = "@breadtest"))
        peopleList.add(People(R.drawable.maria , name = "Maria", username = "@mariatest"))


        peopleAdapter = PeopleAdapter(peopleList)
        recyclerView.adapter = peopleAdapter


    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Suggestions.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Suggestions().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}