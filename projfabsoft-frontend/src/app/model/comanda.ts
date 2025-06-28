import { Cliente } from "./cliente";
import { Pagamento } from "./pagamento";
import { Roupa } from "./roupa";
import { Servico } from "./servico";

export class Comanda {
    id:number;
    dataEntrada:Date;
    dataRetirada:Date;
    cliente:Cliente;
    pagamento:Pagamento;
    listaRoupas:Roupa[];
    listaServicos:Servico[];    
}
