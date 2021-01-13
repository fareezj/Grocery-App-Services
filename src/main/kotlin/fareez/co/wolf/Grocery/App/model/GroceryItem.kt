package fareez.co.wolf.Grocery.App.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class GroceryItem (var name: String,
                        var isChecked: Boolean,
                        var username: String,
                        var groupID: Int,
                        @Id
                        @GeneratedValue(strategy = GenerationType.AUTO)
                        var id: Long = 0L)



