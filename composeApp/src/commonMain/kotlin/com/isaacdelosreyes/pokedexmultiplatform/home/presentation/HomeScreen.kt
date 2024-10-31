package com.isaacdelosreyes.pokedexmultiplatform.home.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.isaacdelosreyes.pokedexmultiplatform.core.utils.gridItems
import com.isaacdelosreyes.pokedexmultiplatform.ui.theme.WhiteSmoke
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.getKoin
import pokedexmultiplatform.composeapp.generated.resources.Res
import pokedexmultiplatform.composeapp.generated.resources.pokeball_image

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel: HomeViewModel = getKoin().get()
    val state = viewModel.state

    if (!state.isLoading) {

        Box(modifier = modifier.fillMaxSize().background(color = Color.White)) {

            Image(
                painter = painterResource(Res.drawable.pokeball_image),
                contentDescription = null,
                colorFilter = ColorFilter.tint(WhiteSmoke),
                modifier = Modifier.size(300.dp)
                    .align(Alignment.TopEnd)
                    .offset {
                        IntOffset(240, -200)
                    }
            )

            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(24.dp)
            ) {

                stickyHeader {

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Pokedex",
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }

                gridItems(
                    data = state.pokemons,
                    columns = 2,
                    key = { it.name },
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        AsyncImage(
                            model = it.sprites.other.officialArtwork.frontDefault,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = it.name.replaceFirstChar {
                                it.uppercase()
                            }
                        )
                    }
                }
            }
        }

    } else {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading...")
        }
    }
}