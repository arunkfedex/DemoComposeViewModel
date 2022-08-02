package com.arun.androidtutsforu.democomposeviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arun.androidtutsforu.democomposeviewmodel.ui.theme.DemoComposeViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeViewModelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CalculateScreen()
                }
            }
        }
    }
}

@Composable
fun CalculateScreen(composeViewModel: ComposeViewModel = viewModel()){
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "JetPack Compose Demo",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value =composeViewModel.firstNum,
            onValueChange ={composeViewModel.changeFirstNum(it)} ,
            label = { Text(text = "Enter First Num")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = composeViewModel.secondNum,
            onValueChange = {composeViewModel.changeSecondNum(it)},
            label = { Text(text = "Enter Second Num")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "The sum is ${composeViewModel.sum}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Button(onClick = { composeViewModel.valuculate() }) {
            Text(text = "Calculate")
        }
    }
}