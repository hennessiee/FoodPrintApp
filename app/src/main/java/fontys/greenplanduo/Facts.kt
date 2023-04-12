package fontys.greenplanduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import fontys.greenplanduo.databinding.FragmentFactsBinding
import kotlin.random.Random


class Facts : Fragment() {

    private lateinit var binding:FragmentFactsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFactsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply{
            val factsArray = resources.getStringArray(R.array.facts)
            val selectedFacts = arrayOfNulls<String>(3)
            for (i in 0..2) {
                var randomNumber= Random.nextInt(0,23)
                selectedFacts[i]=factsArray[randomNumber]
            }
            tvFact1.text=selectedFacts[0]
            tvFact2.text=selectedFacts[1]
            tvFact3.text=selectedFacts[2]


            btBackToHome.setOnClickListener {
                findNavController().navigate(R.id.action_facts_to_homeFragment)
            }
        }
    }


}