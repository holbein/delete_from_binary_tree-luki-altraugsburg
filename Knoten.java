// Sollte funktionieren, ausser, dass die Baumelemente nicht zu Knoten veraendert werden koennen...
// Betroffene Zeilen: 39 u. 84

class Knoten extends Baumelem {
    Datenelem inhalt;
    Baumelem links;
    Baumelem rechts;
    
    Knoten (Datenelem inhalt, Baumelem links, Baumelem rechts) {
        this.inhalt = inhalt;
        this.links = links;
        this.rechts = rechts;
    }
    
    Baumelem naechsterGeben() {
        return this.naechsterGeben();
    }
    
    Baumelem einfuegen(Datenelem d) {
        double vergleichswert = d.inhaltGeben().compareTo(this.inhalt.inhaltGeben());
        
        if (this.istKleiner(d))       { this.links = links.einfuegen(d); }
        else if (this.istGroesser(d)) { this.rechts = rechts.einfuegen(d); }
        
        return this;
    }
    
    Baumelem loeschen(Datenelem d) {
        if (this.inhalt.inhaltGeben() == d.inhaltGeben() ) {
            if (hatKeinenAst()) { 
                return new Abschluss(); 
            } else if (hatEinenAst()) { 
                if (this.links.istLeer()) { return this.rechts; }
                return this.links;
            } else if (hatZweiAeste()) { // Hat zwei Aeste
                Wort w = (Wort)(((Knoten)this.rechts).gibKleinstenSchluesselwert());
                this.rechts = this.rechts.loeschen(w);
                
                return new Knoten(w, this.rechts, this.links);
            }    
        }
            
        if (istGroesser(d)) {
            rechts = rechts.loeschen(d);
        } else if (istKleiner(d)) {
            links = links.loeschen(d);
        }
            return this;
    }
    
     boolean istLeer() {
        return false;
    }
    
    // Hilfsmethoden
    
    boolean istGroesser(Datenelem d) {
      double vergleichswert = d.inhaltGeben().compareTo(this.inhalt.inhaltGeben());
      return vergleichswert > 0;
    }
    
    boolean istKleiner(Datenelem d) {
      double vergleichswert = d.inhaltGeben().compareTo(this.inhalt.inhaltGeben());
      return vergleichswert < 0;
    }
    
    boolean hatKeinenAst() {
        return this.links.istLeer() && this.rechts.istLeer();
    }
    
    boolean hatEinenAst() {
        return this.links.istLeer() && !this.rechts.istLeer() || !this.links.istLeer() && this.rechts.istLeer();
    }
    
    boolean hatZweiAeste() {
        return !this.links.istLeer() && !this.rechts.istLeer();
    }
    
    Datenelem gibKleinstenSchluesselwert() {
        if (this.links.istLeer()) { return this.inhalt; }
        // Ausgeschlossen, dass es sich um einen Abschluss handelt. Konvertierung moegl?
        return ((Knoten)this.links).gibKleinstenSchluesselwert();

    }
    
}
