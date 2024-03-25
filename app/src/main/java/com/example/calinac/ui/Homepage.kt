package com.example.calinac.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.ui.theme.CaliNacTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Homepage(
    modifier: Modifier = Modifier,
    goToAdopt: () -> Unit = {}
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()

    ) {
        Text(
            text = stringResource(R.string.AssoName),
            fontSize = 40.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    bottom = 15.dp,
                    top = 15.dp,
                    start = 15.dp,
                    end = 15.dp
                )
        )
        Text(
            text = "Association nantaise de protection animale",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    bottom = 10.dp,
                    start = 10.dp,
                    end = 10.dp
                )
        )
        Text(
            text = "Lapins & Rongeurs",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.text_secondary),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    bottom = 25.dp
                )
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.secondary)
            ),
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 25.dp
                )
        ) {
            Column {
                Text(
                    text = "Nous aider",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .padding(
                            bottom = 15.dp,
                            top = 15.dp,
                            start = 15.dp,
                            end = 15.dp
                        )
                )
                Button(
                    onClick = goToAdopt,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 25.dp
                        )
                ) {
                    Text(
                        text = "Adopter un animal",
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 25.dp
                        )
                ) {
                    Text(
                        text = "Devenir famille d'accueil",
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 25.dp
                        )
                ) {
                    Text(
                        text = "Faire un don",
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 25.dp,
                            end = 25.dp,
                            bottom = 15.dp
                        )
                ) {
                    Text(
                        text = "Parrainer un animal",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Newsletter()


    }
}

@Composable
fun Newsletter(){
    var news_mail by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(
                align = Alignment.CenterHorizontally
            )
    ) {
        Text(
            text = "Recevoir notre newsletter trimestrielle",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 10.dp
                )
        )
        OutlinedTextField(
            value = news_mail,
            placeholder = { Text(text = "e.g. email@example.com")},
            onValueChange = {news_mail = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 25.dp,
                    vertical = 5.dp
                )
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary),
                contentColor = colorResource(id = R.color.white)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 25.dp
                )
        ) {
            Text(
                text = "Je m'inscris",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomepagePreview(){
    CaliNacTheme {
        Homepage()
    }
}

@Preview(showBackground = true)
@Composable
fun NewsletterPreview(){
    CaliNacTheme {
        Newsletter()
    }
}