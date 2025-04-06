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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealz_app.ui.details.MealDetailScreen
import com.example.mealz_app.ui.details.MealDetailsViewmodel
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
                //MealsCategoriesScreen()
                FoodiezApp()
            }
        }
    }
}
@Composable
private fun FoodiezApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "meal_categories" // Correctly used here
    ) {
        composable("meal_categories") {
            MealsCategoriesScreen()
            { navigationMealID ->
                navController.navigate("destination_meal_detail/$navigationMealID")
            }
        }
        composable(
            route = "destination_meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id")
            {
                type = NavType.StringType
            })
        )
        {
            val viewModel: MealDetailsViewmodel= viewModel()
            MealDetailScreen(viewModel.mealState.value)
        }
    }
}
//    val navController= rememberNavController()
//    NavHost(navController,startDestination="destination_meal_list")
//    composable(route="")
//    {
//        MealsCategoriesScreen()
//    }
//}

