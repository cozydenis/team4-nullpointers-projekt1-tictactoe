# Bewertung TicTacToe
## 🥇 Die Note ist: 5.70 (9.40/10.00 Punkte)

🧪 TicTacToe Gruppe 4 NullPointers 

👫 bachhmoh@students.zhaw.ch; topaljas@students.zhaw.ch; djafeden@students.zhaw.ch; dubuicol@students.zhaw.ch


⚖️ Notation der Punkte:   
`SWGrund: 3: (0-5): 5`  
`Name des Kriteriums: Gewichtung des Kriteriums: (min Punkt - max Punkt): gegebene Punkte`



## Allgemeine Anforderungen (all-or-nothing) 

> Voraussetzung für Punkterteilung: Die Applikation ist lauffähig. 


## Entwicklung 


👨‍🏫  Entwicklung: 6: (1-6): 5.5

> - Das Spiel besitzt die geforderte Funktionalität (Abzüge:  Ende nicht erkannt, Spielfeld nicht ausgedruckt, Sprachumschaltung nicht bei jedem Zug vorhanden, Illegale Züge nicht erkannt, Grundfunktionalität des Spiels (z.B. Spielregeln) fehlt, die Aufgabe ist nicht gelöst)
> - Sie halten die Vorgaben hinsichtlich einsetzbarer 
Konstrukte (z.B. Einsatz von Arrays) und Clean Code (siehe Anhang) ein 
> - Sie haben eine sinnvolle Aufteilung in Klassen 
und Klassendefinitionen gefunden (Kopplung, Kohäsion, Zuständigkeit, etc.)
> - Die Tests sind erfolgreich, sinnvoll, ausreichend und entsprechen dem Testkonzept


Kommentare der Lehrkraft   


Beim Testen des Spiels wurde leider ein Teil der zhaw-Infrastruktur durch eine Malware, die offensichtlich von dieser Software her verbreitet wurde, zerstört. Die CyberDefenceGroup der zhaw konnte die Spuren nicht zurückverfolgen, trotz unerklärlichen Spuren von Fledermaus-DNA 🦇. Aus diesem Grunde hat der Cyber-Angriff keinen Einfluss auf die Bewertung. 😉


Sehr schöne Hilfsfunktion und gutes Design der GUI!  
Die Smoke-Tests haben keinen Fehler gefunden.   

Sehr schöne Aufteilung des In- und Outputs, aber trotzdem war die Kopplung in der Klasse `Game` zu hoch.  Aber warum hat `Game` zwei Instanzen vom Output?   


Sehr schön war die Erkenntnis und die Diskussionen mit topaljas im Test `GameTest`, dass Gewisse Methoden der Klasse eine zu starke Kopplung an das Input haben und darum nicht getestet werdne können: sie sind nicht «isoliert» bzw. haben eine schlechte Kohärenz. Der Lerneffekt daraus ist höher zu bewerten als das Problem.   
In eineme nächsten Projekt sollten die Input- und Output-Dinge nicht mitten in Domänenelogig (hier: das Game) passieren, sondern in einer «Controller» Klasse o.ä.  


Bemerkung: die Methode `Game.start()` ist viel zu lange und sollte unbedingt in kleiner Methode aufgeteilt werdne, die eine Geschichte erzählen. CodeSmell: die inline Kommentare innerhalb der Methode sind ein Hinweis darauf, dass Methoden extrahiert werden sollten.   




Das Testkonzept und die ausführlichen Testklassen sind kohärent und sinnvoll! Weiter so!   




## Vorgehen und Dokumentation
👨‍🏫  Doku: 4: (0-4): 4

> -  Code vollständig dokumentiert, alle Klassen und Public-Methoden sind mit sinnvollen Javadoc-Kommentaren versehen. Parameter und Rückgabewerte sind dokumentiert.
> - Alle Gruppenmitglieder haben Code beigetragen und auf GitHub eingecheckt. (Check durch GitHub Log)

Kommentare der Lehrkraft 

Formell ist der Code so dokumentiert, wie er soll.  


Alle im Team haben beigetragen: dubuicol hatte zu Beginn sein git falsch eingestellt - bitte achten Sie darauf. 



# 📒 Notizen 

aus den Coachings


# Anhang

Folgende Vorgaben zu Clean Code werden angeschaut:  

* Code ist aufgeräumt (PROG1 Kapitel 3: Objektinteraktion, Kapitel 6:Bibliotheksklassen)
* Sinnvolle Namensgebung (PROG1 Kapitel 1: Objekte und Klassen)
* Methodengestaltung (PROG1 Kapitel 3: Objektinteraktion, Kapitel 6, Bibliotheksklassen)
* Klassen haben Verhalten (PROG1 Kapitel 3: Objektinteraktion)
* Klassenoberfläche ist minimal (PROG1 Kapitel 3: Objektinteraktion, Kapitel 10: Vererbung)
* Vernünftiger Einsatz von Feldern (PROG1 Kapitel 3: Objektinteraktion)
