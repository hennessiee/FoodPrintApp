package fontys.greenplanduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fontys.greenplanduo.databinding.FragmentCarbonEmissionBinding


class CarbonEmission : Fragment() {
    private val args:CarbonEmissionArgs by navArgs()
    private var protein=""
    private lateinit var binding:FragmentCarbonEmissionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCarbonEmissionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            protein=args.protein
            textView3.text=protein
            btNextToWater.setOnClickListener {
                findNavController().navigate(R.id.action_carbonEmission_to_waterEmission)
            }
        }
    }
}