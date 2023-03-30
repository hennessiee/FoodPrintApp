package fontys.greenplanduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fontys.greenplanduo.databinding.FragmentAddPlanBinding


class AddPlanFragment : Fragment() {

    private var _binding: FragmentAddPlanBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentAddPlanBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView    = binding.recyclerView
        chooseLayout()
    }
    private fun chooseLayout(){
        recyclerView.layoutManager=LinearLayoutManager(context)

        recyclerView.adapter=ItemAdapter(requireContext())
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}