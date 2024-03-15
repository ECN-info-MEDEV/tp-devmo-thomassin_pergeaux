package com.example.calinac.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.calinac.R

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.primary)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Icon(
            Icons.Outlined.Menu,
            contentDescription = "Menu",
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp)
        )
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
        )
        Icon(
            Icons.Outlined.AccountCircle,
            contentDescription = "Account",
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp)
        )
    }
}