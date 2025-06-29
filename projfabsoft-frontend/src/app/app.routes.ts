import { Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { ComandaComponent } from './comanda/comanda.component';
import { ServicoComponent } from './servico/servico.component';
import { RoupaComponent } from './roupa/roupa.component';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';
import { FormComandaComponent } from './form-comanda/form-comanda.component';
import { FormRoupaComponent } from './form-roupa/form-roupa.component';
import { FormPagamentoComponent } from './form-pagamento/form-pagamento.component';
import { FormServicoComponent } from './form-servico/form-servico.component';
export const routes: Routes = [
    { path: 'clientes', component: ClienteComponent},
    { path: 'comanda', component: ComandaComponent},
    { path: 'servico', component: ServicoComponent},
    { path: 'roupa', component: RoupaComponent},
    { path: 'pagamento', component: PagamentoComponent},
    { path: 'clientes/novo', component: FormClienteComponent},
    { path: 'comanda/novo', component: FormComandaComponent},
    { path: 'servico/novo', component: FormServicoComponent},
    { path: 'roupa/novo', component: FormRoupaComponent},
    { path: 'pagamento/novo', component: FormPagamentoComponent},
    { path: 'clientes/alterar/:id', component: FormClienteComponent},
    { path: 'comanda/alterar/:id', component: FormComandaComponent},
    { path: 'servico/alterar/:id', component: FormServicoComponent},
    { path: 'roupa/alterar/:id', component: FormRoupaComponent},
    { path: 'pagamento/alterar/:id', component: FormPagamentoComponent},
];
