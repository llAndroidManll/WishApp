package eu.tutorials.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*                      Entity Class (@Entity)
*   An Entity class in Room represents a table within the SQLite database.
*   Each instance of an entity corresponds to a row in the table.
*
*   The @Entity annotation is used to mark a class as an entity.
*   This tells Room to create a table for this object.
*
*                       Structure
*   Primary Key:
*       Each entity must define at least one primary key. This is done using the @PrimaryKey
*       annotation. For instance, @PrimaryKey(autoGenerate = true) can be used if you want the
*       database to auto-generate the key.
*   Columns:
*       The fields in the entity represent the columns of the table. You can customize the column
*       name using the @ColumnInfo(name = "custom_name") annotation. If not specified, the column
*       name will be the same as the field name.
* */

@Entity(tableName="wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name="wish-title")
    val title: String="",
    @ColumnInfo(name="wish-desc")
    val description:String=""
)

object DummyWish{
    val wishList = listOf(
        Wish(title="Google Watch 2",
            description =  "An android Watch"),
        Wish(title = "Oculus Quest 2",
            description = "A VR headset for playing games"),
        Wish(title = "A Sci-fi, Book",
            description= "A science friction book from any best seller"),
        Wish(title = "Bean bag",
            description = "A comfy bean bag to substitute for a chair")
        )
}
