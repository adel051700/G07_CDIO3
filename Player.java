class Player {
    private String name;
    private String tokenCharacter;
    private Bank account;
    public Boolean skipPlayerTurn = false;
    public Boolean isInPrison = false;
    public Boolean isBankrupt = false;

    public Player (String name, String tokenCharacter, int bankBalance) {
        this.name = name;
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
        return this.name + " " + this.tokenCharacter + System.lineSeparator() + " Bank balance: " + this.account.getBalance();
    }

    public int getBankBalnce() {
        return account.getBalance();
    }

    public void setBankbalnce(int alphaChange) 
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
