class Player {
    private String name;
    private String tokenCharacter;
    private int bankBalance;
    public Boolean skipPlayerTurn = false;
    public Boolean isInPrison = false;

    public Player (String name, String tokenCharacter, int bankBalance) {
        this.name = name;
        this.tokenCharacter = tokenCharacter;
        this.bankBalance = bankBalance;
    }

    public Boolean getSkipPlayerTurn() {
        return skipPlayerTurn;
    }

    public Boolean setSkipPlayerTurn(Boolean change) {
        return skipPlayerTurn = change;
    }

    public Boolean getIsInPrison() {
        return isInPrison;
    }

    public Boolean setIsInPrison(Boolean change) {
        return isInPrison = change;
    }

    public String toString() {
        return this.name + " " + this.tokenCharacter + System.lineSeparator() + " Bank balance: " + this.bankBalance;
    }

    public int getBankBalnce() {
        return this.bankBalance;
    }

    public int setBankbalnce(int alphaChange) {
        return this.bankBalance += alphaChange;
    }
}
