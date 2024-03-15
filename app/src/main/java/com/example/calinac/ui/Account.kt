package com.example.calinac.ui

import android.accounts.Account
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun Account() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.icons8_instagram_96___),
            contentDescription = null,
            modifier = Modifier.width(300.dp)

        )
        Text(
            text = "Nom d'utilisateur",
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Card (
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.secondary)
            )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        Icons.Outlined.Menu,
                        contentDescription = "Modifier",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp)
                            .alpha(0f)
                    )
                    Text(
                        text = "Mes coordonnées",
                        fontSize = 20.sp,
                        modifier = Modifier
                    )
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Modifier",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp)
                    )
                }
                Divider(
                    thickness = 2.dp,
                    color = colorResource(id = R.color.primary),
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                )
                Row {
                    Text(
                        text = "Nom d'utilisateur :",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    /* TODO */
                }
                Row {
                    Text(
                        text = "Adresse mail :",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    /* TODO */
                }
                DashedDivider(
                    color = Color.Black,
                    thickness = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AccountPreview(){
    CaliNacTheme {
        Account()
    }
}
@Preview (showBackground = true)
@Composable
private fun DashedDividerPreview() {
    DashedDivider(
        color = Color.Black,
        thickness = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun DashedDivider(
    thickness: Dp,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    phase: Float = 10f,
    intervals: FloatArray = floatArrayOf(10f, 10f),
    modifier: Modifier
) {
    Canvas(
        modifier = modifier
    ) {
        val dividerHeight = thickness.toPx()
        drawRoundRect(
            color = color,
            style = Stroke(
                width = dividerHeight,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = intervals,
                    phase = phase
                )
            )
        )
    }
}