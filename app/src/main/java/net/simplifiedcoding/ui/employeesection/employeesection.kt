package net.simplifiedcoding.ui.employeesection

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.data.Resource
import net.simplifiedcoding.navigation.ROUTE_ATTENDANCESCREEN
import net.simplifiedcoding.navigation.ROUTE_CALENDARSCREEN
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_HOMEXSCREEN
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_SIGNUP
import net.simplifiedcoding.ui.auth.AuthHeader
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import net.simplifiedcoding.ui.profile.ProfileImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signup2Screen(viewModel: AuthViewModel?, navController: NavHostController) {

    val signupFlow = viewModel?.signupFlow?.collectAsState()
    var name by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)
            .paint(
                painterResource(id = R.drawable.hhhhh),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (refHeader, refName, refEmail, refPassword, refButtonSignup, refTextSignup, refLoader) = createRefs()
        val spacing = MaterialTheme.spacing



        Column(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "EMPLOYEE WALL",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 50.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Magenta
            )



            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)
            ) {

                item {

                    LazyRow(

                    ) {

                        item {


                            Column(


                            ) {


                                Card(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxSize()
                                    ,

                                    shape = RoundedCornerShape(corner = CornerSize(10.dp))

                                ) {
                                    ProfileImage()
                                    val (galleryImage, setGalleryImage) = remember { mutableStateOf<Uri?>(null) }
                                    val galleryLauncher =
                                        rememberLauncherForActivityResult(
                                            contract = ActivityResultContracts.GetContent(),
                                            onResult = setGalleryImage,
                                        )
                                    if (galleryImage == null) {
                                        TextButton(onClick = { galleryLauncher.launch("image/*") }) {
                                            Text("Change Profile Image")
                                        }
                                    } else {

                                    }
                                }

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 4.dp, end = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(text = "Name:",
                                            modifier = Modifier.width(100.dp),
                                            fontWeight = FontWeight.Bold,

                                            )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .padding(5.dp)
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                      
                                        Column {
                                            Text(
                                                text = viewModel?.currentUser?.displayName ?: "",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontSize = 30.sp
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = "Age: 21",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontSize = 30.sp
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = "Employee No: 210031",
                                                style = MaterialTheme.typography.bodyMedium,
                                                        fontSize = 30.sp
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = "MARK ATTENDANCE",
                                                color = Color.Yellow,
                                                fontSize = 20.sp,
                                                modifier = Modifier.clickable {
                                                    navController.navigate(ROUTE_ATTENDANCESCREEN) {
                                                        popUpTo(ROUTE_ATTENDANCESCREEN) {
                                                            inclusive = true
                                                        }
                                                    }
                                                })


                                        }
                                    }
                                }

                                    }
                                }


                            }
                        }
                    }
                }
            }



@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun SignupScreenPreviewLight() {
    AppTheme {
        Signup2Screen(null, rememberNavController(),)
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SignupScreenPreviewDark() {
    AppTheme {
        Signup2Screen(null, rememberNavController(),)
    }
}
