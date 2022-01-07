package com.example.sessions_clean.android.ui.navigation

const val ROOT_GRAPH_ROUTE = "root"
const val AUTH_GRAPH_ROUTE = "auth"
const val HOME_GRAPH_ROUTE = "home"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object AccountSelection: Screen(route = "account_selection")
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object RegisterCompany: Screen(route = "register_company_screen")
}

sealed class BottomSheet(val route: String) {
    object ProfileImageSelectAction: Screen(route = "profile_image_select_action")
}