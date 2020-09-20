# Ejemplo de API REST con Spring Boot + MongoDB + Swagger2

## Descripción

Este ejemplo no es real, solo es demostrativo. Fue tomado como caso de estudio
cuando inicie mis andares por spring boot con mongodb, además le fue integrado swagger2.

Que es básico! Si lo es. Pues es el objetivo para aquellos que están iniciando les sirva como base.

## API expuesta por Swaggwe2

http://127.0.0.1:8080/swagger-ui.html

<div style="text-align: center; margin: 20px; width: 100%">
    <img style="width:500px" src="./src/main/resources/static/img/swagger.PNG" alt="Interfaz Swagger2"> 
</div>


## Modelo conceptual del negocio

Las Colecciones MongoDB están referenciadas entre si de la siguiente manera:

<div style="text-align: center; margin: 20px; width: 100%">
    <img style="width:500px" src="./src/main/resources/static/img/modelo.png" alt="modelo"> 
</div>

## Entidades:

```
Almacen: {
    id: Long,
    descripcion: String,
    codigo: String
}

CadenaTienda: {
    id: Long,
    descripcion: String,
    codigo: String
}

Duenno: {
    id: Long,
    nombre: String,
    segNom: String,
	ap1: String,
	ap2: String
}

Employee: {
    id: Long,
    firstName: String,
    lastName: String,
    emailId: String,
    municipio: String,
    estado: String,
    pais: String,
}

Estados: {
	id: Long,
	descripcion: String,
	codigo: String
}

Tienda: {
	id: Long,
	descripcion: String,
	codigo: String,
	estado: Estados,
	cadenaTienda: CadenaTienda,
	almacenes: List<Almacen>
}
```
