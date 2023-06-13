package com.equality.herforyou

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var contactView: RecyclerView
    private lateinit var searchBar: SearchView

    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //contactView.setHasFixedSize(true)
        //contactView.layoutManager = LinearLayoutManager(this)

        addDataToList()
        adapter = ContactAdapter(mList)
        contactView.adapter = adapter

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun addDataToList() {
        mList.add(ContactData(3919, "Violences Femmes Info", "Écoute, information et Orientation" ))
        mList.add(ContactData(17, "Police et Gendarmerie", "France" ))
        mList.add(ContactData(112, "Police et Gendarmerie", "Union européenne" ))
        mList.add(ContactData(114, "Remplacement du 15, 17 et 18", "Pour les personnes sourdes, malentendantes, aphasiques et dysphasiques" ))
        mList.add(ContactData(15, "Urgences Médicales (Samu)", "France" ))
        mList.add(ContactData(18, "Pompiers", "France" ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        val myView = inflater.inflate(R.layout.fragment_contacts, container, false)
        //contactView.layoutManager = LinearLayoutManager(activity)

        contactView.layoutManager = LinearLayoutManager(context)
        contactView = myView.findViewById(R.id.contactList)
        searchBar = myView.findViewById(R.id.searchBar)

        // Inflate the layout for this fragment
        return myView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContactsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}