package fareez.co.wolf.Grocery.App.controller

import fareez.co.wolf.Grocery.App.model.GroceryItem
import fareez.co.wolf.Grocery.App.controller.StatusResponseEntity
import fareez.co.wolf.Grocery.App.repository.GroceryItemRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/groceries")
class GroceryController (private val groceryRepository: GroceryItemRepository) {

    @RequestMapping("/")
    fun getGroceryList(): MutableIterable<GroceryItem> {
        return groceryRepository.findAll()
    }

    @PutMapping
    fun addGroceryItem(@RequestBody groceryItem: GroceryItem): ResponseEntity<StatusResponseEntity<GroceryItem>> {
        val savedItem = groceryRepository.save(groceryItem)
        return ResponseEntity(StatusResponseEntity(
                true,
                "Added new grocery item to your list",
                savedItem
        ), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteGroceryItem(@PathVariable("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = groceryRepository.findById(id)
        return when {
            item.isPresent -> {
                ResponseEntity(
                        StatusResponseEntity(true, "deleted item ${item.get().name} from list ", true),
                        HttpStatus.OK
                )
            }
            else -> {
                ResponseEntity<StatusResponseEntity<Boolean>>(
                        StatusResponseEntity(false, "sorry could not find item to delete", false),
                        HttpStatus.NOT_FOUND
                )
            }
        }
    }
    @PostMapping("/available")
    fun toggleGroceryItemAvailability(@RequestBody availability: Boolean, @RequestParam("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = groceryRepository.findById(id)
        return when {
            item.isPresent -> {
                item.get().isAvailable = availability
                groceryRepository.save(item.get())
                ResponseEntity(StatusResponseEntity(true, "item ${item.get().name} is now ${if (availability) "available" else "finished"} ", true), HttpStatus.OK)
            }
            else -> {
                ResponseEntity(StatusResponseEntity(false, "sorry could not find that item", false), HttpStatus.NOT_FOUND)
            }
        }
    }
}