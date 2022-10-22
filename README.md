# Reto Glya

Aplicación realizada con Spring boot.

## Instalación

1. Descargar java 11(Funciona con las ultimas versiones de java pero se debe cambiar la configuración de gradle) https://www.openlogic.com/openjdk-downloads.

## Ejecución

1. Ejecutar el proyecto de Spring boot en Visual Studio Code, o Intellij.

## API

Adicional se adjunta colección de postman con las urls.

1. Pacientes con 1ª y 2ª dosis que no tienen 3ª dosis. (Parámetros: ninguno): localhost:8080/glya/patients/twodoses
2. Numero de dosis por cada dia, según tipo de vacuna (parámetros: vacuna): localhost:8080/glya/encounter/days?vacuna=PFIZER
3. El número total de dosis aplicadas en un rango de fecha. (Parámetros:
Fecha inicial y Fecha Final del rango): localhost:8080/glya/encounter?start=2022-01-10&end=2022-04-30

## Codigo

El codigo se encuentra en el directorio Glya/src/main/Glya

 
