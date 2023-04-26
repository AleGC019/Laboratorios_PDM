package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var actionNavtoCreateMovie: FloatingActionButton
    private lateinit var actionNavtoShowMovieInfo: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        actionNavtoCreateMovie.setOnClickListener(){
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)

        }

        actionNavtoShowMovieInfo.setOnClickListener(){
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

    }

    private fun bind(view: View){
        actionNavtoCreateMovie = view.findViewById(R.id.floatingActionButton)
        actionNavtoShowMovieInfo = view.findViewById(R.id.cardMovie)

    }


}