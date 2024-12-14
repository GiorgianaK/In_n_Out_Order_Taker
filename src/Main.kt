sealed class MenuItem {
    abstract val name: String
    abstract val price: Double
}

class Burger(val patties: Int, val cheese: Boolean, val toppings: List<String>) : MenuItem() {
    override val name = "burger"
    override val price = 3.50 + patties + (if(cheese) 0.50 else 0.0)

}

class Fries(val size: String) : MenuItem() {
    override val name = "fries"
    override val price = if(size == "small") {
        1.00
    } else if (size == "medium") {
        1.50
    } else if(size == "large") {
        2.00
    } else {
        1.50
    }
}

class Drink(val type: String, val size: String) : MenuItem() {
    override val name = "drink"
    override val price = if(size == "small") {
        1.00
    } else if (size == "medium") {
        1.50
    } else if (size == "large") {
        2.00
    } else {
        1.50
    }
}

class Order {
    val items = mutableListOf<MenuItem>()

    fun add(item: MenuItem) {
        items.add(item)
    }

    fun total(): Double {
        return items.sumOf { it.price }
    }


    fun printReceipt() {
        println("--- In 'n' Out Receipt ---")
        for (item in items) {
            println("${item.name} - \$${item.price}")
        }
        println("Total: \$${total()}")
        println("--- Thank You! ---")
    }
}

fun main() {
    val order = Order()
    order.add(Burger(8,true,listOf("tomato")))
    order.add(Drink("root beer","medium"))
    order.add(Fries(""))
    order.printReceipt()
}
