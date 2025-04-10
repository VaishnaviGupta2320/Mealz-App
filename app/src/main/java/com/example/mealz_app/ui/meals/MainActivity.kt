//package com.example.mealz_app.ui.meals
//
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.lifecycle.viewmodel.viewModelFactory
//import com.example.mealz_app.ui.theme.Mealz_appTheme
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.mealz_app.ui.details.MealDetailScreen
//import com.example.mealz_app.ui.details.MealDetailsViewmodel
//import com.example.model.response.MealResponse
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Mealz_appTheme {
//
//                FoodiezApp()
//            }
//        }
//    }
//}
//@Composable
//private fun FoodiezApp() {
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = "meal_categories" // Correctly used here
//    ) {
//        composable("meal_categories") {
//            MealsCategoriesScreen()
//            { navigationMealID ->
//                navController.navigate("destination_meal_detail/$navigationMealID")
//            }
//        }
//        composable(
//            route = "destination_meal_details/{meal_category_id}",
//            arguments = listOf(navArgument("meal_category_id")
//            {
//                type = NavType.StringType
//            })
//        )
//        {
//            val viewModel: MealDetailsViewmodel= viewModel()
//            MealDetailScreen(viewModel.mealState.value)
//        }
//    }
//}
//
//
//

package com.example.mealz_app.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealz_app.ui.details.MealDetailScreen
import com.example.mealz_app.ui.details.MealDetailsViewmodel
import com.example.mealz_app.ui.theme.Mealz_appTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mealz_appTheme {
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
        startDestination = "meal_categories"
    ) {
        composable("meal_categories") {
            MealsCategoriesScreen() { navigationMealID ->
                navController.navigate("destination_meal_details/$navigationMealID")
            }
        }
        composable(
            route = "destination_meal_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewmodel = viewModel()
            MealDetailScreen(viewModel.mealState.value)
        }
    }
}
