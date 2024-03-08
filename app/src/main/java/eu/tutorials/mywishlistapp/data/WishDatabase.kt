package eu.tutorials.mywishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

/*                      Integration in Android App
*   In an Android application using Room, these components are integrated as follows:
*       * Entities define the structure of your database tables.
*       * DAOs provide the methods to interact with these tables.
*       * Database Instance: Room uses these components to create a database
*           instance which your app can use to perform actual data operations.
*
* */
@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class WishDatabase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}