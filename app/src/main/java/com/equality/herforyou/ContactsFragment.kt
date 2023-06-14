package com.equality.herforyou

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equality.herforyou.core.db.entity.ContactData
import com.equality.herforyou.ui.adapter.ContactAdapter


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

    private lateinit var recyclerViewGeneral
    : RecyclerView
    private lateinit var recyclerViewUrgence: RecyclerView


    //private lateinit var searchBar: SearchView

    private var listeDeContactsGeneral = ArrayList<ContactData>()
    private var listeDeContactsDeUrgence = ArrayList<ContactData>()
    private lateinit var adapteurCOntanct_Urgence: ContactAdapter
    private lateinit var adapterConrtact_General: ContactAdapter

    private lateinit var linearLayoutContanct_General :LinearLayoutManager
    private lateinit var linearLayoutContanct_Urgence :LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //contactView.setHasFixedSize(true)
        //contactView.layoutManager = LinearLayoutManager(this)
    }

    private fun addDataToList() {
        listeDeContactsGeneral.add(ContactData("3919", "Violences Femmes Info", "Écoute, information et Orientation" ))
        listeDeContactsGeneral.add(ContactData("17", "Police et Gendarmerie", "France" ))
        listeDeContactsGeneral.add(ContactData("112", "Police et Gendarmerie", "Union européenne" ))
        listeDeContactsGeneral.add(ContactData("114", "Remplacement du 15, 17 et 18", "Pour les personnes sourdes, malentendantes, aphasiques et dysphasiques" ))
        listeDeContactsGeneral.add(ContactData("15", "Urgences Médicales (Samu)", "France" ))
        listeDeContactsGeneral.add(ContactData("18", "Pompiers", "France" ))

        listeDeContactsDeUrgence.add(ContactData("JS", "Julie Smith", "Mère" ))
        listeDeContactsDeUrgence.add(ContactData("JS", "Julie Smith", "Mère" ))
        listeDeContactsDeUrgence.add(ContactData("JS", "Julie Smith", "Mère" ))

        listeDeContactsDeUrgence.add(ContactData("LR", "Lana Renault", "Sœur" ))
        listeDeContactsDeUrgence.add(ContactData("ED", "Elliot Dunant", "Collègue" ))

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        /**
         * Contacts Genaral
         */
        addDataToList()
        recyclerViewGeneral = view.findViewById(R.id.recyclerViewNumGeneral)

        linearLayoutContanct_General = LinearLayoutManager(activity)
        recyclerViewGeneral.layoutManager=linearLayoutContanct_General

        adapterConrtact_General= ContactAdapter(listeDeContactsGeneral)

        recyclerViewGeneral.adapter=adapterConrtact_General

        /**
         * Contacts Urgence
         */

        recyclerViewUrgence = view.findViewById(R.id.recyclerViewNumUrgence)

        linearLayoutContanct_Urgence = LinearLayoutManager(activity)
        recyclerViewUrgence.layoutManager=linearLayoutContanct_Urgence
        adapteurCOntanct_Urgence = ContactAdapter(listeDeContactsDeUrgence)

        recyclerViewUrgence.adapter=adapteurCOntanct_Urgence


        // Inflate the layout for this fragment
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactsFragment()
    }
}