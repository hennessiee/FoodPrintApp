package fontys.greenplanduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fontys.greenplanduo.databinding.FragmentWaterEmissionBinding
import java.math.BigDecimal


class WaterEmission : Fragment() {
private val args: WaterEmissionArgs by navArgs()
    private var waterEmission:Int=0
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
            waterEmission=args.waterEmission
            tvWaterEmission.text=waterEmission.toString()+"Litres of water"

            var showerNumber=(waterEmission/9).toFloat()
            var showerStripZeros=String.format("%.3f", showerNumber).replace("\\.?0*$".toRegex(), "")

            var showerEquivalent=showerStripZeros+" minutes of showering"

            tvShowerEquivalent.text=showerEquivalent

            btNextToFacts.setOnClickListener {
                findNavController().navigate(R.id.action_waterEmission_to_facts)
            }
        }
    }
}