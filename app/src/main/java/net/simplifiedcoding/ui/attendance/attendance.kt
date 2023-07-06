package net.simplifiedcoding.ui.attendance

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.simplifiedcoding.R
import net.simplifiedcoding.ui.auth.AuthViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(viewModel: AuthViewModel?, navController: NavHostController) {


    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("Attendance", color = Color.White) },


                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Black)


            )
        },
        bottomBar = {

            BottomAppBar( modifier = Modifier.background(Color.Magenta)) {

                Text(text = " PLEASE MARK ATTENDANCE",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.size(40.dp))







                }








            }
        ,

        content = {

            Box(modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.vec),
                    contentScale = ContentScale.FillBounds
                )
            ){

            }

            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start


            ) {

                item {
                    Spacer(modifier = Modifier.size(20.dp))
                }

                item {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                    ) {

                        Column {


                            LazyRow() {

                                item {

                                    Text(text = "1.", fontSize = 30.sp)



                                    Spacer(modifier = Modifier.size(10.dp))
                                    Column {

                                        Text(
                                            text = " Name ",
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )


                                        Text(text =  viewModel?.currentUser?.displayName ?: "", fontSize = 30.sp)

                                    }
                                    Spacer(modifier = Modifier.size(14.dp))
                                    Column {
                                        Text(
                                            text = " MONDAY ",
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )



                                        Checkbox(checked = true, onCheckedChange = null)

                                    }


                                    Column {
                                        Text(
                                            text = " TUESDAY ",
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )



                                        Checkbox(checked = false, onCheckedChange = null)

                                    }

                                    Column {
                                        Text(
                                            text = " WEDNESDAY ",
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )



                                        Checkbox(checked = false, onCheckedChange = null)

                                    }

                                    Column {
                                        Text(
                                            text = " THURSDAY ",
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )



                                        Checkbox(checked = false, onCheckedChange = null)

                                    }

                                    Column {
                                        Text(
                                            text = " FRIDAY ",
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.Underline
                                        )



                                        Checkbox(checked = false, onCheckedChange = null)

                                    }
                                }
                            }
                            

                        }
                    }

                }}})}