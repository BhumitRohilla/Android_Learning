package com.hfad.guessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.hfad.guessinggame.databinding.FragmentGameBinding
import androidx.navigation.findNavController
import androidx.lifecycle.ViewModelProvider

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        viewModel.livesLeft.observe(viewLifecycleOwner, Observer {value->
            binding.lives.text="You have $value lives left"})

        viewModel.incorrectGuesses.observe(viewLifecycleOwner,Observer{value->
            binding.incorrectGuesses.text="Incorrect guesses: $value"
        })

        viewModel.secretWordDisplay.observe(viewLifecycleOwner,Observer{view->
            binding.word.text= view })

        viewModel.gameOver.observe(viewLifecycleOwner,Observer{value->
            if(value){
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(viewModel.wonLostMessage())
                binding.root.findNavController().navigate(action)
            }
        })
        binding.guessButton.setOnClickListener() {
            viewModel.makeGuess(binding.guess.text.toString().uppercase())
            binding.guess.text = null
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}