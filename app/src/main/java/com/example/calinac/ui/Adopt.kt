package com.example.calinac.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.ui.component.AnimalIcon
import com.example.calinac.ui.theme.CaliNacTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Adopt(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
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
            ExternalButton(
                url = "https://forms.gle/3jVDRtm3o62ooz9d7",
                text = "Adopter un animal"
            )
        }
        Text(
            text = "Animaux en attente d'adoption",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            FlowRow(
                modifier = Modifier.padding(8.dp)
            ) {
                AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
                AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
                AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
                AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
                AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
                AnimalIcon(name = "Snoopy", picture = R.drawable.snoopy , bgColor = R.color.secondary)
            }

        }
    }
}

@Composable
fun ExternalButton(
    url: String,
    text: String
){
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(url)) }

    Button(
        onClick = {context.startActivity(intent)},
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
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdoptPreview(){
    CaliNacTheme {
        Adopt()
    }
}