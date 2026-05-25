# 📱 Turny App

**Turny** es una aplicación móvil diseñada para gestionar y organizar citas en pequeños negocios como barberías, salones de uñas y servicios similares.

## 👥 Equipo de Desarrollo

- **Yulieth Tatiana Rengifo**
- **Pedro Jose Lopez**
- **Juan Jose Valencia**

## 🎯 Descripción del Proyecto

Turny facilita la conexión entre clientes y pequeños negocios, permitiendo:
- **Clientes**: Explorar negocios, reservar citas, gestionar su historial y marcar favoritos
- **Negocios**: Gestionar reservas, servicios ofrecidos y configuración del negocio

## 🛠️ Tecnología

### Stack Principal
- **Lenguaje**: Kotlin
- **Framework UI**: Jetpack Compose + Material 3
- **Arquitectura**: MVVM
- **Networking**: Retrofit 2 + Gson
- **Persistencia Local**: DataStore Preferences
- **Concurrencia**: Kotlin Coroutines
- **Navegación**: Jetpack Navigation Compose

### Requisitos
- Android 8.0+ (API 26)
- Target: Android 14+ (API 36)
- Java 11

## 📲 Funcionalidades Principales

### 👤 Para Clientes
- ✅ Autenticación y registro
- ✅ Exploración de negocios disponibles
- ✅ Búsqueda y filtrado por categorías
- ✅ Reserva de citas
- ✅ Gestión de citas (próximas e historial)
- ✅ Agregar negocios a favoritos
- ✅ Perfil de usuario

### 🏢 Para Negocios
- ✅ Panel de control
- ✅ Gestión de reservas/citas
- ✅ Administración de servicios ofrecidos
- ✅ Configuración del negocio

## 🏗️ Estructura del Proyecto

```
turnyapp/
├── app/src/main/java/com/app/turny/
│   ├── domain/           # Lógica de negocio
│   ├── data/             # Acceso a datos (local y remoto)
│   ├── ui/               # Pantallas y componentes
│   ├── navigation/       # Gestión de navegación
│   └── MainActivity.kt
├── build.gradle.kts      # Configuración del build
└── ...
```

## 🔌 API Backend

**Base URL**: `https://skillful-tranquility-production-bca4.up.railway.app/`

### Servicios Disponibles
- **AuthApiService**: Autenticación y registro
- **ProfileApiService**: Datos del perfil de usuario
- **BusinessApiService**: Información de negocios
- **AppointmentApiService**: Gestión de citas
- **FavoriteApiService**: Gestión de favoritos

## 🚀 Primeros Pasos

### Requisitos Previos
- Android Studio Iguana o superior
- JDK 11+
- Conexión a internet

### Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/JuanValle5/turny-app.git
   cd turny-app
   ```

2. **Abrir en Android Studio**
   ```bash
   File → Open → (seleccionar la carpeta turnyapp)
   ```

3. **Compilar y ejecutar**
   - Conectar dispositivo Android o usar emulador
   - Click en "Run" o presionar Shift + F10

## 📦 Dependencias Principales

```kotlin
// Jetpack Compose
implementation("androidx.activity:activity-compose:1.8.0")
implementation("androidx.compose.ui:ui:1.x.x")
implementation("androidx.compose.material3:material3:1.x.x")

// Networking
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")

// Navigation
implementation("androidx.navigation:navigation-compose:2.8.0")

// Persistencia
implementation("androidx.datastore:datastore-preferences:1.1.1")

// Corrutinas
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
```

## 🔐 Gestión de Sesión

La aplicación utiliza **DataStore** para almacenar de forma segura:
- Token de autenticación
- Tipo de usuario (cliente/negocio)
- Información básica del usuario

## 📱 Pantallas de la Aplicación

| Pantalla | Descripción |
|----------|-------------|
| **Login** | Autenticación con selector de rol |
| **Register** | Registro de nuevos clientes |
| **Home Cliente** | Exploración de negocios y servicios |
| **Citas** | Visualización de citas próximas e historial |
| **Favoritos** | Negocios marcados como favoritos |
| **Perfil** | Información y configuración del usuario |
| **Home Negocio** | Panel principal del negocio |

## 🎨 Tema y Personalización

La aplicación incluye:
- Tema claro y oscuro
- Colores personalizados (Azul, Verde, Amarillo)
- Soporte para Material You (Android 12+)

## 📋 Estado de Desarrollo

- ✅ Navegación completa
- ✅ Autenticación funcional
- ✅ Consumo de APIs
- ✅ Pantalla de cliente completa
- ✅ Gestión de favoritos
- ✅ Gestión de citas
- 🔄 Optimizaciones y mejoras continuas

## 🐛 Reportar Problemas

Si encuentras algún problema, por favor abre un **Issue** en el repositorio con:
- Descripción clara del problema
- Pasos para reproducirlo
- Versión de Android utilizada
- Capturas de pantalla (si es relevante)

## 📄 Licencia

Este proyecto está disponible bajo licencia abierta. Consulta el archivo LICENSE para más detalles.

## 🙋 Soporte y Contacto

Para preguntas o sugerencias sobre el desarrollo de la aplicación, contacta a los integrantes del equipo.

---

**Última actualización**: Mayo 2026  
**Versión**: 1.0.0
