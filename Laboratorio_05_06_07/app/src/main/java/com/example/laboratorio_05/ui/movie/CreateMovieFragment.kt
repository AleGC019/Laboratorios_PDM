package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.example.laboratorio_05.databinding.FragmentCreateMovieBinding


class CreateMovieFragment : Fragment() {


    private lateinit var binding: FragmentCreateMovieBinding

    private val viewModel: MovieViewModel by activityViewModels(){
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_create_movie, container, false)

        binding = FragmentCreateMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver(){
        viewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("TAG APP", viewModel.getMovies().toString())
                    Log.d("TAG APP", status)

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }

                status.equals(MovieViewModel.MOVIE_DELETED) -> {
                    Log.d("TAG APP", status)
                    viewModel.clearStatus()
                }

            }

        }

    }






}