package work;

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
    String source = "";  //源字符串
    String ansStr = "null";  //结果字符串
    double ansNum = 0;  //求值结果
    //表达式求值过程
    String opt = "+-*/()";
    String cmpr[]={
        ">><<<>",
        ">><<<>",
        ">>>><>",
        ">>>><>",
        "<<<<<+",
        ">>>>$>"
    };
    //中缀式转后缀式
    public void convertTosuffix(){//1+2+3#
        String ans = "";
        int len = source.length();
        char st[] = new char[1000]; int top = 0;
        for(int i = 0; i < len; i++){
        	if(source.charAt(i) == '('){
        		st[top++] = source.charAt(i);
        		continue;
        	}
        	if(source.charAt(i) == ')'){
        		while(st[top-1] != '('){
        			ans += st[top-1];
        			top--;
        			ans += " ";
        		}
        		top--;
        		continue;
        	}
        	if(isOpt(source.charAt(i))){
        		while(top > 0 && cmpr[getIdx(st[top-1])].charAt(getIdx(source.charAt(i))) != '<'){
        			ans += st[top-1];
        			top--;
        		}
        		st[top++] = source.charAt(i);
        	}
        	else{
        		while(!isOpt(source.charAt(i))){
        			ans += source.charAt(i);
        		}
        	}
        	ans += " ";
        }
        while(top > 0){
        	ans += st[top-1];
        	top--;
        	ans += " ";
        }
        System.out.println("Hello :" + ans);
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
            prefix(rt.Rson, s);
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
    boolean isOpt(char ch){  //判断是不是运算符
        for(int i = 0; i < opt.length(); i++){
            if(ch == opt.charAt(i))
                return true;
        }
        return false;
    }
    char cmp(char opt1, char opt2){  //对两个操作符进行比较大小
        return cmpr[getIdx(opt1)].charAt(getIdx(opt2));
    }
    double calc(double num1, char opt, double num2){  //完成一个运算
        double ans = 0;
        if(opt == '+') ans = num1+num2;
        if(opt == '-') ans = num1-num2;
        if(opt == '*') ans = num1*num2;
        if(opt == '/') ans = num1/num2;
        return ans;
    }
    int getIdx(char ch){  //得到运算符的下标
        for(int i = 0; i < opt.length(); i++){
            if(opt.charAt(i) == ch)
                return i;
        }
        return -1;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    }
}
  }
}
