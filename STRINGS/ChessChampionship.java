/* 
The World Chess Championship 2022 is about to start. 14 Classical games will be played between Chef and Carlsen in the championship, where each game has one of three outcomes — it can be won by Carlsen, won by Chef, or it can be a draw. The winner of a game gets 2, and the loser gets 0 points. If it’s a draw, both players get 1 point each.

The total prize pool of the championship is 100⋅𝑋. At end of the 14 Classical games, if one player has strictly more points than the other, he is declared the champion and gets 60⋅X as his prize money, and the loser gets 40⋅X.

If the total points are tied, then the defending champion Carlsen is declared the winner. However, if this happens, the winner gets only 55⋅X, and the loser gets 45⋅X.

Given the results of all the 14 games, output the prize money that Carlsen receives.

The results are given as a string of length 14 consisting of the characters C, N, and D.

C denotes a victory by Carlsen.
N denotes a victory by Chef.
D denotes a draw.

*/

public class ChessChampionship {

    private static void findWinner(String str, int x) {
        int carlsen = 0, chef = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C') {
                carlsen += 2;
            } else if (str.charAt(i) == 'N') {
                chef += 2;
            } else {
                carlsen += 1;
                chef += 1;
            }
        }
        int prizeCarlsen = (carlsen > chef) ? (60 * x) : ((carlsen == chef) ? (55 * x) : (40 * x));
        System.out.println(prizeCarlsen);
    }

    public static void main(String[] args) {

        findWinner("CCCCCCCCCCCCCC", 100);
        findWinner("CDCDCDCDCDCDCD", 400);
        findWinner("DDCCNNDDDCCNND", 30);
        findWinner("NNDNNDDDNNDNDN", 1);
    }
}