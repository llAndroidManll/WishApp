package eu.tutorials.mywishlistapp

import android.content.Context
import androidx.room.Room
import eu.tutorials.mywishlistapp.data.WishDatabase
import eu.tutorials.mywishlistapp.data.WishRepository

/*
*   So this graph object is effectively acting as a simple dependency container,
*   where it initializes and provides instances of the database and repository needed by the app.
*   This pattern is handy for (հարմար է) managing dependencies in a centralized way, avoiding tight coupling
*   between components (избежание тесной(ամուր) связи между компонентами), and making the code more testable and maintainable(ремонтопригодный).
* */
object Graph {

    lateinit var database: WishDatabase

    /*                      by lazy
    *   This variable is only initialized once it is going to be needed.
    * */
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    /*
    *   So when u want to build your database,
    *   you need to know which context you want to build that
    *
    *   So we have this database (line 17 `lateinit var database`) right.
    *   The provide function will now initialize that database because we're
    *   trying to use it here(line 22 `WishRepository(wishDao = database.wishDao())`),
    *   but it's not initialized at this moment. So we need to initialize it.
    * */
    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }

}