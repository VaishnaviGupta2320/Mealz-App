package com.example.mealz_app.ui.meals

import android.content.ContentProvider
import android.graphics.Paint.Align
import androidx.annotation.ContentView
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.rememberAsyncImagePainter
import com.example.mealz_app.ui.theme.Mealz_appTheme
import com.example.model.response.MealResponse
import retrofit2.Call
import retrofit2.Callback


@Composable
fun MealsCategoriesScreen(navigationCallback: (String) -> Unit) {
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
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MealCategory(meal, navigationCallback)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealCategory(meal:MealResponse, navigationCallback:  (String) -> Unit)
{
    var isExpanded by remember { mutableStateOf(false) }
    Card(shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp).clickable {
            navigationCallback(meal.id)
        }) {
        Row(modifier = Modifier.animateContentSize()) {
            Image(
                painter = rememberAsyncImagePainter(meal.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(88.dp).padding(4.dp).align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier.align(Alignment.CenterVertically).fillMaxWidth(0.8f)
                .padding(16.dp)) {
                Text(text=meal.name, style = MaterialTheme.typography.headlineMedium)
                CompositionLocalProvider(value = LocalContentColor provides Color.Gray) {
                    Text(text=meal.description, textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if(isExpanded)10 else 4)
                }

            }
            Icon(imageVector = if(isExpanded) Icons.Filled.KeyboardArrowUp else
                Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand row items", modifier = Modifier.padding(16.dp)
                    .align(if(isExpanded) Alignment.Bottom else Alignment.CenterVertically).clickable { isExpanded != isExpanded })
        }
    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Mealz_appTheme {
        MealsCategoriesScreen({})
    }
}