
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ThreeCardPokerGame extends Application {
    
    Player playerOne;
    Player playerTwo;
    Dealer theDealer;
    ThreeCardLogic logic;
    
    static Font font;
    static Font fontAreas;

    public ThreeCardPokerGame(){
        playerOne = new Player();
        playerTwo = new Player();
        theDealer = new Dealer();
        logic = new ThreeCardLogic();
        
        ArrayList<Card> hand = theDealer.dealHand();
        playerOne.setHand(hand);
        hand = theDealer.dealHand();
        playerTwo.setHand(hand);
    }
    
    static Label lbl1, lbl2, lbl3, lblOne, lblTwo;
    static Button anteWagerOne, anteWagerTwo, pairPlusWagerOne, pairPlusWagerTwo, 
            playWagerOne, playWagerTwo, foldOne, foldTwo, dealCards;
    static TextArea playerOneArea, playerTwoArea, dealerArea, betsAreaOne, betsAreaTwo, generalArea;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Three Card Poker Game");
        
        font = Font.font("Verdana", FontWeight.BOLD, 14);
        fontAreas = Font.font("Verdana", FontWeight.BOLD, 20);
        Image image = new Image(new FileInputStream("background.jpeg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(800);
        imageView.setFitWidth(1100);
        imageView.setX(0); 
        imageView.setY(0); 
        
            
        lbl1 = new Label("Player One's Cards");
        lbl1.setTextFill(Color.WHITE);
        lbl1.setFont(font);
        lbl1.setLayoutX(10);
        lbl1.setLayoutY(40);
        playerOneArea = new TextArea();
        playerOneArea.setFont(fontAreas);
        playerOneArea.setEditable(false);
        playerOneArea.setMinSize(350, 170);
        playerOneArea.setMaxSize(350, 170);
        playerOneArea.setLayoutX(10);
        playerOneArea.setLayoutY(60);
        
        lbl2 = new Label("Player Two's Cards");
        lbl2.setTextFill(Color.WHITE);
        lbl2.setFont(font);
        lbl2.setLayoutX(375);
        lbl2.setLayoutY(40);
        playerTwoArea = new TextArea();
        playerTwoArea.setFont(fontAreas);
        playerTwoArea.setEditable(false);
        playerTwoArea.setMinSize(350, 170);
        playerTwoArea.setMaxSize(350, 170);
        playerTwoArea.setLayoutX(375);
        playerTwoArea.setLayoutY(60);
        
        lbl3 = new Label("Dealer's Cards");
        lbl3.setTextFill(Color.WHITE);
        lbl3.setFont(font);
        lbl3.setLayoutX(740);
        lbl3.setLayoutY(40);
        dealerArea = new TextArea();
        dealerArea.setFont(fontAreas);
        dealerArea.setEditable(false);
        dealerArea.setMinSize(350, 170);
        dealerArea.setMaxSize(350, 170);
        dealerArea.setLayoutX(740);
        dealerArea.setLayoutY(60);
        dealerArea.appendText("##  ##  ##");
        
        //AREAS to Display Bets for both players
        betsAreaOne = new TextArea();
        betsAreaOne.setFont(fontAreas);
        betsAreaOne.setMinSize(530, 120);
        betsAreaOne.setMaxSize(530, 120);
        betsAreaOne.setLayoutX(10);
        betsAreaOne.setLayoutY(370);
        betsAreaTwo = new TextArea();
        betsAreaTwo.setFont(fontAreas);
        betsAreaTwo.setMinSize(530, 120);
        betsAreaTwo.setMaxSize(530, 120);
        betsAreaTwo.setLayoutX(560);
        betsAreaTwo.setLayoutY(370);
        betsAreaOne.setEditable(false);
        betsAreaTwo.setEditable(false);
        
        //Area to display general info
        generalArea = new TextArea();
        generalArea.setFont(fontAreas);
        generalArea.setEditable(false);
        generalArea.setMinSize(1080, 170);
        generalArea.setMaxSize(1080, 170);
        generalArea.setLayoutX(10);
        generalArea.setLayoutY(510);
        
        //Winning Labels
        int winnings1 = 0;
        int winnings2 = 0;
        lblOne = new Label("Total Winnings: "+String.format("%02d", winnings1));
        lblOne.setTextFill(Color.WHITE);
        lblOne.setFont(font);
        lblOne.setLayoutX(10);
        lblOne.setLayoutY(490);
        lblTwo = new Label("Total Winnings: "+String.format("%02d", winnings2));
        lblTwo.setTextFill(Color.WHITE);
        lblTwo.setFont(font);
        lblTwo.setLayoutX(220);
        lblTwo.setLayoutY(490);
        
        /*
            PLAYER ONE BUTTONS
        */
        TextField anteWager1 = new TextField();
        anteWager1.setMinSize(200, 30);
        anteWager1.setMaxSize(200, 30);
        anteWager1.setLayoutX(10);
        anteWager1.setLayoutY(240);
        anteWagerOne = new Button("Ante Wager");
        anteWagerOne.setMinSize(200, 30);
        anteWagerOne.setMaxSize(200, 30);
        anteWagerOne.setLayoutX(210);
        anteWagerOne.setLayoutY(240);
        anteWagerOne.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!anteWager1.getText().equals("")){
                    int bet = Integer.parseInt(anteWager1.getText());
                    if(bet >= 5 && bet <= 25){
                        if(playerOneArea.getText().equals("")){
                            playerOne.setAnteBet(bet);
                            ArrayList<Card> hand = playerOne.getHand();
                            for (Card card : hand) {
                                playerOneArea.appendText(card.toString()+" ");
                            }
                        }
                    }
                    else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setContentText("Bet Must be in between $5 & $25");
                        alert.show();
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Place Ante Bet to Reveal Your Hand!");
                    alert.show();
                }
            }
        });
        
        TextField pairPlus1 = new TextField();
        pairPlus1.setMinSize(200, 30);
        pairPlus1.setMaxSize(200, 30);
        pairPlus1.setLayoutX(10);
        pairPlus1.setLayoutY(280);
        pairPlusWagerOne = new Button("Pair Plus");
        pairPlusWagerOne.setMinSize(200, 30);
        pairPlusWagerOne.setMaxSize(200, 30);
        pairPlusWagerOne.setLayoutX(210);
        pairPlusWagerOne.setLayoutY(280);
        pairPlusWagerOne.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!pairPlus1.getText().equals("")){
                    int bet = Integer.parseInt(pairPlus1.getText());
                    playerOne.setPairPlusBet(bet);
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Place Pair Plus Bet to set the bet!");
                    alert.show();
                }
            }
        });
        
        TextField play1 = new TextField();
        play1.setMinSize(200, 30);
        play1.setMaxSize(200, 30);
        play1.setLayoutX(10);
        play1.setLayoutY(320);
        playWagerOne = new Button("Play");
        playWagerOne.setMinSize(100, 30);
        playWagerOne.setMaxSize(100, 30);
        playWagerOne.setLayoutX(210);
        playWagerOne.setLayoutY(320);
        playWagerOne.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!play1.getText().equals("")){
                    int anteBet = Integer.parseInt(anteWager1.getText());
                    int playBet = Integer.parseInt(play1.getText());
                    if(anteBet == playBet){
                        playerOne.setPlayBet(playBet);
                        dealerArea.setText("");
                        ArrayList<Card> dealerHand = theDealer.dealersHand;
                        for (int a = 0; a < dealerHand.size(); a++) {
                            dealerArea.appendText(dealerHand.get(a).toString()+" ");
                        }
                        betsAreaOne.setText("Ante Bet: "+playerOne.getAnteBet()+"\n");
                        betsAreaOne.appendText("Pair Plus Bet: "+playerOne.getPairPlusBet()+"\n");
                        betsAreaOne.appendText("Play Bet: "+playerOne.getPlayBet()+"\n");
                        if(theDealer.hasQueenHigh()){
                            generalArea.appendText("Dealer Qualifies to Play\n");
                            int eval = ThreeCardLogic.evalHand(playerOne.getHand());
                            if(eval == 0){ //just has a high card
                                int highPlayer = playerOne.getHighValue();
                                int highDealer = theDealer.getHighValue();
                                if(highPlayer > highDealer){
                                    //player wins
                                    playerOne.totalWinnings++;
                                    generalArea.appendText("Player 1 Wins\n");
                                }
                                else if(highPlayer < highDealer){
                                    //dealer wins
                                    playerOne.totalWinnings--;
                                    generalArea.appendText("Dealer Wins\n");
                                }
                                else{
                                    //tie
                                    generalArea.appendText("Nobody Wins\n");
                                }
                            }
                            else {  //has someting from 1-5
                                int result = ThreeCardLogic.compareHands(dealerHand, playerOne.getHand());
                                if(result == 2){
                                    //dealer wins
                                    playerOne.totalWinnings--;
                                    generalArea.appendText("Dealer Wins\n");
                                }
                                else if(result == 1){
                                    //player wins
                                    playerOne.totalWinnings++;
                                    generalArea.appendText("Player 1 Wins\n");
                                    generalArea.appendText("Player 1 gets $"+playerOne.getAnteBet()+" for Ante Bet\n");
                                    generalArea.appendText("Player 1 gets $"+playerOne.getPlayBet()+" for Play Bet\n");
                                }
                                else{
                                    //Tie
                                    generalArea.appendText("Nobody Wins\n");
                                }
                            }
                        }
                        else{
                            generalArea.appendText("Dealer does not Qualify to Play\n");
                            generalArea.appendText("Player 1 gets $"+playerOne.getAnteBet()+" for Ante Bet\n");
                        }
                        
                        //Optional Bet (Pair Plus) winning/losing here
                        if(playerOne.getPairPlusBet() > 0){
                            int eval = ThreeCardLogic.evalHand(playerOne.getHand());
                            int win = ThreeCardLogic.evalPPWinnings(playerOne.getHand(), playerOne.getPairPlusBet());
                            if(eval == 1){
                                generalArea.appendText("Player 1 gets $"+win+" for Pair Plus Bet due to Straight Flush\n");
                            }
                            else if(eval == 2){
                                generalArea.appendText("Player 1 gets $"+win+" for Pair Plus Bet due to Three of a Kind\n");
                            }
                            else if(eval == 3){
                                generalArea.appendText("Player 1 gets $"+win+" for Pair Plus Bet due to Straight\n");
                            }
                            else if(eval == 4){
                                generalArea.appendText("Player 1 gets $"+win+" for Pair Plus Bet due to Flush\n");
                            }
                            else if(eval == 5){
                                generalArea.appendText("Player 1 gets $"+win+" for Pair Plus Bet due to Pair\n");
                            }
                            else{
                                generalArea.appendText("Player 1 lost the Pair Plus Bet\n");
                            }
                        }
                        lblOne.setText("Total Winnings: "+String.format("%02d", playerOne.getTotalWinnings()));
                    }
                    else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setContentText("Play Bet must be same as Ante Bet");
                        alert.show();
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Place Play Bet to play the game!");
                    alert.show();
                }
            }
        });
        
        foldOne = new Button("Fold");
        foldOne.setMinSize(100, 30);
        foldOne.setMaxSize(100, 30);
        foldOne.setLayoutX(310);
        foldOne.setLayoutY(320);
        foldOne.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                int pairPlusBet = 0;
                if(!pairPlus1.getText().equals("")){
                    pairPlusBet = Integer.parseInt(pairPlus1.getText());
                    playerOne.setPairPlusBet(pairPlusBet);
                }
                playerOne.setAnteBet(0);
                playerOne.setPairPlusBet(0);
                generalArea.appendText("Player 1 decides to Fold. Ante & Pair Plus Bets Lost!\n");
            }
        });
        
        TextField anteWager2 = new TextField();
        anteWager2.setMinSize(140, 30);
        anteWager2.setMaxSize(140, 30);
        anteWager2.setLayoutX(560);
        anteWager2.setLayoutY(240);
        anteWagerTwo = new Button("Ante Wager");
        anteWagerTwo.setMinSize(190, 30);
        anteWagerTwo.setMaxSize(190, 30);
        anteWagerTwo.setLayoutX(700);
        anteWagerTwo.setLayoutY(240);
        anteWagerTwo.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!anteWager2.getText().equals("")){
                    int bet = Integer.parseInt(anteWager2.getText());
                    if(bet >= 5 && bet <= 25){
                        if(playerTwoArea.getText().equals("")){
                            playerTwo.setAnteBet(bet);
                            ArrayList<Card> hand = playerTwo.getHand();
                            for (Card card : hand) {
                                playerTwoArea.appendText(card.toString()+" ");
                            }
                        }
                    }
                    else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setContentText("Bet Must be in between $5 & $25");
                        alert.show();
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Place Ante Bet to Reveal Your Hand!");
                    alert.show();
                }
            }
        });
        
        TextField pairPlus2 = new TextField();
        pairPlus2.setMinSize(140, 30);
        pairPlus2.setMaxSize(140, 30);
        pairPlus2.setLayoutX(560);
        pairPlus2.setLayoutY(280);
        pairPlusWagerTwo = new Button("Pair Plus");
        pairPlusWagerTwo.setMinSize(190, 30);
        pairPlusWagerTwo.setMaxSize(190, 30);
        pairPlusWagerTwo.setLayoutX(700);
        pairPlusWagerTwo.setLayoutY(280);
        pairPlusWagerTwo.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!pairPlus2.getText().equals("")){
                    int bet = Integer.parseInt(pairPlus2.getText());
                    playerTwo.setPairPlusBet(bet);
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Place Pair Plus Bet to set the bet!");
                    alert.show();
                }
            }
        });
        
        TextField play2 = new TextField();
        play2.setMinSize(140, 30);
        play2.setMaxSize(140, 30);
        play2.setLayoutX(560);
        play2.setLayoutY(320);
        
        playWagerTwo = new Button("Play");
        playWagerTwo.setMinSize(100, 30);
        playWagerTwo.setMaxSize(100, 30);
        playWagerTwo.setLayoutX(700);
        playWagerTwo.setLayoutY(320);
        playWagerTwo.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(!play2.getText().equals("")){
                    int anteBet = Integer.parseInt(anteWager2.getText());
                    int playBet = Integer.parseInt(play2.getText());
                    if(anteBet == playBet){
                        playerTwo.setPlayBet(playBet);
                        dealerArea.setText("");
                        ArrayList<Card> dealerHand = theDealer.dealersHand;
                        for (int a = 0; a < dealerHand.size(); a++) {
                            dealerArea.appendText(dealerHand.get(a).toString()+" ");
                        }
                        betsAreaTwo.setText("Ante Bet: "+playerTwo.getAnteBet()+"\n");
                        betsAreaTwo.appendText("Pair Plus Bet: "+playerTwo.getPairPlusBet()+"\n");
                        betsAreaTwo.appendText("Play Bet: "+playerTwo.getPlayBet()+"\n");
                        if(theDealer.hasQueenHigh()){
                            generalArea.appendText("Dealer Qualifies to Play\n");
                            int eval = ThreeCardLogic.evalHand(playerOne.getHand());
                            if(eval == 0){ //just has a high card
                                int highPlayer = playerTwo.getHighValue();
                                int highDealer = theDealer.getHighValue();
                                if(highPlayer > highDealer){
                                    //player wins
                                    playerTwo.totalWinnings++;
                                    generalArea.appendText("Player 2 Wins\n");
                                }
                                else if(highPlayer < highDealer){
                                    //dealer wins
                                    playerTwo.totalWinnings--;
                                    generalArea.appendText("Dealer Wins\n");
                                }
                                else{
                                    //tie
                                    generalArea.appendText("Nobody Wins\n");
                                }
                            }
                            else {  //has someting from 1-5
                                int result = ThreeCardLogic.compareHands(dealerHand, playerTwo.getHand());
                                if(result == 2){
                                    //dealer wins
                                    playerTwo.totalWinnings--;
                                    generalArea.appendText("Dealer Wins\n");
                                }
                                else if(result == 1){
                                    //player wins
                                    playerTwo.totalWinnings++;
                                    generalArea.appendText("Player 2 Wins\n");
                                    generalArea.appendText("Player 2 gets $"+playerTwo.getAnteBet()+" for Ante Bet\n");
                                    generalArea.appendText("Player 2 gets $"+playerTwo.getPlayBet()+" for Play Bet\n");
                                }
                                else{
                                    //Tie
                                    generalArea.appendText("Nobody Wins\n");
                                }
                            }
                        }
                        else{
                            generalArea.appendText("Dealer does not Qualify to Play\n");
                            generalArea.appendText("Player 2 gets $"+playerTwo.getAnteBet()+" for Ante Bet\n");
                        }
                        
                        //Optional Bet (Pair Plus) winning/losing here
                        if(playerTwo.getPairPlusBet() > 0){
                            int eval = ThreeCardLogic.evalHand(playerTwo.getHand());
                            int win = ThreeCardLogic.evalPPWinnings(playerTwo.getHand(), playerTwo.getPairPlusBet());
                            if(eval == 1){
                                generalArea.appendText("Player 2 gets $"+win+" for Pair Plus Bet due to Straight Flush\n");
                            }
                            else if(eval == 2){
                                generalArea.appendText("Player 2 gets $"+win+" for Pair Plus Bet due to Three of a Kind\n");
                            }
                            else if(eval == 3){
                                generalArea.appendText("Player 2 gets $"+win+" for Pair Plus Bet due to Straight\n");
                            }
                            else if(eval == 4){
                                generalArea.appendText("Player 2 gets $"+win+" for Pair Plus Bet due to Flush\n");
                            }
                            else if(eval == 5){
                                generalArea.appendText("Player 2 gets $"+win+" for Pair Plus Bet due to Pair\n");
                            }
                            else{
                                generalArea.appendText("Player 2 lost the Pair Plus Bet\n");
                            }
                        }
                        lblTwo.setText("Total Winnings: "+String.format("%02d", playerTwo.getTotalWinnings()));
                    }
                    else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setContentText("Play Bet must be same as Ante Bet");
                        alert.show();
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setContentText("Place Play Bet to play the game!");
                    alert.show();
                }
            }
        });
        
        foldTwo = new Button("Fold");
        foldTwo.setMinSize(90, 30);
        foldTwo.setMaxSize(90, 30);
        foldTwo.setLayoutX(800);
        foldTwo.setLayoutY(320);
        foldTwo.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                int pairPlusBet = 0;
                if(!pairPlus2.getText().equals("")){
                    pairPlusBet = Integer.parseInt(pairPlus2.getText());
                    playerTwo.setPairPlusBet(pairPlusBet);
                }
                playerTwo.setAnteBet(0);
                playerTwo.setPairPlusBet(0);
                generalArea.appendText("Player 2 decides to Fold. Ante & Pair Plus Bets Lost!\n");
            }
        });
        
        dealCards = new Button("Deal Cards Again");
        dealCards.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        dealCards.setMinSize(200, 70);
        dealCards.setMaxSize(200, 70);
        dealCards.setLayoutX(890);
        dealCards.setLayoutY(280);
        dealCards.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                playerOne.reset();
                playerTwo.reset();
                
                anteWager1.setText("");
                anteWager2.setText("");
                pairPlus1.setText("");
                pairPlus2.setText("");
                play1.setText("");
                play2.setText("");
                betsAreaOne.setText("");
                betsAreaTwo.setText("");
                
                playerOneArea.setText("");
                playerTwoArea.setText("");
                dealerArea.setText("");
                generalArea.setText("");
                
                ArrayList<Card> hand = theDealer.dealHand();
                playerOne.setHand(hand);
                hand = theDealer.dealHand();
                playerTwo.setHand(hand);
                theDealer.dealersHand = theDealer.dealHand();
            }
        });
        
        //Menu items for the app
        MenuBar menubar = new MenuBar();
        Menu options = new Menu("Options");
        MenuItem newLook = new MenuItem("New Look");
        newLook.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                newLook();
            }
        });
        MenuItem freshStart = new MenuItem("Fresh Start");
        freshStart.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                playerOne = new Player();
                playerTwo = new Player();
                theDealer = new Dealer();
                logic = new ThreeCardLogic();
                anteWager1.setText("");
                anteWager2.setText("");
                pairPlus1.setText("");
                pairPlus2.setText("");
                play1.setText("");
                play2.setText("");
                betsAreaOne.setText("");
                betsAreaTwo.setText("");
                
                playerOneArea.setText("");
                playerTwoArea.setText("");
                dealerArea.setText("");
                generalArea.setText("");
                
                lblOne.setText("Total Winnings: "+String.format("%02d", playerOne.getTotalWinnings()));
                lblTwo.setText("Total Winnings: "+String.format("%02d", playerTwo.getTotalWinnings()));
                
                
                ArrayList<Card> hand = theDealer.dealHand();
                playerOne.setHand(hand);
                hand = theDealer.dealHand();
                playerTwo.setHand(hand);
                theDealer.dealersHand = theDealer.dealHand();
            }
        });
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.exit(0);
            }
        });
        options.getItems().addAll(newLook, freshStart, exit);  
        menubar.getMenus().addAll(options);
        
        Group root = new Group();
        root.getChildren().addAll(imageView, menubar, lbl1, playerOneArea, lbl2, playerTwoArea, lbl3, dealerArea,
                anteWager1, anteWagerOne, pairPlus1, pairPlusWagerOne, play1, playWagerOne, foldOne,
                anteWager2, anteWagerTwo, pairPlus2, pairPlusWagerTwo, play2, playWagerTwo, foldTwo,
                betsAreaOne, betsAreaTwo,
                lblOne, lblTwo, 
                generalArea,
                dealCards);
        Scene scene = new Scene(root, 1100, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void newLook(){
        String[] fonts = new String[]{"Verdana", "Helvetica", "Times New Roman", 
            "Comic Sans MS", "Impact", "Lucida Sans Unicode" };
        
        int random = (int) (Math.random() * fonts.length);
        font = Font.font(fonts[random], FontWeight.BOLD, 14);
        fontAreas = Font.font(fonts[random], FontWeight.BOLD, 20);
        
        lbl1.setFont(font);
        lbl2.setFont(font);
        lbl3.setFont(font);
        lblOne.setFont(font);
        lblTwo.setFont(font);
        
        anteWagerOne.setFont(font);
        anteWagerTwo.setFont(font);
        pairPlusWagerOne.setFont(font);
        pairPlusWagerTwo.setFont(font);
        playWagerOne.setFont(font);
        playWagerTwo.setFont(font);
        foldOne.setFont(font);
        foldTwo.setFont(font);
        dealCards.setFont(font);
        
        playerOneArea.setFont(fontAreas);
        playerTwoArea.setFont(fontAreas);
        dealerArea.setFont(fontAreas);
        betsAreaOne.setFont(fontAreas);
        betsAreaTwo.setFont(fontAreas);
        generalArea.setFont(fontAreas);
        
    }

}
