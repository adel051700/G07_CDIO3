class Player {
    private int number;
    private String tokenCharacter = "";
    private Bank account;
    public boolean skipPlayerTurn = false;
    public boolean isInPrison = false;
    public boolean isBankrupt = false;

    public Player (int number, int bankBalance) {
        this.number = number;
        this.account = new Bank();
        this.account.changeBalance(bankBalance);
    }

    public int getNumber()
    {
        return this.number;
    }

    public Boolean getSkipPlayerTurn() {
        return skipPlayerTurn;
    }

    public void setSkipPlayerTurn() {
        this.skipPlayerTurn = !getSkipPlayerTurn();
    }

    public Boolean getIsInPrison() {
        return isInPrison;
    }

    public void setIsInPrison() {
        this.isInPrison = !getIsInPrison();
    }

    public String toString() {
        return "Player " + this.number + " " + this.tokenCharacter + System.lineSeparator() + "Bank balance: " + this.account.getBalance();
    }

    public int getBankBalance() {
        return account.getBalance();
    }

    public void setBankBalance(int alphaChange) 
    {
        account.changeBalance(alphaChange);
    }
}
