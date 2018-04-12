class Abschluss extends Baumelem {
    
    Abschluss () {
        
    }
    
    Baumelem naechsterGeben() {
        return this;
    }
    
    Baumelem einfuegen(Datenelem d) {
        return new Knoten(d, new Abschluss(), new Abschluss());
    }
    
    Baumelem loeschen(Datenelem d) {
        return this;
    }
    
    boolean istLeer() {
        return true;
    }

}
