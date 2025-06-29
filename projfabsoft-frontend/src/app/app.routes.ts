import { Routes } from '@angular/router';

import { ClienteComponent } from './cliente/cliente.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';

import { ComandaComponent } from './comanda/comanda.component';
import { FormComandaComponent } from './form-comanda/form-comanda.component';

import { ServicoComponent } from './servico/servico.component';
import { FormServicoComponent } from './form-servico/form-servico.component';

import { RoupaComponent } from './roupa/roupa.component';
import { FormRoupaComponent } from './form-roupa/form-roupa.component';

import { PagamentoComponent } from './pagamento/pagamento.component';
import { FormPagamentoComponent } from './form-pagamento/form-pagamento.component';

export const routes: Routes = [

    { path: 'clientes', component: ClienteComponent},
    { path: 'clientes/novo', component: FormClienteComponent},
    { path: 'clientes/alterar/:id', component: FormClienteComponent},

    { path: 'comanda', component: ComandaComponent},
    { path: 'comanda/novo', component: FormComandaComponent},
    { path: 'comanda/alterar/:id', component: FormComandaComponent},

    { path: 'servico', component: ServicoComponent},
    { path: 'servico/novo', component: FormServicoComponent},
    { path: 'servico/alterar/:id', component: FormServicoComponent},

    { path: 'roupa', component: RoupaComponent},
    { path: 'Roupas/novo', component: FormRoupaComponent},
    { path: 'roupa/alterar/:id', component: FormRoupaComponent},

    { path: 'pagamento', component: PagamentoComponent},
    { path: 'pagamento/novo', component: FormPagamentoComponent},
    { path: 'pagamento/alterar/:id', component: FormPagamentoComponent},

];