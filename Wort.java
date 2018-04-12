class Wort extends Datenelem {
    String inhalt;
    
    Wort (String str) {
        this.inhalt = str;
    }
    
    String inhaltGeben() {
        return this.inhalt;
    }
}
