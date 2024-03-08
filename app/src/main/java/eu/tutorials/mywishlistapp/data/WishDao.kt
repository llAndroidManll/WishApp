package eu.tutorials.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


/*                          Understanding CRUD Operations
*   In Android development, especially when using the Room Persistence Library, these CRUD operations are
*   abstracted through DAOs (Data Access Objects). Developers define methods in DAOs that perform these
*   operations, and Room generates the necessary SQL code.
*
*   CREATE ---- @INSERT
*   READ   ---- @SELECT
*   UPDATE ---- @UPDATE
*   DELETE ---- @DELETE
*
*                           Data Access Object (DAO):
*   DAOs are interfaces or abstract classes where you define methods to access your database. In
*   other words, DAOs are the main component for defining the logic of your database operations.
*
*   Within a DAO, you define methods to perform your database operations (CRUD operations).
*   Room translates these methods into SQLite queries.
*
*   Insert: Annotated with @Insert, used for adding records to the database.
*    Query: Annotated with @Query , used for reading data. You can write SQLite queries inside the annotation.
*   Update: Annotated with @Update, used to modify existing records.
*   Delete: Annotated with @Delete, used to remove records.
*
* */
@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addAWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long): Flow<Wish>


}