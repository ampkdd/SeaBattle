import java.util.*;

public class DotComBust {
    private GameHelper helper=new GameHelper();
    private ArrayList<DotCom> dotComsList=new ArrayList<DotCom>();
    private int numOfGuesses=0;
    public void setUpGame() {
        DotCom one=new DotCom();
        one.setName("Pets.com");
        DotCom two=new DotCom();
        two.setName("eToys.com");
        DotCom three=new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Ваша цель-потопить три  сайта.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet: dotComsList){
            ArrayList<String>newLocation=helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    public void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess=helper.getUserInput("Сделайте ход");
            checkUserGuess (userGuess);
            }
        finishGame();
    }

    public void checkUserGuess (String userGuess){
        numOfGuesses++;
        String result="Мимо";
        for (DotCom dotComToTest:dotComsList){
            result=dotComToTest.checkYourself(userGuess);
            if(result.equals("Попал")){
                break;
            }
            if (result.equals("Потопил")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
    }
    public void finishGame(){
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses<=18){
            System.out.println("Это заняло у вас всего"+numOfGuesses+"попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        }else{
            System.out.println("Это заняло у вас довольно много времени."+numOfGuesses+"попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }
    public static void main (String[] args) {
        SimpleGui app=new SimpleGui();
        app.setVisible(true);
        DotComBust game=new DotComBust();
        game.setUpGame();
        game.startPlaying();


    }


}
