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
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.calinac.CaliNacScreen
import com.example.calinac.R
import com.example.calinac.data.AnimalState
import com.example.calinac.data.ProfilState
import com.example.calinac.ui.component.AnimalIcon
import com.example.calinac.ui.component.Footer
import com.example.calinac.ui.component.Header
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun Account(
    state : ProfilState,
    animalState: AnimalState,
    profilModel: AccountViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.boy),
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .padding(top = 15.dp)

        )
        Text(
            text = state.username,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Coordonees(
            state.username,
            state.email,
            state.name,
            state.surName,
            state.phoneNumber,
            profilModel
        )
        Banque(
            state.rib,
            state.bank,
            profilModel
        )
        Contacts()
        Animaux(
            navController,
            animalState
        )
    }
}
@Composable
private fun Coordonees(
    username: String = "",
    email: String = "",
    name: String = "",
    surname: String = "",
    phone: String = "",
    profilModel: AccountViewModel = AccountViewModel()
) {
    var showPopup by remember {
        mutableStateOf(false)
    }

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
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
                IconButton(
                    onClick = { showPopup = true },
                    modifier = Modifier
                        .size(45.dp)
                ) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Modifier",
                    )
                }
            }
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.primary),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Nom d'utilisateur :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = username,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Adresse mail :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = email,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
            DashedDivider(
                color = Color.Black,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Nom :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = name,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Prénom :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = surname,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Numéro :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = phone,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
        }

    }
    PopupBox(popupWidth = 150.dp,
        popupHeight = 500.dp,
        showPopup = showPopup,
        onClickOutside = {showPopup = false},
        content = {
            EditCoordonnes(
                username,
                email,
                name,
                surname,
                phone,
                profilModel,
                onSave = {showPopup = false}
            )

        }
    )
}

@Composable
fun EditCoordonnes(
    username: String = "",
    email: String = "",
    name: String = "",
    surname: String = "",
    phone: String = "",
    profilModel: AccountViewModel = AccountViewModel(),
    onSave: () -> Unit = {}
){

    var username by remember {
        mutableStateOf(username)
    }
    var email by remember {
        mutableStateOf(email)
    }
    var name by remember {
        mutableStateOf(name)
    }
    var surname by remember {
        mutableStateOf(surname)
    }
    var phone by remember {
        mutableStateOf(phone)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        ),
        modifier = Modifier
            .padding(16.dp)
            .alpha(1f)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            EditStringField(
                label = R.string.username,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = username,
                onValueChanged = { username = it},
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditStringField(
                label = R.string.mail,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = email,
                onValueChanged = { email = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditStringField(
                label = R.string.name,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = name,
                onValueChanged = { name = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditStringField(
                label = R.string.surname,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = surname,
                onValueChanged = { surname = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditStringField(
                label = R.string.number,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = phone,
                onValueChanged = { phone = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = { profilModel.updateCoordonnees(
                    username = username,
                    email = email,
                    name = name,
                    surname = surname,
                    phone = phone
                ); onSave()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Enregistrer",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}





@Composable
private fun Banque(
    rib: String = "",
    banque: String = "",
    profilModel: AccountViewModel = AccountViewModel()
) {
    var showPopup by remember {
        mutableStateOf(false)
    }

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
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
                IconButton(
                    onClick = { showPopup = true },
                    modifier = Modifier
                        .size(45.dp)
                ) {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = "Modifier",
                    )
                }
            }
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.primary),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "RIB : ",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = rib,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Banque :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = banque,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
        }
    }
    PopupBox(popupWidth = 150.dp,
        popupHeight = 500.dp,
        showPopup = showPopup,
        onClickOutside = {showPopup = false},
        content = {
            EditBanque(
                rib,
                banque,
                profilModel,
                onSave = {showPopup = false}
            )

        }
    )
}

@Composable
fun EditBanque(
    rib: String = "",
    banque: String = "",
    profilModel: AccountViewModel = AccountViewModel(),
    onSave: () -> Unit = {}
){

    var rib by remember {
        mutableStateOf(rib)
    }
    var banque by remember {
        mutableStateOf(banque)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        ),
        modifier = Modifier
            .padding(16.dp)
            .alpha(1f)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            EditStringField(
                label = R.string.rib,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = rib,
                onValueChanged = { rib = it},
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditStringField(
                label = R.string.banque,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = banque,
                onValueChanged = { banque = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = { profilModel.updateBanque(
                    rib = rib,
                    banque = banque,
                ); onSave()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.primary),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Enregistrer",
                    fontWeight = FontWeight.Bold
                )
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
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Mes Contacts",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                )
            }
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.primary),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Référent Animal :",
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "Amélie Dupuis",
                    color = colorResource(id = R.color.primary),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .width(150.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "amélie.dupuis@gmail.com",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "06 00 00 00 00",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .width(150.dp)
                )
            }
            DashedDivider(
                color = Color.Black,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Référent Cali'Nac",
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "Victor dupont",
                    color = colorResource(id = R.color.primary),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .width(150.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "victor.dupont@gmail.com",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "07 00 00 00 00",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .width(150.dp)
                )
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Animaux(
    navController: NavController,
    animalState: AnimalState
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        ),

    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                FlowRow(
                    modifier = Modifier.padding(8.dp)
                ) {
                    AnimalIcon(
                        name = animalState.name, picture = R.drawable.snoopy ,
                        bgColor = R.color.primary, onClick = {navController.navigate(CaliNacScreen.Animal.name)}
                    )
                }

            }
        }
    }
}

@Composable
fun EditStringField(
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
fun EditCoordonneesPreview(){
    CaliNacTheme {
        EditCoordonnes()
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
        Animaux(
            navController = rememberNavController(),
            animalState = AnimalState()
        )
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
    popupWidth: Dp,
    popupHeight:Dp,
    showPopup: Boolean,
    onClickOutside: () -> Unit, content: @Composable() () -> Unit
) {
    if (showPopup) {
        // full screen background
        Dialog(
            onDismissRequest = { onClickOutside() })
        {
            Box(
                contentAlignment = Alignment.Center
            ) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PopupBoxPreview(){
    PopupBox(
        popupWidth = 150.dp,
        popupHeight = 500.dp,
        showPopup = true,
        onClickOutside = { /*TODO*/ }) {

    }
}