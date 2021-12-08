package com.example.ca_mobile1

import android.util.Log
import androidx.lifecycle.*
import com.example.ca_mobile1.data.Disney
import com.example.ca_mobile1.webaccess.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    // MutableLiveData - means this list can be changed at runtime
    // Note!!! _plants above is private, only visible here the underscore represents variables not exposed to the UI layer (fragments)
    private val _characters: MutableLiveData<List<Disney>> = MutableLiveData()

    // Plants is exposed to the UI - Fragment
    val characters: LiveData<List<Disney>>
        // get() This is a getter() function, which returns the list of plants as LiveData
        get() = _characters

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    // No Longer get the data from SampleDataProvider
    init {
//        // here we get the plant list data to share with the user interface
        getCharacters()
    }

    private fun getCharacters() {
        // web-access so run in a background thread - Coroutine
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedCharacters = RetrofitInstance.api.getCharacters()
            Log.i("Character logging", "List of Characters : $fetchedCharacters")
            _characters.value = fetchedCharacters.data
            _isLoading.value = false
        }
    }
}