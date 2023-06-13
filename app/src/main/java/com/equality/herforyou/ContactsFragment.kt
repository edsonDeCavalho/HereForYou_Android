package com.equality.herforyou

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

    private lateinit var recyclerViewGenaral: RecyclerView
    private lateinit var recyClerViewUrgence: RecyclerView


    //private lateinit var searchBar: SearchView

    private var listeDeContactsDeUrgence = ArrayList<ContactData>()
    private var listeDeContactsGeneral = ArrayList<ContactData>()
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
        listeDeContactsDeUrgence.add(ContactData(3919, "Violences Femmes Info", "Écoute, information et Orientation" ))
        listeDeContactsDeUrgence.add(ContactData(17, "Police et Gendarmerie", "France" ))
        listeDeContactsDeUrgence.add(ContactData(112, "Police et Gendarmerie", "Union européenne" ))
        listeDeContactsDeUrgence.add(ContactData(114, "Remplacement du 15, 17 et 18", "Pour les personnes sourdes, malentendantes, aphasiques et dysphasiques" ))
        listeDeContactsDeUrgence.add(ContactData(15, "Urgences Médicales (Samu)", "France" ))
        listeDeContactsDeUrgence.add(ContactData(18, "Pompiers", "France" ))
        listeDeContactsGeneral=listeDeContactsDeUrgence
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        //contactView.layoutManager = LinearLayoutManager(activity)
        /**
         * Contacts Genaral
         */
        addDataToList()
        recyclerViewGenaral = view.findViewById(R.id.recyclerView_numero_general)

        linearLayoutContanct_General = LinearLayoutManager(activity)
        recyclerViewGenaral.layoutManager=linearLayoutContanct_General

        adapterConrtact_General= ContactAdapter(listeDeContactsGeneral)

        recyclerViewGenaral.adapter=adapterConrtact_General

        /**
         * Contacts Urgence
         */


        recyClerViewUrgence = view.findViewById(R.id.resyclerView_numero_urgence)

        linearLayoutContanct_Urgence = LinearLayoutManager(activity)
        recyClerViewUrgence.layoutManager=linearLayoutContanct_Urgence
        adapteurCOntanct_Urgence = ContactAdapter(listeDeContactsDeUrgence)

        recyClerViewUrgence.adapter=adapteurCOntanct_Urgence


        // Inflate the layout for this fragment
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactsFragment()
    }
}