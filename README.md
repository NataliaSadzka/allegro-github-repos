# Allegro GitHub Repos

### O aplikacji
Oprogramowanie pozwalające na:
* listowanie repozytoriów (nazwa i liczba gwiazdek),
* zwracanie sumy gwiazdek we wszystkich repozytoriach,
  dla dowolnego użytkownika serwisu GitHub.

### Instrukcja budowania
W celu zbudowania projektu, w wierszu poleceń należy wywołać komendę`mvn clean package`.

### Instrukcja instalowania
Do instalacji projektu należy wykorzystać kontener aplikcaji np. Apache Tomcat.

### Instrukcja używania
1. Żeby wyświetlić listę repozytoriów w aplikacji umiejscowionej na serwerze localhost należy wpisać w przeglądarce np. Chrome następujący URL: http://localhost:8080/allegro-github-repos-1.0.0-RELEASE/Allegro/list
2. Żeby wyświetlić listę repozytoriów i łączną listę gwiazdek w aplikacji umiejscowionej na serwerze localhost należy wpisać w przeglądarce np. Chrome następujący URL: http://localhost:8080/allegro-github-repos-1.0.0-RELEASE/Allegro/totalStars

### Dalsze możliwe rozszerzenia
Poniższy projekt można rozszerzyć o inne funkcjonalności bazując na GitHub API:
* wyszukiwanie konkretnej pozycji, którą chce się znaleźć. Na przykład można znaleźć użytkownika lub określony plik w repozytorium,
* prezentowanie dodatkowych informacji na temat repozytoriów, np. liczba oglądających,
* tworzenie pól requestów.
