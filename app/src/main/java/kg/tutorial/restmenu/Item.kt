package kg.tutorial.restmenu

data class Item(
    val id : Long,
    val imageId: Int,
    val title: String,
    val timeOrder: String,
    val nameCountry: String,
    val nameFood: String,
    val distanceDelivery: String
)
