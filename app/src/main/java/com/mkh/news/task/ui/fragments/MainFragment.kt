package com.mkh.news.task.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkh.news.task.R
import com.mkh.news.task.adapter.RecyclerAdapter
import com.mkh.news.task.models.Item
import com.mkh.news.task.viewmodel.GitRepoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: GitRepoViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.searchBtn.setOnClickListener {
            val q = view.searchEditText.text.toString()

            if (!q.equals("")) {
                viewModel.getWord(q)

            } else {
                viewModel.getWord("tetris")

            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.gitResp.observe(requireActivity(), { response ->

            run {
                val list: List<Item> = response.items
                val adapter = RecyclerAdapter(requireContext(), list)
                progressBar.visibility = View.GONE
                recycler_view.layoutManager =
                    LinearLayoutManager(requireContext())
                recycler_view.adapter = adapter

            }

        })

    }

}