package com.example.model
//
import android.annotation.SuppressLint
import com.example.mealz_app.ui.meals.MealsCategoriesScreen
import com.example.model.api.MealsWebService
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
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()

        }
    }



