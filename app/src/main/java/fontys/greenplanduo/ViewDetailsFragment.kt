package fontys.greenplanduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fontys.greenplanduo.databinding.FragmentViewDetailsBinding
import androidx.navigation.fragment.navArgs


class ViewDetailsFragment : Fragment() {
    private val args:ViewDetailsFragmentArgs by navArgs()
    private var item=""
private lateinit var binding: FragmentViewDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentViewDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            item=args.item
            tvDetails.text= item
        }
    }

}