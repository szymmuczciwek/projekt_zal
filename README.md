# projekt_zal

# Ćwiczenie pisania na klawiaturze.

## Spis treści

1. [Opis projektu](#opis-projektu)
2. [Funkcjonalności](#funkcjonalności)
3. [Instrukcje obsługi](#instrukcje-obsługi)
    - [Wymagania](#wymagania)
    - [Uruchomienie aplikacji](#uruchomienie-aplikacji)
4. [Autor](#autor)

## Opis projektu

Aplikacja "Ćwiczenie pisania na klawiaturze" jest narzędziem do ćwiczenia pisania na klawiaturze. Program losuje zdanie z pliku, wyświetla je użytkownikowi do przepisania, a następnie sprawdza poprawność wpisanego tekstu, podkreśla błędy i informuje o procentowej ilości błędów oraz czasie potrzebnym na wykonanie zadania.

## Funkcjonalności

- **Wczytywanie zdań z pliku**: Program wczytuje zdania z pliku `sentences.txt`.
- **Wyświetlanie zdań**: Program wyświetla wszystkie zdania w oknie aplikacji.
- **Losowe wybieranie zdania**: Program losowo wybiera jedno ze zdań do przepisania.
- **Podświetlanie zdania**: Wybrane zdanie jest podświetlane na żółto.
- **Ukrywanie wpisywanego tekstu**: Tekst wpisywany przez użytkownika jest ukryty.
- **Sprawdzanie poprawności**: Program sprawdza poprawność wpisanego tekstu, podkreślając błędy na czerwono.
- **Pomiar czasu**: Program mierzy czas od pierwszego znaku do wciśnięcia klawisza Enter.
- **Informacja o błędach**: Program wyświetla liczbę błędów oraz procentową ilość błędów.
- **Opcja ponowienia**: Użytkownik może zdecydować, czy chce spróbować ponownie.

## Instrukcje obsługi

### Wymagania

- Java Development Kit (JDK) w wersji 8 lub wyższej.
- Plik `sentences.txt` zawierający zdania do wczytania, umieszczony w tym samym katalogu co plik Javy.

### Uruchomienie aplikacji

1. **Pobierz i zainstaluj JDK**:
    - Pobierz najnowszą wersję JDK ze strony [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) lub [OpenJDK](https://openjdk.java.net/install/).
    - Zainstaluj JDK zgodnie z instrukcjami dla Twojego systemu operacyjnego.

2. **Przygotuj plik `sentences.txt`**:
    - Utwórz plik `sentences.txt` w katalogu projektu.
    - Dodaj do pliku następujące zdania, każde w osobnej linii:
      ```
	Ala ma kota, a kot ma Alę.
	Leje jak z cebra, więc weź parasol.
	W zdrowym ciele zdrowy duch.
	Nie wszystko złoto, co się świeci.
	Czas to pieniądz.
      ```

3. **Skompiluj i uruchom program**:
    - Otwórz terminal (lub wiersz poleceń) i przejdź do katalogu, w którym znajduje się plik `TypingPractice.java`.
    - Skompiluj program poleceniem:
      ```
      javac TypingPractice.java
      ```
    - Uruchom program poleceniem:
      ```
      java TypingPractice
      ```

4. **Korzystanie z aplikacji**:
    - Po uruchomieniu aplikacji, w oknie programu pojawią się wszystkie zdania z pliku `sentences.txt`.
    - Program losowo wybierze jedno zdanie i podświetli je na żółto.
    - Użytkownik powinien przepisać podświetlone zdanie w polu tekstowym. Tekst wpisywany przez użytkownika jest ukryty.
    - Po wciśnięciu klawisza Enter program sprawdzi poprawność wpisanego tekstu, podkreśli błędy na czerwono oraz wyświetli liczbę błędów i czas potrzebny na przepisanie zdania.
    - Użytkownik może zdecydować, czy chce spróbować ponownie. W przypadku zgody, program losowo wybierze kolejne zdanie.

## Autor

Aplikacja została stworzona przez Szymona Uczciwka.
