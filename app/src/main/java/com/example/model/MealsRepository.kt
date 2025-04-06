package com.example.model
//
import android.annotation.SuppressLint
import com.example.mealz_app.ui.meals.MealsCategoriesScreen
import com.example.model.api.MealsWebService
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//
//class MealsRepository(private val WebService:MealsWebService=MealsWebService())
//{
//
//    fun getMeals(successCallback: (response: MealsCategoriesResponse?)-> Unit)
//    {
//        return WebService.getMeals().enqueue(object: Callback<MealsCategoriesResponse>
//        {
//
//
//            override fun onResponse(
//                call: Call<MealsCategoriesResponse>,
//                response: Response<MealsCategoriesResponse>
//            ) {
//                if(response.isSuccessful)
//                successCallback(response.body())
//            }
//
//            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
//
//            }
//        })
//
//
//    }
//}
//
//
//
//
//


//import com.codingtroops.model.api.MealsWebService
//import com.codingtroops.model.response.MealsCategoriesResponse
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response

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
//    companion object
//
//    @Volatile
//        private var instance:MealsRepository?= null
//    fun getInstance() = instance?: synchronized(this)
//    {
//        instance?:MealsRepository().also { instance= it }
//    }
//    }

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






