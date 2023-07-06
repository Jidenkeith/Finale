package net.simplifiedcoding.ui.complaintsection


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomexScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    var subject by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        val (refHeader, refName, refEmail, refPassword, refButtonSignup, refTextSignup, refLoader) = createRefs()
        val spacing = MaterialTheme.spacing




        Column(
            modifier = Modifier

                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

//            Box(modifier = Modifier
//                .fillMaxSize()
//                .paint(
//                    painterResource(id = R.drawable.vec),
//                    contentScale = ContentScale.FillBounds
//                )
//            ){
//
//            }

            Text(
                text = "To:",
                modifier = Modifier
                    .align(Start)
                    .padding(top = 50.dp),


                )
            TextField(
                value = to,
                onValueChange = {
                    to = it
                },
                label = {
                    Text(text = "Email...")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),


                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )


            )


            Text(
                text = "Subject:",
                modifier = Modifier
                    .align(Start),
            )

            TextField(
                value = subject,
                onValueChange = {
                    subject = it
                },
                label = {
                    Text(text = "Subject...")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .height(100.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )


            )

            Text(
                text = "Message:",
                modifier = Modifier
                    .align(Start),
            )

            TextField(
                value = message,
                onValueChange = {
                    message = it
                },
                label = {
                    Text(text = "Message...")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .height(250.dp),

                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )


            )
            val intent = Intent(Intent.ACTION_SENDTO,)
            intent.setData(Uri.parse("mailto:"))
            intent.putExtra(Intent.EXTRA_INTENT, to)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_INTENT, message)
            val context = LocalContext.current
            Button(onClick = {
                startActivity(context, intent, null) }
            ) {
                Text("Send Complaint")
            }

        }

    }}
