package programs.arrays;

/**
 * Given an api which returns an array of chemical names and an array of chemical symbols,
 * display the chemical names with their symbol surrounded by square brackets:
 */
public class UberProblem4 {

    public static void main(String[] args) {

        String[] array = {"Amazon", "Microsoft", "Google"};
        String[] symbols = {" I", "Am", "cro", "Na", "le", "abc"};

        int i= 0;
       for(String word: array){
            array[i] = replace(word,symbols);
            i++;
        }
       for(String replaced: array){
           System.out.println(replaced);

        }
    }

    private static String replace(String word,String[] symbols) {

        for(String symbol: symbols){
            if(word.contains(symbol)){
                String replace = "["+symbol+"]";
                word = word.replace(symbol,replace);
            }
        }
        return word;
    }
}
