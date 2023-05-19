# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Nicolás Pérez Gómez  uvus: nicpergom

Trabajaremos con un dataset de datos sobre jugadores de la nba. 
Ofrece datos sobre la nba como el salario del jugador en cuestión, 
el nombre del jugador o su estatura.
Utilizaremos una programación orientada a objetos (java) para realizar consultas sobre este dataset.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.NBA**: Paquete que contiene los tipos del proyecto.
  * **fp.NBA.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto.
    * **NBA19-20.csv**: Dataset de datos sobre NBA.
    
## Estructura del *dataset*

El dataset está compuesto por 11 columnas, con la siguiente descripción:

* **Salary**: de tipo Integer, representa el salario de un jugador.
* **Player**: de tipo String, representa el nombre del jugador.
* **DateOfBirth**: de tipo LocalDate, representa la fecha de nacimiento del jugador.
* **Retired**: de tipo Boolean, representa si el jugador está retirado o no.
* **Height**: de tipo Double, representa la estatura del jugador.
* **Team**: de tipo String, representa el equipo en el que ha jugado.
* **Copa**: de tipo Boolean, representa si tiene una copa o no.
* **Weight**: de tipo Double, representa el peso del jugador.
* **Nationality**: de tipo String, representa la nacionalidad del jugador.
* **Position**: de tipo Enumerate, representa la posición del jugador.
* **equiposHaJugado**: de tipo List<String>, representa una lista de los equipos en los que ha jugado ese jugador.
	
	Además, el dataset está formado por 15 filas. La primera es la cabecera y las demás son los registros. 

## Tipos implementados



### Tipo Base
En el tipo base del proyecto (NBA.java), se declaran las propiedades básicas del tipo, las propiedades derivadas, las funciones auxiliares, los métodos getters y setters, los constructores, los checkers, el método de igualdad, el método de orden natural y la representación como cadena.

**Propiedades**:

- salary, de tipo Integer, consultable y modificable. 
- player, de tipo String, consultable. 
- cumpleaños, de tipo LocalDate, consultable.
- retirado, de tipo Boolean, consultable.
- altura, de tipo Double, consultable.
- team, de tipo String, consultable y modificable.
- copa, de tipo Boolean, consultable.
- peso, de tipo Double, consultable.
- nacionalidad, de tipo String, consultable.
- position, de tipo Posicion, consultable.
- equiposHaJugado, de tipo Lista, consultable y modificable.
**Constructores**: 

- C1: Un constructor con todas las propiedades del tipo.
- C2: Un constructor con las propiedades: salary, player, altura, team, peso, nacionalidad, position.
- C3: Un constructor con la propiedad: cumpleaños.

**Restricciones**:
 
- R1: La altura debe ser positiva, altura >0
- R2: El salario del jugador debe ser 0 o mayor que 0, salary >=0
- R3: El peso debe ser positivo, peso >0
- R4: La fecha del cumpleaños debe ser anterior a la fecha de hoy, cumpleaños.isBefore(LocalDate.now())

**Criterio de igualdad**: Para que dos objetos sean iguales se tiene que cumplir que:
	- Las nacionalidades sean iguales, el nombre del jugador, el equipo en el que juegan y la estatura.

**Criterio de ordenación**: Para establecer el orden natural, primero, comparamos por altura, posteriormente por el nombre del jugador, después, por la nacionalidad y por último, por el peso.

**Otras operaciones**:
 
-	getEdadJugador: Calcula la edad del jugador calculando el periodo de tiempo que hay desde el dia de hoy hasta la fecha de su cumpleaños.
- 	getCoefAlturaPeso: Calcula el coeficiente altura/peso..

#### Tipos auxiliares
Este proyecto, cuenta con un tipo Enumerate llamado Posicion, que es un tipo auxiliar, que cuenta con 5 propiedades: PointGuard, ShootingGuard, Center, SmallForward, PowerForward.

