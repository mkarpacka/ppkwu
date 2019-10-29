# ppkwu
Programowanie pod kątem wielokrotnego użycia

## String API
API stworzone do konwertowania stringów.

1.
```bash
/api/reverse/{characters}
```
Funkcjonalność odwracania kolejności znaków w podanym parametrze. Jako parametr {characters} podajemy ciąg znaków. W odpowiedzi dostajemy znaki w odwróconej kolejności.
Przykład:
```bash
dane wejściowe: 12345
dane wyjściowe: 54321
```

2.
```bash
/api/recognize/{characters}
```
Funkcjonalność rozpoznawania podanych w parametrze znaków. Jako parametr {characters} podajemy ciąg znaków. W odpowiedzi otrzymujemy cztery listy: {uppercaseletters=[], lowercaseletters=[], signs=[], digits=[]} w postaci String. W nawiasach kwadratowych zostają wpisane znaki, które odpowiadają danej kategorii. Możemy poznać, które z podanych znaków były małymi literami, wielkimi literami, liczbami oraz pozostałymi znakami.
Przykład 1:
```bash
dane wejściowe: aA1:
dane wyjściowe: {uppercaseletters=[A], lowercaseletters=[a], signs=[:], digits=[1]}
```
Przykład 2:
```bash
dane wejściowe: 12883bZbb.Aaaa-->=-777111
dane wyjściowe: {uppercaseletters=[Z, A], lowercaseletters=[b, b, b, a, a, a], signs=[., -, -, >, =, -], digits=[1, 2, 8, 8, 3, 7, 7, 7, 1, 1, 1]}
```
