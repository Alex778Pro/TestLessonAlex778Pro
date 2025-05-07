public class UserBankLogic extends GetSetBallansFile {
    private final double USD = 91.45;
    private final double CNY = 11.91;
    private final double KZT = 0.19;
    private final double TRY = 2.69;
    private final double RUB = 1.;


    private String[] operations;
    private double[] ball = super.getBallans();

    public void operation(String operation) {
        this.operations = operation.split("\\s+");

        if (operations != null) {
            String operator = operations[0].toUpperCase();
            switch (operator) {
                case "ВНЕСТИ":
                    inputMoney();
                    break;
                case "ВЫВЕСТИ":
                    outputMoney();
                    break;
                case "ОБМЕН":
                    convertMoney();
                    break;
                case "БАЛАНС":
                    ballansPrint();
                    break;
                default:
                    System.out.println("Такой опперации нету");
            }
        } else {
            System.out.println("Вы не ввели операцию");
        }

    }

    private void inputMoney() {
        if (operations[1] != null && operations[2] != null) {
            String current = operations[2].toUpperCase();
            double ammount = Math.round(Double.parseDouble(operations[1]) * 100.0) / 100.0;

            switch (current) {
                case "USD":
                    super.setBallans(ammount + ball[0], ball[1], ball[2], ball[3], ball[4]);
                    break;
                case "CNY":
                    super.setBallans(ball[0], ammount + ball[1], ball[2], ball[3], ball[4]);
                    break;
                case "KZT":
                    super.setBallans(ball[0], ball[1], ammount + ball[2], ball[3], ball[4]);
                    break;
                case "TRY":
                    super.setBallans(ball[0], ball[1], ball[2], ammount + ball[3], ball[4]);
                    break;
                case "RUB":

                    super.setBallans(ball[0], ball[1], ball[2], ball[3], ammount + ball[4]);
                    break;
                default:
                    System.out.println("Такой валюты нету");
            }
        }
    }

    private void outputMoney() {

        if (operations[1] != null && operations[2] != null) {
            String current = operations[2].toUpperCase();
            double ammount = Math.round(Double.parseDouble(operations[1]) * 100.0) / 100.0;

            switch (current) {
                case "USD":
                    super.setBallans(ball[0] - ammount, ball[1], ball[2], ball[3], ball[4]);
                    break;
                case "CNY":
                    super.setBallans(ball[0], ball[1] - ammount, ball[2], ball[3], ball[4]);
                    break;
                case "KZT":
                    super.setBallans(ball[0], ball[1], ball[2] - ammount, ball[3], ball[4]);
                    break;
                case "TRY":
                    super.setBallans(ball[0], ball[1], ball[2], ball[3] - ammount, ball[4]);
                    break;
                case "RUB":

                    super.setBallans(ball[0], ball[1], ball[2], ball[3], ball[4] - ammount);
                    break;
                default:
                    System.out.println("Такой валюты нету");
            }
        }
    }

    private void convertMoney() {
        if (operations[1] != null && operations[2] != null && operations[3] != null) {
            String current = operations[2].toUpperCase();
            String currentConv = operations[3].toUpperCase();
            double ammount = Math.round(Double.parseDouble(operations[1]) * 100.0) / 100.0;
            double hold = ammount;
            boolean checkConvert = false;
            if (!current.equals(currentConv)) {
                if (current.equals("USD")) {
                    ammount = ammount * USD;
                    if (ball[0] - hold >= 0) {
                        super.setBallans(ball[0] - hold, ball[1], ball[2], ball[3], ball[4]);
                        checkConvert = true;
                    } else
                        System.out.println("Недостточно средств");
                } else if (current.equals("CNY")) {
                    ammount = ammount * CNY;
                    if (ball[1] - hold >= 0) {
                        super.setBallans(ball[0], ball[1] - hold, ball[2], ball[3], ball[4]);
                        checkConvert = true;
                    }else
                        System.out.println("Недостточно средств");
                } else if (current.equals("KZT")) {
                    ammount = ammount * KZT;
                    if (ball[2] - hold >= 0) {
                        super.setBallans(ball[0], ball[1], ball[2] - hold, ball[3], ball[4]);
                        checkConvert = true;
                    }else
                        System.out.println("Недостточно средств");
                } else if (current.equals("TRY")) {
                    ammount = ammount * TRY;
                    if (ball[3] - hold >= 0) {
                        super.setBallans(ball[0], ball[1], ball[2], ball[3] - hold, ball[4]);
                        checkConvert = true;
                    }else
                        System.out.println("Недостточно средств");
                } else if (current.equals("RUB")) {
                    ammount = ammount * RUB;
                    if (ball[4] - hold >= 0) {
                        super.setBallans(ball[0], ball[1], ball[2], ball[3], ball[4] - hold);
                        checkConvert = true;
                    }else
                        System.out.println("Недостточно средств");
                } else
                    System.out.println("Error");

                if (checkConvert) {
                    ball = super.getBallans();
                    switch (currentConv) {
                        case "USD":
                            super.setBallans((ammount / USD) + ball[0], ball[1], ball[2], ball[3], ball[4]);
                            break;
                        case "CNY":
                            super.setBallans(ball[0], (ammount / CNY) + ball[1], ball[2], ball[3], ball[4]);
                            break;
                        case "KZT":
                            super.setBallans(ball[0], ball[1], (ammount / KZT) + ball[2], ball[3], ball[4]);
                            break;
                        case "TRY":
                            super.setBallans(ball[0], ball[1], ball[2], (ammount / TRY) + ball[3], ball[4]);
                            break;
                        case "RUB":
                            super.setBallans(ball[0], ball[1], ball[2], ball[3], (ammount / RUB) + ball[4]);
                            break;
                        default:
                            System.out.println("Такой валюты нету");
                    }
                }
            } else
                System.out.println("Обмен не возможен");


        }
        else
            System.out.println("ERROR");


    }

    private void ballansPrint() {
        String[] val = new String[]{"USD", "CNY", "KZT", "TRY", "RUB"};

        System.out.print("Баланс: ");
        for (int u = 0; u < this.ball.length; u++) {
            String formattedNumber = String.format("%.2f", this.ball[u]);
            System.out.print(val[u] + ":" + formattedNumber + " ");
        }
    }
}
