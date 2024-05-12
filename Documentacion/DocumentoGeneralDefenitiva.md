
# Documentacion general

## **Indice** 

### BASE DE DATOS 
***
* [Descripcion de la base de datos.](#bd)
* [Diagrama E/R](#diagramaE/R)
* [Diagrama relacinal](#diagramaR)
* Archivo de importacion SQL 

### [WEB](#web)
***
* [Estructura de la pagina web](#WebEstructura)
* [Estilos utilizados](#WebEstilos)
* [Contenido](#WebContenido)

### [JAVA](#java)
***

* [Diagrama de clases](#diagramaClases)
* [Javadoc ](#)
* Explicar y justificar las decisiones tomadas para realizar la asignación de grupos/ cursos
y número de alumnos al registrar una actividad nueva  

<br>

## Base de datos <a name="bd"></a>

[![Diagrama-BD.png](https://i.postimg.cc/rsYwW1js/Diagrama-BD.png)](https://postimg.cc/JHZ8CB9C)
### 1.Tabla Profesor
* Columnas: id_profesor,dni,nombre,apellidos,correo,contraseña,perfil,activo
* Clave primaria: id_profesor

### 2. Tabla Actividades Programadas

* Columnas: id_actividad,  titulo ,tipo ,departamento ,prevista ,fini ,ffin ,hini , hfin ,transporte,comentario_alojamiento , comentario,estado
* Clave primaria: id_actividad

### 3.Tabla Desplazamiento

* Columnas: id_actividad,id_transporte,km
*  Clave primaria: id_trasnporte 

### 4. Tabla Departamento
* Columnas:id_depart,jefe,nombre,codigo_departamento
* Clave primaria: id_depart

### 5. Tabla Actividades Solicitadas 
* Columnas:  id_actividad,  titulo ,tipo ,departamento ,prevista ,fini ,ffin ,hini , hfin ,transporte,comentario_alojamiento , comentario,estado, comentario_estado
* Clave primaria: id_actividad

### 6. Tabla Grupo
* Columna:id_grupo, codigo, curso, num_alumnos, activo
* Clave primaria:id_grupo 

### 7. Tabla Transporte
* Columna: id_transporte, tipo,comentario 
* Clave primaria: id_transporte

### 8. Tabla Curso Participa
* Columna: id_curso,id_actividad,num_alumnos
* Clave primaria: id_curso
* Clave foranea: id_actividad

### 9.Tabla Profesor responsable 
* Columna: id_profesor, id_actividad
* Clave primaria: id_profesor 

### 10.Tabla Curso
* Columnas:id_curso,codigo,descripcion,etapa,activo 
* Clave primaria:id_curso 

### 11.Tabla Fotos
* Columnas: id_fotos,id_actividad,url,descripcion
* Clave: id_fotos 

### 12.Tabla Grupo participa
* Columnas:id_grupo,id_actividad,num_alumnos
* Clave: id_grupo

### 13.Tabla Profesor participa
* Columnas: id_profesor,id_actividad
* Clave: id_profesor 


###
<br>

### Diagrama E/R <a name="#diagramaE/R"></a>

[![Diagrama-ER.png](https://i.postimg.cc/N049Fr39/Diagrama-ER.png)](https://postimg.cc/VSJLH5Lm)

En este diagrama de entidad y relacion, hemos podido representar las cardinalidades necesarias y los atributos que disponen, ademas mostrando las claves primarias 


<br>

### Diagrama relacional <a name="#diagramaR"></a>
***

[![Modelo-Relacional-Reto-Equipo2-2-drawio.png](https://i.postimg.cc/htRf0rgQ/Modelo-Relacional-Reto-Equipo2-2-drawio.png)](https://postimg.cc/0bZkk7z9)

En este diagrama relacional podemos tener una vision clara de las tablas que componen 


### Archivo de importación SQL 
*** 
https://github.com/bfalqued/reto/blob/rama-elsa/Base%20de%20Datos/Scrip



<br>

## Web
[![inicio.png](https://i.postimg.cc/sXVqtBSH/inicio.png)](https://postimg.cc/hJ52mt2V)
### Estructura de la pagina web <a name="#WebEstructura"></a>
***

La estructura de la pagina web sigue un diseño minimalista y funcional, con un encabezado fijo que incluye el logotipo de la instuticion escolar y un menu de navegacion para acceder facilmente a los diferentes apartados. 
Se ha implementado un menu lateral despegable para una mejor experiencia de usuario en dispositivos moviles 

El contenido de la página se divide en secciones, cada una representada por un apartado HTML diferente. Estas secciones incluyen actividades,galeria de fotos,logros y reconocimientos y contacto. 
Cada seccion tiene su propio encabezado y contenido relevante 

### Decisiones de diseño
[![Captura-CSS.png](https://i.postimg.cc/Y0cNsX7s/Captura-CSS.png)](https://postimg.cc/tZ5V1NY3)

* Encabezado y Menú de Navegación: Se ha optado por un encabezado fijo que facilita la navegación del usuario en todo momento. El menú de navegación presenta enlaces claros y directos a cada red social del instituto

[![CSS2.png](https://i.postimg.cc/mDVRdn7b/CSS2.png)](https://postimg.cc/bDGKr36M)


* Fondo y capa semitransparente:El fondo de la página presenta una imagen de montañas nevadas, que evoca una sensación de tranquilidad y naturaleza. Se ha añadido una capa semitransparente sobre el fondo para mejorar la legibilidad del texto y los elementos de la página.
* Galería de Fotos en Cuadrícula: La galería de fotos se presenta en una cuadrícula de tres columnas para una visualización ordenada y estética de las imágenes. Esto facilita la exploración de las fotos y mejora la experiencia del usuario.

### Tipos de estilos utilizados <a name=#WebEstilos></a>
* Estilos Globales: Se han utilizado estilos globales para establecer márgenes, rellenos y fuentes predeterminadas para todos los elementos de la página. Esto garantiza consistencia en todo el diseño y una apariencia uniforme en toda la página web.
* Estilos de encabezado y menu: Los estilos especificos se han aplicado al encabezado y menu de navegacion para mejorar su apariencia y funcionalidad.Se han utilizado suaves y efectos de desplazamiento para una experiencia de usuario mas atractiva 
* Estilos de secciones: Cada seccion de la pagina tiene su propio estilo para destacar el contenido relevante.Se han utilizado fondos semitransparentes y sombras para resaltar las secciones y mejorar su legibilidad 

### Contenidos de la web <a name=#WebContenido></a>
* Actividades: se incluye informacion sobre las activiades extraescolares ofrecidas por la institucion,que pueden incluir deportes,excursiones, charlas, entre otros eventos 
* Galeria de fotos: se presenta una seleccion de imagenes que muestran momentos especiales capturados durante las activades extracurriculares.Esto permita a los visitantes de la pagina tener una idea de la diversion y la participacion en la comunidad escolar 
* Logros y reconocimientos: se destaca el exito y los logros obtenidos por la institucion y sus estudiantes, lo que ayuda a fortalecer la reputacion y la imagen de la escuela
* Contacto: Se proporciona informacion de contacto para que los visitantes puedan comunicarse con la institucion si desean obtener mas informacion o realizar consultas


En base a la aplicacion que hemos realizado 
<br>

## Java 

### Diagrama de clases <a name="#diagramaClases"></a>
[![DIAGRAMA-CLASES-EQUIPO2.png](https://i.postimg.cc/rsk1L6YF/DIAGRAMA-CLASES-EQUIPO2.png)](https://postimg.cc/gXgXv7Wf)

***

| Tecnologias utilizadas   | Asociado a: |
|----------------|-------------------|
| Visual Studio | Pagina web |
| Mysql Workbench | Para realizar tablas  |
| NetBeans | Programar la interfaz   |

