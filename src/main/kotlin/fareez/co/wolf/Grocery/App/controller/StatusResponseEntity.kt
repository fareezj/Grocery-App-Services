package fareez.co.wolf.Grocery.App.controller

data class StatusResponseEntity<T>(val status: Boolean, val message: String, val entity: T?)