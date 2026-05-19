# Sistema de Gestion de Vehiculos POO

Sistema desarrollado en Java para gestionar distintos tipos de vehiculos utilizando Programacion Orientada a Objetos.

El proyecto demuestra:

- herencia
- clases abstractas
- interfaces
- polimorfismo
- ArrayList
- menus interactivos

---

## Estructura del Proyecto

```txt
semana-03-vehiculos-poo/
│
├── Main.java
├── README.md
│
├── modelo/
│   ├── Vehiculo.java
│   ├── Auto.java
│   ├── Moto.java
│   ├── Camion.java
│   ├── Electrico.java
│   ├── AutoElectrico.java
│   └── MotoElectrica.java
│
├── servicio/
│   └── GestorVehiculos.java
│
└── capturas/
```

---

## Diagrama de Clases

```txt
[ Vehiculo ] (abstract)
        |
  -------------------------
  |           |           |
[Auto]      [Moto]    [Camion]
  |            |
[AutoElectrico] [MotoElectrica]
        |
   << Electrico >>
```

---

## Decision de Diseño

### ¿Por que Vehiculo es abstracta?

Vehiculo representa una plantilla general de cualquier vehiculo.

No tiene sentido crear un vehiculo generico directamente, por eso se utiliza una clase abstracta.

Ademas obliga a que las clases hijas implementen el metodo:

```txt
acelerar()
```

---

### ¿Por que Electrico es interfaz?

Electrico representa un comportamiento.

Los vehiculos electricos necesitan:

- cargar bateria
- mostrar bateria
- verificar carga

Una interfaz permite que distintas clases implementen ese comportamiento.

---

## Conceptos Aplicados

| Concepto | Aplicado |
|---|---|
| Herencia | Sí |
| Polimorfismo | Sí |
| Clase abstracta | Sí |
| Interface | Sí |
| ArrayList | Sí |
| Packages | Sí |
| Override | Sí |

---

## Compilacion

```bash
javac Main.java modelo/*.java servicio/*.java
```

---

## Ejecucion

```bash
java Main
```

---

## Ejemplo de Salida

```txt
=== POLIMORFISMO ===

Toyota Corolla acelera suavemente
Honda CB500 acelera rapidamente
Volvo FH16 acelera lentamente
Tesla Model 3 acelera silenciosamente
NIU MQi+ acelera de forma electrica
```

---

## Funcionalidades

- Registrar vehiculos
- Listar vehiculos
- Filtrar por tipo
- Mostrar electricos
- Cargar baterias bajas
- Demostrar polimorfismo
- Mostrar estadisticas

---

## Autor

Mateo Rocabado Vargas
Universidad Tecnica de Oruro