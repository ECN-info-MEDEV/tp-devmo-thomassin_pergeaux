package com.example.calinac.ui


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun Homepage(){
    Text(
        text = "Hello World !",
        fontSize = 32.sp,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .wrapContentSize(
                Alignment.Center
            ),
    )
}

@Preview(showBackground = true)
@Composable
fun HomepagePreview(){
    CaliNacTheme {
        Homepage()
    }
}