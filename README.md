# TeenPattiGame
TeenPattiGame Java

# Teen Patti android game  using OOPS  principles.

# Classes: 
1. TeenPattiGame 
2. Deck 
3. Cards
4. Player
5. GameRules
6. Game
7. Suits

# Specification of the game :
At the start of the game  ask for number of Players : N ( N>=2 && N <= 5) and number of Rounds.

Create N Players in the code.
Assign them 3 random Cards  out of the Deck  for the Round .

Analyse  which Player has better cards using teen Patti game Rules.
And declare the winner of the Round , its cards and the , Rule name  by which it won.

* Do not implement the bidding process its just one Round game.

# Example Input  :  
N = 2  Rounds =1,  create 2 Players, assign them  
Player 1 Cards = AAA and Player 2 cards = AKK. (A = Ace, K = King)
Result : Player 1 won , Cards  = AAA , Rule = TRIO.

# Rules: 
The ranking of the possible hands, from high to low, is as follows.

# Trio - 
Three cards of the same rank. Three aces are the best trio and three twos are the lowest.

# Straight run - 
Three consecutive cards of the same suit. Ace can be used in the run A-2-3, which is the highest straight run. Next comes A-K-Q, K-Q-J and so on down to 4-3-2, which is the lowest. 2-A-K is not a valid run.

# Normal run - 
Three consecutive cards, not all of the same suit. A-2-3 is the best normal run, then A-K-Q, K-Q-J and so on down to 4-3-2. 2-A-K is not valid.

# Colour - 
Any three cards of the same suit. When comparing two colours, compare the highest card; if these are equal compare the second; if these are equal too, compare the lowest. Thus the highest colour is A-K-J and the lowest is 5-3-2.

# Pair - 
Two cards of the same rank. Between two such hands, compare the pair first, then the odd card if these are equal. The highest pair hand is therefore A-A-K and the lowest is 2-2-3.

# High card - 
Three cards that do not belong to any of the above types. Compare the highest card first, then the second highest, then the lowest. The best hand of this type is A-K-J of mixed suits, and the worst is 5-3-2.
