/**
 * 这个类是表示一道题目
 */
public class Question {
  private int firstNumber;
  private int secondNumber;
  private String operator;
  private int answer;
  private int userAnswer;

  public Question(int firstNumber, int secondNumber, String operator) {
    this.firstNumber = firstNumber;
    this.secondNumber = secondNumber;
    this.operator = operator;
    answer = generateCorrectAnswer();
    checkRep();

  }

  public int getFirstNumber() {
    return firstNumber;
  }

  public int getSecondNumber() {
    return secondNumber;
  }

  public String getOperator() {
    return operator;
  }

  public int getAnswer() {
    return answer;
  }

  public int getUserAnswer() {
    return userAnswer;
  }

  public void setFirstNumber(int firstNumber) {
    this.firstNumber = firstNumber;
  }

  public void setSecondNumber(int secondNumber) {
    this.secondNumber = secondNumber;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  public void setUserAnswer(int userAnswer) {
    this.userAnswer = userAnswer;
  }

  /**
   * 判断用户输入的答案是否正确
   * @param userAnswer 用户输入的答案
   * @return 返回用户的答案是否正确
   */
  public boolean judgementAnswer(int userAnswer){
    this.userAnswer = userAnswer;
    return answer == userAnswer;
  }

  /**
   * 生成正确的答案
   * @exception  RuntimeException 当firstNumber，secondNumber有一个为空，或者operator不为“+”或“-”时抛出异常
   * @return 返回正确的答案
   */
  private int generateCorrectAnswer(){
    if(operator!=null){
      if(operator.equals("+"))
        return firstNumber+secondNumber;
      else if(operator.equals("-"))
        return firstNumber-secondNumber;
      else
        throw new RuntimeException("operator is not defined");
    }else
      throw new RuntimeException("parameters are not initialized");
  }

  /**
   * 判断Question的是否保持不变量
   * @return 保持返回true, 否则返回false
   */
  private boolean checkRep(){
    if(firstNumber>=0&&firstNumber<100&&secondNumber>=0&&secondNumber<100&&operator!=null){
      if(operator.equals("+")){ return answer>=0&&answer<100;}
      else if (operator.equals("-")&&firstNumber>=secondNumber){ return answer>=0&&answer<100;}
    }
    throw new RuntimeException("don't satisfy rep");
  }

  /**
   * 显示题目
   * @return 题目的字符串
   */
  public String questionString(){
    return firstNumber+operator+secondNumber+"=";
  }

  @Override
  public String toString() {
    return "Question{" +
        "firstNumber=" + firstNumber +
        ", operator='" + operator +
        ", secondNumber=" + secondNumber +
        ", answer=" + answer +
        ", userAnswer=" + userAnswer +
        '}';
  }
}
