class Suchbaum {
    Baumelem erster;

    Suchbaum () {    
        this.erster = new Knoten(new Wort("natty"),
                                // Links.....
                                 new Knoten(new Wort("decay"),
                                            new Knoten(new Wort("barn"), new Abschluss(), new Abschluss()),
                                            new Knoten(new Wort("jeer"),
                                                       new Knoten(new Wort("folly"),
                                                                  new Abschluss(),
                                                                  new Knoten(new Wort("heir"), 
                                                                             new Abschluss(), 
                                                                             new Abschluss()
                                                                            )           
                                                                  ),
                                                       new Abschluss()
                                                       )
                                           ),
                                  // Rechts.....
                                  new Knoten (new Wort("peony"),
                                              new Abschluss(),
                                              new Knoten(new Wort("tulip"),
                                                         new Knoten(new Wort("stern"), new Abschluss(), new Abschluss()),
                                                         new Knoten(new Wort("wee"), new Abschluss(), new Abschluss())
                                                        )
                                             )
                                  );
                    
    }
    
    void einfuegen(Datenelem d) {
        this.erster = erster.einfuegen(d);
    }
    
    void loeschen(Datenelem d) {
        this.erster = erster.loeschen(d);
    }
}
