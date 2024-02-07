package com.example.deck_cards

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deck_cards.ui.theme.Deck_cardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Deck_cardsTheme {
                DeckCardAp()
            }
        }
    }
}

@Preview
@Composable
fun DeckCardAp() {
    DeckCardApDesignAndLogic(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DeckCardApDesignAndLogic(modifier: Modifier = Modifier) {
    var card by remember {
        mutableStateOf(1)
    }
    //    val imageResource = when (card) {
    //        1 -> R.drawable.k_1
    //        2 -> R.drawable.k_2
    //        3 -> R.drawable.k_3
    //        4 -> R.drawable.k_4
    //        5 -> R.drawable.k_5
    //        6 -> R.drawable.k_6
    //        7 -> R.drawable.k_7
    //        8 -> R.drawable.k_8
    //        9 -> R.drawable.k_9
    //        10 -> R.drawable.k_10
    //        11 -> R.drawable.k_11
    //        12 -> R.drawable.k_12
    //        13 -> R.drawable.k_13
    //        14 -> R.drawable.k_14
    //        15 -> R.drawable.k_15
    //        16 -> R.drawable.k_16
    //        17 -> R.drawable.k_17
    //        18 -> R.drawable.k_18
    //        19 -> R.drawable.k_19
    //        20 -> R.drawable.k_20
    //        21 -> R.drawable.k_21
    //        22 -> R.drawable.k_22
    //        23 -> R.drawable.k_23
    //        24 -> R.drawable.k_24
    //        25 -> R.drawable.k_25
    //        26 -> R.drawable.k_26
    //        27 -> R.drawable.k_27
    //        28 -> R.drawable.k_28
    //        29 -> R.drawable.k_29
    //        30 -> R.drawable.k_30
    //        31 -> R.drawable.k_31
    //        32 -> R.drawable.k_32
    //        33 -> R.drawable.k_33
    //        34 -> R.drawable.k_34
    //        35 -> R.drawable.k_35
    //        else -> R.drawable.k_36
    //    }
    val randomImage = (1..36).map { i ->
        painterResource(id = when (i) {
            in 1..35 -> R.drawable::class.java.getField("k_$i").getInt(null)
            else -> R.drawable.k_36
        })
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = randomImage[card - 1],
            contentDescription = "",
            modifier = Modifier
                .size(400.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { card = (1..36).random()},
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
        ) {
            Text(text = "Достать")

        }
    }
}