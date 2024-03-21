package com.example.calinac.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calinac.R
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun AnimalIcon(
    name: String,
    picture: Int,
    bgColor: Int = R.color.secondary
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = bgColor)
        ),
        modifier = Modifier
            .padding(
                start = 15.dp,
                end = 15.dp,
                bottom = 10.dp,
                top = 10.dp
            )
            .width(120.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = picture),
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp,
                            end = 10.dp,
                            top = 10.dp
                        )
                )
            }

            Text(
                text = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
                    .padding(
                        bottom = 5.dp
                    )
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalIconPreview(){
    CaliNacTheme {
        AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
    }
}

