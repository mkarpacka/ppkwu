# ppkwu
Programowanie pod kątem wielokrotnego użycia

String API
API stworzone do konwertowania stringów.

1. /api/reverse/{characters}
Funkcjonalność odwracania kolejności znaków w podanym parametrze. Jako parametr {characters} podajemy ciąg znaków. W odpowiedzi dostajemy znaki w odwróconej kolejności.
Przykład:
dane wejściowe: 12345
dane wyjściowe: 54321

2. /api/recognize/{characters}
Funkcjonalność rozpoznawania podanych w parametrze znaków. Jako parametr {characters} podajemy ciąg znaków. W odpowiedzi otrzymujemy cztery listy: {uppercaseletters=[], lowercaseletters=[], signs=[], digits=[]} w postaci String. W nawiasach kwadratowych zostają wpisane znaki, które odpowiadają danej kategorii. Możemy poznać, które z podanych znaków były małymi literami, wielkimi literami, liczbami oraz pozostałymi znakami.
Przykład:
dane wejściowe: aA1:
dane wyjściowe: {uppercaseletters=[A], lowercaseletters=[a], signs=[:], digits=[1]}
