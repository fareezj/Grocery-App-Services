package fareez.co.wolf.Grocery.App.dbHelper

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import fareez.co.wolf.Grocery.App.repository.GroceryItemRepository
import fareez.co.wolf.Grocery.App.model.GroceryItem
import javax.persistence.PrePersist

@Component
class DBHelper(private val groceryRepository: GroceryItemRepository) : CommandLineRunner {

    @PrePersist
    fun deleteAllGroceryItem) {
        groceryRepository.deleteAll()
    }

    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        val items = listOf(
                GroceryItem("Beans", true),
                GroceryItem("Eggs", false),
                GroceryItem("Milk", true),
                GroceryItem("Cheese", true)
        )
        groceryRepository.saveAll(items)
    }
}