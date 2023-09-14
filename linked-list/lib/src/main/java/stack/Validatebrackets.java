package stack;

public class Validatebrackets {
    public Stack <Character>brackets = new Stack<>();

    public Validatebrackets() {
    }

    public boolean validateBrackets(String sentece) {

        for (int i = 0; i < sentece.length(); i++) {
            if (isOpenBracket(sentece.charAt(i))) {
                brackets.push(sentece.charAt(i));
            } else if (isClosedBracket(sentece.charAt(i))) {
                if(!brackets.isEmpty()&&matched(brackets.peek(),sentece.charAt(i))){
                    brackets.pop();
                }else return false;
            }
        }
    return brackets.isEmpty();}


    public boolean isOpenBracket(char ch) {
        if (ch == '(' || ch == '[' || ch == '{')
            return true;
        return false;
    }

    public boolean isClosedBracket(char ch) {
        if (ch == ')' || ch == ']' || ch == '}')
            return true;
        return false;
    }

    public boolean matched(char ch1, char ch2) {
        if (ch1=='(' && ch2==')')
            return true;
        else if (ch1=='{' && ch2=='}')
            return true;
        else if (ch1=='[' && ch2==']')
            return true;
        return false;
    }
}

