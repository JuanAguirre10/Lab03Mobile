# Exploración de Componentes Android - Jetpack Compose

Este proyecto demuestra el uso de 31 componentes básicos de Jetpack Compose, organizados en **Contenedores** y **Controles**.

## Estructura del Proyecto

```
MainActivity.kt - Contiene todos los componentes
└── Función para cada componente
    ├── 10 Contenedores
    └── 21 Controles

## CONTENEDORES

### 1. LazyColumn
**Descripción:** Lista vertical que solo renderiza elementos visibles en pantalla (lazy loading).
**Uso:** Para mostrar listas largas de datos de manera eficiente.
**Características:**
- Solo carga elementos visibles
- Scroll vertical automático
- Optimización de memoria

```kotlin
LazyColumn {
    items(lista) { item ->
        Text(item.nombre)
    }
}
```

### 2. LazyRow
**Descripción:** Lista horizontal que solo renderiza elementos visibles.
**Uso:** Para carruseles, galerías horizontales, chips.
**Características:**
- Scroll horizontal
- Lazy loading horizontal
- Ideal para elementos pequeños

```kotlin
LazyRow {
    items(fotos) { foto ->
        Image(painter = painterResource(foto))
    }
}
```

### 3. Grid
**Descripción:** Organiza elementos en una cuadrícula regular.
**Uso:** Para galerías, menús de opciones, dashboards.
**Características:**
- Distribución uniforme
- Número fijo de columnas
- Auto-ajuste de altura

```kotlin
LazyVerticalGrid(columns = GridCells.Fixed(2)) {
    items(productos) { producto ->
        ProductCard(producto)
    }
}
```

### 4. ConstraintLayout
**Descripción:** Posiciona elementos usando restricciones relativas entre componentes.
**Uso:** Para layouts complejos con relaciones específicas.
**Características:**
- Posicionamiento relativo
- Reducción de anidamiento
- Layouts responsivos

```kotlin
ConstraintLayout {
    val (button, text) = createRefs()
    Button(modifier = Modifier.constrainAs(button) {
        top.linkTo(parent.top)
    })
}
```

### 5. Scaffold
**Descripción:** Estructura básica de pantalla con slots predefinidos (TopBar, BottomBar, FAB, etc.).
**Uso:** Como base para pantallas completas de aplicaciones.
**Características:**
- Slots predefinidos
- Manejo automático de padding
- Estructura Material Design

```kotlin
Scaffold(
    topBar = { TopAppBar(...) },
    bottomBar = { BottomNavigation(...) },
    floatingActionButton = { FAB(...) }
) { paddingValues ->
    // Contenido principal
}
```

### 6. Surface
**Descripción:** Contenedor que proporciona elevación, color de fondo y forma.
**Uso:** Para tarjetas, paneles, elementos con sombra.
**Características:**
- Elevación con sombra
- Manejo de colores Material
- Formas personalizables

```kotlin
Surface(
    shadowElevation = 8.dp,
    shape = RoundedCornerShape(16.dp)
) {
    // Contenido
}
```

### 7. Chip
**Descripción:** Elemento compacto que representa una entrada, atributo o acción.
**Uso:** Para filtros, tags, selecciones múltiples.
**Características:**
- Diseño compacto
- Estados seleccionado/no seleccionado
- Iconos opcionales

```kotlin
AssistChip(
    onClick = { /* acción */ },
    label = { Text("Chip") },
    leadingIcon = { Icon(...) }
)
```

### 8. BackdropScaffold
**Descripción:** Scaffold con una capa de fondo que se revela deslizando.
**Uso:** Para paneles de filtros, configuraciones secundarias.
**Características:**
- Revelación por gesto
- Dos capas de contenido
- Animaciones suaves

### 9. FlowRow
**Descripción:** Organiza elementos horizontalmente, saltando a nueva línea cuando es necesario.
**Uso:** Para tags, chips, elementos de tamaño variable.
**Características:**
- Flujo automático
- Wrapping inteligente
- Spacing configurable

```kotlin
FlowRow {
    tags.forEach { tag ->
        Chip(text = tag)
    }
}
```

### 10. FlowColumn
**Descripción:** Organiza elementos verticalmente, creando nuevas columnas cuando es necesario.
**Uso:** Para layouts de múltiples columnas adaptables.
**Características:**
- Flujo vertical
- Múltiples columnas
- Adaptable al contenido

---

## CONTROLES

### 11. AlertDialog
**Descripción:** Ventana modal que interrumpe el flujo para mostrar información importante.
**Uso:** Para confirmaciones, alertas, formularios simples.
**Características:**
- Modal (bloquea interacción)
- Botones de acción
- Título y mensaje

```kotlin
AlertDialog(
    onDismissRequest = { },
    title = { Text("Confirmar") },
    text = { Text("¿Estás seguro?") },
    confirmButton = { Button(...) }
)
```

### 12. Card
**Descripción:** Contenedor con elevación que agrupa información relacionada.
**Uso:** Para mostrar elementos de lista, artículos, productos.
**Características:**
- Elevación automática
- Esquinas redondeadas
- Clickeable

```kotlin
Card(
    modifier = Modifier.clickable { },
    elevation = CardDefaults.cardElevation(4.dp)
) {
    // Contenido de la tarjeta
}
```

### 13. Checkbox
**Descripción:** Control para seleccionar/deseleccionar una opción binaria.
**Uso:** Para formularios, listas de selección múltiple.
**Características:**
- Estados: marcado/desmarcado/indeterminado
- Animaciones de transición
- Accesible

```kotlin
var checked by remember { mutableStateOf(false) }
Checkbox(
    checked = checked,
    onCheckedChange = { checked = it }
)
```

### 14. FloatingActionButton (FAB)
**Descripción:** Botón circular flotante para la acción principal de una pantalla.
**Uso:** Para acciones primarias como crear, agregar, editar.
**Características:**
- Elevación prominente
- Posición fija
- Icono centrado

```kotlin
FloatingActionButton(
    onClick = { /* acción principal */ }
) {
    Icon(Icons.Default.Add, contentDescription = "Agregar")
}
```

### 15. Icon
**Descripción:** Muestra iconos vectoriales de Material Icons o personalizados.
**Uso:** Para botones, navegación, indicadores visuales.
**Características:**
- Escalable sin pérdida
- Tinteable
- Amplia biblioteca disponible

```kotlin
Icon(
    Icons.Default.Home,
    contentDescription = "Inicio",
    tint = Color.Blue
)
```

### 16. Image
**Descripción:** Muestra imágenes bitmap o vectoriales.
**Uso:** Para fotos, avatares, ilustraciones.
**Características:**
- Múltiples fuentes (resources, URL, bitmap)
- Escalado configurable
- Placeholder y error handling

```kotlin
Image(
    painter = painterResource(R.drawable.foto),
    contentDescription = "Descripción",
    contentScale = ContentScale.Crop
)
```

### 17. ProgressBar
**Descripción:** Indica progreso de una operación (lineal o circular).
**Uso:** Para cargas, procesos en background, formularios.
**Características:**
- Determinado e indeterminado
- Lineal y circular
- Animaciones suaves

```kotlin
// Progreso determinado
LinearProgressIndicator(progress = 0.7f)

