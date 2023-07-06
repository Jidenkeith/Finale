package net.simplifiedcoding.ui.profile


import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: AuthViewModel?, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var Employee by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    val loginFlow = viewModel?.loginFlow?.collectAsState()


    Box(modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.bkkkk),
            contentScale = ContentScale.FillBounds
        )
    ){

    }

    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current, notification.value,Toast.LENGTH_LONG).show()
        notification.value = ""
    }


    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(8.dp)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Cancel",
                modifier = Modifier.clickable { notification.value = "Cancelled" })
            Text(text = "Save",
                modifier = Modifier.clickable { notification.value = "Profile Updated" }
                )

        }
        ProfileImage()

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
            TextField(value = viewModel?.currentUser?.displayName ?: "", onValueChange = {name = it},
                modifier = Modifier.background(Color.Transparent),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black
                ))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Employee No:",
                modifier = Modifier.width(100.dp),
                fontWeight = FontWeight.Bold,
            )
            TextField(value = Employee, onValueChange = {Employee = it},
                modifier = Modifier.background(Color.Transparent),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black
                ))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(text = "Bio:",
                modifier = Modifier
                    .width(100.dp)
                    .padding(top = 8.dp),
                        fontWeight = FontWeight.Bold,
            )
            TextField(value = bio, onValueChange = {bio = it},
                modifier = Modifier
                    .background(Color.Transparent)
                    .height(200.dp)
                ,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black
                ),
                singleLine = false,

            )
        }
    }
}
@Composable
fun ProfileImage() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .size(120.dp)
        ) {
            Image(
                painterResource(id = R.drawable.ic_person ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                ,
                alignment = Alignment.Center


            )
        }

    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun LoginScreenPreviewLight() {
    AppTheme {
        ProfileScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreviewDark() {
    AppTheme {
        ProfileScreen(null, rememberNavController())
    }
}
