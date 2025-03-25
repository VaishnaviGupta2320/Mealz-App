package com.example.mealz_app.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.model.MealsRepository
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//import com.example.model.response.MealsResponse
//
//class MealCategoriesViewModel(private val repository: MealsRepository= MealsRepository()):ViewModel() {
//    fun getMeals(successCallback: (response: MealsCategoriesResponse?)-> Unit)
//    {
//        repository.getMeals{
//            response ->  successCallback(response)
//        }
//    }
//}
//
//
//






//import androidx.lifecycle.ViewModel
//import com.codingtroops.model.MealsRepository
//import com.codingtroops.model.response.MealResponse
//import com.codingtroops.model.response.MealsCategoriesResponse


class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
//private val mealsjob= Job()
    init {
        Log.d("TAG_COROUTINE", "we are about to launch coroutine")//1
        //val scope = CoroutineScope(mealsjob + Dispatchers.IO)
        //scope.launch () {
        viewModelScope.launch (Dispatchers.IO) {
            Log.d("TAG_COROUTINE", "we have launched coroutine")//3
            val meals = getMeals()
            Log.d("TAG_COROUTINE", "we have received async data")//4
            mealsState.value = meals
        }
    Log.d("TAG_COROUTINE", "other work")//2
    }
    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())
//    override fun onCleared() {
//        super.onCleared()
//        mealsjob.cancel()
//    }

    private suspend fun getMeals(): List<MealResponse> {
return repository.getMeals().categories
    }
}
