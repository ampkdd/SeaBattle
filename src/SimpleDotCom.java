public class SimpleDotCom {
    int[] locationCells;
    int numOfHits=0;
    public void setLocationCells(int[] locs){
        locationCells=locs;
    }
    public String checkYourself(String stringGuess) {
        //преобразуем тип String в int
        int guess = Integer.parseInt(stringGuess);
        //Создаем переменную для хранения результата, который будем возращать.
        String result ="Мимо";
        // Повторяем с каждой ячейкой из массива
        for (int cell:locationCells){
            if (guess == cell){
                result="Попал";
                numOfHits++;
                break;
                            }
                    }
        if (numOfHits==locationCells.length){
            result="Потопил";
                    }
        System.out.println(result);
        return result;
    }

}
