package com.wl.aacdemo.ui

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.wl.aacdemo.viewmodel.GithubViewModelFactory
import com.wl.aacdemo.databinding.RepoFragmentBinding


/**
 * Created by KY5680 on 27,08,2020
 */
class RepoFragment : Fragment() {

    companion object {
        const val TAG = "Repo"
        fun newInstance(): RepoFragment? {
            return RepoFragment()
        }
    }

    private lateinit var binding: RepoFragmentBinding

    private var factory: GithubViewModelFactory = GithubViewModelFactory()

    private lateinit var viewModel: RepoViewModel

    private var repoAdapter: RepoAdapter = RepoAdapter(ArrayList())


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = RepoFragmentBinding.inflate(inflater, container, false)

        binding.btnSearch.setOnClickListener { doSearch() }

        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )

        binding.recyclerView.adapter = repoAdapter

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory).get(RepoViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.repos.observe(this,
            { repos -> repoAdapter.swapItems(repos) })
    }

    private fun doSearch() {
        val query = binding.edtQuery.text.toString()
        if (TextUtils.isEmpty(query)) {
            repoAdapter.clearItems()
            return
        }
        viewModel.searchRepo(query)
        dismissKeyboard()
    }

    private fun dismissKeyboard() {
        val view = activity!!.currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}