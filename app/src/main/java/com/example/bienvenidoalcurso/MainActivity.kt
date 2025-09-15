package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item { Text("CONTENEDORES", style = MaterialTheme.typography.headlineMedium) }
                    item { LazyColumnExample() }
                    item { LazyRowExample() }
                    item { GridExample() }
                    item { ConstraintLayoutExample() }
                    item { ScaffoldExample() }
                    item { SurfaceExample() }
                    item { ChipExample() }
                    item { BackdropScaffoldExample() }
                    item { FlowRowExample() }
                    item { FlowColumnExample() }

                    item { Text("CONTROLES", style = MaterialTheme.typography.headlineMedium) }
                    item { AlertDialogExample() }
                    item { CardExample() }
                    item { CheckboxExample() }
                    item { FloatingActionButtonExample() }
                    item { IconExample() }
                    item { ImageExample() }
                    item { ProgressBarExample() }
                    item { RadioButtonExample() }
                    item { SliderExample() }
                    item { SpacerExample() }
                    item { SwitchExample() }
                    item { TopAppBarExample() }
                    item { BottomNavigationExample() }
                    item { DialogExample() }
                    item { DividerExample() }
                    item { DropDownMenuExample() }
                    item { LazyVerticalGridExample() }
                    item { NavigationRailExample() }
                    item { OutlinedTextFieldExample() }
                    item { PagerExample() }
                    item { SnackbarExample() }
                    item { TabRowExample() }
                    item { TooltipExample() }
                }
            }
        }
    }
}

// CONTENEDORES
@Composable
fun LazyColumnExample() {
    Text("LazyColumn - Lista vertical")
    LazyColumn(modifier = Modifier.height(80.dp)) {
        items(3) { Text("Item $it") }
    }
}

@Composable
fun LazyRowExample() {
    Text("LazyRow - Lista horizontal")
    LazyRow {
        items(3) {
            Card(modifier = Modifier.padding(4.dp).size(50.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("$it")
                }
            }
        }
    }
}

