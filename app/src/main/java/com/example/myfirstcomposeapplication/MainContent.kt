package com.example.myfirstcomposeapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapplication.ui.theme.MyFirstComposeApplicationTheme

@Composable
fun MainContent() {
    MyFirstComposeApplicationTheme {
        // A surface container using the 'background' color from the theme
        var greetingsState by remember {
            mutableStateOf("Lorem ipsum dolor sit amet")
        }

        var counter by remember {
            mutableIntStateOf(0)
        }

        var stringToFind by remember {
            mutableStateOf("")
        }

        var searchResult by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {
            Greeting(
                modifier = Modifier.wrapContentSize(),
                text = greetingsState,
                counter = counter
            )

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    counter++
                    greetingsState = "Hello Nexi! Hope you're enjoying Android!"
                }
            ) {
                Text(text = "Click me!")
            }


            Spacer(modifier = Modifier.height(16.dp))


            Row(modifier = Modifier) {

                //how to place it on right side?
                Button(
                    modifier = Modifier,
                    onClick = {

                        if (stringToFind.length > 1) {

                            searchResult = "Word "

                            if (!greetingsState.contains(stringToFind))
                                searchResult += "not "

                            searchResult += "found"
                        }


                    }
                ) {
                    Text(text = "Search!")
                }

                TextField(
                    modifier = Modifier,
                    value = stringToFind,
                    onValueChange = { stringToFind = it }
                )



            }

            Text(text = searchResult, modifier = Modifier.align(Alignment.CenterHorizontally))

        }
    }
}