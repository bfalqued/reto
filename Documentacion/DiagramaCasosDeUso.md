
## Diagrama casos de uso 💢

[![Diagramas-de-uso-drawio-3.png](https://i.postimg.cc/0yWp92tQ/Diagramas-de-uso-drawio-3.png)](https://postimg.cc/w1NtVHY8)


Tendrá tres perfiles de usuario: Administrador, Profesor y Equipo directivo

Las operaciones que debería realizar la aplicación son las que se indican a continuación:

- Crear una solicitud por parte de un profesor 
- Consultar modificar una solicitud 
- Aprobacion/denegacon de solicitudes
- Ver solicitud
- Preparacion de solicitud


### Caso de uso: Crear solicitud 

• Actores involucrados: persona usuaria.
• Precondición: la agenda tiene que estar creada
• Flujo básico:
1. El profesor inicia la sesion en la aplicacion

2. Se pide que el profesor introduzca el departamento al que pertenece el profesor que hace la solicitud, titulo de la actividad, si la actividad estaba prevista, la contestation solo puede ser si/no, el medio de transporte que se llevara a cabo, fecha y hora de inicio de la actividad, Fecha y hora de fin de la actividad,grupo o cursos y número de alumnos,alojamiento y una informacion sobre la actividad

3. Tras la introducción de los datos, el sistema en la introducion de medio de transporte proponda una lista con los posibles valores , por ejemplo: andando, bici, bus, taxi, barco, tren o avión. En algunos casos puede ser más de una la
seleccionada, en grupos o cursos;la propuesta en un principio es seleccionar si es por cursos o por grupos. Una vez realizada esta selección se habilita una lista de los
cursos o una lista de los grupos,en el alojamiento  contestación solo puede ser si/no. En el caso que la opción sea si el sistema habilita un área donde el profesor especifica información acerca del alojamiento 


4. Se vuelve a solicitar al profesor la selección de una operación.


Los estados de una solicitud son:
* Solicitado: Es el estado cuando se crea una solicitud
* Aprobada: Es el estado al que pasa cuando el equipo directivo da el visto bueno a la
realización de la solicitud propuesta de la actividad.
* Denegada: Es el estado al que pasa cuando el equipo directivo considera que la solicitud propuesta de actividad no debe realizarse.
* Realizada: Es el estado al que pasa cuando una actividad ha sido Aprobada y la actividad
se ha realizado

### Caso de uso: Consultar/modificar una solitud por parte de un profesor 

1. Si el profesor solo tiene el rol de profesor, siempre va a poder ver las solicitudes creadas por él y en las que son responsable
2. Puede modificarla siempre que el estado sea solicitado,
mostramos las solicitudes ordenadas por fecha de inicio de la actividad
3. 

### Caso de uso: Aprobación/denegación de solicitudes
1. El profesor debe tener el perfil de equipo directivo o administrador


2. Muestra todas las solicitudes que están en estado solicitado y denegado apareciendo siempre las solicitadas primero que las denegadas y ordenadas por fechas de inicio,además, aparece un nuevo campo en la solicitud Comentarios del equipo directivo donde el equipo directivo aporta información sobre la decisión tomada. No es obligatorio que tenga que introducir dicha información
3. Cuando una solicitud pasa a estar Aprobada, implica que la actividad pasa a la fase de
preparación de la actividad, la solicitud es copiada con toda su información a una nueva
actividad. A partir de este estado la solicitud no puede ser modificada. Todos los cambios que
queremos incorporar se realizan en la actividad.

### Caso de uso: Preparación de solicitud

1. Esta opción es solo para el administrador y los profesores responsables.
2.  Es la actividad creada a partir de la solicitud aprobada, por lo tanto tiene todos los datos de la solicitud, titulo,estado,alojamiento,prevista,solicitante,transporte...
3. También se pueden modificar cualquiera de los datos traspasados de la solicitud mientras la
actividad no se encuentre en realizada
* Se propone que de un aviso si modifica una actividad que falten menos de 5 días para que inicie.
4. El administrador es el que tiene que cambiar el estado de la actividad a realizada.

### Caso de uso: Ver solicitud

1. Esta opción es solo para el profesor
2. Es la actividad creada apartir de la solicitud aprobada en la que permite ver todos los datos que se han introducido 
  
