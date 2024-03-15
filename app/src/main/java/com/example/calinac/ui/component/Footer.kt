package com.example.calinac.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R

@Composable
fun Footer() {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.primary)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
                contentColor = colorResource(id = R.color.black)
            ),
            contentPadding = PaddingValues(vertical = 5.dp, horizontal = 25.dp),
            modifier = Modifier
                .width(275.dp)
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(R.string.footer_contact_text),
                fontSize = 12.sp,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 10.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.icons8_instagram_96___),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(45.dp)
                    .padding(horizontal = 5.dp)
            )
            Icon(
                painterResource(id = R.drawable.icons8_facebook_96___),
                contentDescription = "Account",
                modifier = Modifier
                    .size(45.dp)
                    .padding(horizontal = 5.dp)
            )
        }
    }
}