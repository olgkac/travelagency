#Travel Agency

##Wstęp
Pokazowy wycinek aplikacji umożliwiającej zarządzanie biurem podróży.

Zaimplementowana jedna przykładowa funkcjonalność - zarządzanie klientami.

##Wymagania środowiskowe
####Do zbudowania backendu i uruchomienia aplikacji wymagana jest obecność na ścieżce:
- `mvn` (Maven)
- `jdk8` (Java Development Kit 8 lub wyższy)

####Do zbudowania frontendu wymagana jest obecność na ścieżce:
- `ng` (Angular CLI)
- `ts` (TypeScript)

Dla wygody frontend dostarczony jest w formie zbudowanej w folderze `src/main/resources/public`

####Baza danych:
- Do działania aplikacji konieczne jest połączenie z bazą danych
- Dostarczona aplikacja skonfigurowana jest do używania bazy PostgreSQL
- Dane połączeniowe należy zmodyfikować w zależności od środowiska w pliku `src/main/resources/application.properties`
- Baza musi zawierać tabelę client. Można dodać ją wraz z innymi tabelami używając skryptu znajdującego się w `src/main/resources/sql/generate-db.sql`

##Budowanie i uruchamianie
Aplikację można uruchomić komendą `mvn spring-boot:run`

Po uruchomieniu aplikacja dostępna będzie pod adresem `localhost:8080`

Aby przebudować całą aplikację wraz z frontendem należy użyć komendy `mvn package -Pgenerate-frontend`
