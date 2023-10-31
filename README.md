# Persona-DAO-mysql

Esercizio da consegnare su design pattern in OOP<br>
Scrivere <a href="https://i.ibb.co/VV38wz4/UML-DAO.png">UML</a> e implementare in Java un DAO (Data Access Object). Il programma deve
consentire all’utente di creare una Persona (con un id, nome, cognome, età, email, numero di
telefono), rimuovere una Persona tramite id, aggiornare una Persona(esempio modificare
email o telefono), leggere la lista di Persone contenute nel database.<BR>
● <b>La Persona deve essere costruita utilizzando il Design Pattern “Builder”</b>.<br>
● Nel momento in cui il “Client”/Main cambia l’email o il numero di telefono della
persona salvata nel database, un’email di notifica all’amministratore (ovvero voi
stessi, alla vostra casella di posta) deve essere inviata per notificare l’evento.
Questo punto va implementato utilizzando il Design Pattern “Observer”.
● L’UML da consegnare deve essere solo del DAO.

Per lo storage dei dati rappresentati: MySQL.
