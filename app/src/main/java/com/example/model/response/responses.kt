package com.example.model.response
//
//import com.google.gson.annotations.SerializedName
//import java.net.URL
//
//data class MealsCategoriesResponse( val Categories: List<MealsResponse>)
//data class MealsResponse(
//    @SerializedName(value = "idCategory")  val id:String,
//   @SerializedName(value = "strCategory")  val name:String,
//   @SerializedName(value = "strCategoryDescription")  val description:String,
//   @SerializedName(value = "strCategoryThumb")  val imageURL: String)
//
//


import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)