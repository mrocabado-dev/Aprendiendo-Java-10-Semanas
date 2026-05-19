# Sistema de Gestion de Estudiantes

Proyecto desarrollado en Java utilizando Collections Framework.

El sistema permite registrar estudiantes, buscar por carnet, ordenar por promedio y mostrar estadisticas.

---

## Conceptos Aplicados

- HashMap
- TreeSet
- ArrayList
- Comparable
- CRUD
- Collections Framework
- Programacion Orientada a Objetos

---

## Estructura

```txt
semana-04-estudiantes-collections/
│
├── Main.java
├── README.md
│
├── modelo/
│   └── Estudiante.java
│
├── servicio/
│   └── GestorEstudiantes.java
│
└── capturas/
```

---

## Collections Utilizadas

| Collection | Uso |
|---|---|
| HashMap | busqueda rapida por carnet |
| TreeSet | ranking ordenado |
| ArrayList | historial de acciones |

---

## Comparable

La clase Estudiante implementa Comparable para ordenar estudiantes por promedio.

En caso de empate se usa el carnet para evitar duplicados en TreeSet.

---

## Funcionalidades

- Agregar estudiante
- Buscar estudiante
- Actualizar promedio
- Eliminar estudiante
- Mostrar ranking
- Mostrar top 5
- Filtrar por carrera
- Mostrar estadisticas
- Mostrar historial

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

## Ejemplo de Ranking

```txt
1. [2021006] Pedro Vargas Sistemas 55.0
2. [2021004] Luis Mamani Civil 61.0
3. [2021010] Diego Arce Civil 67.5
```

---

## Autor

Mateo Rocabado Vargas
Universidad Tecnica de Oruro