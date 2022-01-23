package com.example.sessions.android.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.sessions.android.R
import com.example.sessions.android.ui.theme.LocalDarkMode
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.dsl.cameraOptions

@Composable
fun MapboxMap() {
    val mapView = MapView()
    val isDarkTheme = LocalDarkMode.current
    val accessToken = stringResource(R.string.mapbox_access_token)

    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize()
    ) { mapView ->
        mapView.getMapboxMap()
            .apply {
                cameraOptions {
                    zoom(19.0)
                }
                loadStyleUri(
                    if (isDarkTheme)
                        "mapbox://styles/jonaslevin/cktycnfii0uvd17rzw3er2oas?access_token=$accessToken"
                    else
                        "mapbox://styles/jonaslevin/cku13hqcd23if17phlvyl5lo4?access_token=$accessToken"
                )
            }
    }
}


@Composable
private fun MapView(): MapView {
    val accessToken = stringResource(R.string.mapbox_access_token)
    val context = LocalContext.current
    val isDarkTheme = LocalDarkMode.current

    val options = MapInitOptions(
        context,
    )

    return MapView(context, options)
}