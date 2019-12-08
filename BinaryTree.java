package CSproblem.work;

class node{
    public int flag = 0;  //标记是否有值
    public double w = 0;
    public char ch = '@';
    node(){}
    node Lson;
    node Rson;
}

public class BinaryTree{
    node rt;
    String source = "";  //1+2+3#
    String ansStr = "null";
    double ansNum = 0;
    //表达式求值过程
    String opt = "+-*/()#";
    String cmp[]={
        ">><<<>>",
        ">><<<>>",
        ">>>><>>",
        ">>>><>>",
        "<<<<<+$",
        ">>>>$>>",
        "<<<<<$+"
    };
    boolean isOpt(char ch){
        for(int i = 0; i < opt.length(); i++){
            if(ch == opt.charAt(i))
                return true;
        }
        return false;
    }
    char cmp(char opt1, char opt2){
        return cmp[getIdx(opt1)].charAt(getIdx(opt2));
    }
    double calc(double num1, char opt, double num2){
        double ans = 0;
        if(opt == '+') ans = num1+num2;
        if(opt == '-') ans = num1-num2;
        if(opt == '*') ans = num1*num2;
        if(opt == '/') ans = num1/num2;
        return ans;
    }
    int getIdx(char ch){
        for(int i = 0; i < opt.length(); i++){
            if(opt.charAt(i) == ch)
                return i;
        }
        return -1;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    }
    //中缀式建树
    public void build(){
        
    }
    //前缀
    public void prefix(node rt, String s){
        if(rt.flag == 1){
            if(rt.ch == '@'){
                s = s+(rt.w+"");
            }
            else{
                s = s+rt.ch;
            }
            prefix(rt.Lson, s);
            prefis(rt.Rson, s);
        }
    }
    //中缀
    public void infix(node rt, String s){
        if(rt.flag == 1){
            infix(rt.Lson, s);
            if(rt.ch == '@'){
                s = s+(rt.w+"");
            }
            else{
                s = s+rt.ch;
            }
            infix(rt.Rson, s);
        }
    }
    //后缀
    public void suffix(node rt, String s){
        if(rt.flag == 1){
            suffix(rt.Lson, s);
            suffix(rt.Rson, s);
            if(rt.ch == '@'){
                s = s+(rt.w+"");
            }
            else{
                s = s+rt.ch;
            }
        }
    }
    public double prefixGetAnswer(String str){
        return ansNum;
    }
    public double infixGetAnswer(String str){
        return ansNum;
    }
    public double suffixGetAnswer(String str){
        return ansNum;
    }
    public String getFix(String way){
        if(way.equals("prefix")){
            //prefix(rt, ansStr);
        }
        if(way.equals("infix")){
            //infix(rt, ansStr);
        }
        if(way.equals("suffix")){
            //suffix(rt, ansStr);
        }
        return ansStr;
    }
    public double getNum(String way){
        if(way.equals("prefix")){
            //ansNum = prefixGetAnswer(getFix("prefix"));
        }
        if(way.equals("infix")){
            //ansNum = infixGetAnswer(getFix("infix"));
        }
        if(way.equals("suffix")){
            //ansNum = suffixGetAnswer(getFix("suffix"));
        }
        return ansNum;
    }
}