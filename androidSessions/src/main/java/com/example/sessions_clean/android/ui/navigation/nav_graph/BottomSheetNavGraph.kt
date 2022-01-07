package com.example.sessions_clean.android.ui.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import com.example.sessions_clean.android.ui.navigation.BottomSheet
import com.example.sessions_clean.android.ui.screens.bottom_sheets.ProfileImageSelectAction
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet

@ExperimentalMaterialNavigationApi
fun NavGraphBuilder.bottomSheetNavGraph() {
    bottomSheet(route = BottomSheet.ProfileImageSelectAction.route) {
        ProfileImageSelectAction()
    }
}