Examen Acceso a Datos - 3er Trimestre
Este proyecto es una API REST desarrollada con Spring Boot para la gestión de un inventario de artículos (Items).

🛠️ Tecnologías Utilizadas
Java 17.

Spring Boot 3.2.5.

Spring Data JPA: Para la persistencia de datos.

H2 Database: Base de datos en memoria para desarrollo y pruebas.

Spring Security: Configuración de seguridad básica.

Maven: Gestión de dependencias.

📂 Estructura del Proyecto
controller: Contiene ItemController con los endpoints de la API.

service: Lógica de negocio en ItemService.

repository: Interfaz ItemRepository para comunicación con la base de datos.

model: Definición de la entidad Item.

dto: Objetos de transferencia de datos como EstadisticaDTO y ErrorResponseDTO.

exception: Manejador global de excepciones (GlobalExceptionHandler).

config: Configuración de seguridad y carga inicial de datos.

🚀 Funcionalidades y Endpoints
La API permite realizar las siguientes operaciones sobre los artículos:

GET /api/items: Listar todos los artículos.

GET /api/items/{id}: Obtener un artículo por su ID.

POST /api/items: Crear un nuevo artículo.

PUT /api/items/{id}: Actualizar un artículo existente.

DELETE /api/items/{id}: Eliminar un artículo.

GET /api/items/stats: Obtener estadísticas del inventario.

⚙️ Configuración
Base de Datos: Utiliza H2. La consola está habilitada en /h2-console.

Puerto: La aplicación corre por defecto en el puerto 8080.

Carga de Datos: El sistema carga datos iniciales automáticamente al arrancar.

📝 Ejecución
Para arrancar el proyecto, ejecuta el siguiente comando en la raíz:

Bash
mvn spring-boot:run
