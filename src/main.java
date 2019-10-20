import java.util.Scanner;

/**
 * user 进行使用的主函数
 */

public class main {
  public static void main(String[] args){
    int userAnswer;
    Scanner input = new Scanner(System.in);
    boolean isContinue = false;
    QuestionGenerator qg = new QuestionGenerator();
    do{
      Question question = qg.generateQuestion();
      System.out.println(question.questionString());
      System.out.println("请输入正确答案");

      userAnswer = input.nextInt();
      boolean isCorrect = question.judgementAnswer(userAnswer);
      System.out.println("正确答案"+question.getAnswer()+",做题结果"+isCorrect);

      System.out.println("是否继续做题：继续做题输入1，结束做题输入2");
      int isGoingOn = input.nextInt();
      if(isGoingOn==1){isContinue = true;}
      else if(isGoingOn==2){ isContinue = false;}
      else {
        System.out.println("输入错误，结束做题");
        isContinue = false;
      }
    }while(isContinue);
    System.out.println("做题结束");
  }
}
