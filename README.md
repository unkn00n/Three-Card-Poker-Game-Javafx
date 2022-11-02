# Three-Card-Poker-Game-Javafx

Description:
In this project you will implement a two player version of the popular casino game 3
Card Poker. This is a somewhat simple game to understand and play which should
allow you to focus on learning GUI development in JavaFX and trying your hand at
event driven programing.
This project will be completed in two parts: Part #1 is the planning stage where you will
create a wireframe of your user interface and well as a class diagram with all of the
classes, interfaces and relations you expect to use in your code.
This project will be developed as a Maven project using the template provided. You
may work in teams of two but do not have to.
How the game is played:
***Keep in mind: there are different variations of this game you will
find on the web; the following is how your version will play***
In three card poker, each player only plays against the dealers hand, not each other:
• Both players will start by placing an ante wager. We will limit the ante bet to $5 or
greater, up to $25.
• There is one optional bet the players can make called the Pair Plus wager. We will
also limit this bet to $5 or greater, up to $25. This is a separate bet that will win if a
players hand is at least a pair of 2’s. The payoff for this bet applies regardless of the
dealers hand and what happens in the rest of the game. (See below for payouts).
• After all bets are made(ante and/or pair plus), the cards are dealt out. Each player
and the dealer receive three cards each. The players cards are face up and the
dealers hand is face down.
• Each player must decide if they will play or fold. If they fold, they lose their ante wager
and pair plus wager(if they made one).
• If the player wants to continue, they will make a play wager (this must be equal to the
amount of the ante wager).
• At this point, the dealer will show their cards. If the dealer does not have at least a
Queen high or better, the play wager is returned to the players who did not fold and
the ante bet is pushed to the next hand.
• If the dealer does have at least a Queen high or better, then each players hand, that
did not fold, is evaluated against the dealers hand (see below for order of winning
hands). If the dealer wins, the player loses both the ante and play wager. If the player
wins, they get paid out 1 to 1 (they get back double what they wagered). Say the
player bet $5 each for the ante and play wager and won, they would get back $20.
For the Pair Plus wager:

As long as the player does not fold, the Pair Plus wager gets evaluated regardless of if
their hand beat the dealers hand; it is a separate bet based solely on the players hand.
If the player does not have at least a pair of 2’s, they lose this bet. Otherwise, the
payouts are as follows:
• Straight Flush 40 to 1
• Three of a Kind 30 to 1
• Straight 6 to 1
• Flush 3 to 1
• Pair 1 to 1


The GUI:
You are welcome to use/discover any widget, pane, node, layout or other in JavaFX to
implement your GUI. For this project, you are not allowed to use Scene
Builder or FXML layout files. The following elements are required:
• There should be an area to display both Players cards and Dealers cards
with each clearly labeled. You may use images or text to display the
cards.
• Each player must have some way to make all of the available game
wagers.
• Each player should have a separate area to display the Ante, Pair Plus
and Play wager.
• Each player should have a separate area to display total winnings.
• There should be an area that displays info for the game. For example:
“Player one loses Pair Plus”
“Player one beats dealer”
“Player two loses to dealer”
“Player two wins Pair Plus”
“Dealer does not have at least Queen high; ante wager is pushed”
• You will need to have a menu bar in your program with one tab: Options
Under options you will have Exit, Fresh Start and NewLook. Exit will end the program
while Fresh Start will reset each players current winnings to zero and allow the user to
start a new game. NewLook will change the look of the GUI; such as new colors, fonts,
images….etc. While there is no minimum for elements to change, the new look must be
noticeable to the average user.
Playing the game in your Program:
Your game must play and feel like the user is actually playing in real time. You must
include pause transitions or add buttons like “continue” to control the flow of the game. If
you did not, the program would move too fast and not allow the user to understand what
is happening.
Testing Code:
You are required to include JUnit 5 test cases for your program. Add these to the
src/test/java directory of your Maven Project. Keep in mind that you will not be able to
test any of the graphical elements with JUnit, only the logic of your program. At a
minimum you must test: 
• ThreeCardLogic class, at least 20 test cases
• Deck and Dealer class, at least 10 test cases
