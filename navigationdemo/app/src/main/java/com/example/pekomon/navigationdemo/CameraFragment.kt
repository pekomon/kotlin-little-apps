package com.example.pekomon.navigationdemo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_camera.*
import java.util.*


class CameraFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_photos.setOnClickListener {
            val random = Random()

            // Safe args plugin generates CameraFragmentDirections
            val nextAction = CameraFragmentDirections.nextAction(random.nextInt(100))

            // it would also be possible to navigate to R.id.blaa but actions can handle args
            Navigation.findNavController(it).navigate(nextAction)
        }
    }
}
