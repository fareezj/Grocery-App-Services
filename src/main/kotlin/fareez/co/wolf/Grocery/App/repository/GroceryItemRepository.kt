package fareez.co.wolf.Grocery.App.repository

import fareez.co.wolf.Grocery.App.model.GroceryItem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GroceryItemRepository: CrudRepository<GroceryItem, Long>