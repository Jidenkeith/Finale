package net.simplifiedcoding.ui.messages

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.home.HomeScreen
import net.simplifiedcoding.ui.theme.spacing

@Composable
fun MessagesScreen(
    viewModel: AuthViewModel?,
    navController: NavHostController
)
{ val spacing = MaterialTheme.spacing


    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.medium)
            .padding(top = spacing.extraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "EMPLOYER DASHBOARD ",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold

        )



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.medium)
                .background(Color.Gray)
        ) {

            Text(text = "VIEW MESSAGES ",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
                , modifier = Modifier
                    .align(CenterHorizontally)




            )
            Spacer(modifier = Modifier.size(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = "Name: ",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = viewModel?.currentUser?.displayName ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()

            ) {
                Text(
                    text = "Email: ",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = viewModel?.currentUser?.email ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }


        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable fun HomeScreenPreviewLight()
{ HomeScreen(null, rememberNavController(),) }