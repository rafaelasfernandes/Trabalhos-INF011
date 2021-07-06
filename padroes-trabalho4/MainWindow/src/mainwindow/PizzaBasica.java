package mainwindow;

import interfaces.PizzaComponent;
/**
 *
 * @author Rafaela
 */
public class PizzaBasica implements PizzaComponent {
    @Override
    public void preparar() {
        System.out.println("Preparando massa + molho + queijo");
    }
}
