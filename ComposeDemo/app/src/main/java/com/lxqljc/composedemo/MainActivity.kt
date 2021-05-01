package com.lxqljc.composedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.height
import androidx.ui.layout.padding
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NewsStory() }
    }

    @Composable
    fun Greeting(name: String) {

        Text(text = "hello , $name !");
    }

    @Preview
    @Composable
    fun NewsStory() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(180.dp),
                contentScale = ContentScale.Crop,
                painter = ImagePainter(imageResource(R.drawable.header))
            )
            Spacer (Modifier.padding(10.dp))
            Text("简单爱", style = TextStyle(fontSize = TextUnit.Sp(16)))
            Text("爱在西元前", style = TextStyle(fontSize = TextUnit.Sp(16)))
            Text("七里香", style = TextStyle(fontSize = TextUnit.Sp(16)))
        }
    }
}