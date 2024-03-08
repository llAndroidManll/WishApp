package eu.tutorials.mywishlistapp.data

import kotlinx.coroutines.flow.Flow


/*                      Using Repositories and Kotlin Coroutines
*   In Android development with Kotlin, especially when using Room for database operations, repositories and
*   coroutines play a crucial role in managing data operations and ensuring a smooth, responsive user interface.
*   Let’s delve into these concepts:
*
*       1. Repositories:
*           Role:
*               A repository acts as a mediator between different data sources (like Room database, network, etc.)
*               and your application’s business logic. It abstracts the source of the data from the rest of your app,
*               providing a clean API for data access to the rest of your application.
*           Benefits:
*               By using a repository, you can keep your data operations and your business logic separate
*               from your UI code. This separation makes your code more modular, easier to test, and flexible in terms of
*               changing data sources.
*       2. Kotlin Coroutines:
*           Role: Coroutines — это функция Kotlin, которая упрощает асинхронное программирование, позволяя писать код последовательно.
*               Они особенно полезны для управления длительными задачами, которые потенциально могут заблокировать основной поток, например,
*               операции с базой данных или сетевые вызовы.
*           Dispatchers in Coroutines:
*               Dispatchers.IO is a coroutine dispatcher that optimizes the execution of IO-intensive tasks, like reading from or
*               writing to a database, reading files, and network operations. By using this dispatcher, such tasks are offloaded to a shared pool of threads,
*               ensuring that the main thread, responsible for handling UI updates, remains responsive.
*       3. Flow<> in Room with Kotlin:
*           What is Flow?:
*               Flow is a type in the Kotlin Coroutines library (kotlinx.coroutines.flow) used for
*               representing streams of data that can emit (որը կարող է արտանետել) multiple values over time. Unlike a single-shot call (like a suspending function),
*               can emit multiple values sequentially(հաջորդաբար).
*           Use in Room:
*               When used with Room, Flow can be particularly powerful for observing changes in the
*               database. For instance, you can return a from a DAO method, and Room will ensure that every time the data
*               in the table changes, the Flow emits these updates automatically.
* */
class WishRepository(private val wishDao: WishDao) {

    suspend fun addAWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id:Long) :Flow<Wish> {
        return wishDao.getAWishById(id)
    }

    suspend fun updateAWish(wish:Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }

}