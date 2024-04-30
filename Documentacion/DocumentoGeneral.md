
# Documentacion general

## **Indice** 
*** 
### [BASE DE DATOS](#bd)
***
* Descripcion de la base de datos. [](#linkBd)
* Imagen de E/R y breve explicación. [Diagrama E/R](#diagramaE/R)
* Diagrama relacional [Diagrama relacinal](#diagramaR)
* Archivo de importacion SQL 

### [WEB](#web)
***
* Estructura de la pagina web 
* Estilos utilizados 
* Contenido 

### [JAVA](#java)
***

* Diagramas de clases (funciones, atributos y cardinalidad)
* Documentacion de las clases utilizando JavaDoc 
* Explicar y justificar las decisiones tomadas para realizar la asignación de grupos/ cursos
y número de alumnos al registrar una actividad nueva

<br>

## Base de datos 
***


![GNU](img/ "Diagrama E/R")


### 1.Tabla Profesor
* Columnas: id_profesor,dni,nombre,apellidos,correo,contraseña,perfil,activo
* Clave primaria: id_profesor

### 2. Tabla Actividades Programadas

* Columnas: id_actividad,  titulo ,tipo ,departamento ,prevista ,fini ,ffin ,hini , hfin ,transporte,comentario_alojamiento , comentario,estado

### 3.Tabla Desplazamiento

* Columnas: id_actividad,id_transporte,km
*  Clave primaria: id_trasnporte 

### 4. Tabla Departamento
* Columnas:id_depart,jefe,nombre,codigo_departamento
* Clave primaria: id_depart

### 5. Tabla Actividades solicitadas 
* Columnas:  id_actividad,  titulo ,tipo ,departamento ,prevista ,fini ,ffin ,hini , hfin ,transporte,comentario_alojamiento , comentario,estado, comentario_estado
* Clave primaria: id_actividad

### 5. Tabla Grupo
* Columna:id_grupo, codigo, curso, num_alumnos, activo
* Clave primaria:id_grupo 

### 6. Tabla Transporte
* Columna: id_transporte, tipo,comentario 
* Clave primaria: id_transporte

### 6. Tabla Curso_participa
* Columna: id_curso,id_actividad,num_alumnos
* Clave primaria: id_curso
* Clave foranea: id_actividad

### 7.Tabla Profesor_responsable 
* Columna: id_profesor, id_actividad
* Clave primaria: id_profesor 

### 8.Tabla Curso
* Columnas:id_curso,codigo,descripcion,etapa,activo 
* Clave primaria:id_curso 

### 9.Tabla Fotos
* Columnas: id_fotos,id_actividad,url,descripcion
* Clave: id_fotos 

### 10.Tabla Grupo participa
* Columnas:id_grupo,id_actividad,num_alumnos
* Clave: id_grupo

### 11.Tabla Profesor participa
* Columnas: id_profesor,id_actividad
* Clave: id_profesor 

###
<br>

### Diagrama E/R

![GNU](img/DiagramaER.PNG "Diagrama E/R")


<br>

### Diagrama relacional 

![GNU](img/DiagramaRelacional.PNG "Diagrama Relacional")

### Archivo de importación SQL 

<br>

## Web
***

<br>

## Java 
***

Diagrama de clases





