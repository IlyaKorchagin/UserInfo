package com.korchagin.userinfo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.korchagin.userinfo.R
import com.korchagin.userinfo.adapter.AdapterForRecyclerView
import com.korchagin.userinfo.adapter.UsersAdapter
import com.korchagin.userinfo.network.UserApi
import com.korchagin.userinfo.repository.UsersRepository
import com.korchagin.userinfo.viewmodel.UserViewModel
import com.korchagin.userinfo.viewmodel.UserViewModelFactory
import kotlinx.android.synthetic.main.fragment_user_list.*


const val BASE_URL = "https://api.jsonbin.io/b/"
val TAG = "MainActivity"

class UserListFragment : Fragment() {

    private lateinit var factory: UserViewModelFactory
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_user_list, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = UserApi()
        val repository = UsersRepository(api)
        factory = UserViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this,factory).get(UserViewModel::class.java)
        viewModel.getUsers()
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            rv_Info.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                //it.adapter = UsersAdapter(users)
                it.adapter = AdapterForRecyclerView(users.people)
            }
        })
    }



}