package com.example.test1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Requests.newInstance] factory method to
 * create an instance of this fragment.
 */
class Requests : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var peopleList: ArrayList<People_requests>
    private lateinit var peopleAdapter: PeopleAdapter_requests

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
        val view = inflater.inflate(R.layout.fragment_requests, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewRequests)
        recyclerView.layoutManager = LinearLayoutManager(context)

        peopleList = ArrayList()
        peopleList.add(People_requests(R.drawable.peni , name = "Peni", username = "@penitest"))
        peopleList.add(People_requests(R.drawable.evan , name = "Evan", username = "@evantest"))
        peopleList.add(People_requests(R.drawable.tina , name = "Tina", username = "@tinatest"))
        peopleList.add(People_requests(R.drawable.viktoria , name = "Victoria", username = "@victoriatest"))
        peopleList.add(People_requests(R.drawable.moni , name = "Moni", username = "@monitest"))


        peopleAdapter = PeopleAdapter_requests(peopleList)
        recyclerView.adapter = peopleAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Requests.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Requests().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}