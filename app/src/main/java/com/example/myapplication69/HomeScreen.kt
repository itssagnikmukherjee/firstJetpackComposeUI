package com.example.myapplication69

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication69.ui.theme.MyBlack
import com.example.myapplication69.ui.theme.MyGrey
import com.example.myapplication69.ui.theme.Purple40
import com.example.myapplication69.ui.theme.Purple80
import com.example.myapplication69.ui.theme.backgroundGradient
import com.example.myapplication69.ui.theme.darkGrey
import com.example.myapplication69.ui.theme.deepBlue
import com.example.myapplication69.ui.theme.forestGreen
import com.example.myapplication69.ui.theme.lightGrey
import com.example.myapplication69.ui.theme.myRed
import com.example.myapplication69.ui.theme.myYellow
import com.example.myapplication69.ui.theme.orangeGradient
import com.example.myapplication69.ui.theme.outfitFontFamily
import com.example.myapplication69.ui.theme.purpleGradient
import com.example.myapplication69.ui.theme.royalPurple
import com.example.myapplication69.ui.theme.sunsetOrange

data class FeaturedItemData(
    val bigTxt: String,
    val smlTxt: String,
    val img: Int,
    val color: Brush,
    val btnColor: Color
)

@Composable
fun HomeScreen() {
    Box(
        Modifier
            .background(backgroundGradient)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            GreetingSec()
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Meditation"))
            Current()
            FeaturedSec()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavBar()
        }
    }
}

@Composable
fun GreetingSec(name: String = "Sagnik") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp, start = 30.dp, end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Good Morning!",
                    fontSize = 22.sp,
                    fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = lightGrey
                )
                Text(
                    text = " $name",
                    fontSize = 30.sp,
                    fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = myYellow
                )
            }
            Text(
                text = "we wish you a good day ;)",
                fontSize = 18.sp,
                fontFamily = outfitFontFamily,
                fontWeight = FontWeight.Normal,
                color = lightGrey
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_search), contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(
        Modifier.padding(top = 20.dp)
    ) {
        items(chips.size) { index ->
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = index
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == index) myRed else sunsetOrange
                    )
            ) {
                Text(
                    text = chips[index],
                    color = if (selectedChipIndex == index) Color.White else lightGrey,
                    fontSize = 18.sp,
                    fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}

@Composable
fun Current() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(purpleGradient)
                .padding(20.dp, 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = "Daily Thought", fontSize = 22.sp, fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Bold, color = lightGrey
                )
                Text(
                    text = "Meditation • 3-10 min", fontSize = 18.sp, fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Normal, color = lightGrey
                )
            }
            Image(
                painter = painterResource(id = R.drawable.playbutton), contentDescription = "",
                Modifier.size(40.dp),
                colorFilter = ColorFilter.tint(Color.White),
            )
        }
    }
}

@Composable
fun FeaturedSec() {
    val featuredItems = listOf(
        FeaturedItemData("Sleep", "3-10 min", R.drawable.headphone, orangeGradient, lightGrey),
        FeaturedItemData("Relax", "5-15 min", R.drawable.headphone, purpleGradient, lightGrey),
        FeaturedItemData("Focus", "10-20 min", R.drawable.headphone, purpleGradient, lightGrey),
        FeaturedItemData("Energy", "5-10 min", R.drawable.headphone, orangeGradient, lightGrey),
        FeaturedItemData("Calm", "15-20 min", R.drawable.headphone, orangeGradient, lightGrey),
        FeaturedItemData("Joy", "10-15 min", R.drawable.headphone, purpleGradient, lightGrey)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth().padding(bottom = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Featured",
            color = Color.White,
            fontFamily = outfitFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(20.dp, 5.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .padding(bottom = 20.dp)
        ) {
            items(featuredItems.size) { index ->
                val item = featuredItems[index]
                FeaturedItem(
                    bigTxt = item.bigTxt,
                    smlTxt = item.smlTxt,
                    img = item.img,
                    color = item.color,
                    btnColor = item.btnColor
                )
            }
        }
    }
}

@Composable
fun FeaturedItem(bigTxt: String, smlTxt: String, img: Int, color: Brush,btnColor:Color) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(10.dp))
                .heightIn(170.dp)
                .width(180.dp)
                .background(color)
                .padding(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = bigTxt,
                    color = lightGrey,
                    fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Text(
                    text = smlTxt,
                    color = Color.White,
                    fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(btnColor),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Start", color = darkGrey, fontSize = 16.sp,
                            fontFamily = outfitFontFamily,
                            fontWeight = FontWeight.Bold)
                    }
                    Image(
                        painter = painterResource(id = img), contentDescription = "",
                        modifier = Modifier.size(32.dp),
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavBar() {
    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),  // Set your desired height here
        backgroundColor = MyGrey,
        contentColor = Color.White,
        elevation = 10.dp
    ) {
       Row (
           modifier = Modifier.padding(20.dp,10.dp)
       ){
           BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
               Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home",
                   modifier = Modifier.size(40.dp),
                   tint = lightGrey)
           })
           BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
               Icon(painter = painterResource(id = R.drawable.heart), contentDescription = "Home",
                   modifier = Modifier.size(40.dp))
           })
           BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
               Icon(painter = painterResource(id = R.drawable.music), contentDescription = "Home",
                   modifier = Modifier.size(40.dp))
           })
           BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
               Icon(painter = painterResource(id = R.drawable.setting), contentDescription = "Home",
                   modifier = Modifier.size(40.dp))
           })
       }
    }
}
