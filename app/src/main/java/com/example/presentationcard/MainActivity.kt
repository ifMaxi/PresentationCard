package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.Orange
import com.example.presentationcard.ui.theme.Orange300
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentationCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LogoTitle()
                }
            }
        }
    }
}

@Composable
fun LogoTitle(
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.android_logo)

    Column(
        modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Orange300, Orange)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier
                .size(170.dp)
        )
        Text(
            text = stringResource(id = R.string.name_last),
            fontSize = 34.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 25.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier.padding(20.dp))
        InformationText(
            email = stringResource(id = R.string.mail), 
            country = stringResource(id = R.string.country), 
            github = stringResource(id = R.string.github)
        )
    }
}

@Composable
fun InformationText(
    email: String,
    country: String,
    github: String
) {
    val space = Modifier.padding(8.dp)
    val largeSpace = Modifier.padding(20.dp)

    Row(
        modifier = Modifier
            .width(250.dp)
    ) {
        Icon(
            Icons.Rounded.Mail,
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = largeSpace)
        Text(text = email)
    }
    Spacer(modifier = space)
    Row(
        modifier = Modifier
            .width(250.dp)
    ) {
        Icon(
            Icons.Rounded.Language,
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = largeSpace)
        Text(text = country)
    }
    Spacer(modifier = space)
    Row(
        modifier = Modifier
            .width(250.dp)
    ) {
        Icon(
            Icons.Rounded.Share,
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = largeSpace)
        Text(text = github)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PresentationCardTheme {
        LogoTitle()
    }
}