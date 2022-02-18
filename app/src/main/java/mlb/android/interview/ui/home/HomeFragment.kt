package mlb.android.interview.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mlb.android.interview.databinding.FragmentHomeBinding

const val ORIENTATION_KEY = "Orientation"

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //Keep track of the last known orientation.
       
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //The view model should not be recreated every time the onCreate method is called. Check
        //if it has been initialized or do it outside of the life cycle of the fragment.


        //If there's something stored in the bundle, check if the orientation is different, if it is
        //Increase the rotation counter.
        savedInstanceState?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Initialize the random logic that will keep updating the random string value every 5 seconds
        //Be careful to not re-launch the coroutine as it will not honor the 5 second timer.


        homeViewModel.mlbLiveData.observe(viewLifecycleOwner) {
            when (resources.configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    //If we are in landscape mode, use 2 separate text views.

                }
                Configuration.ORIENTATION_PORTRAIT -> {
                    //If we are in portrait mode, use the single text view.

                }
                else -> Unit
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
