class Player {
    private int number;
    private String tokenCharacter;
    private Bank account;
    public Boolean skipPlayerTurn = false;
    public Boolean isInPrison = false;
    public Boolean isBankrupt = false;

    public Player (int number, String tokenCharacter, int bankBalance) {
        this.number = number;
        this.tokenCharacter = tokenCharacter;
        this.account = new Bank();
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
        return "Player " + this.number + " " + this.tokenCharacter + System.lineSeparator() + " Bank balance: " + this.account.getBalance();
    }

    public int getBankBalance() {
        return account.getBalance();
    }

    public void setBankBalance(int alphaChange) 
    {
        account.changeBalance(alphaChange);
    }

    public Boolean getIsBankrupt() {
        if (account.getBalance() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
