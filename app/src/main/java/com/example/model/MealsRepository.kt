package com.example.model
//import com.example.model.api.MealsWebService
//import com.example.model.response.MealResponse
//import com.example.model.response.MealsCategoriesResponse
//
//
//class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
//    private var cachedMeals = listOf<MealResponse>()
//    suspend fun getMeals(): MealsCategoriesResponse {
//        val response = webService.getMeals()
//        cachedMeals = response.categories
//        return response
//
//    }
//
//    fun getMeal(id: String): MealResponse? {
//        return cachedMeals.firstOrNull {
//            it.id == id
//        }
//    }
//
//
//    companion object {
//        @Volatile
//        private var INSTANCE: MealsRepository? = null
//
//        fun getInstance(): MealsRepository {
//            return INSTANCE ?: synchronized(this) {
//                val instance = MealsRepository()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}




import com.example.model.api.MealsWebService
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response

    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: MealsRepository? = null

        fun getInstance(): MealsRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = MealsRepository()
                INSTANCE = instance
                instance
            }
        }
    }
}