@Composable
fun GridExample() {
    Text("Grid - Cuadrícula")
    Row {
        repeat(3) {
            Card(modifier = Modifier.padding(2.dp).size(40.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("$it")
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutExample() {
    Text("ConstraintLayout - Layout con restricciones")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Inicio")
        Text("Fin")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Text("Scaffold - Estructura de pantalla")
    Box(modifier = Modifier.height(80.dp)) {
        Scaffold(topBar = { TopAppBar(title = { Text("App") }) }) {
            Box(modifier = Modifier.padding(it)) { Text("Contenido") }
        }
    }
}

@Composable
fun SurfaceExample() {
    Text("Surface - Superficie con elevación")
    Surface(modifier = Modifier.fillMaxWidth().height(40.dp), shadowElevation = 4.dp) {
        Box(contentAlignment = Alignment.Center) { Text("Surface") }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipExample() {
    Text("Chip - Elemento seleccionable")
    AssistChip(onClick = {}, label = { Text("Chip") })
}

@Composable
fun BackdropScaffoldExample() {
    Text("BackdropScaffold - Scaffold con fondo")
    Box(modifier = Modifier.fillMaxWidth().height(40.dp)) {
        Text("BackdropScaffold (simulado)")
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowExample() {
    Text("FlowRow - Fila que fluye")
    FlowRow {
        repeat(4) {
            Card(modifier = Modifier.padding(2.dp)) {
                Text("Item $it", modifier = Modifier.padding(4.dp))
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnExample() {
    Text("FlowColumn - Columna que fluye")
    FlowColumn(modifier = Modifier.height(60.dp)) {
        repeat(4) {
            Card(modifier = Modifier.padding(2.dp)) {
                Text("$it", modifier = Modifier.padding(4.dp))
            }
        }
    }
}

// CONTROLES
@Composable
fun AlertDialogExample() {
    var show by remember { mutableStateOf(false) }
    Text("AlertDialog - Diálogo de alerta")
    Button(onClick = { show = true }) { Text("Mostrar") }
    if (show) {
        AlertDialog(
            onDismissRequest = { show = false },
            title = { Text("Título") },
            text = { Text("Mensaje") },
            confirmButton = { Button(onClick = { show = false }) { Text("OK") } }
        )
    }
}

@Composable
fun CardExample() {
    Text("Card - Tarjeta")
    Card(modifier = Modifier.fillMaxWidth()) {
        Text("Contenido de la card", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    Text("Checkbox - Casilla")
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text("Opción")
    }
}

@Composable
fun FloatingActionButtonExample() {
    Text("FloatingActionButton - Botón flotante")
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

@Composable
fun IconExample() {
    Text("Icon - Icono")
    Row {
        Icon(Icons.Default.Home, contentDescription = "Home")
        Icon(Icons.Default.Star, contentDescription = "Star")
    }
}

@Composable
fun ImageExample() {
    Text("Image - Imagen")
    Icon(Icons.Default.AccountCircle, contentDescription = "Image", modifier = Modifier.size(50.dp))
}

@Composable
fun ProgressBarExample() {
    Text("ProgressBar - Barra de progreso")
    Column {
        LinearProgressIndicator(progress = { 0.7f })
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator()
    }
}

@Composable
fun RadioButtonExample() {
    var selected by remember { mutableStateOf(0) }
    Text("RadioButton - Botón de radio")
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == 0, onClick = { selected = 0 })
            Text("Opción 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected == 1, onClick = { selected = 1 })
            Text("Opción 2")
        }
    }
}

@Composable
fun SliderExample() {
    var value by remember { mutableStateOf(50f) }
    Text("Slider - Control deslizante")
    Slider(value = value, onValueChange = { value = it }, valueRange = 0f..100f)
}

@Composable
fun SpacerExample() {
    Text("Spacer - Espacio")
    Text("Texto 1")
    Spacer(modifier = Modifier.height(16.dp))
    Text("Texto 2")
}

@Composable
fun SwitchExample() {
    var switched by remember { mutableStateOf(false) }
    Text("Switch - Interruptor")
    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(checked = switched, onCheckedChange = { switched = it })
        Text(if (switched) "ON" else "OFF")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    Text("TopAppBar - Barra superior")
    TopAppBar(title = { Text("Título") })
}

@Composable
fun BottomNavigationExample() {
    Text("BottomNavigation - Navegación inferior")
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
    }
}

@Composable
fun DialogExample() {
    var show by remember { mutableStateOf(false) }
    Text("Dialog - Diálogo")
    Button(onClick = { show = true }) { Text("Mostrar") }
    if (show) {
        AlertDialog(
            onDismissRequest = { show = false },
            title = { Text("Dialog") },
            confirmButton = { Button(onClick = { show = false }) { Text("Cerrar") } }
        )
    }
}

@Composable
fun DividerExample() {
    Text("Divider - Divisor")
    Text("Arriba")
    HorizontalDivider()
    Text("Abajo")
}

@Composable
fun DropDownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    Text("DropDownMenu - Menú desplegable")
    Box {
        Button(onClick = { expanded = true }) { Text("Menú") }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Opción 1") }, onClick = { expanded = false })
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    Text("LazyVerticalGrid - Cuadrícula vertical")
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.height(80.dp)) {
        items(4) {
            Card(modifier = Modifier.padding(2.dp)) {
                Text("$it", modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun NavigationRailExample() {
    Text("NavigationRail - Barra de navegación lateral")
    NavigationRail(modifier = Modifier.width(60.dp)) {
        NavigationRailItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
        )
    }
}

@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    Text("OutlinedTextField - Campo de texto")
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Escribe") }
    )
}

@Composable
fun PagerExample() {
    Text("Pager - Paginador")
    Text("(Simulación de páginas)")
    Row {
        repeat(3) {
            Card(modifier = Modifier.padding(2.dp).size(30.dp)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("$it")
                }
            }
        }
    }
}

@Composable
fun SnackbarExample() {
    Text("Snackbar - Mensaje temporal")
    Snackbar { Text("Mensaje de Snackbar") }
}

@Composable
fun TabRowExample() {
    var selected by remember { mutableStateOf(0) }
    Text("TabRow - Fila de pestañas")
    TabRow(selectedTabIndex = selected) {
        Tab(selected = selected == 0, onClick = { selected = 0 }, text = { Text("Tab 1") })
        Tab(selected = selected == 1, onClick = { selected = 1 }, text = { Text("Tab 2") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipExample() {
    Text("Tooltip - Información emergente")
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = { PlainTooltip { Text("Tooltip") } },
        state = rememberTooltipState()
    ) {
        Button(onClick = {}) { Text("Hover") }
    }
}

@Preview
@Composable
fun Preview() {
    MaterialTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { Text("CONTENEDORES", style = MaterialTheme.typography.headlineMedium) }
            item { LazyColumnExample() }
            item { LazyRowExample() }
            item { GridExample() }
            item { ConstraintLayoutExample() }
            item { ScaffoldExample() }
            item { SurfaceExample() }
            item { ChipExample() }
            item { BackdropScaffoldExample() }
            item { FlowRowExample() }
            item { FlowColumnExample() }

            item { Text("CONTROLES", style = MaterialTheme.typography.headlineMedium) }
            item { AlertDialogExample() }
            item { CardExample() }
            item { CheckboxExample() }
            item { FloatingActionButtonExample() }
            item { IconExample() }
            item { ImageExample() }
            item { ProgressBarExample() }
            item { RadioButtonExample() }
            item { SliderExample() }
            item { SpacerExample() }
            item { SwitchExample() }
            item { TopAppBarExample() }
            item { BottomNavigationExample() }
            item { DialogExample() }
            item { DividerExample() }
            item { DropDownMenuExample() }
            item { LazyVerticalGridExample() }
            item { NavigationRailExample() }
            item { OutlinedTextFieldExample() }
            item { PagerExample() }
            item { SnackbarExample() }
            item { TabRowExample() }
            item { TooltipExample() }
        }
    }
}