### Factoría
En la factoría de este proyecto, tenemos dos funciones principales: la de que el programa sea capaz de leer el csv y la de que los datos estén correctamente parseados. Por otro lado, también existen métodos de parseo de algunas propiedades en concreto como "parseaRetirado" o "parseaCopa".
- leerNBA (String fichero): Este método se encarga de la correcta lectura del fichero csv en el que tenemos todos los datos que posteriormente serán leídos.
- parseaNBA (String lineaCSV): Este método se encarga del parseo de los datos, es decir, que todos los datos estén en su correspondiente tipo, poner un formato a la fecha etc.
- parseaRetirado (String cadena): Este método se encarga del parseo de una propiedad, en este caso, si el jugador está retirado o no. Esta propiedad es de tipo Boolean.
- parseaCopa (String copa): Este método se encarga del parseo de una propiedad, en este caso, si el jugador tiene una copa o no. Esta propiedad es de tipo Boolean.

### Tipo Contenedor

Es la clase contenedora de los objetos NBA. En este tipo contenedor, tenemos distintos tratamientos secuenciales en los que accedemos a los datos del csv y realizamos operaciones de filtrado, de suma, diccionarios etc.


**Otras operaciones**:
 
-	getNumeroElementos (): Obtiene el número de datos de NBA.
- 	agregarElementos (NBA n): Añadir nuevos datos a NBA.
-	incorporarNBA (List <NBA> totalNBA): Incorpora una lista de NBA.
- 	eliminarNBA (NBA a): Elimina una serie de datos de NBA
-	existeJugadorConAltura (ContenedorNBA, Double altura): Devuelve true si existe un jugador con la altura pasada como parámetro y false si no 	existe (de tipo Boolean).
-	getPesoTotal(): Devuelve la suma de todos los pesos de los jugadores (de tipo Double).
-	getJugadoresConCopa(): Devuelve una lista con todos los jugadores que han ganado una copa (de tipo List <String>).
-	agrupaJugadoresPorEquipo(): Devuelve un map en el que las claves son los equipos y los valores una lista con los jugadores que juegan en 	esos equipos (de tipo Map <String, List <String>>).
-	numeroJugadoresRetiradosOno(): Devuelve un map en el que las claves es true o false según si se han retirado o no y los valores el númeero 	de jugadores retirados o no (de tipo Map <Boolean, Integer>).
- 	existeJugadorParaEquipo(): verifica si existe algún jugador en el equipo especificado. Retorna un valor booleano que indica si hay jugadores en el equipo.

- 	MediaPesoJugadores(): calcula la media del peso de todos los jugadores. Retorna un valor de tipo Double que representa la media de los pesos.

- 	JugadoresNoRetirados(): filtra los jugadores que no se han retirado y devuelve una lista de sus nombres.

- 	getMaximaAlturaDeJugadorQueHaJugadoOJuegaEnUnEquipo(): busca el jugador más alto que haya jugado o juegue en un equipo específico y retorna su altura.

- 	getJugadoresMasAltosConCopaOrdenados(): selecciona los jugadores más altos que hayan ganado una copa y los ordena de forma descendente. Retorna una lista de alturas de tipo Double.

- 	getNacionalidadesPorEquipo(): devuelve un mapa donde las claves son los nombres de los equipos y los valores son listas de las nacionalidades de los jugadores de cada equipo.

- 	getNumeroJugadoresCadaNacionalidad(): devuelve un mapa donde las claves son las nacionalidades de los jugadores y los valores son el número de jugadores de cada nacionalidad.

- 	getSalarioMasAltoPorEquipo(): devuelve un mapa donde las claves son los nombres de los equipos y los valores son los salarios más altos de los jugadores de cada equipo.

- 	getNAlturasPorNacionalidad(): devuelve un mapa ordenado (SortedMap) donde las claves son las nacionalidades de los jugadores y los valores son las N alturas más altas de cada nacionalidad, ordenadas de forma descendente.

- 	getMayorNumeroJugadoresEnPosicion(): devuelve la posición con el mayor número de jugadores. Retorna un objeto Map.Entry que contiene la posición y el número de jugadores.

- 	getMayorMediaAlturaDeTodosLosEquipos():	 devuelve el equipo con la mayor media de altura de los jugadores. Retorna un objeto Map.Entry que contiene el nombre del equipo y la media de altura.

















