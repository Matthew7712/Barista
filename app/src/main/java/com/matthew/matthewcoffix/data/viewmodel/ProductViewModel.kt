package com.matthew.matthewcoffix.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matthew.matthewcoffix.R
import com.matthew.matthewcoffix.ui.menu.MenuItem

class ProductViewModel: ViewModel() {

    private val _items = MutableLiveData<List<MenuItem>>(
        listOf(
            MenuItem(id = 1, text = "Kapi Susu Brutai", image =  R.drawable.nathan, cost = 2.05F, description = ""),
            MenuItem(id = 2, text = "Caramel Suntay", image = R.drawable.nafinia_putra_kwdp_0pok_i_unsplash, cost = 2.95F, description = ""),
            MenuItem(id = 3, text = "Kapi Susu Brutai", image =  R.drawable.nathan, cost = 2.05F, description = ""),
            MenuItem(id = 4, text = "Caramel Suntay", image = R.drawable.nafinia_putra_kwdp_0pok_i_unsplash, cost = 2.95F, description = ""),
            MenuItem(id = 5, text = "Kapi Susu Brutai", image =  R.drawable.nathan, cost = 2.05F, description = ""),
            MenuItem(id = 6, text = "Caramel Suntay", image = R.drawable.nafinia_putra_kwdp_0pok_i_unsplash, cost = 2.95F, description = ""),
            MenuItem(id = 7, text = "Kapi Susu Brutai", image =  R.drawable.nathan, cost = 2.05F, description = ""),
            MenuItem(id = 8, text = "Caramel Suntay", image = R.drawable.nafinia_putra_kwdp_0pok_i_unsplash, cost = 2.95F, description = "")
        )
    )
    val items: LiveData<List<MenuItem>> = _items

    fun getItemById(id: Int): MenuItem? {
        return _items.value?.find { it.id == id }
    }
}