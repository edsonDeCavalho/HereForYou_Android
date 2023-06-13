package com.equality.herforyou

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.equality.herforyou.R
import com.equality.herforyou.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController

//    private lateinit var contactView: RecyclerView
//    private lateinit var searchBar: SearchView
//
//    private var mList = ArrayList<ContactData>()
//    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Initialisation de la vue
         */
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

//        contactView = findViewById(R.id.contactList)
//        searchBar = findViewById(R.id.searchBar)
//
//        contactView.setHasFixedSize(true)
//        contactView.layoutManager = LinearLayoutManager(this)
//
//        addDataToList()
//        adapter = ContactAdapter(mList)
//        contactView.adapter = adapter

        setContentView(view)

        setSupportActionBar(binding.toolbar)

        /**
         * L'orientation est bloquée:
         * tablette : horizontale
         * smartphone : portrait
         */
        requestedOrientation = if (resources.getBoolean(R.bool.isTablet)) ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE else ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        /**
         * Initialisation de la toolbar
         */
        binding.toolbar.setTitle(R.string.app_name)

        binding.bottomNavigationBar.background = null
       // binding.bottomNavigationBar.menu.getItem(2).isEnabled = false

        /**
         * Initialisation de NavController
         */
        navController = findNavController(R.id.fragmentContainerView)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.accueilFragment,
                R.id.safePlacesFragment,
                R.id.SOSFragment,
                R.id.contactsFragment,
                R.id.compteFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationBar.setupWithNavController(navController)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        binding.floattingPhone.setOnClickListener {
            navController.navigate(R.id.SOSFragment)
        }

        /**
         * Defenition icone de la toolbar
         */
        //binding.toolbar.setNavigationIcon(R.drawable.gear)

//        binding.bottomNavigationBar.setOnItemSelectedListener{
//            when(it.itemId){
//                R.id.action_scanner ->{
//                    setFaBarsIconsAndFrag("scanner")
//                    true
//                }
//                R.id.action_historique ->{
//                    setFaBarsIconsAndFrag("historique")
//                    true
//                }
//                R.id.action_settings ->{
//                    setFaBarsIconsAndFrag("settings")
//                    true
//                }
//                else -> false
//            }
//        }

    }
//    private fun addDataToList() {
//        mList.add(ContactData(3919, "Violences Femmes Info", "Écoute, information et Orientation" ))
//        mList.add(ContactData(17, "Police et Gendarmerie", "France" ))
//        mList.add(ContactData(112, "Police et Gendarmerie", "Union européenne" ))
//        mList.add(ContactData(114, "Remplacement du 15, 17 et 18", "Pour les personnes sourdes, malentendantes, aphasiques et dysphasiques" ))
//        mList.add(ContactData(15, "Urgences Médicales (Samu)", "France" ))
//        mList.add(ContactData(18, "Pompiers", "France" ))
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_navigation_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}