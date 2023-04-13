package fontys.greenplanduo

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fontys.greenplanduo.databinding.FragmentWaterEmissionBinding
import nl.dionsegijn.konfetti.core.Angle
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.Rotation
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.math.BigDecimal
import java.util.concurrent.TimeUnit


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
            tvWaterEmission.text=waterEmission.toString()+" Litres of water"

            if(waterEmission>100){
                val mediaPlayer=MediaPlayer.create(requireContext(),R.raw.shower)
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
                tvTitleWater.text="You wasted plenty of Water! You used:"
                frameLayout2.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.blue))

            }
            else if(waterEmission<25){
                val mediaPlayer= MediaPlayer.create(requireContext(),R.raw.cheer)
                mediaPlayer.setVolume(0.5f,0.5f)
                mediaPlayer.start()
                konfettiView.start(
                    Party(
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
                )
                )
                tvTitleWater.text="You're water saver! You used:"
                frameLayout2.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.green))

            }
            else{
                tvTitleWater.text="You did Okay! You used:"
                frameLayout2.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.green))


            }
            var showerNumber=(waterEmission/9).toFloat()
            var showerStripZeros=String.format("%.3f", showerNumber).replace("\\.?,0*$".toRegex(), "")

            var showerEquivalent=showerStripZeros+"  minutes of showering"

            tvShowerEquivalent.text=showerEquivalent

            btNextToFacts.setOnClickListener {
                findNavController().navigate(R.id.action_waterEmission_to_facts)
            }
        }
    }
}