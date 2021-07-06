package mostardadecorator;

import interfaces.PizzaComponent;
import interfaces.PizzaDecorator;

/**
 *
 * @author Rafaela
 */
public class MostardaDecorator extends PizzaDecorator{
    
    public MostardaDecorator(){
        
    }
    
    public MostardaDecorator(PizzaComponent decorated){
        this.decorated = decorated;
    }

    @Override
    public void preparar() {
        decorated.preparar();
        System.out.println("Adicionando a mostarda");
    }
}
