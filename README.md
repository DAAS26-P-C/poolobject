[![codecov](https://codecov.io/gh/DAAS26-P-C/poolobject/graph/badge.svg?token=7SNQCQ7DLK)](https://codecov.io/gh/DAAS26-P-C/poolobject)

poolobject
==========


Java code example of creational design pattern pool object

Workshop to use good practices in software development: testing, ci and measurement.

Authors:

- Carlos Lopez Nozal
- Jesus Alonso Abad

Editors:

- Carmen Minguela - <cmz1002@alu.ubu.es>
- Melany Loma - <mlc1016@alu.ubu.es>
- Rodrigo Ortiz - <roe1001@alu.ubu.es>
- Judith Vinós - <jvs1007@alu.ubu.es>

# PoolObject-Informe de pruebas y cobertura

## Objetivos de la actividad

Los objetivo de esta actividad han sido:

* Implementación de un patrón de diseño (Pool Object)
* Desarrollo incremental de pruebas unitarias con JUnit 5
* Medición de cobertura mediante JaCoCo y Codecov
* Uso de integración continua con GitHub Actions
* Trabajo colaborativo con control de versiones Git

El repositorio contiene la implementación del sistema, la batería de pruebas desarrolladas y la configuración de integración continua que valida automáticamente cada cambio.

---

## Enunciado

Hemos trabajado sobre un proyecto base que implementa el patrón Pool Object.
La actividad consiste en:

* Analizar el código existente
* Diseñar y desarrollar pruebas unitarias
* Incrementar progresivamente la cobertura
* Configurar integración continua
* Documentar el proceso y los resultados obtenidos

---

## ¿Se ha realizado trabajo en equipo?

Sí, el trabajo se ha desarrollado de forma colaborativa mediante un repositorio compartido en GitHub a través de una Organizacion.

Cada miembro del equipo hemos ido contribuyendo con commits que añadían nuevas pruebas o mejoraban las existentes. El historial del repositorio muestra las  contribuciones de múltiples autores, lo que se puede verificar la participación conjunta en el desarrollo.

Además, se han realizado operaciones de sincronización, resolución de conflictos y merges, propias de un flujo de trabajo colaborativo real.
Podemos verlo a través de las actions del propio repositorio de GitHub: https://github.com/DAAS26-P-C/poolobject/actions

**Indicadores cuantitativos:**

* Múltiples autores en el historial de commits
* Commits distribuidos entre miembros del equipo
* Resolución de conflictos durante la integración

---

## ¿Tiene calidad el conjunto de pruebas disponibles?

Sí, el conjunto de pruebas presenta una calidad adecuada al cubrir:

* Comportamiento normal del sistema
* Manejo de excepciones
* Verificación de propiedades del patrón Singleton
* Reutilización de objetos del pool

Las pruebas se han desarrollado de forma incremental, lo que ha permitido aumentar progresivamente la cobertura y detectar escenarios no contemplados inicialmente.
Pruebas mediante CodeCov: https://app.codecov.io/gh/DAAS26-P-C/poolobject

**Indicadores cuantitativos:**

* Ejecución automática de pruebas en CI
* Cobertura elevada medida con JaCoCo y Codecov
* Inclusión de pruebas positivas y negativas

---

## ¿Cuál es el esfuerzo invertido en realizar la actividad?

El esfuerzo se ha distribuido en varias fases:

1. Análisis del código base
2. Diseño de casos de prueba
3. Implementación incremental de tests
4. Configuración de integración continua
5. Resolución de conflictos Git
6. Documentación del proceso

El trabajo colaborativo implicó coordinación entre miembros y sincronización de cambios, lo que forma parte del esfuerzo real de desarrollo en equipo.
Podemos ver el trabajo colaborativo de cada uno de ellos en el siguiente enlace: https://github.com/DAAS26-P-C/poolobject/graphs/contributors

**Indicadores cuantitativos:**

* Número de commits realizados
* Número de iteraciones de pruebas
* Tiempo dedicado a resolución de conflictos y sincronización

---

## ¿Cuál es el número de fallos encontrados en el código original?

Mediante el desarrollo de las pruebas hemos identificado comportamientos no cubiertos y situaciones excepcionales que no estaban validadas inicialmente, como:

* Adquisición de instancias cuando no existen recursos libres
* Liberación duplicada de objetos
* Comportamiento del cliente ante excepciones

Estos aspectos no representaban errores funcionales críticos, pero sí casos no verificados que fueron detectados gracias a la actividad de testing.

**Indicadores cuantitativos:**

* Excepciones contempladas mediante pruebas negativas
* Mejora progresiva de cobertura
* Nuevos escenarios incorporados al conjunto de tests

---

## ¿El proceso de integración continua realizado ha sido de calidad?

Sí, se ha configurado un pipeline de integración continua mediante GitHub Actions que:

* Compila el proyecto
* Ejecuta automáticamente la batería de pruebas
* Genera informes de cobertura
* Publica resultados en Codecov

Esto garantiza que cada cambio en el repositorio sea validado automáticamente y permite detectar fallos de forma temprana.

**Indicadores cuantitativos:**

* Ejecución automática del workflow en cada push
* Publicación de informes de cobertura
* Estado visible del pipeline en el repositorio

---

## Conclusión

La actividad ha permitido aplicar de forma práctica conceptos clave de calidad software, incluyendo testing, medición de cobertura, integración continua y trabajo colaborativo.

El desarrollo incremental de pruebas y la automatización del proceso de validación han contribuido a mejorar la confianza en el sistema y a adquirir experiencia en prácticas profesionales de desarrollo software.

