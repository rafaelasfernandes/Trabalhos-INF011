package azeitonadecorator;

import interfaces.PizzaComponent;
import interfaces.PizzaDecorator;

/**
 *
 * @author Rafaela
 */
public class AzeitonaDecorator extends PizzaDecorator {
    
    public AzeitonaDecorator(){
        
    }
    
    public AzeitonaDecorator(PizzaComponent decorated) {
       this.decorated = decorated;
    }
    public void preparar() {
        decorated.preparar();
        System.out.println("Adicionando a azeitona");
    }    
}
