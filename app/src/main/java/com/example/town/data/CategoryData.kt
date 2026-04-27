package com.example.town.data

import com.example.town.R
import com.example.town.model.Category

object CategoryData {
    val categories = listOf(
        Category(
            id = 1,
            title = R.string.category_cafe,
            description = R.string.desc_category_cafe,
            iconId = R.drawable.ic_coffee
        ),
        Category(
            id = 2,
            title = R.string.category_restaurant,
            description = R.string.desc_category_restaurant,
            iconId = R.drawable.ic_restaurant
        ),
        Category(
            id = 3,
            title = R.string.category_park,
            description = R.string.desc_category_park,
            iconId = R.drawable.ic_park
        ),
        Category(
            id = 4,
            title = R.string.category_museum,
            description = R.string.desc_category_museum,
            iconId = R.drawable.ic_museum
        ),
        Category(
            id = 5,
            title = R.string.category_kids,
            description = R.string.desc_category_kids,
            iconId = R.drawable.ic_child_friendly
        )
    )

}