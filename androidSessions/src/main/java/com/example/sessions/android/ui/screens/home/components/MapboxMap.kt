package com.example.sessions.android.ui.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.sessions.android.R
import com.example.sessions.android.ui.theme.LocalDarkMode
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions

@Composable
fun MapboxMap() {
    val mapView = rememberMap(0.0, 0.0)
    val accessToken = stringResource(R.string.mapbox_access_token)

    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize(),
        update = {}
    )
}

@Composable
private fun rememberMap(latitude: Double, longitude: Double): MapView {
    val accessToken = stringResource(R.string.mapbox_access_token)
    val context = LocalContext.current
    val isDarkTheme = LocalDarkMode.current

    val mapView = remember {
        MapView(context).apply {
            val mapBoxMap = this.getMapboxMap()

            mapBoxMap.loadStyleUri(if (isDarkTheme) Style.DARK else Style.LIGHT)

            mapBoxMap.setCamera(
                cameraOptions = cameraOptions {
                    center(Point.fromLngLat(longitude, latitude))
                    zoom(6.0)
                }
            )
        }
    }

    return mapView
}