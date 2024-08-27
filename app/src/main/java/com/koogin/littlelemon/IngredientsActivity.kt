package com.koogin.littlelemon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ingredients)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dishName = intent.getStringExtra(EXTRA_DISH_NAME)
        val dishIngredients = when (dishName) {
            "Hamburger" -> "Pain à hamburger\nSteak haché de bœuf\n" +
                    "\nFromage (généralement cheddar ou american cheese)\nLaitue\n" +
                    "Tomates en tranches\nOignons (crus ou caramélisés)\nCornichons\nKetchup\nMoutarde\n" +
                    "\nMayonnaise"
            "Pasta" -> "Pâtes (spaghetti, penne, fusilli, etc.)\nSauce tomate\nHuile d'olive\n" +
                    "\nAil\nOignons\nHerbes (basilic, origan, thym)\nSel\nPoivre\nParmesan râpé (optionnel)"
            else -> "Unknown Ingredient"

        }

        findViewById<TextView>(R.id.dish_name_label).text = dishName
        findViewById<TextView>(R.id.dish_ingredients_desc).text = dishIngredients


    }


    companion object {
        private const val EXTRA_DISH_NAME = "DishName"

        fun start(context: Context, dishName: String) {
            val intent = Intent(context, IngredientsActivity::class.java)
            intent.putExtra(EXTRA_DISH_NAME, dishName)
            context.startActivity(intent)
        }
    }
}

