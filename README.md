# **Pasos para correr la aplicación:**

### Ramas
1. **main:** tiene la descripción sobre cómo correr la aplicación completa.
2. **client:** tiene la aplicación del **cliente** hecha con **React**.
3. **server:** tiene la aplicación del **servidor** hecha con **Spring Boot**.

### Servidor (Spring Boot)

Primero que todo es necesario tener la API andando para que el cliente pueda hacer las solicitudes necesarias e interactuar con el servidor. Para esto es necesario correr la aplicación del servidor.

Esta aplicación está con una base de datos SQLite, por tanto no será necesario configurar nada, solo se debe correr la aplicación para que esta funcione.

### Cliente (React)

Para poder correr la aplicación del cliente son necesarios dos pasos en orden:
1. Abrir una consola o terminal dentro de la carpeta del proyecto y ejecutar el comando **npm install**.
2. En la misma consola o terminar anterior, ejecutar el comando **npm run start**.

### Test Unitarios

- En **Spring Boot** debes ejecutar el archivo **ServerApplicationTests.java** que se encuentra en la ruta */src/test/java/com/api/server/*.

### Otros detalles

Obviamente faltaron validaciones de entrada en la API, algunas validaciones de entrada también en la aplicación del cliente. Esto se puede mejorar si se le invierte un poco más de tiempo, pero por temas de desarrollo para la prueba y el tiempo limitado se dejo funcionando bien, pero sin validar completamente.