// Progreso indeterminado
CircularProgressIndicator()
```

### 18. RadioButton
**Descripción:** Permite seleccionar una opción de un grupo mutuamente excluyente.
**Uso:** Para opciones únicas, configuraciones, formularios.
**Características:**
- Selección única por grupo
- Estado visual claro
- Agrupación lógica

```kotlin
val selectedOption = remember { mutableStateOf(0) }
RadioButton(
    selected = selectedOption.value == 1,
    onClick = { selectedOption.value = 1 }
)
```

### 19. Slider
**Descripción:** Control deslizante para seleccionar valores en un rango.
**Uso:** Para volumen, brillo, filtros, configuraciones numéricas.
**Características:**
- Rango configurable
- Pasos discretos opcionales
- Feedback visual

```kotlin
var volume by remember { mutableStateOf(0.5f) }
Slider(
    value = volume,
    onValueChange = { volume = it },
    valueRange = 0f..1f
)
```

### 20. Spacer
**Descripción:** Componente invisible que ocupa espacio para crear separaciones.
**Uso:** Para espaciado entre elementos, layouts responsivos.
**Características:**
- Tamaño configurable
- Invisible pero ocupa espacio
- Útil para alineación

```kotlin
Spacer(modifier = Modifier.height(16.dp))
Spacer(modifier = Modifier.weight(1f)) // Espacio flexible
```

### 21. Switch
**Descripción:** Interruptor para activar/desactivar opciones.
**Uso:** Para configuraciones, preferencias, estados on/off.
**Características:**
- Estados claramente diferenciados
- Animación de transición
- Feedback táctil

```kotlin
var enabled by remember { mutableStateOf(false) }
Switch(
    checked = enabled,
    onCheckedChange = { enabled = it }
)
```

### 22. TopAppBar
**Descripción:** Barra superior que muestra título y acciones de la pantalla.
**Uso:** Para navegación, títulos, acciones principales.
**Características:**
- Título centrado o alineado
- Iconos de acción
- Navegación hacia atrás

```kotlin
TopAppBar(
    title = { Text("Mi App") },
    navigationIcon = { IconButton(...) },
    actions = { IconButton(...) }
)
```

### 23. BottomNavigation
**Descripción:** Barra de navegación inferior para cambiar entre vistas principales.
**Uso:** Para navegación principal entre 3-5 secciones.
**Características:**
- Máximo 5 elementos
- Indicador de selección
- Iconos + etiquetas

```kotlin
NavigationBar {
    items.forEach { item ->
        NavigationBarItem(
            selected = currentRoute == item.route,
            onClick = { navController.navigate(item.route) },
            icon = { Icon(item.icon) },
            label = { Text(item.label) }
        )
    }
}
```

### 24. Dialog
**Descripción:** Ventana emergente para mostrar contenido adicional.
**Uso:** Para formularios, galerías, información detallada.
**Características:**
- Contenido personalizable
- Modal o no modal
- Animaciones de entrada/salida

### 25. Divider
**Descripción:** Línea visual para separar contenido o secciones.
**Uso:** Para separar elementos de lista, secciones de formularios.
**Características:**
- Grosor configurable
- Color personalizable
- Horizontal y vertical

```kotlin
HorizontalDivider(
    thickness = 1.dp,
    color = MaterialTheme.colorScheme.outline
)
```

### 26. DropDownMenu
**Descripción:** Menú desplegable que muestra opciones en una lista.
**Uso:** Para selecciones de listas, menús contextuales.
**Características:**
- Aparece sobre otros elementos
- Scroll automático si es necesario
- Dismissible

```kotlin
var expanded by remember { mutableStateOf(false) }
DropdownMenu(
    expanded = expanded,
    onDismissRequest = { expanded = false }
) {
    DropdownMenuItem(
        text = { Text("Opción 1") },
        onClick = { /* acción */ }
    )
}
```

### 27. LazyVerticalGrid
**Descripción:** Grid vertical con lazy loading para grandes cantidades de datos.
**Uso:** Para galerías de fotos, productos, dashboards.
**Características:**
- Lazy loading vertical
- Columnas configurables
- Optimización de memoria

```kotlin
LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 128.dp)
) {
    items(photoList) { photo ->
        PhotoItem(photo)
    }
}
```

### 28. NavigationRail
**Descripción:** Barra de navegación lateral para pantallas amplias.
**Uso:** Para tablets, pantallas horizontales, navegación secundaria.
**Características:**
- Diseño vertical
- Para pantallas amplias
- Menos elementos que BottomNav

```kotlin
NavigationRail {
    items.forEach { item ->
        NavigationRailItem(
            selected = currentRoute == item.route,
            onClick = { navController.navigate(item.route) },
            icon = { Icon(item.icon) }
        )
    }
}
```

### 29. OutlinedTextField
**Descripción:** Campo de texto con borde para entrada de datos del usuario.
**Uso:** Para formularios, búsquedas, entrada de texto.
**Características:**
- Borde visible
- Label flotante
- Estados de error y validación

```kotlin
var text by remember { mutableStateOf("") }
OutlinedTextField(
    value = text,
    onValueChange = { text = it },
    label = { Text("Nombre") },
    isError = text.isEmpty()
)
```

### 30. Pager
**Descripción:** Contenedor que permite navegar entre páginas deslizando.
**Uso:** Para onboarding, galerías, tutoriales.
**Características:**
- Navegación por gestos
- Indicadores de página
- Scroll suave

### 31. Snackbar
**Descripción:** Mensaje temporal que aparece en la parte inferior de la pantalla.
**Uso:** Para confirmaciones, errores, información temporal.
**Características:**
- Aparición temporal
- Acción opcional
- No bloquea interacción

```kotlin
Snackbar(
    action = {
        TextButton(onClick = { /* deshacer */ }) {
            Text("DESHACER")
        }
    }
) {
    Text("Elemento eliminado")
}
```

### 32. TabRow
**Descripción:** Fila de pestañas para navegar entre vistas relacionadas.
**Uso:** Para categorías, filtros, secciones de contenido.
**Características:**
- Indicador de selección
- Scroll automático si es necesario
- Máximo recomendado: 6 tabs

```kotlin
TabRow(selectedTabIndex = selectedTab) {
    tabs.forEachIndexed { index, title ->
        Tab(
            selected = selectedTab == index,
            onClick = { selectedTab = index },
            text = { Text(title) }
        )
    }
}
```

### 33. Tooltip
**Descripción:** Información contextual que aparece al hacer hover o long press.
**Uso:** Para explicar funciones, mostrar información adicional.
**Características:**
- Aparición temporal
- Posicionamiento inteligente
- No bloquea interacción

```kotlin
TooltipBox(
    positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
    tooltip = { PlainTooltip { Text("Ayuda") } },
    state = rememberTooltipState()
) {
    IconButton(onClick = { }) {
        Icon(Icons.Default.Help)
    }
}



**Autor:** [Tu Nombre]  
**Fecha:** Septiembre 2025  
**Versión:** 1.0
