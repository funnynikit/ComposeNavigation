package com.example.navigationincompose.screen


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationincompose.DETAIL_ARGUMENT_KEY2
import com.example.navigationincompose.Person
import com.example.navigationincompose.Screen

@Composable
fun DetailsScreen(
    navHostController: NavHostController
){

    val bundle = navHostController.currentBackStackEntry?.arguments
    val result = navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
    bundle?.let {
        var name = it.getString(DETAIL_ARGUMENT_KEY2)
        Log.d("Detail","Name : $name")

    }
    result?.let {
        Log.d("Detail","Full Name : ${result.firstName + result.secondName}")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
//                navHostController.popBackStack() // this would remove the current screen from the application screen stack
                navHostController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route){
                        inclusive = true
                    }
                }
            },
            text = "Details",
            color = Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview(){
    DetailsScreen(navHostController = rememberNavController())
}