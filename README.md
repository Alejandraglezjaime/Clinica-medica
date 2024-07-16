# CLINICA MEDICA 

Este proyecto es creado con el fin de entender el funcionamiento de backEnd, nuestro principal objetivo es crear una app donde el usuario (ya sea trabajador o cliente) pueda crear un perfil, si es un trabajador pueda ingresar su información general, lo mismo si es cliente. Una vez terminado, se propone su creación del front End para mayor facilidad para el usuario.

## OBJETIVOS DEL PROYECTO 

1.- Creación de una API Rest

2.- CRUD (Cread, Read, Update, Delete)

3.- Validaciones, verificación que el tipo de dato enviado a mi rests service es el tipo de datos que mi base de datos acepta.

4.- Paginación y orden. 

Para la creación del json vamos a usar Insomnia, que es una herramienta similar a Postman, para los que son familiarizados con Postman, para simular los requests que nuestro cliente de front end podría realizar a nuestro API.

## DESCRIPCION DEL PROYECTO 

1.- **REGISTRO DEL MEDICO (CREAD AND READ)**

• Como primer punto **creamos a nuestro cliente**, el cual fue creado en insomina; como segundo punto **obtendremos los datos que nuestro cliente ha enviado** y ya tenerlos a nivel del API de nuestro back end.

•Una vez obtenido los datos del cliente serán guardados en una base de datos.

<p align="center">
  <img src="https://github.com/Alejandraglezjaime/Clinica-medica/blob/master/Img/registroMedico.jpg?raw=true" alt="Imagen app registro del medico" width="200"/>
</p>

Ejemplo de la base de datos.

![Imagen ejemplo de la base de datos](https://github.com/Alejandraglezjaime/Clinica-medica/blob/master/Img/ejemploBaseDatos.jpg?raw=true)


### Consideraciones para las validaciones

##### Médico
Nombre: Solo deben ser letras, puede estar varias veces registrado en la base de datos
Especialidad: ortopedía, ginecología, cardiología, pediatría. 
Cédula: Solo acepta números.
Email: tiene que ser formato email y no puede ser repetido, su correo debe corresponder a su especialidad 
Teléfono: Solo acepta números.

##### Dirección
Calle: acepta letras y números.
Colonia: acepta letras y números.
Estado: Solo acepta letras.
Código: Solo acepta números
Número interior: acepta números y letras
Número exterior: Solo acepta números

2.- **LISTADO DEL MEDICOS**

En esta sección la información que debe ser mostrada del médico es: *nombre, especialidad, cédula, email*
Tiene que ser ordenado ascendentemente, es decir, debe poder ser ordenado por nombre o por código.
Debe ser paginado, con máximo 10 registros por página. 

<p align="center">
  <img src="https://github.com/Alejandraglezjaime/Clinica-medica/blob/master/Img/listadoMedicos.jpg?raw=true" alt="Imagen app registro del medico" width="200"/>
</p>


### Actualización de los datos de los médicos permitidos a actualizar.

La información permitida para la actualización es: *nombre, télefono y dirección*, no se permite actualizar email, especialidad ni cédula.

### Exclusión de médicos. (DELETE)

[IMPORTANTE] El registro no debe ser borrado de la base de datos y el listado debe retornar solo médicos activos.

#### FUNCIONALIDAD CODIGO .


## TECNOLOGIAS
• Spring Boot 3
• Java 17
• Lombok
• MySQL / Flyway / postgresql
• JPA / Hibernate
• Maven
• Insomnia. *URL: https://insomnia.rest/*


## DEPENDENCIAS

![Imagen dependencias de spring ](https://github.com/Alejandraglezjaime/Clinica-medica/blob/master/Img/dependencias.jpg?raw=true)
![Imagen dependencias de spring ](https://github.com/Alejandraglezjaime/Clinica-medica/blob/master/Img/dependencias2.jpg?raw=true)
![Imagen dependencias de spring ](https://github.com/Alejandraglezjaime/Clinica-medica/blob/master/Img/dependencias3.jpg?raw=true)



# AUTOR
#### © Alejandra Gonzalez  

