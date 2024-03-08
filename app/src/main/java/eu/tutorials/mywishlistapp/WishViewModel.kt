package eu.tutorials.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.mywishlistapp.data.Wish
import eu.tutorials.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
):ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")


    fun onWishTitleChanged(newString:String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addAWish(wish= wish)
        }
    }

    fun getAWishById(id:Long):Flow<Wish> {
        return wishRepository.getAWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish= wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish= wish)
            getAllWishes = wishRepository.getWishes()
        }
    }
}
/* -----------|`lateinit`|-----------
*
*   So we have not used late init before, but let's look at what it does.
*   In this video so late in it.
*   VAR is a promise that you make to the Kotlin compiler that the variable will be initialized before you
*   call any operations on it.
*   So how does that work from a flow perspective?
*   So you have to consider that when you want to use a variable, the variable needs to exist.
*   So when you want to access a variable inside of your code later on, the variable needs to exist, because
*   otherwise you run into an error because basically the variable doesn't exist and you're trying to access
*   it and that crashes your application.
*   So if you want to create a variable that will take some time.
*   To be created like stuff that runs with a coroutine.
*   Right?
*   So this whole flow thing, which works via a coroutine whenever you have something that happens asynchronously
*   and can take a little while, like flow coroutine stuff, then you need to make sure that you add this
*   late init, which is a late initializer.
*   We're basically saying, hey, we promise that we're going to initialize this variable before we're
*   going to actually use it.
* */