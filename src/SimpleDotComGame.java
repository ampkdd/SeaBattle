public class SimpleDotComGame {
    public static void main (String [] args){
        // переменная для слежения за количеством ходов пользователя
        int numOfGuesses =0;
        // класс содержит метод пользовательского ввода
        GameHelper helper=new GameHelper();
        // создаем объект "сайт", который надо потопить
        SimpleDotCom theDotCom=new SimpleDotCom();
        // генерируем случайное число для первой ячейки и используем его для формирования массива
        int randomNum=(int)(Math.random()*5);
        int [] location ={randomNum,randomNum+1,randomNum+2};
        //передаем сайту местоположение его ячеек
        theDotCom.setLocationCells(location);
        //создаем булеву переменную, чтобы проверить в цикле, не закончилась ли игра
        boolean isAlive=true;
        while (isAlive==true) {
            String guess=helper.getUserInput("Введите число");
            String result=theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Потопил")){
                isAlive=false;
                System.out.println("Вам потребовалось"+numOfGuesses+"попыток(и)");
            }

        }
    }
}
