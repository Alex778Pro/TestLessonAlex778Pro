import java.io.*;

public class GetSetBallansFile {

    public double[] getBallans() {

        double[] userBall;

        try (BufferedReader reader = new BufferedReader(new FileReader("User.txt"))) {

            String[] userDataStr = reader.readLine().split("\\s+");
            userBall = new double[userDataStr.length];

            for (int u = 0; u < userDataStr.length; u++) {
                userBall[u] = Math.round(Double.parseDouble(userDataStr[u]) * 100.0) / 100.0;   //округляем если ввели больше трех цыфр после запятой
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userBall;

    }

    public void setBallans(double ballUSD, double ballCNY, double ballKZT, double ballTRY, double ballRUB) {
        if (ballCNY >= 0 && ballKZT >= 0 && ballRUB >= 0 && ballUSD >= 0 && ballTRY >= 0) {
            try (FileWriter writer = new FileWriter("User.txt")) {
                writer.write(ballUSD + " " + ballCNY + " " + ballKZT + " " + ballTRY + " " + ballRUB);

            } catch (IOException e) {
                System.out.println("ERROR " + e);
            }
        } else
            System.out.println("Недостаточно средст");

    }
}
