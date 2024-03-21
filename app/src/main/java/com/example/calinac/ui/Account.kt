package com.example.calinac.ui

import android.accounts.Account
import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import com.example.calinac.R
import com.example.calinac.ui.component.Footer
import com.example.calinac.ui.component.Header
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun Account() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
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
        Coordonees()
        Banque()
        Contacts()
        Animaux()
    }
}
@Composable
private fun Coordonees() {
    var username by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var showPopup by rememberSaveable { mutableStateOf(false) }
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                IconButton(onClick = { showPopup = true }) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Modifier",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp)
                    )
                }
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
            Row {
                Text(
                    text = "Nom :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                /* TODO */
            }
            Row {
                Text(
                    text = "Prénom :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                /* TODO */
            }
            Row {
                Text(
                    text = "Numéro :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                /* TODO */
            }
        }
        PopupBox(popupWidth = 350F,
            popupHeight = 500F,
            showPopup = showPopup,
            onClickOutside = {showPopup = false},
            content = {
                Column {
                    EditNumberField(
                        label = R.string.username,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        value = username,
                        onValueChanged = { username = it },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                            .fillMaxWidth()
                    )
                    EditNumberField(
                        label = R.string.mail,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        value = mail,
                        onValueChanged = { mail = it },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                            .fillMaxWidth()
                    )
                    EditNumberField(
                        label = R.string.name,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        value = name,
                        onValueChanged = { name = it },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                            .fillMaxWidth()
                    )
                    EditNumberField(
                        label = R.string.surname,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        value = surname,
                        onValueChanged = { surname = it },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                            .fillMaxWidth()
                    )
                    EditNumberField(
                        label = R.string.number,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        value = number,
                        onValueChanged = { number = it },
                        modifier = Modifier
                            .padding(bottom = 32.dp)
                            .fillMaxWidth()
                    )
                }
            }
        )
    }
}

@Composable
private fun Banque() {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                    text = "Informations bancaires",
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
                    text = "RIB : ",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                /* TODO */
            }
            Row {
                Text(
                    text = "Banque :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                /* TODO */
            }
        }
    }
}

@Composable
private fun Contacts() {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                    text = "Mes Contacts",
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
                    text = "Référent Animal :",
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
            Row {
                Text(
                    text = "Référent Cali'Nac",
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
            Row {
                Text(
                    text = "Cabinet vétérinaire :",
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
            Row {
                Text(
                    text = "Urgence :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                /* TODO */
            }
        }
    }
}

@Composable
private fun Animaux() {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        )
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                    text = "Mes Animaux",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                )
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.primary),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Row {

            }
            Row {

            }
            Row {

            }
            Row {

            }
        }
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions
    )
}
@Preview(showBackground = true)
@Composable
fun CoordonneesPreview(){
    CaliNacTheme {
        Coordonees()
    }
}

@Preview(showBackground = true)
@Composable
fun BanquesPreview(){
    CaliNacTheme {
        Banque()
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsPreview(){
    CaliNacTheme {
        Contacts()
    }
}

@Preview(showBackground = true)
@Composable
fun AnimauxPreview(){
    CaliNacTheme {
        Animaux()
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
    intervals: FloatArray = floatArrayOf(20f, 20f),
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

@Composable
fun PopupBox(
    popupWidth: Float,
    popupHeight:Float,
    showPopup: Boolean,
    onClickOutside: () -> Unit, content: @Composable() () -> Unit
) {
    if (showPopup) {
        // full screen background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue.copy(alpha = 0.5F))
                .zIndex(50F)
                .wrapContentWidth()
                .clip(RoundedCornerShape(5.dp)),
            contentAlignment = Alignment.Center
        ) {
            // popup
            Popup(
                alignment = Alignment.Center,
                properties = PopupProperties(
                    excludeFromSystemGesture = true,
                ),
                // to dismiss on click outside
                onDismissRequest = { onClickOutside() }
            ) {
                Box(
                    Modifier
                        .width(popupWidth.dp)
                        .height(popupHeight.dp)
                        .background(colorResource(id = R.color.primary)),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PopupBoxPreview(){
    PopupBox(
        popupWidth = 300F,
        popupHeight = 300F,
        showPopup = true,
        onClickOutside = { /*TODO*/ }) {

    }
}