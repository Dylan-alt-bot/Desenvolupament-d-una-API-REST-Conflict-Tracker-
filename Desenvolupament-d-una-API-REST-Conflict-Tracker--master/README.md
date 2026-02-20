# Conflict Tracker 

## Descripció del Projecte
**Conflict Tracker API** és un sistema d'informació backend desenvolupat amb **Java 17** i **Spring Boot 3**. La seva finalitat és gestionar i fer un seguiment dels conflictes bèl·lics a nivell mundial, incloent-hi les faccions involucrades, els països participants i els esdeveniments clau associats a cada conflicte.

El projecte s'ha dissenyat seguint una arquitectura per capes (Controlador, Servei, Repositori), utilitzant **Spring Data JPA** per a la persistència de dades (H2 en desenvolupament i PostgreSQL preparat per a producció) i l'ús de **DTOs** (Data Transfer Objects) per protegir i desacoblar el model de dades intern. Inclou també un frontend testimonial en HTML pur i JavaScript per validar el consum de l'API.

---

## Requisits Previs
*(https://maven.apache.org/) o(https://gradle.org/) (el projecte inclou els *wrappers* `mvnw` o `gradlew` pel que no és estrictament necessari tenir-los instal·lats al sistema).

---

## Com compilar i executar l'aplicació 

Obre un terminal a l'arrel del projecte i executa les següents comandes segons el gestor de dependències que utilitzis.


Un cop l'aplicació estigui en marxa, el servidor s'executarà al port 8080.
Pots comprovar el frontend testimonial accedint a:(http://localhost:8080)
L'API estarà disponible sota el prefix: http://localhost:8080/api/v1

# Exemples d'Us

1. Obtenir tots els conflictes
   
   curl -X GET http://localhost:8080/api/v1/conflicts

2. Obtenir els conflictes filtrats per estat (Ex: ACTIVE)
   
   curl -X GET "http://localhost:8080/api/v1/conflicts?status=ACTIVE"

3. Obtenir conflictes per codi de país (Ex: Ucraïna - UKR)
   
   curl -X GET http://localhost:8080/api/v1/countries/UKR/conflicts
4. 
4. Obtenir el detall d'un conflicte concret (Ex: ID 1)
  
   curl -X GET http://localhost:8080/api/v1/conflicts/1

5. Crear un nou conflicte (POST)
   Nota: Assegura't de definir l'encapçalament Content-Type: application/json.
   
   curl -X POST http://localhost:8080/api/v1/conflicts \
   -H "Content-Type: application/json" \
   -d '{
   "name": "Segona Guerra Mundial",
   "startDate": "1939-09-01",
   "status": "ENDED",
   "description": "Conflicte militar global que es va desenvolupar entre 1939 i 1945."
   }'

6. Actualitzar un conflicte existent (PUT)
   
   curl -X PUT http://localhost:8080/api/v1/conflicts/1 \
   -H "Content-Type: application/json" \
   -d '{
   "name": "Guerra Russo-Ucraïnesa",
   "startDate": "2014-02-20",
   "status": "ACTIVE",
   "description": "Descripció actualitzada del conflicte."
   }'

7. Eliminar un conflicte (DELETE)
   
   curl -X DELETE http://localhost:8080/api/v1/conflicts/1
