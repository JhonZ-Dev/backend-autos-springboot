# concesionario-autos-backend
# consecionario--back-end-srping-boot
Seguridad a las API con Json Web Token - Spring security 

Sistema consecionario de autos, a continuación se presenta el diagrama entidad relación que se va a implementar.
![er](https://github.com/JhonZambranoM/consecionario--back-end-srping-boot/assets/75482142/88c873da-5cfe-41c5-b954-1d19e955a9f5)

# Diagrama Estructural de la aplicación.

![mode](https://github.com/JhonZambranoM/consecionario--back-end-srping-boot/assets/75482142/a9155726-a7eb-4315-b23d-54809319d349)

# DTO
Para este proyecto es necesario usar clases DTO, ya que como no hay una relación directa con las entidades, se necesita crear una o unas clases DTO para poder cumplir con los requerimientos.
Una clase DTO (Data Transfer Object) en Spring Boot se utiliza para transferir datos entre diferentes capas de una aplicación, como la capa de controladores (controllers) y la capa de servicios (services) o la capa de servicios y la capa de acceso a datos (data access). Los DTO se utilizan para encapsular y transportar datos específicos entre estas capas sin exponer directamente los detalles de la estructura interna de los objetos de dominio o entidades de la base de datos. Aquí tienes algunas razones y ejemplos de por qué se utilizan clases DTO en Spring Boot. Ejemplo:

![venta](https://github.com/jhonZambrano1999/backend-autos-springboot/assets/79710173/f209654c-82c8-4eeb-96ed-6348b487d459)

Para obtener el detalle de las ventas tambien se usa una clase DTO, ya que por una simple consulta solo trae los datos que le pertenecen a esa tabla, para entender mejor se hace lo sigueinte, mire la Figura. 
![mapping](https://github.com/jhonZambrano1999/backend-autos-springboot/assets/79710173/35162884-63b7-4d30-b7ec-e0b725f3babf)

