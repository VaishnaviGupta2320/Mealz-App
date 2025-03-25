package com.example.mealz_app.ui.meals

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mealz_app.ui.theme.Mealz_appTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.example.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        Log.d("MainActivity", "This is a debug log")
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//       val viewModel by viewModels<MealCategoriesViewModel>()
//        setContent {
//            Mealz_appTheme {
//                   MealsCategoriesScreen()
//               }
//            }
//        }
//    }
//
//
//@Composable
//fun MealsCategoriesScreen() {
//    //val ViewModel= MealCategoriesViewModel()
//    val remeberedmeals: MutableState<List<MealsResponse> > =
//    remember{ mutableStateOf(emptyList<MealsResponse>()) }
//    val ViewModel: MealCategoriesViewModel = viewModel()
//    ViewModel.getMeals { response->
//        val mealsfromtheapi=response?.Categories
//       // remeberedmeals.value = mealsfromtheapi.orEmpty()
//        remeberedmeals.value = mealsfromtheapi.orEmpty() as List<MealsResponse>
//
//    }
//    Text(
//        text = remeberedmeals.value.toString()
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Mealz_appTheme {
//        MealsCategoriesScreen()
//    }
//}
//
//
//
//
//


//package com.codingtroops.mealzapp.ui.meals
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.viewModels
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
////import androidx.compose.material.Text
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.viewmodel.compose.viewModel
////import com.codingtroops.mealzapp.ui.theme.MealzAppTheme
//import com.codingtroops.model.response.MealResponse

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mealz_appTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
//    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }
//   val coroutineScope = rememberCoroutineScope()
//    LaunchedEffect("GET_MEALS") {
//       coroutineScope.launch (Dispatchers.IO){
//           val meals= viewModel.getMeals()
//           rememberedMeals.value=meals
//   }
//
 // }
val meals= viewModel.mealsState.value
    LazyColumn {
        items(meals) { meal ->
            Text(text = meal.name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mealz_appTheme {
        MealsCategoriesScreen()
    }
}
