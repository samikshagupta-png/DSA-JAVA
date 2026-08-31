package Recursion;

public class charoccurence {
    public static int first =-1;
    public static int last = -1;
    public static void findcharoccur(String word,int idx, char element){
        // base class
        if(idx == word.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currchar = word.charAt(idx);
        if(currchar == element){
            if(first ==-1){
                first = idx;
            }else{
                last = idx;
            }
        }
        findcharoccur(word, idx+1, element);

    }
    public static void main(String[] args) {
        String word="abcaaaaaghnaaaa";
        findcharoccur(word, 0, 'a');
    }
    
}
