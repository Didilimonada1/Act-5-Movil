package com.example.practica05

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.practica05.data.PreferencesManager

@Composable
fun FormScreen() {

    val context = LocalContext.current
    val preferencesManager = remember {
        PreferencesManager(context)
    }
    var nombre by remember {
        mutableStateOf(
            preferencesManager.obtenerNombre()
        )
    }
    var modoOscuro by remember {
        mutableStateOf(
            preferencesManager.obtenerModoOscuro()
        )
    }
    var notificaciones by remember {
        mutableStateOf(
            preferencesManager.obtenerNotificaciones()
        )
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Configuración",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it

                    preferencesManager.guardarNombre(it)
                },
                label = {
                    Text("Nombre")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Modo oscuro"
                )
                Switch(
                    checked = modoOscuro,
                    onCheckedChange = {
                        modoOscuro = it

                        preferencesManager.guardarModoOscuro(it)
                    }
                )
            }
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Notificaciones"
                )
                Switch(
                    checked = notificaciones,
                    onCheckedChange = {
                        notificaciones = it

                        preferencesManager.guardarNotificaciones(it)
                    }
                )
            }
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Button(
                onClick = {
                    preferencesManager.guardarNombre(nombre)
                    preferencesManager.guardarModoOscuro(modoOscuro)
                    preferencesManager.guardarNotificaciones(notificaciones)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Guardar preferencias"
                )
            }
        }
    }
}
