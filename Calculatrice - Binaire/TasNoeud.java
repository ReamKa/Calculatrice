public class TasNoeud {
    Noeud noeud;
    TasNoeud next;

    // Structure qui me servira pour pointer sur le prochain élément (même que la
    // notion de pointeur en C)
    public TasNoeud(Noeud noeud) {
        this.noeud = noeud;
        next = null;
    }

}
