# PAO-FoodDeliveryApp
<h2>Etapa 1 </h2>
<p>1. Definirea sistemului:</p>
<p>-Să se creeze o lista pe baza temei alese cu cel puțin 10 acțiuni/interogări care se pot face în cadrul sistemului și o lista cu cel puțin 8 tipuri de obiecte.</p>
<p>2. Implementare: Să se implementeze în limbajul Java o aplicație pe baza celor definite la punctul 1. Aplicația va conține:</p>
<p>-Clase simple cu atribute private / protected și metode de acces</p>
<p>-Cel puțin 2 colecții diferite capabile să gestioneze obiectele definite anterior (List, Set, Map, etc.) dintre care cel puțin una sa fie sortata. Se vor folosi array-uri uni/bidimensionale in cazul in care nu se parcurg colectiile pana la data checkpoint-ului.</p>
<p>-Utilizare moștenire pentru crearea de clase adiționale și utilizarea lor în cadrul colecțiilor</p>
<p>- Cel puțin o clasa serviciu care sa expună operațiile</p>
<p>- O clasa main din care sunt făcute apeluri către servicii</p>

<p></p>
<p></p>
<p>Clase: entities.comanda, ComandaFelMancare, Curier, CurierSofer, CurierBiciclist, Client, Persoana, FelMancare, entities.restaurant, entities.appDelivery + interfata Service</p>
<p>Actiuni:</p>
<p>- pentru client -> afisare profil client</p>
<p>- pentru aplicatie -> adauga/sterge clienti</p>
<p>- pentru aplicatie -> adauga/sterge curieri</p>
<p>- pentru aplicatie -> adauga/sterge restaurante</p>
<p>- pentru aplicatie -> adauga comenzi</p>
<p>- pentru entities.restaurant -> adauga/sterge un fel de mancare</p>
<p>- pentru entities.restaurant -> afisare meniu</p>
<p>- pentru entities.comanda -> adauga ce sa fie in ea , feluri de mancare</p>
<p>- pentru entities.comanda -> afisare entities.comanda: cost + continut</p>
<p>- pentru client -> afisare total plata pentru entities.comanda + ce a comandat</p>
<p>- pentru curieri -> marire salariu</p>
<p>- pentru curieri -> afisare comenzi efectuate + ce continea fiecare entities.comanda efectuata</p>
<p>- pentru curieri -> afisare numar comenzi efectuate</p>
<h2>Etapa 2 </h2>
<p>1. Extindeți proiectul din prima etapa prin realizarea persistentei utilizând fișiere.</p>
<p>-Se vor realiza fișiere de tip csv 1(comma separated values) pentru cel puțin 4 dintre clasele definite in prima etapa.</p>
<p>-Se vor realiza servicii singleton generice pentru scrierea și citirea din fișiere</p>
<p>-La pornirea programului se vor încărca datele din fișiere utilizând serviciile create</p>

<p>2. Realizarea unui serviciu de audit</p>
<p>- se va realiza un serviciu care sa scrie într-un fișier de tip CSV de fiecare data când este executata una dintre acțiunile descrise in prima etapa. Structura fișierului: nume_actiune, timestamp</p>

<h2>Etapa 3 </h2>
<p>-Înlocuiți serviciile realizate în etapa a II-a cu servicii care sa asigure persistenta utilizând baza de date folosind JDBC.</p>
<p> Să se realizeze servicii care sa expună operații de tip create, read, update, delete pentru cel puțin 4 dintre clasele definite</p>

