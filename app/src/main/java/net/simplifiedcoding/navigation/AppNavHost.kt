package net.simplifiedcoding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.ui.attendance.AttendanceScreen
import net.simplifiedcoding.ui.complaintsection.HomexScreen
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.auth.LoginScreen
import net.simplifiedcoding.ui.auth.SignupScreen
import net.simplifiedcoding.ui.employeesection.Signup2Screen
import net.simplifiedcoding.ui.firstone.HommeScreen
import net.simplifiedcoding.ui.home.HomeScreen
import net.simplifiedcoding.ui.profile.ProfileScreen
import net.simplifiedcoding.ui.rating1.RatingScreen


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOMME
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(ROUTE_HOMME) {
            HommeScreen(viewModel , navController )
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }

        composable(ROUTE_SIGNUP2SCREEN) {
            Signup2Screen(viewModel, navController,)
        }

        composable(ROUTE_HOMEXSCREEN) {
            HomexScreen(viewModel, navController,)

        }

        composable(ROUTE_RATINGSCREEN) {
            RatingScreen(viewModel, navController,)

        }

        composable(ROUTE_PROFILESCREEN) {
            ProfileScreen(viewModel, navController,)

        }

        composable(ROUTE_ATTENDANCESCREEN) {
            AttendanceScreen(viewModel, navController,)

        }

    }
}