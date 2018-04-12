abstract class Baumelem {
    abstract Baumelem naechsterGeben();
    abstract Baumelem einfuegen(Datenelem d);
    abstract Baumelem loeschen(Datenelem d);
    abstract boolean istLeer();
}
