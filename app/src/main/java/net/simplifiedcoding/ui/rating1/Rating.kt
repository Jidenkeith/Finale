package net.simplifiedcoding.ui.rating1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.simplifiedcoding.R
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.spacing



@Composable
fun RatingScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    val rating by remember { mutableStateOf("")}




    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.bkkkk),
                contentScale = ContentScale.FillBounds
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

Text(text = "RATE THE COMPANY", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)

Spacer(modifier = Modifier.height(100.dp))

        Row {
            // The rating stars
            for (i in 1..5) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star",
modifier = Modifier.clickable {"THANKS FOR THE RATING!"}

                )
            }
            // The text label
            Text(text = "Rating: $rating")
        }
Spacer(modifier = Modifier.height(250.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .paint(
                    painterResource(id = R.drawable.logo1),
                    contentScale = ContentScale.FillWidth
                )
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {



            }
        }}


