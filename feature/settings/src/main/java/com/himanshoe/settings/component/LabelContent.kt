package com.himanshoe.settings.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.himanshoe.settings.ui.SettingsViewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun LabelContent(
    settingsViewModel: SettingsViewModel,
    onLocationClick: () -> Unit,
    onPinCodeClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val locationState = settingsViewModel.location.observeAsState()
    val phoneNumber = settingsViewModel.phoneNumber .observeAsState()
    val districtPinCode = settingsViewModel.districtPinCode.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        LocationItem(locationState, onLocationClick)
        DistrictItem(districtPinCode, onPinCodeClick)
        LoginItem(phoneNumber, onLoginClick)
        DownloadCertificate(viewModel = settingsViewModel) {

        }
        DeveloperItem()
    }
}

@Composable
fun LoginItem(phoneNumber: State<String?>, onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onLoginClick()
            }

    ) {
        Text(
            text = "Login via mobile to download certificate",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(1.dp))

        Text(
            text = phoneNumber.value ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Divider(Modifier.height(1.dp))

    }
}

@Composable
fun DistrictItem(districtPinCode: State<String?>, onPinCodeClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onPinCodeClick()
            }

    ) {
        Text(
            text = "Your pin code",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(1.dp))

        Text(
            text = districtPinCode.value ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Divider(Modifier.height(1.dp))

    }
}

@Composable
private fun LocationItem(pinCodeState: State<String?>, onLocationClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onLocationClick()
            }

    ) {
        Text(
            text = "Location",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(1.dp))

        Text(
            text = pinCodeState.value ?: "-",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Divider(Modifier.height(1.dp))

    }
}

@Composable
private fun DeveloperItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = "Contributors",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(1.dp))

        Text(
            text = "Himanshu Singh (Twitter: @hi_man_shoe)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(10.dp))

        Text(
            text = "Rohan Shah (LinkedIn: @rohanrshah)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(10.dp))

        Text(
            text = "Gurupreet singh (Twitter: @_gurupreet)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "Sutirth Chakravarty (Twitter: @Sutirth)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, top = 2.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Divider(Modifier.height(1.dp))
    }
}
