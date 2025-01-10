# Spotify 🎶

Un servidor de servicios web (web services) con una interfaz gráfica destinada exclusivamente para la administración del sistema. Este proyecto complementa y administra el backend del proyecto [SpotifyWeb](https://github.com/dylanwh23/SpotifyWeb).

## Requisitos del sistema ✅

- **Java 20** (JDK y JRE).
- Sistema operativo compatible: **Windows**, **Linux**, o **macOS**.
- Apache Tomcat (o cualquier servidor de aplicaciones compatible con Java EE para SOAP).

## Descripción 📋

El proyecto **Spotify** es un servidor de servicios web que incluye una interfaz gráfica para la gestión administrativa del sistema. Sus principales funcionalidades incluyen:
- Gestión de usuarios, playlists y álbumes.
- Administración de datos y sincronización con el backend de SpotifyWeb.
- Exposición de servicios web **SOAP** para interactuar con otras aplicaciones.
- Diseño enfocado en facilitar el control y monitoreo del sistema por parte de administradores.

### Funcionalidades clave 🚀
1. **Interfaz de administrador:**
   - Desarrollada en **Java Swing**.
   - Diseñada para gestionar usuarios, playlists, y datos relacionados.
2. **Servidor de servicios web SOAP:**
   - Provee servicios para que otras aplicaciones (como SpotifyWeb) interactúen con el sistema.
   - Manejo  de peticiones y respuestas en formato XML.
3. **Sincronización de datos:**
   - Permite mantener actualizados los datos entre el servidor y las aplicaciones conectadas.
   
## Capturas de pantalla 📸
![1](https://diegopozzi.com/proyectospotify/15.png)

## Instalación ⚙️

### Configuración del servidor:
1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/dylanwh23/spotify.git
