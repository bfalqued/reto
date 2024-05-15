# Documentacion general ⭐️

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

### Diagrama E/R <a name="diagramaE/R"></a>

[![Diagrama-ER.png](https://i.postimg.cc/N049Fr39/Diagrama-ER.png)](https://postimg.cc/VSJLH5Lm)

En este diagrama de entidad y relacion, hemos podido representar las cardinalidades necesarias y los atributos que disponen, ademas mostrando las claves primarias 


<br>

### Diagrama relacional <a name="diagramaR"></a>
***

[![Modelo-Relacional-Reto-Equipo2-2-drawio.png](https://i.postimg.cc/htRf0rgQ/Modelo-Relacional-Reto-Equipo2-2-drawio.png)](https://postimg.cc/0bZkk7z9)

En este diagrama relacional podemos tener una vision clara de las tablas que componen 


### Archivo de importación SQL 
*** 
https://github.com/bfalqued/reto/blob/rama-elsa/Base%20de%20Datos/Scrip



<br>

## Web
[![inicio.png](https://i.postimg.cc/sXVqtBSH/inicio.png)](https://postimg.cc/hJ52mt2V)
### Estructura de la pagina web <a name="WebEstructura"></a>
***

La estructura de la pagina web sigue un diseño minimalista y funcional, con un encabezado fijo que incluye el logotipo de la instuticion escolar y un menu de navegacion para acceder facilmente a los diferentes apartados. 
Se ha implementado un menu lateral despegable para una mejor experiencia de usuario en dispositivos moviles 

El contenido de la página se divide en secciones, cada una representada por un apartado HTML diferente. Estas secciones incluyen actividades,galeria de fotos,logros y reconocimientos y contacto. 
Cada seccion tiene su propio encabezado y contenido relevante 

### Decisiones de diseño

* Encabezado y Menú de Navegación: Se ha optado por un encabezado fijo que facilita la navegación del usuario en todo momento. El menú de navegación presenta enlaces claros y directos a cada red social del instituto
* Fondo y capa semitransparente:El fondo de la página presenta una imagen de montañas nevadas, que evoca una sensación de tranquilidad y naturaleza. Se ha añadido una capa semitransparente sobre el fondo para mejorar la legibilidad del texto y los elementos de la página.
* Galería de Fotos en Cuadrícula: La galería de fotos se presenta en una cuadrícula de tres columnas para una visualización ordenada y estética de las imágenes. Esto facilita la exploración de las fotos y mejora la experiencia del usuario.

### Tipos de estilos utilizados <a name=WebEstilos></a>
* Estilos Globales: Se han utilizado estilos globales para establecer márgenes, rellenos y fuentes predeterminadas para todos los elementos de la página. Esto garantiza consistencia en todo el diseño y una apariencia uniforme en toda la página web.
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

### Contenidos de la web <a name=#WebContenido></a>
* Actividades: se incluye informacion sobre las activiades extraescolares ofrecidas por la institucion,que pueden incluir deportes,excursiones, charlas, entre otros eventos 
* Galeria de fotos: se presenta una seleccion de imagenes que muestran momentos especiales capturados durante las activades extracurriculares.Esto permita a los visitantes de la pagina tener una idea de la diversion y la participacion en la comunidad escolar 
* Logros y reconocimientos: se destaca el exito y los logros obtenidos por la institucion y sus estudiantes, lo que ayuda a fortalecer la reputacion y la imagen de la escuela
* Contacto: Se proporciona informacion de contacto para que los visitantes puedan comunicarse con la institucion si desean obtener mas informacion o realizar consultas


En base a la aplicacion que hemos realizado 
<br>

## Java 

### Diagrama de clases <a name="diagramaClases"></a>
[![DIAGRAMA-CLASES-EQUIPO2.png](https://i.postimg.cc/rsk1L6YF/DIAGRAMA-CLASES-EQUIPO2.png)](https://postimg.cc/gXgXv7Wf)
Clases y Atributos
1. GRUPO
***
id_grupo: PK

Codigo: UK

Curso: FK

Num_Alumnos: int

Activo: Boolean

2. CURSO
***
ID_curso: PK

Codigo: UK

Descripcion: String

Etapa: Enum

Activo: Boolean

3. ACTIVIDAD_SOLICITADA_O_DENEGADA
***
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

4. ACTIVIDAD_PROGRAMADA
***
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

5. PROFE_RESPONSABLE
***
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

6. DEPARTAMENTO
***
id_dep: PK

Jefe: int

Codigo: String

Nombre: String

Codigo_Departamento: Char

7. TRANSPORTE
***
Id_Transporte: PK

Tipo: Enum

Comentario: String

* Relaciones
*** 
GRUPO tiene una relación de uno a muchos con ACTIVIDAD_SOLICITADA_O_DENEGADA.

CURSO está relacionado con GRUPO mediante una clave foránea.

ACTIVIDAD_SOLICITADA_O_DENEGADA está relacionada uno a uno con ACTIVIDAD_PROGRAMADA.

ACTIVIDAD_SOLICITADA_O_DENEGADA está relacionada uno a muchos con PROFE_RESPONSABLE.

PROFE_RESPONSABLE tiene claves foráneas hacia PROFESOR y ACTIVIDAD_SOLICITADA_O_DENEGADA.

PROFESOR tiene una relación de uno a muchos con PROFE_RESPONSABLE.

ACTIVIDAD_SOLICITADA_O_DENEGADA está relacionada con DEPARTAMENTO mediante un atributo.

DEPARTAMENTO tiene una relación de uno a muchos con ACTIVIDAD_PROGRAMADA.

TRANSPORTE tiene una relación de uno a muchos con ACTIVIDAD_PROGRAMADA.
***

### Decisiones tomadas para realizar la asignacion de cursos y grupos

* Si el profesor ingresa 0 alumnos le saldra una ventana de error el que te tiene que ser superior o igual al número de alumnos o si ingresar demasiados alumnos saltara mismamente un mensaje de error
  
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



| Tecnologias utilizadas   | Asociado a: |
|----------------|-------------------|
| Visual Studio | Pagina web |
| Mysql Workbench | Para realizar tablas  |
| NetBeans | Programar la interfaz   |

