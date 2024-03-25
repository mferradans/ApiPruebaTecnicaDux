# ApiPruebaTecnicaDux
## Cómo utilizar la seguridad
En este apartado vamos a probar el sistema de seguridad que nos brinda Spring Security + JWT.

En primer lugar debemos registrar un usuario, para eso hacemos una llamada POST en http://localhost:8080/api/auth/register y en el Body incluimos los datos de registro, en este caso para la prueba ponemos:

```json
{
    "username":"test",
    "password":"12345"
}
```

Al hacer esta llamada vamos a obtener como respuesta un token que nos servirá para validad el usuario cuando intentemos loguearnos.

![paso1](https://github.com/mferradans/ApiPruebaTecnicaDux/assets/76523709/fd91440d-f3da-4ec7-8d62-0592c33fa7c5)


Este token lo copiamos y hacemos una llamada a http://localhost:8080/api/auth/login. En el body ponemos los mismos datos que registramos para que el logueo sea exitoso. Y en el apartado de Authorization ponemos el Token de tipo Bearer.

![paso2](https://github.com/mferradans/ApiPruebaTecnicaDux/assets/76523709/2d737d58-23c7-46a5-9c0c-ec6f42d0abfd)


Cuando le demos en Send, enviará la petición y como respuesta tendremos el token de autenticación para poder acceder a los servicios de nuestra API.

Por ultimo hacemos una llamada a cualquier servicio brindado por nuestra API como por ejemplo buscar los equipos asociados a una liga cuyo país es el que ingresamos, y colocamos el token de autenticación que nos dio el login.

![paso3](https://github.com/mferradans/ApiPruebaTecnicaDux/assets/76523709/6c0186b4-306d-49d4-a9bf-e15518ced7e2)


---

## Pasos para dockerizar

Creé un Dockerfile que dispone de todo lo necesario para que funcione, para probarlo solo debemos:

1. Construimos el docker (recordar tener el cliente de Docker ejecutandose):
docker build -t nombre-de-tu-imagen:version .
2. Corremos el docker:
docker run -p 8080:8080 nombre-de-tu-imagen

---

Hecho por Mateo Ferradans - mferradanss@gmail.com
