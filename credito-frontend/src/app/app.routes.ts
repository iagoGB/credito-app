import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path:'', redirectTo: 'credito', pathMatch: 'full'
    },
    {
        path: 'credito',
         loadChildren: () => import('./credito/credito-module').then(m => m.CreditoModule)
    }
];
