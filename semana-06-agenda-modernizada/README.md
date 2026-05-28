# Agenda Modernizada con Streams y JUnit

Proyecto desarrollado en Java utilizando Streams API, Optional, Gson y pruebas unitarias con JUnit 5.

---

## Tecnologias

- Java 21
- Maven
- Gson
- JUnit 5
- Streams API
- Optional

---

## Funcionalidades

- agregar contactos
- buscar contactos
- filtrar por categoria
- ordenar contactos
- guardar JSON
- cargar JSON
- pruebas unitarias

---

## Estructura

```txt
semana-06-agenda-modernizada/
│
├── src/
├── datos/
├── capturas/
├── pom.xml
└── README.md
```

---

## Ejecutar

```bash
mvn exec:java -Dexec.mainClass="Main"
```

---

## Ejecutar tests

```bash
mvn test
```

---

## Caracteristicas modernas usadas

### Streams

- filter
- map
- collect
- count
- sorted
- anyMatch

### Optional

- Optional<Contacto>
- ifPresentOrElse()

### Testing

- assertEquals
- assertTrue
- assertFalse
- assertThrows

---

## Autor

Mateo Rocabado Vargas
Universidad Tecnica de Oruro