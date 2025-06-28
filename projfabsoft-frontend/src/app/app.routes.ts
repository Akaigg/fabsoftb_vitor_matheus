import { Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { ComandaComponent } from './comanda/comanda.component';
import { ServicoComponent } from './servico/servico.component';
import { RoupaComponent } from './roupa/roupa.component';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';
export const routes: Routes = [
    { path: 'clientes', component: ClienteComponent},
    { path: 'comanda', component: ComandaComponent},
    { path: 'servico', component: ServicoComponent},
    { path: 'roupa', component: RoupaComponent},
    { path: 'pagamento', component: PagamentoComponent},
    { path: 'clientes/novo', component: FormClienteComponent},
    { path: 'clientes/alterar/:id', component: FormClienteComponent},
];
