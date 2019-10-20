/**
 * 这个类负责生成题目
 */
class QuestionGenerator{

    constructor(){}

    /**
     * 生成一个Question包括firstNumber，secondNumber和运算符。
     * @returns {Question} 一个符合条件的Question
     */
    generateQuestion(){
        let resultMax = 100;
        while (true){
            this.firstNumber = Math.floor(Math.random()*resultMax);
            this.secondNumber = Math.floor(Math.random()*resultMax);
            this.op = Math.floor(Math.random()*2);
            alert(this.firstNumber);
            if(this.op===0&&this.firstNumber+this.secondNumber<100){
                return new Question(this.firstNumber, this.secondNumber, "+");
            }else if(this.op===1){
                var fn = Math.max(this.firstNumber, this.secondNumber);
                var sn = Math.min(this.firstNumber, this.secondNumber);
                return new Question(fn, sn, "-");
            }
        }
    }
}

/**
 * 这个类是表示一道题目 (by js)
 */
class Question{

    /**
     * 构造器
     * @param firstNumber 算式的第一个数字
     * @param secondNumber 算式的第二个数字
     * @param operator 运算符
     */
    constructor(firstNumber, secondNumber, operator){
        this._answer = this.generateCorrectAnswer();
        this.checkRep();
        this._firstNumber = firstNumber;
        this._secondNumber = secondNumber;
        this._operator = operator;
    }

    get firstNumber() {
        return this._firstNumber;
    }

    get secondNumber() {
        return this._secondNumber;
    }

    get operator() {
        return this._operator;
    }

    get answer() {
        return this._answer;
    }


    set firstNumber(value) {
        this._firstNumber = value;
    }

    set secondNumber(value) {
        this._secondNumber = value;
    }

    set operator(value) {
        this._operator = value;
    }

    set answer(value) {
        this._answer = value;
    }

    /**
     * 判断用户输入的答案是否正确
     * @param userAnswer 用户输入的答案
     * @returns {boolean} 返回用户的答案是否正确
     */
    judgementAnswer(userAnswer){
        this.userAnswer = userAnswer;
        return this._answer === userAnswer;
    }
    /**
     * 生成正确的答案
     * @returns {*} 返回正确的答案,当firstNumber，secondNumber有一个为空，
     *              或者operator不为“+”或“-”，返回NaN
     */
    generateCorrectAnswer(){
        if(this._operator!=null){
            if(this._operator==="+")
                return this._firstNumber+this._secondNumber;
            else if(this._operator==="-")
                return this._firstNumber-this._secondNumber;
            else
                alert("operator is not defined");
            return NaN
        }else
            alert("parameters are not initialized");
        return NaN

    }

    /**
     * 判断Question的是否保持不变量
     * @returns {boolean} 保持返回true, 否则返回弹出“don't satisfy rep”
     */
    checkRep(){
        if(this._firstNumber>=0&&this._firstNumber<100&&this._secondNumber>=0
            &&this._secondNumber<100&&this._operator!=null){
            if(this._operator==="+"&&this._answer>=0&&this._answer<100){
                return true;
            }
            else if (this._operator==="-"&&this._firstNumber>=this._secondNumber
                &&this._answer>=0&&this._answer<100) {
                return true;
            }
        }
        alert("don't satisfy rep");
        return false;
    }

    /**
     * 返回题目的字符串
     * @returns {string} 题目的字符串
     */
    questionString(){
        return this._firstNumber+this._operator+this._secondNumber+"=";
    }

    /**
     * 返回题目的字符串.
     * @returns {string} 题目的字符串表示
     */
    toString() {
        return "Question{" +
            "firstNumber=" + this._firstNumber +
            ", operator='" + this._operator +
            ", secondNumber=" + this._secondNumber +
            ", answer=" + this._answer +
            ", userAnswer=" + this.userAnswer +
            '}';
    }
}