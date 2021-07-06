package palmitodecorator;

import interfaces.PizzaComponent;
import interfaces.PizzaDecorator;

/**
 *
 * @author Rafaela
 */
public class PalmitoDecorator extends PizzaDecorator{
    
    public PalmitoDecorator(){
        
    }
    
    public PalmitoDecorator(PizzaComponent decorated){
        this.decorated = decorated;
    }

    @Override
    public void preparar() {
        decorated.preparar();
        System.out.println("Adicionando o palmito");
    }   
}
