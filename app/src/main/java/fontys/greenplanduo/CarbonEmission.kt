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
    private var carbonEmission:Float=0f
    private var waterEmission:Int=0
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
            carbonEmission=args.carbonEmission
            waterEmission=args.waterEmission

            var carbonEmissionShortened=String.format("%.3f", carbonEmission)
            textView3.text=carbonEmissionShortened
            var carEquivalent=carbonEmission.times( 0.196974607)
            tvKmOfCar.text=String.format("%.3f", carEquivalent)

            btNextToWater.setOnClickListener {
                val direction=CarbonEmissionDirections.actionCarbonEmissionToWaterEmission(waterEmission)
                findNavController().navigate(direction)
            }
        }
    }
}