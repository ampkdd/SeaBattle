public class SimpleDotComTestDrive {
    public static void main (String [] ars){
        SimpleDotCom dot=new SimpleDotCom();
        int location [];
        location = new int[]{2,3,4};
        dot.setLocationCells(location);
        String userGuess= "2";
        String result=dot.checkYourself(userGuess);
        String testResult ="Неудача";
        if (result.equals("Попал")) {
            testResult = "Пройден";
        }
        System.out.println(testResult);
    }
}
