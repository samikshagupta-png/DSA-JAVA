package backtracking;
//Youaregivenastartingpositionforaratwhichisstuckinamazeataninitialpoint(0,0)
// (themazecanbethoughtofasa2-dimensionalplane).
// The mazewouldbegivenintheformofasquarematrixoforderN*Nwherethecellswithvalue0representthemaze’sblockedlocationswhilevalue1istheopen/availablepaththattheratcantaketoreachitsdestination.
// The rat's destination is at (N - 1, N - 1).
// Yourtaskistofindallthepossiblepathsthattheratcantaketoreachfromsourcetodestination in the maze.
// Thepossibledirectionsthatitcantaketomoveinthemazeare'U'(up)i.e.(x,y-1),'D'(down)i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y)

public class rateinmazeqns {
    public static int totalway(int[][] maze,int n,int i ,int j,String path,boolean[][] visited){

        //base class
        if (i== n-1 && j ==n-1){
            System.out.println(path);
            return 1;
        }
        // Boundary + blocked + already visited check

        if(i<0 || j <0 || i >=n || j >= n || maze[i][j] == 0 || visited[i][j]){
            return 0;
        }
        //recursion;
        visited[i][j] = true;
        int total= 0;
        //move down
         total += totalway(maze, n, i+1, j, path +"D", visited);
        //move up
         total += totalway(maze, n, i-1, j , path +"U", visited);
        //move right
         total += totalway(maze, n, i, j+1 , path +"R", visited);
        // move left
         total += totalway(maze, n, i, j-1, path + "L", visited);
        
        visited[i][j] = false;
        return total;
       
    }
    public static void solveMaze(int[][] maze, int n) {
        boolean[][] visited = new boolean[n][n];
        if (maze[0][0] == 0) {
            System.out.println("No path exists");
            return;
        }
        totalway(maze, n, 0, 0, "", visited);
    }
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int n = maze.length;

        System.out.println("Possible paths:");
        solveMaze(maze, n);
    }
    
    
}
