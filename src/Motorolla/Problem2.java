package Motorolla;

public class Problem2 {
    public static String solution(int T) {
        int hours = T / 3600;
        T -= hours * 3600;
        int minutes = T / 60;
        T -= minutes * 60;
        int seconds = T;

        return String.format("%dh%dm%ds",
                hours, minutes, seconds);
    }

    public static void main(String[] args) {
        System.out.println(Problem2.solution(83643));
    }
}
