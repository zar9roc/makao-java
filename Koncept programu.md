# Koncepcja budowy obiektowej programu
Ja proponuję budować program nieco po kolei bez porywania się na budowanie mechaniki gry póki co, chociaz można już o niej powoli myśleć i pod jej kątem budować obiekty.
## Player
Co może gracz robić w grze? Grasz pobiera karty, zagrywa karty. Chyba nic więcej. Jeżeli chodzi o reczy typu rządania to będzie chyba zawarte w klasie `Interface`
Gracz będzie miał atrybuty z nazwą, numerem kolejki i jedo ręką.
```Java
public class Player{
  String name;
  int order;
  List<Integer> hand = new ArrayList<Integer>();
  
  void TakeCard(int){...}
  void PlayCard(int){...}
}
```
## Interface
Interfej będzie łączył urzytkownika aplikacji z graczem w kodzie oraz bedzie pośredniczył w kontakcie gracza z grą i jej zasadami. Będzie on odbierał aktualne dane o grze takie jak karta która jest na wierzchu, czy ktoś rząda karty i w takim przypadku zada odpowiednie komunikaty urzytkownikowi aplikacji.
Sama budowa metod i pól jeszcze nie jest określona. Na to przyjdzie czas.
```Java
public class Interface{
  //???
}
```
## Game
Myślę że dobrym pomysłem będzie zaprzęgnięcia tej klasy do decydowania o zasadach, tam powinny znalesć się informacje o ostatniej zagranej karcie, do tej klasy będziemy zagrywać kartami za pośrednictwem klasy `Interface' rzecz jasna.
```Java
public class Game{
  int NumberOfPlayers;
  public class Deck{
    //...
  }
  
  public class FiniteDeck extends Deck{
    //...
  }
  
  public class InfiniteDeck extends Deck{
    //...
  }
}
```
Jak widać zawarta jest tam inna klasa - `Deck` która będzie w dwóch formach: skończonej i nieskończonej. Chodzi o to żeby mozna było zagrać na jednej talii, na dwóch czy 7, ale również na nieograniczonej talii. A co. Nie można pomarzyć xD?
