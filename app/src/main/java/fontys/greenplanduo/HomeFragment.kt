package fontys.greenplanduo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter

import androidx.navigation.fragment.findNavController
import fontys.greenplanduo.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var thisContext:Context
    private var protein:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentHomeBinding.inflate(inflater,container,false)
        if (container != null) {
            thisContext = container.context
        }
        return binding.root
    }
    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        protein= parent.getItemAtPosition(pos).toString()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            spProtein.onItemSelectedListener=this.spProtein.onItemSelectedListener
            getAllFoodData()

            btCalculate.setOnClickListener{
                val direction=HomeFragmentDirections.actionHomeFragmentToCarbonEmission(protein)
                findNavController().navigate(direction)
            }
        }
    }



    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO
    }
    private fun getAllFoodData(){
        getProteinData()
        getCarbsData()
        getDairyData()
        getVeggiesData()
        getFruitsData()
    }
    private fun getProteinData(){
        binding.apply{
            ArrayAdapter.createFromResource(
                thisContext,
                R.array.protein,
                android.R.layout.simple_dropdown_item_1line
            ).also{adapter->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                spProtein.adapter=adapter
            }
        }
    }
    private fun getCarbsData(){
        binding.apply {
            ArrayAdapter.createFromResource(
                thisContext,
                R.array.Carbohydrate,
                android.R.layout.simple_dropdown_item_1line
            ).also{adapter->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                spCarbs.adapter=adapter
            }
        }
    }
    private fun getFruitsData(){
        binding.apply {
            ArrayAdapter.createFromResource(
                thisContext,
                R.array.Fruits,
                android.R.layout.simple_dropdown_item_1line
            ).also{adapter->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                spFruits.adapter=adapter
            }
        }
    }
    private fun getVeggiesData(){
        binding.apply {
            ArrayAdapter.createFromResource(
                thisContext,
                R.array.Vegetable,
                android.R.layout.simple_dropdown_item_1line
            ).also{adapter->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                spVeggies.adapter=adapter
            }
        }
    }
    private fun getDairyData(){
        binding.apply {
            ArrayAdapter.createFromResource(
                thisContext,
                R.array.Milk_Dairy,
                android.R.layout.simple_dropdown_item_1line
            ).also{adapter->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                spDairy.adapter=adapter
            }
        }
    }


}