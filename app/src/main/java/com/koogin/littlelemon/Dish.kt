package com.koogin.littlelemon

class Dish (val name: String, val ingredients: MutableList<String>)


fun Dish.getIngredients() : String {
    var ingredientsFormatedList = ""

    for (i in ingredients.indices) {
        ingredientsFormatedList += "${i + 1}. ${this.ingredients[i]}\n"
    }
    return ingredientsFormatedList
}


fun Dish.removeSalt() {
    this.ingredients.remove("Salt")
}