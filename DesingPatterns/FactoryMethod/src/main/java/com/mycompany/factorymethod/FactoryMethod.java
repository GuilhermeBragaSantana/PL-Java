/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factorymethod;
import java.util.HashMap;
public class FactoryMethod {
    public static void main(String[] args) {
        abstract class Veiculo {
            abstract int getCapacidade();
        }
        class Onibus extends Veiculo{
            int getCapacidade(){return 40;}
        }
        class Van extends Veiculo{
            int getCapacidade(){return 12;}
        }
        interface VeiculoFactory{
            Veiculo createVeiculo();
        }
    
        class OnibusFactory implements VeiculoFactory{
            public Veiculo createVeiculo(){return new Onibus();}
        }
        class VanFactory implements VeiculoFactory{
            public Veiculo createVeiculo(){return new Van();}
        }
    
        class GerenciadorVeiculo{
            HashMap<String, VeiculoFactory> fabricas = new HashMap<>();
        
            public GerenciadorVeiculo(){
                fabricas.put("onibus", new OnibusFactory());
                fabricas.put("van", new VanFactory());
            }
            public Veiculo obter (String tipo){
                VeiculoFactory fabrica = fabricas.get(tipo);
                if (fabrica != null){
                return fabrica.createVeiculo();
                }   
                return null;
            }
        }
        GerenciadorVeiculo gerenciador = new GerenciadorVeiculo();
        Veiculo v1 = gerenciador.obter("onibus");
        Veiculo v2 = gerenciador.obter("van");
    
        System.out.println("Onibus: " + v1.getCapacidade());
        System.out.println("Van: " + v2.getCapacidade());
    }
}
