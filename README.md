# 📌 Aplicación Acex    
<p align="right">
  <a href="https://postimg.cc/0MBhhBj8">
    <img src="https://i.postimg.cc/C5hYnyVf/LOGODEFINITIVO.png" alt="LOGODEFINITIVO.png">
  </a>
</p>

Integrantes: Borja, Joel, Elsa , Aymane


<br>
<br>

## 🔗 INDICE <br> 
- [Introducción](#introduccion)
- [Manual de usuario]()
  

### BASE DE DATOS 🔷
***
* [Descripcion de la base de datos.](#bd)
* [Diagrama E/R](#diagramae/r)
* [Diagrama relacinal](#diagramarelacional)
* [Archivo de importacion SQL](#archivosql)
* [Documetación CVS](https://github.com/bfalqued/reto/blob/33513916e5ba556b4d9bd4bfdb3eb3106257d938/Documentacion/DocumentarCSVS.md)

### WEB 🔷
***
* [Estructura de la pagina web](#webestructura)
* [Estilos utilizados](#webestilos)
* [Contenido](#webcontenido)

### JAVA 🔷
***

* [Diagrama de clases](#diagramaclases)
* [Diagrama casos de usos](https://github.com/bfalqued/reto/blob/ba3d391c0777ea3c5bdf36e1b9777d7f7314cdac/Documentacion/DiagramaCasosDeUso.md)
* [Javadoc ](#)
* [Explicar y justificar las decisiones tomadas para realizar la asignación de grupos/ cursos
y número de alumnos al registrar una actividad nueva](#cursosygrupos)  
***
### CONTACTO 🔷 
* [Aquí ](#contacto)



***

| Asignaciones   | Nombres           |
|----------------|-------------------|
| Lider        |    Borja    | 
| Secretaria    |  Elsa   |
|  Desarrollador |   Joel   |
| Analista       |  Aymane  |




<br>

## Como se llevara a cabo este proceso 💡 <a name="introduccion"></a>

<br>

## Análisis de la aplicacion ✔️

* El departamento de coordinación de Actividades Complementarias y Extraescolares del centro
necesita una aplicación de escritorio para gestionar esas actividades y una
página web en la que se informe de las actividades realizadas

<br>

## Mantenimientos basicos de la aplicación ✔️

* Solo es accesible para el super usuario y el rol de administrador.

##  Cuentas de acceso ✔️

Habra tres perfiles de usuario:
<br>
* 👨‍🏫 Profesor: son los usuarios de la aplicación que solo van a poder crear la solicitud
de una actividad y podrán modificarla mientras esté en el estado solicitada

* 👨‍🏫Equipo directivo: son los profesores que forman parte del equipo directivo del IES su funcion es aprobar o denegar solicitudes

* 👨‍🏫Aministrador: profesores que forman parte del equipo ACE y pueden completar o modificar cualquier solicitud 

## Consultar/modificar una solicitud por parte de un profesor ✔️

* Si el profesor solo tiene el rol de profesor, siempre va a poder ver las solicitudes creadas por él
y en las que son responsable. 

## Aprobación/denegación de solicitudes ✔️

* Si el profesor tiene el perfil de equipo directivo o administrador, muestra todas las solicitudes
que están en estado solicitado
y denegado apareciendo siempre las solicitudes primero que las denegadas

## Fase de preparación de la actividad ✔️

* Esta opcion es solo para el administrador y los profesores responsables, es la actividad creada a partir de la solicitud aprobada 

Empresa de transporte: area de texto donde se introducen datos relativos 

## Generación de informes ✔️

* Informe del calendario de las actividades programas para el mes siguiente a la fecha actual 
* Informe anual de las actividades realizadas en un grupo o un curso

## Licencia y condiciones de uso✔️
Licencia de Uso Personal

Licencia de Uso No Comercial: Permite a los usuarios utilizar el software para fines personales o educativos, pero no para fines comerciales.


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

### Diagrama E/R <a name="diagramae/r"></a>

[![Diagrama-ER.png](https://i.postimg.cc/N049Fr39/Diagrama-ER.png)](https://postimg.cc/VSJLH5Lm)


* Este modelo E/R está bastante detallado y parece diseñado para gestionar diferentes aspectos de las actividades educativas, incluyendo la programación de actividades, la participación de cursos y grupos, la gestión de profesores y departamentos, así como el seguimiento del transporte y las fotos asociadas a las actividades.
* En el podemos observar las claves primarias que poseen en cada clase 

<br>

### Diagrama relacional <a name="diagramarelacional"></a>
***

[![Modelo-Relacional-Reto-Equipo2-2-drawio.png](https://i.postimg.cc/htRf0rgQ/Modelo-Relacional-Reto-Equipo2-2-drawio.png)](https://postimg.cc/0bZkk7z9)

* Este diagrama muestra cómo se organizan las actividades académicas y cómo diferentes entidades (profesores, departamentos, cursos, grupos) están relacionadas en función de estas actividades. Las claves primarias (PK) y foráneas (FK) garantizan la integridad referencial y permiten la navegación entre las diferentes tablas del modelo.


### Archivo de importación SQL <a name="archivosql"></a>
*** 
https://github.com/bfalqued/reto/blob/rama-elsa/Base%20de%20Datos/Scrip



<br>

## Web
[![inicio.png](https://i.postimg.cc/sXVqtBSH/inicio.png)](https://postimg.cc/hJ52mt2V)
### Estructura de la pagina web <a name="webestructura"></a>
***

La estructura de la pagina web sigue un diseño minimalista y funcional, con un encabezado fijo que incluye el logotipo de la instuticion escolar y un menu de navegacion para acceder facilmente a los diferentes apartados. 
Se ha implementado un menu lateral despegable para una mejor experiencia de usuario en dispositivos moviles 

El contenido de la página se divide en secciones, cada una representada por un apartado HTML diferente. Estas secciones incluyen actividades,galeria de fotos,logros y reconocimientos y contacto. 
Cada seccion tiene su propio encabezado y contenido relevante 

### Decisiones de diseño

* Encabezado y Menú de Navegación: Se ha optado por un encabezado fijo que facilita la navegación del usuario en todo momento. El menú de navegación presenta enlaces claros y directos a cada red social del instituto
* Fondo y capa semitransparente:El fondo de la página presenta una imagen de montañas nevadas, que evoca una sensación de tranquilidad y naturaleza. Se ha añadido una capa semitransparente sobre el fondo para mejorar la legibilidad del texto y los elementos de la página.
* Galería de Fotos en Cuadrícula: La galería de fotos se presenta en una cuadrícula de tres columnas para una visualización ordenada y estética de las imágenes. Esto facilita la exploración de las fotos y mejora la experiencia del usuario.

### Tipos de estilos utilizados <a name=webestilos></a>
* Estilos Globales: Se han utilizado estilos globales para establecer márgenes, rellenos y fuentes predeterminadas para todos los elementos de la página. Esto garantiza consistencia en todo el diseño y una apariencia uniforme en toda la página web.
``` java
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Montserrat Alternates', sans-serif;
}

body {
    background: url(./images/fondo.jpg);
    background-attachment: fixed;
    background-size: 100vw 100vh;
    background-repeat: no-repeat;
    margin: 0;
    padding: 0;
}

.capa {
    position: fixed;
    width: 100%;
    height: 100vh;
    background: rgba(0, 0, 0, 0.6);
    z-index: -1;
    top: 0;
    left: 0;
}
````
* Estilos de encabezado y menu: Los estilos especificos se han aplicado al encabezado y menu de navegacion para mejorar su apariencia y funcionalidad.Se han utilizado suaves y efectos de desplazamiento para una experiencia de usuario mas atractiva
  
```java
/* Estilos para el encabezado */
.header {
    width: 100%;
    height: 100px;
    position: fixed;
    top: 0;
    left: 0;
}

.header:hover {
    background-color: rgba(0, 0, 0, 0.767);
    transition: background-color 0.3s ease; 
}


.container {
    width: 90%;
    max-width: 1200px;
    margin: auto;
}

.container .aside-menu,
.logo {
    float: left;
    line-height: 100px;
}

.container .aside-menu label {
    color: #fff;
    font-size: 25px;
    cursor: pointer;
}

.logo {
    margin-top: 2vh;
    margin-left: 2vh;
}

.logo a {
    text-decoration: none;
}

.logo h1 {
    color: #fff;
    font-weight: 400;
    font-size: 22px;
    margin-left: 10px;
}

.container .menu {
    float: right;
    line-height: 100px;
}

.container .menu a {
    display: inline-block;
    padding: 15px;
    line-height: normal;
    text-decoration: none;
    color: #fff;
    transition: all 0.3s ease;
    border-bottom: 2px solid transparent;
    font-size: 15px;
    margin-right: 5px;
}

.container .menu a:hover {
    border-bottom: 2px solid #c7c7c7;
    padding-bottom: 5px;
}

/* Fin de Estilos para el encabezado */
```

```java
/* Fin de Menú lateral */

/* Estilos adicionales para la gestión de actividades extraescolares */

.section {
    margin-top: 150px;
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
}

.container {
    max-width: 800px;
    margin: 0 auto;
}

.container h2 {
    font-size: 24px;
    color: #333;
}

.container p {
    font-size: 16px;
    color: #666;
}

/* Fin estilos adicionales para la gestión de actividades extraescolares */
```
* Estilos de secciones: Cada seccion de la pagina tiene su propio estilo para destacar el contenido relevante.Se han utilizado fondos semitransparentes y sombras para resaltar las secciones y mejorar su legibilidad 
```java
/* Estilos para Contacto */
.textarea{
    width: 750px;
    height: 175px;
}

.campoemail{
    width: 300px;
}

.mapa{
    width: 750px;
}
/* Fin de estilos para contacto */
```
### Contenidos de la web <a name=webcontenido></a>
* Actividades: se incluye informacion sobre las activiades extraescolares ofrecidas por la institucion,que pueden incluir deportes,excursiones, charlas, entre otros eventos 
* Galeria de fotos: se presenta una seleccion de imagenes que muestran momentos especiales capturados durante las activades extracurriculares.Esto permita a los visitantes de la pagina tener una idea de la diversion y la participacion en la comunidad escolar 
* Logros y reconocimientos: se destaca el exito y los logros obtenidos por la institucion y sus estudiantes, lo que ayuda a fortalecer la reputacion y la imagen de la escuela
* Contacto: Se proporciona informacion de contacto para que los visitantes puedan comunicarse con la institucion si desean obtener mas informacion o realizar consultas


En base a la aplicacion que hemos realizado 
<br>

## Java 

### Diagrama de clases <a name="diagramaclases"></a>
[![DIAGRAMA-CLASES-EQUIPO2.png](https://i.postimg.cc/rsk1L6YF/DIAGRAMA-CLASES-EQUIPO2.png)](https://postimg.cc/gXgXv7Wf)
Clases y Atributos
### 1. GRUPO

id_grupo: PK

Codigo: UK

Curso: FK

Num_Alumnos: int

Activo: Boolean

### 2. CURSO

ID_curso: PK

Codigo: UK

Descripcion: String

Etapa: Enum

Activo: Boolean

### 3. ACTIVIDAD_SOLICITADA_O_DENEGADA

ID_Act: PK

Solicitante: String

Titulo: String

Departamento: int

Prevista: Enum

Fini: Date

Ffin: Date

Hini: Time

Transporte: Enum

Comentario_Transporte: String

Alojamiento: Enum

Comentario_Alojamiento: String

Estado: Enum

Comentario_Estado: String

### 4. ACTIVIDAD_PROGRAMADA

Id_Actividad: int

Titulo: Varchar

Tipo: Enum

Departamento: int

Prevista: Enum

Fini: Date

Ffin: Date

Hini: Time

Transporte: Enum

Comentario_transporte: String

Alojamiento: Enum

Comentario_Alojamiento: String

Comentario: String

Estado: Enum

Comentario_Estado: String

Empresa_Transporte: String

### 5. PROFE_RESPONSABLE

Id_profesor: FK
Id_actividad: FK
PROFESOR

ID_Prof: PK

nombre: String

apellido: String

DNI: String

Correo: String

Activo: Boolean

Contrasena: String

Perfil: Enum

### 6. DEPARTAMENTO

id_dep: PK

Jefe: int

Codigo: String

Nombre: String

Codigo_Departamento: Char

### 7. TRANSPORTE

Id_Transporte: PK

Tipo: Enum

Comentario: String

###  Relaciones

* GRUPO tiene una relación de uno a muchos con ACTIVIDAD_SOLICITADA_O_DENEGADA.

* CURSO está relacionado con GRUPO mediante una clave foránea.

* ACTIVIDAD_SOLICITADA_O_DENEGADA está relacionada uno a uno con ACTIVIDAD_PROGRAMADA.

* ACTIVIDAD_SOLICITADA_O_DENEGADA está relacionada uno a muchos con PROFE_RESPONSABLE.

* PROFE_RESPONSABLE tiene claves foráneas hacia PROFESOR y ACTIVIDAD_SOLICITADA_O_DENEGADA.

* PROFESOR tiene una relación de uno a muchos con PROFE_RESPONSABLE.

* ACTIVIDAD_SOLICITADA_O_DENEGADA está relacionada con DEPARTAMENTO mediante un atributo.

* DEPARTAMENTO tiene una relación de uno a muchos con ACTIVIDAD_PROGRAMADA.

* TRANSPORTE tiene una relación de uno a muchos con ACTIVIDAD_PROGRAMADA.
***

### Decisiones tomadas para realizar la asignacion de cursos y grupos <a name="cursosygrupos"></a>

* Si el profesor ingresa 0 alumnos le saldra una ventana de error el que te tiene que ser superior o igual al número de alumnos o si ingresa más de 72 alumnos que es el máximo le saldra un mensaje de error para que vuelva a introdcuir los datos
  
[![IMG-8668.png](https://i.postimg.cc/SR9B0Tt3/IMG-8668.png)](https://postimg.cc/Fk9W3ZvV)


  
* Este es el codigo que hemos utilizado 
``` java
    private void guardargruposparticipantesMouseClicked(java.awt.event.MouseEvent evt) {                                                        
        int[] gruposSeleccionados = listagruposparticipantes.getSelectedIndices();
        for (int index : gruposSeleccionados) {
            String grupoSeleccionado = listagruposparticipantes.getModel().getElementAt(index);
            int maximoAlumnos = this.obtenerNumAlumnosGrupo(grupoSeleccionado);
            boolean valido = false;
            while (!valido) {
                try {
                    String inputValue = JOptionPane.showInputDialog("Ingrese el número de alumnos participantes del grupo: " + grupoSeleccionado + grupoSeleccionado + "(Máximo: " + maximoAlumnos + ")");
                    if (inputValue != null && !inputValue.isEmpty()) {
                        int number = Integer.parseInt(inputValue);
                        if (number <= maximoAlumnos && number > 0) {
                            valido = true;
                            Mapagruposselecionados.put(grupoSeleccionado, number);
                        } else {
                            throw new Exception("Tiene que ser inferior o igual al número máximo de alumnos");
                        }
                    } else {
                        throw new Exception("Insertar el número de alumnos");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido para " + grupoSeleccionado);
                } catch (Exception exs) {
                    JOptionPane.showMessageDialog(null, exs.toString());
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Selecciones guardadas con éxito:\n" + Mapagruposselecionados);
        gruposparticipantes.setVisible(false);

    }
```

### CONTACTO <a name="contacto"></a>

* 📫 Gmail: ies.miguel.herrero.pereda@educantabria.es
* 📲 Télefono: 942 88 24 98
* 📌 Ubicación: P.º de Julio Hauzeur, 59, 39300, Torrelavega, Cantabria

<br>

| Tecnologias utilizadas   | Asociado a: |
|----------------|-------------------|
| Visual Studio | Pagina web |
| Mysql Workbench | Para realizar tablas  |
| NetBeans | Programar la interfaz   |
| Logo | Leoanador IA   |











