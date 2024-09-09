# Java--ApiNotasJWT

## Endpoints

### POST /auth?user=luis&password=123456789
Authenticator, valida y genera token de acceso.

### GET /api/notas
Obtiene todas las notas posibles

### POST /api/notas
Crea una nueva nota. Requiere un JSON con `title` y `content`.
{
  "title": "Nota de prueba",
  "content": "Contenido de prueba"
}

## Swagger
Visita [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para ver la documentación interactiva.

## Pruebas Unitarias
Se han incluido pruebas unitarias en la clase `JwtDemoApplicationTests` para validar la lógica del negocio.

## Docker
Para construir y ejecutar el contenedor Docker:

```sh
docker build -t note-app .
docker run -p 8080:8080 note-app