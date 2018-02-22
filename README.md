# Instrucciones


1. Abra los proyectos en Netbeans

2. En Netbeans Vaya a Services, Databases, JavaDB y cree una base de datos que se llame eventoDB (los dem´s campos dejelos en blanco)



## Punto 1. Ud debe completar el servicio que permite crear un evento. 

Tenemos un Recurso Evento que representa los eventos que suceden en una ciudad. 
De cada evento se conoce su nombre (name) y su tipo (ambos String) y se tiene un campo 
id de tipo Long que representa la llave primaria del evento. 

 Para esto Ud. debe:

1. Crear la clase EventoEntity con los atributos (se da la clase BaseEntity para que su clase 
extienda de ella y herede el `Long id` como llave primaria)

2. Completar en la clase EventoPersistence el método que permite crear el evento. 
Se debe llamar `create`: recibe y retorna un `EventoEntity`

3. Ejecute la prueba en EventoPersistenceTest (guardar la imagen de la prueba en 
un archivo llamado `pruebapersistencia.jpg`en la carpeta `images` en el proyecto raíz.

4. Defina el método createEvento de la clase EventoLogic, el cual recibe un objeto 
EventoEntity y valida las siguientes reglas de negocio:
1) Que no exista un evento con el mismo nombre
2) Que el tipo del evento sea válido (utilice el método dado en la clase EventoLogic).
Si ambas reglas de negocio se cumplen, se debe llamar la persistencia para que 
el objeto sea persistido, de lo contrario debe lanzar una excepción 
BussinessLogiException con un mensaje donde se especifique cual regla no se cumplió.


Ejecutar el programa y probar en postman el servicio:

`POST localhost:8080/eventos-web/api/eventos`

a. Ingresar el siguiente json: 

`{ 
  "name": "El hombre Elefante",
  "tipo": "1-Musical"
}`

Guarde una pantalla del resultado en  un archivo llamado postok.jpg en la carpeta
 `images` en el proyecto raiz.

b. Ingresar el siguiente json;

`{ 
  "name": "El hombre Elefante",
  "tipo": "Teatro"
}`

Guarde una pantalla del resultado en  un archivo llamado postnook.jpg en la carpeta
 `images` en el proyecto raiz.


## Punto 2: Un evento se presenta en una ciudad. Cada ciudad  tiene un name (String) y de nuevo un Lon id que es la llave primaria.
Ud. debe extender su programa para que cuando ejecute 

`POST localhost:8080/eventos-web/api/eventos`

con el json:

`{ 
  "name": "Suenan las campanas",
  "tipo": "1-Musical",
  "ciudad": {
              "name": "Bogota"
            }
}`

Se cree el evento con la información de la ciudad. 

Para esto Ud. debe:

1. Crear las clases CiudadDTO y CiudadEntity que modelan la ciudad.  

En la clase CiudadDTO, además de tener un constructor sin parámetros, 
para convertir una CiudadEntity en una CiudadDTO defina el siguiente constructor:

public CiudadDTO(CiudadEntity ciudad) {
        this.id = evento.getId();
        this.name = evento.getName();
    }

Para convertir una CiudadDTO  en una CiudadEntity defina el siguiente método:

public CiudadEntity toEntity() {
        CiudadEntity entity = new CiudadEntity();
        entity.setId(this.id);
        entity.setName(this.name);      
        return entity;
    }

2. Defina un atributo nuevo en EventoDetailDTO que representa la ciudad donde 
se presenta el evento. Defina set/get y actualice los demás métodos con el nuevo 
atributo incluyendo el constructor que recibe un EVentoEntity y el métodod toEntity. 

3. Defina en EventoEntity la relación con ciudad (unidireccional). Está es una relación de muchos 
a uno (ManyToOne). Para lograr que cuando se cree el evento se cree también la ciudad,
la anotación debe tener la propiedad de:

cascade = CascadeType.ALL

4. Ejecute 

a. `POST localhost:8080/eventos-web/api/eventos`

con el json:

`{ 
  "name": "Suenan las campanas",
  "tipo": "1-Musical",
  "ciudad": {
              "name": "Bogota"
            }
}`

b. Fijese en el id que retornó el POST y Ejecute 

`GET localhost:8080/eventos-web/api/eventos/idqueretornoelpostanterior`

Guarde el resultado en una imagen que se llame postconciudad.jpg y guarde el archivo 
en la carpeta  `images` en el proyecto raiz.
