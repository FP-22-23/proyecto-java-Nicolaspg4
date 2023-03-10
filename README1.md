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

#### Tipos auxiliaress
Este proyecto, cuenta con un tipo Enumerate llamado Posicion, que cuenta con 5 propiedades: PointGuard, ShootingGuard, Center, SmallForward, PowerForward..

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
