package fareez.co.wolf.Grocery.App.dbHelper

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import fareez.co.wolf.Grocery.App.repository.GroceryItemRepository
import fareez.co.wolf.Grocery.App.model.GroceryItem
import javax.persistence.PrePersist

@Component
class DBHelper(private val groceryRepository: GroceryItemRepository) : CommandLineRunner {

    @PrePersist
    fun deleteAllGroceryItem() {
        groceryRepository.deleteAll()
    }

    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        val items = listOf(
                GroceryItem("Beans", false, "Fareez", 100),
                GroceryItem("Eggs", false, "Fareez", 110),
                GroceryItem("Eggs", false, "Fareez", 110),
                GroceryItem("Milk", false, "Fareez", 120),
                GroceryItem("Cheese", false, "Fareez", 130)
        )
        groceryRepository.saveAll(items)
    }
}