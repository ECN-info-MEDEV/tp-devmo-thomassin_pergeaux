package com.example.calinac.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.data.AnimalState
import com.example.calinac.data.ProfilState
import com.example.calinac.ui.component.AnimalIcon
import com.example.calinac.ui.theme.CaliNacTheme

// Dans le cadre du TP, on ne vas travailler qu'avec un seul animal, on ne va donc pas créer de BDD

@Composable
fun AnimalSheet(
    state : AnimalState,
    animalModel: AnimalViewModel,
    canEdit: Boolean,
    onBack: () -> Unit = {},
    ){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    start = 5.dp,
                    end = 5.dp
                )
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(25.dp)
            ) {
                Icon(
                    Icons.Sharp.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = state.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Icon(
                Icons.Sharp.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .alpha(0f)
            )
        }
        Divider(
            color = colorResource(id = R.color.primary),
            thickness = 2.dp,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 20.dp
                )
        )
        AnimalInfos(
            canEdit,
            state.name,
            state.weight,
            state.age,
            state.gender,
            state.breed,
            animalModel
        )
        AnimalPictures()
    }

}

@Composable
fun AnimalInfos(
    canEdit: Boolean,
    name: String,
    weight: Int,
    age: Int,
    gender: String,
    breed: String,
    animalModel: AnimalViewModel
){
    var showPopup by remember {
        mutableStateOf(false)
    }

    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (canEdit) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(35.dp)
                            .alpha(0f)
                            .padding(
                                start = 10.dp
                            )
                    ) {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = "Modifier",
                        )
                    }
                }
                var modifier: Modifier = Modifier
                if (!canEdit) {
                    modifier = Modifier.fillMaxWidth()
                }

                Text(
                    text = "Informations",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                )
                if (canEdit) {
                    IconButton(
                        onClick = { showPopup = true },
                        modifier = Modifier
                            .size(35.dp)
                            .padding(
                                end = 10.dp
                            )
                    ) {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = "Modifier",
                        )
                    }
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
                    text = "Poids :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "$weight kg",
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
                    text = "Age :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = "$age mois",
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
                    text = "Sexe :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = gender,
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
                    text = "Race :",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 5.dp)
                )
                Text(
                    text = breed,
                    modifier = Modifier
                        .width(175.dp)
                )
            }
        }
        PopupBox(popupWidth = 150.dp,
            popupHeight = 500.dp,
            showPopup = showPopup,
            onClickOutside = {showPopup = false},
            content = {
                EditInfos(
                    name,
                    weight,
                    age,
                    gender,
                    breed,
                    animalModel,
                    onSave = {showPopup = false}
                )

            }
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AnimalPictures(){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        ),
        modifier = Modifier
            .padding(
                vertical = 15.dp
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Photos",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
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
                    AnimalPicture()
                    AnimalPicture()
                    AnimalPicture()
                    AnimalPicture()
                    AnimalPicture()
                    AnimalPicture()
                    AnimalPicture()
                    AnimalPicture()

                }

            }
        }
    }
}

@Composable
fun AnimalPicture(){
    Image(
        painter = painterResource(id = R.drawable.snoopy),
        contentDescription = "pictures",
        modifier = Modifier
            .width(150.dp)
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp
            )
    )
}

@Composable
fun EditInfos(
    name: String = "",
    weight: Int = 0,
    age: Int =0,
    gender: String = "",
    breed: String = "",
    animalModel: AnimalViewModel = AnimalViewModel(),
    onSave: () -> Unit = {}
){

    var name by remember {
        mutableStateOf(name)
    }
    var weight by remember {
        mutableStateOf(weight)
    }
    var age by remember {
        mutableStateOf(age)
    }
    var gender by remember {
        mutableStateOf(gender)
    }
    var breed by remember {
        mutableStateOf(breed)
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
            EditField(
                label = R.string.name,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = name,
                onValueChanged = { name = it},
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditField(
                label = R.string.poids_kg,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = weight.toString(),
                onValueChanged = { if(it == ""){weight = 0} else {weight = it.toInt()} },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditField(
                label = R.string.age_mois,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = age.toString(),
                onValueChanged = { if(it == ""){age = 0} else {age = it.toInt()} },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditField(
                label = R.string.sexe,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                value = gender.toString(),
                onValueChanged = { gender = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            EditField(
                label = R.string.race,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                value = breed.toString(),
                onValueChanged = { breed = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = { animalModel.updateInfos(
                    name, weight, age, gender, breed
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
fun EditField(
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
fun AnimalSheetPreview(){
    CaliNacTheme {
        AnimalSheet(state = AnimalState(), animalModel = AnimalViewModel(), canEdit = true)
    }
}