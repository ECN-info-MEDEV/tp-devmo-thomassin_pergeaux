package com.example.calinac.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.ui.component.AnimalIcon
import com.example.calinac.ui.theme.CaliNacTheme
import org.w3c.dom.Text

@Composable
fun Adopt(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Adopter un animal",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.secondary)
            ),
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 10.dp
                )
        ) {
            Text(
                text = "Informations",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(
                        bottom = 5.dp,
                        top = 15.dp,
                        start = 15.dp,
                        end = 15.dp
                    )
            )
            Text(
                text = "Attention, l'adoption est une décision importante !",
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(
                        bottom = 5.dp,
                        top = 5.dp,
                        start = 5.dp,
                        end = 5.dp
                    )
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp,
                        vertical = 10.dp
                    )
            ) {
                Text(
                    text = "Adopter un animal",
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Text(
            text = "Animaux en attente d'adoption",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , color = R.color.secondary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdoptPreview(){
    CaliNacTheme {
        Adopt()
    }
}