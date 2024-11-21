# bck-base-hexa-domine
Descripción breve del proyecto, incluyendo su propósito y principales características.

## Configuración e Instalación

### Requisitos Previos

Para trabajar en este proyecto, necesitarás tener instalado lo siguiente:

- JDK 17 o superior
- Gradle (la versión se especificará en el archivo `gradle/wrapper/gradle-wrapper.properties`)
- IDE de tu elección (Recomendado: IntelliJ IDEA, Eclipse, o Visual Studio Code)

### Configuración del Entorno de Desarrollo

#### IntelliJ IDEA (RECOMENDADO)

1. **Instalación de IntelliJ IDEA**: Descarga e instala IntelliJ IDEA desde [su sitio web oficial](https://www.jetbrains.com/idea/download/).
2. **Plugins recomendados**:
   - **Lombok Plugin**: Para soporte de la biblioteca Lombok.
   - **SonarLint**: Para análisis de código y detección de errores.
   - **Tabnine**: Para autocompletado de código impulsado por IA.
3. **Importar el proyecto**: Abre IntelliJ IDEA y selecciona "Open" o "Import Project", luego navega hasta la ubicación del proyecto y selecciónalo.

#### Visual Studio Code

1. **Instalación de Visual Studio Code**: Descarga e instala Visual Studio Code desde [su sitio web oficial](https://code.visualstudio.com/Download).
2. **Extensiones recomendadas**:
   - **Java Extension Pack**: Incluye soporte para Java, Maven, y Gradle.
   - **Lombok Annotations Support for VS Code**: Para soporte de la biblioteca Lombok.
   - **Spring Boot Extension Pack**: Para soporte de desarrollo con Spring Boot.
   - **SonarLint**: Para análisis de código y detección de errores.
   - **Tabnine for Visual Studio Code**: Para autocompletado de código impulsado por IA.
3. **Abrir el proyecto**: Simplemente abre la carpeta del proyecto con Visual Studio Code.

### Instalación del Proyecto

Para configurar el proyecto en tu máquina local, sigue estos pasos:

1. **Clonar el repositorio**: Usa Git para clonar el repositorio del proyecto a tu máquina local.
   ```
   git clone <URL-del-repositorio>
   ```
2. **Construir el proyecto**: Abre una terminal en la raíz del proyecto y ejecuta:
   ```
   ./gradlew build
   ```
3. **Ejecutar las pruebas**: Para asegurarte de que todo está configurado correctamente, puedes ejecutar las pruebas con:
   ```
   ./gradlew test
   ```

## Uso

Descripción de cómo utilizar el proyecto, incluyendo comandos de ejecución y ejemplos de uso.

## Contribuir

Información sobre cómo contribuir al proyecto, incluyendo convenciones de código y proceso de revisión de código.

---

## Informes

### Swagger
Se accede al Swagger por el siguiente link:
http://localhost:9082/swagger-ui/index.html#/

### Jacoco
Se accede al reporte de pruebas despues de hacer build del proyecto, por el siguiente link.
Nota: Hay que ajustar la ruta para la ubicacion del proyecto.

file:///C:/PROGRAMAS/Proteccion-PruebaTecnica/bck-base-prueba-proteccion/domain/build/reports/tests/test/index.html


Este README es un punto de partida y puede ser personalizado según las necesidades específicas de tu proyecto.