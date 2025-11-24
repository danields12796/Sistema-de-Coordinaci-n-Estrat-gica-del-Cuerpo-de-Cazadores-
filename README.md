#  Pilares Inteligencia API

API REST desarrollada en Spring Boot, con Spring Data JPA y MySQL. Permite gestionar pilares tácticos, registrar mensajes fragmentados, reconstruirlos y calcular triangulación estimada.

##  Requisitos Previos
- Java 17+
- Maven
- MySQL
- IDE (VS Code / IntelliJ)

## Configuración de Base de Datos
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pilaresdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

##  Ejecución del Proyecto
```bash
mvn clean install -DskipTests
mvn spring-boot:run
```

## Endpoints principales

### Pilares
 Método
-------------------------------------
POST ->  /api/pilares 
GET ->/api/pilares
GET -> /api/pilares/{id} 
POST -> /api/pilares/{id}/actualizar-posicion

### Mensajes
| Método
-------------------------------
POST ->  /api/mensajes | Registrar fragmento de mensaje |
PUT-> /api/mensajes/{pilarId}/reconstruir | Reconstruir mensaje |

### Inteligencia
| Método 
----------------------------------
GET -> /api/inteligencia/triangulacion | Obtener triangulación estimada |

## Ejemplo JSON para registrar Pilar
```json
{
  "nombre": "Pilar Norte",
  "posX": 4.6521,
  "posY": -74.1234,
  "estado": "Activo"
}
```

##  Ejemplo JSON para mensaje fragmentado
```json
{
  "pilarId": 1,
  "contenidoFragmentado": "El enemigo",
  "fragmento": 1
}
```

## Manejo de errores
- 404 Not Found
- 400 Bad Request
- 500 Internal Server Error