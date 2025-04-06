package com.example.mealz_app.ui.details

import android.graphics.drawable.shapes.Shape
import android.net.Uri.Builder
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.example.model.response.MealResponse
import kotlin.math.max
import kotlin.math.min

@Composable
fun MealDetailScreen(meal: MealResponse?) {
  //  var isExpanded by remember { mutableStateOf(false) }
    //val imagesizeDp: Dp by animateDpAsState(targetValue = if (isExpanded) 200.dp else 100.dp)
//var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
//    val transition= updateTransition(targetState = profilePictureState, label = "")
//    val imagesizeDp by transition.animateDp(targetValueByState =  { it.size }, label = "")
//    val color by transition.animateColor(targetValueByState =  { it.color }, label = "")
//    val widthSize by transition.animateDp(targetValueByState =  { it.borderWidth }, label = "")


// val Scrollstate= rememberScrollState()

    val Scrollstate= rememberLazyListState()
    val offset= min(1f,1-(Scrollstate.firstVisibleItemScrollOffset/600f +
            Scrollstate.firstVisibleItemIndex))
    val size by animateDpAsState(targetValue = max(100.dp, 140.dp*offset))
Surface(color = MaterialTheme.colorScheme.background) {
    Column {
        Surface(shadowElevation = 10.dp) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Card(modifier = Modifier.padding(16.dp), shape = CircleShape,
                    border = BorderStroke(width = 2.dp, color = Color.Green)
                ) {
                    Image(painter = rememberAsyncImagePainter(model = ImageRequest.Builder(LocalContext.current)
                        .data(meal?.imageUrl)
                        .transformations(CircleCropTransformation())
                        .crossfade(true)
                        .build()
                    ), contentDescription = "Meal Image", modifier = Modifier
                        .size(size)
                    ) }
                Text(meal?.name ?: "default name", modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                )
            }
        }
val dummyContentList= (0..100).map{it.toString()}

        LazyColumn(state = Scrollstate) {
items(dummyContentList){dummyItems->
    Text(text = dummyItems, modifier= Modifier.padding(24.dp))

}

        }

//        Column(modifier = Modifier.verticalScroll(Scrollstate)) {
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//            Text("this is a text element", modifier = Modifier.padding(32.dp))
//        }
//        Button(modifier = Modifier.padding(16.dp), onClick =
//        { profilePictureState = if(profilePictureState == MealProfilePictureState.Normal)
//            MealProfilePictureState.Expanded
//        else
//            MealProfilePictureState.Normal}) {
//            Text("Change state of meal profile picture")
        }
    }
}



        enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
            Normal(Color.Magenta, 120.dp, 8.dp),
            Expanded(Color.Green, 200.dp, 24.dp)
        }

