import java.util.Random;

/**
 * 这个类负责生成题目
 */
public class QuestionGenerator {
  public final int resultMax = 100;  //不包括100
  public final int resultMin = 0;   //包括0

  /**
   * 生成一个Question包括firstNumber，secondNumber和运算符。
   * @return 一个符合条件的Question
   */
  public Question generateQuestion(){
    Random random = new Random();
    while (true){
      int firstNumber = random.nextInt(resultMax);
      int secondNumber = random.nextInt(resultMax);
      int op = random.nextInt(2);
      if(op==0&&firstNumber+secondNumber<100){
        return new Question(firstNumber, secondNumber, "+");
      }else if(op==1){
        int fn = Math.max(firstNumber, secondNumber);
        int sn = Math.min(firstNumber, secondNumber);
        return new Question(fn, sn, "-");
      }
    }
  }
}
