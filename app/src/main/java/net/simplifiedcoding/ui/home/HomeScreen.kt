package net.simplifiedcoding.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_HOMEXSCREEN
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_MESSAGESSCREEN
import net.simplifiedcoding.navigation.ROUTE_PROFILESCREEN
import net.simplifiedcoding.navigation.ROUTE_RATINGSCREEN
import net.simplifiedcoding.navigation.ROUTE_SIGNUP2SCREEN
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing






    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .paint(
                painterResource(id = R.drawable.bkkkk),
                contentScale = ContentScale.FillBounds
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        LazyColumn(

            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {


                Text(
                    text = "WELCOME BACK,",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = Color.Black
                )

                Text(
                    text = viewModel?.currentUser?.displayName ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.size(20.dp))

                Image(
                    painter = painterResource(R.drawable.baseline_calendar_month_24),
                    contentDescription = "Circle Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(115.dp)
                )

                Text(
                    text = "Access Daily Attendance",
                    fontSize = 30.sp,
                    color = Color.Black

                )
                Text(
                    text = "Click Here",
                    modifier = Modifier.clickable {
                        navController.navigate(ROUTE_SIGNUP2SCREEN) {
                            popUpTo(ROUTE_SIGNUP2SCREEN) { inclusive = true }
                        }
                    })



                Image(
                    painter = painterResource(R.drawable.baseline_upload_file_24),
                    contentDescription = "Circle Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(115.dp)
                )



                Text(
                    text = "Complaints & Announcements",

                    fontSize = 27.sp,
                    color = Color.Black
                )
                Text(
                    text = "Click Here",
                    modifier = Modifier.clickable {
                        navController.navigate(ROUTE_HOMEXSCREEN) {
                            popUpTo(ROUTE_MESSAGESSCREEN) { inclusive = true }
                        }
                    })

                Image(
                    painter = painterResource(R.drawable.baseline_assignment_returned_24),
                    contentDescription = "Circle Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(115.dp)
                )

                Text(
                    text = "Ratings",
                    fontSize = 30.sp,
                    color = Color.Black

                )

                Text(
                    text = "Click Here",
                    modifier = Modifier.clickable {
                        navController.navigate(ROUTE_RATINGSCREEN) {
                            popUpTo(ROUTE_RATINGSCREEN) { inclusive = true }
                        }
                    })

                Button(
                    onClick = {
                        viewModel?.logout()
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = spacing.extraLarge)
                ) {
                    Text(text = stringResource(id = R.string.logout))
                }

            }

        }

    }

                }


