package fontys.greenplanduo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.NumberPicker

import androidx.navigation.fragment.findNavController
import fontys.greenplanduo.databinding.FragmentHomeBinding



class HomeFragment :Fragment() ,AdapterView.OnItemSelectedListener   {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var thisContext:Context
    private var protein:Int=0
    private var carbs:Int=0
    private var fruit:Int=0
    private var veggies:Int=0
    private var dairy:Int=0

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{

            getAllFoodData()
            spProtein.onItemSelectedListener=this@HomeFragment
            spCarbs.onItemSelectedListener=this@HomeFragment
            spVeggies.onItemSelectedListener=this@HomeFragment
            spDairy.onItemSelectedListener=this@HomeFragment
            spFruits.onItemSelectedListener=this@HomeFragment

            spProtein.prompt=""
            btCalculate.setOnClickListener{

                val co2Emissions:Float=calculateCo2Emissions().toFloat()
                val waterEmissions:Int=calculateWaterEmissions()

                val direction=HomeFragmentDirections.actionHomeFragmentToCarbonEmission(co2Emissions,waterEmissions)
                findNavController().navigate(direction)
            }
        }
    }
    private fun calculateWaterEmissions():Int{
        val proteinEmissions = getProteinWater()
        val carbsEmissions = getCarbsWater()
        val vegEmissions = getVegWater()
        val fruitEmissions = getFruitWater()
        val dairyEmissions = getDairyWater()

        return proteinEmissions+carbsEmissions+vegEmissions+fruitEmissions+dairyEmissions
    }
    private fun getProteinWater():Int{
        val emissionsArray = resources.getStringArray(R.array.p_water)
        val emissions = emissionsArray[protein]
        binding.apply{
            return (emissions.toInt()*etProtein.text.toString().toInt())/1000
        }
    }
    private fun getCarbsWater():Int{
        val emissionsArray = resources.getStringArray(R.array.c_water)
        val emissions = emissionsArray[carbs]
        binding.apply{
            return (emissions.toInt()*etCarbs.text.toString().toInt())/1000
        }
    }
    private fun getVegWater():Int{
        val emissionsArray = resources.getStringArray(R.array.v_water)
        val emissions = emissionsArray[veggies]
        binding.apply{
            return (emissions.toInt()*etVeggies.text.toString().toInt())/1000
        }
    }
    private fun getFruitWater():Int{
        val emissionsArray = resources.getStringArray(R.array.f_water)
        val emissions = emissionsArray[fruit]
        binding.apply{
            return (emissions.toInt()*etFruits.text.toString().toInt())/1000
        }
    }
    private fun getDairyWater():Int{
        val emissionsArray = resources.getStringArray(R.array.d_water)
        val emissions = emissionsArray[dairy]
        binding.apply{
            return (emissions.toInt()*etDairy.text.toString().toInt())/1000
        }
    }

    private fun calculateCo2Emissions(): Double {
        val proteinEmissions = getProteinCo2()
        val carbsEmissions = getCarbsCo2()
        val vegEmissions = getVegCo2()
        val fruitEmissions = getFruitCo2()
        val dairyEmissions = getDairyCo2()

        return proteinEmissions+carbsEmissions+vegEmissions+fruitEmissions+dairyEmissions
    }
    private fun getProteinCo2(): Double {
        val emissionsArray = resources.getStringArray(R.array.p_co2)
        val emissions = emissionsArray[protein]
        binding.apply{
            return (emissions.toDouble()*etProtein.text.toString().toInt())/1000
        }
    }
    private fun getCarbsCo2(): Double {
        val emissionsArray = resources.getStringArray(R.array.c_co2)
        val emissions = emissionsArray[carbs]
        binding.apply{
            return (emissions.toDouble()*etCarbs.text.toString().toInt())/100
        }
    }
    private fun getVegCo2(): Double {
        val emissionsArray = resources.getStringArray(R.array.v_co2)
        val emissions = emissionsArray[veggies]
        binding.apply{
            return (emissions.toDouble()*etVeggies.text.toString().toInt())/100
        }
    }
    private fun getFruitCo2(): Double {
        val emissionsArray = resources.getStringArray(R.array.f_co2)
        val emissions = emissionsArray[fruit]
        binding.apply{
            return (emissions.toDouble()*etFruits.text.toString().toInt())/100
        }
    }
    private fun getDairyCo2(): Double {
        val emissionsArray = resources.getStringArray(R.array.d_co2)
        val emissions = emissionsArray[dairy]
        binding.apply{
            return (emissions.toDouble()*etDairy.text.toString().toInt())/1000
        }
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
                requireContext(),
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent?.id) {
            R.id.sp_Protein -> {
                binding.apply{
                    val imageIds= intArrayOf(
                        R.drawable.ic_protein,
                        R.drawable.ic_beef,
                        R.drawable.ic_chicken,
                        R.drawable.ic_cod,
                        R.drawable.ic_lamb,
                        R.drawable.ic_mackerel,
                        R.drawable.ic_pork,
                        R.drawable.ic_prawn,
                        R.drawable.ic_salmon,
                        R.drawable.ic_tuna)
                    protein= position
                    ivProtein.setImageResource(imageIds[position])


                }
            }
            R.id.sp_Carbs->{
                binding.apply{
                    val imageIds= intArrayOf(
                        R.drawable.ic_carbs,
                        R.drawable.ic_bagel,
                        R.drawable.ic_baguette,
                        R.drawable.ic_bread,
                        R.drawable.ic_croissant,
                        R.drawable.ic_donut,
                        R.drawable.ic_granola,
                        R.drawable.ic_muesli,
                        R.drawable.ic_naan,
                        R.drawable.ic_pancake,
                        R.drawable.ic_potatoes  ,
                        R.drawable.ic_pita,
                        R.drawable.ic_rice,
                        R.drawable.ic_sourdough,
                        R.drawable.ic_spagetti,
                        R.drawable.ic_corn,
                        R.drawable.ic_tofu,
                        R.drawable.ic_tortilla)

                    carbs= position
                    ivCarbs.setImageResource(imageIds[position])
                }
            }
            R.id.sp_Veggies->{
                binding.apply{
                    val imageIds= intArrayOf(
                        R.drawable.ic_veggies,
                        R.drawable.ic_broccoli,
                        R.drawable.ic_cucumber,
                        R.drawable.ic_courgette,
                        R.drawable.ic_corn,
                        R.drawable.ic_carrots,
                        R.drawable.ic_cauliflower,
                        R.drawable.ic_lettuce,
                        R.drawable.ic_salad,
                        R.drawable.ic_mushrooms,
                        R.drawable.ic_onions,
                        R.drawable.ic_tomatoes)
                    veggies= position
                    ivVeggies.setImageResource(imageIds[position])
                }
            }
            R.id.sp_Fruits->{
                binding.apply{
                    val imageIds= intArrayOf(
                        R.drawable.ic_fruits,
                        R.drawable.ic_apple,
                        R.drawable.ic_banana,
                        R.drawable.ic_grape,
                        R.drawable.ic_lemon,
                        R.drawable.ic_lime,
                        R.drawable.ic_melon,
                        R.drawable.ic_orange,
                        R.drawable.ic_strawberry,
                        R.drawable.ic_watermelon,)
                    fruit= position
                    ivFruits.setImageResource(imageIds[position])
                }
            }
            R.id.sp_Dairy->{
                binding.apply{
                    val imageIds= intArrayOf(
                        R.drawable.ic_dairy,
                        R.drawable.ic_coconut,
                        R.drawable.ic_milk,
                        R.drawable.ic_chocolate,
                        R.drawable.ic_cheese,
                        R.drawable.ic_chocommk,
                        R.drawable.ic_oatmilk,
                        R.drawable.ic_parmesan,
                        R.drawable.ic_soy,
                    )
                    dairy= position
                    ivDairy.setImageResource(imageIds[position])

                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}