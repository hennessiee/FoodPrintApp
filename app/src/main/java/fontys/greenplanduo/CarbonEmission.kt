package fontys.greenplanduo

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fontys.greenplanduo.databinding.FragmentCarbonEmissionBinding
import nl.dionsegijn.konfetti.core.Angle
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.Rotation
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit


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
            if(carbonEmission<0.5){
                val mediaPlayer=MediaPlayer.create(requireContext(),R.raw.cheer)
                mediaPlayer.setVolume(0.5f,0.5f)
                mediaPlayer.start()
                konfettiView.start(Party(
                    speed = 15f,
                    maxSpeed = 20f,
                    damping = 0.9f,
                    angle = Angle.BOTTOM,
                    spread = 180,
                    timeToLive = 9000L,
                    rotation = Rotation(),
                    colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(75),
                    position = Position.Relative(0.5, 0.0)
                ))
                tvTitleCarbon.text="Well Done!, You only Emitted:"
            }
            else if (carbonEmission>2){
                val mediaPlayer=MediaPlayer.create(requireContext(),R.raw.car)
                mediaPlayer.setVolume(0.75f,0.75f)
                mediaPlayer.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    mediaPlayer.stop()
                    mediaPlayer.release()
                }, 6000L)
                konfettiView.start(Party(
                    speed = 30f,
                    maxSpeed = 50f,
                    damping = 0.9f,
                    angle = Angle.BOTTOM,
                    spread = 180,
                    timeToLive = 9000L,
                    rotation = Rotation(),
                    colors = listOf(0, 0xFFFF00),
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                    position = Position.Relative(0.5, 0.0)
                ))
                tvTitleCarbon.text="Come on, You can be better! You Emitted:"

            }
            else{
                tvTitleCarbon.text="You were okay! You Emitted:"

            }



            var carbonEmissionShortened=String.format("%.3f", carbonEmission)
            textView3.text=carbonEmissionShortened
            var carEquivalent=carbonEmission/0.2
            tvKmOfCar.text=String.format("%.3f", carEquivalent)+" km"


            btNextToWater.setOnClickListener {
                val direction=CarbonEmissionDirections.actionCarbonEmissionToWaterEmission(waterEmission)
                findNavController().navigate(direction)
            }
        }
    }
}