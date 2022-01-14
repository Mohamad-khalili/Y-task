package com.mkh.news.task.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkh.news.task.models.RepositoriesModel
import com.mkh.news.task.repository.GitRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitRepoViewModel @Inject constructor(private val gitRepoRepository: GitRepoRepository) : ViewModel() {
    lateinit var searchWord :String


    val _resp = MutableLiveData<RepositoriesModel>()

    val gitResp : LiveData<RepositoriesModel>
    get() = _resp

    init {
        searchWord = "tetris"
        getRepository(searchWord)
    }

    private fun getRepository(q: String) = viewModelScope.launch {
        gitRepoRepository.getRepo(q).let { response ->
            if (response.isSuccessful){
                _resp.postValue(response.body())
            }else{
                Log.d("TAG", "getRepository: " )
            }
        }



    }

    fun getWord(q: String) {
        searchWord =q
        getRepository(q)

    }

}