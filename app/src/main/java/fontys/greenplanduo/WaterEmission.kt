package fontys.greenplanduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import fontys.greenplanduo.databinding.FragmentWaterEmissionBinding


class WaterEmission : Fragment() {

private lateinit var binding: FragmentWaterEmissionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentWaterEmissionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btNextToFacts.setOnClickListener {
                findNavController().navigate(R.id.action_waterEmission_to_facts)
            }
        }
    }


}