package kg.tutorial.restmenu

object Data {
    val items = listOf<Item>(
            Item(1,R.drawable.iv_burger, "Burger Craze", "15 - 20 min", "American", "Burger", "1.5 km away"),
            Item(2, R.drawable.iv_pizza, "Vegetarian Pizza", "10 -15 min", "Italian", "Burger", "0.8 km away"),
            Item(3, R.drawable.iv_roll, "Sushi Rolls","15 - 30 min", "Japan", "Roll", "2.5 km away")
    )

    fun getLongListOfItems(): MutableList <Item> {
        val list = mutableListOf<Item>()
        for (i in 0..10){
            list.addAll(items)
        }
        return list
    }
}